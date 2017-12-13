package com.ejie.nbrs.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejie.nbrs.dao.LoanInfoDao;
import com.ejie.nbrs.dao.TempletPrintLoanDao;
import com.ejie.nbrs.dto.NewLoanView;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.entity.Account;
import com.ejie.nbrs.entity.CommonApplicant;
import com.ejie.nbrs.entity.MortgageHouse;
import com.ejie.nbrs.entity.PrintCreditView;
import com.ejie.nbrs.entity.PrintLoanView;
import com.ejie.nbrs.service.AccountService;
import com.ejie.nbrs.service.TempletPrintLoanService;
import com.ejie.nbrs.util.BigDecimalExUtils;
import com.ejie.nbrs.util.WordGenerator;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * 
 * ClassName:TempletPrintLoanServiceImpl
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月30日 下午5:30:41
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
@Service
public class TempletPrintLoanServiceImpl implements TempletPrintLoanService {
	public static void main(String[] args) {
		BigDecimal b = new BigDecimal(0.00);
		String st = "0.00";
		System.out.println(String.valueOf(b).equals(st));
	}

	@Resource
	private AccountService accountService;
	@Autowired
	private TempletPrintLoanDao tpdao;

	@Autowired
	private LoanInfoDao loanInfoDao;

	private String templatePdfPath;
	private String ttcPath;
	private String targetPdfpath;
	private PrintLoanView printLoanView;
	private PrintCreditView printCreditView;

	/**
	 * 查询放款
	 */
	@Override
	public PrintLoanView selectePrintLoanView(SearchCondition sc) {
		return tpdao.selectePrintLoanView(sc);
	}

	/**
	 * 查询授信
	 */
	@Override
	public PrintCreditView selectePrintCreditView(SearchCondition sc) {

		PrintCreditView printCreditView = tpdao.selectePrintCreditView(sc);

		NewLoanView nv = loanInfoDao.showLoanView(sc);// 查到贷款人详细信息表
		if (nv == null) {// 有查询结果的情况
			return printCreditView;
		}
		if (printCreditView != null) {
			List<CommonApplicant> cp;// 声明一个新的共借人集合
			Integer cAInfoId = nv.getaBaseId();// 得到主借人id,通过主借人id去找共借人
			cp = loanInfoDao.selectCommonApplicantByCAInfoId(cAInfoId);
			printCreditView.setCommonApplicant(cp);

			List<MortgageHouse> mh = new ArrayList<MortgageHouse>();// 声明一个新的抵押房集合
			String mhouseId = nv.getMhouseId();
			mh = loanInfoDao.selectMortgageHouseListByMhouseId(mhouseId);
			printCreditView.setMortgageHouse(mh);
		}

		return printCreditView;

	}

	/**
	 * 
	 * @Title: docPrintCredit
	 * @Description: TODO word下载授信
	 * @param @param req
	 * @param @param sc 传入参数封装类
	 * @param @return 参数
	 * @return List<File> 多个文件集合
	 * @throws
	 */
	@Override
	public List<File> docPrintCredit(HttpServletRequest req, SearchCondition sc) {
		List<File> files = new ArrayList<File>();// 打包的原始文件
		String type = "";// 临时文件名
		String source = "printCredit.ftl";// 源模版文件
		try {
			PrintCreditView pc = selectePrintCreditView(sc);// 通过查询参数得到打印授信基本信息

			Account account = accountService.queryByUId(sc.getcUserId());// 得到用户实体
			pc.setuName(account.getUserName());// 设置用户名
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			pc.setlTime(sdf.format(new Date()));// 设置操作时间

			List<MortgageHouse> mh = pc.getMortgageHouse();// 抵押物集合
			if (mh != null) {
				for (MortgageHouse mo : mh) {// 遍历抵押物结合
					Map<String, Object> map = new HashMap<String, Object>();
					// 设置基本信息
					map.put("name", pc.getName() == null ? "" : pc.getName());
					map.put("idNumber",
							pc.getIdNumber() == null ? "" : pc.getIdNumber());
					map.put("apAge", String.valueOf(pc.getAge() == 0 ? "" : pc
							.getAge()));
					map.put("companyName1", pc.getCompanyName() == null ? ""
							: pc.getCompanyName());
					map.put("phoneNumber", pc.getPhoneNumber() == null ? ""
							: pc.getPhoneNumber());
					map.put("periods", String.valueOf(pc.getPeriods() == 0 ? ""
							: pc.getPeriods()));
					map.put("repayWay",
							pc.getRepayWay() == null ? "" : pc.getRepayWay());
					map.put("rate", pc.getRate() == null ? "" : pc.getRate());
					map.put("loanPurpose", pc.getLoanPurpose() == null ? ""
							: pc.getLoanPurpose());
					map.put("uName", pc.getuName() == null ? "" : pc.getuName());
					map.put("lTime", pc.getlTime() == null ? "" : pc.getlTime());

					List<CommonApplicant> co = pc.getCommonApplicant();
					if (co != null) {// 设置共借人
						int j = 0;
						for (CommonApplicant c : co) {
							map.put("CAName" + j, c.getcAName() == null ? ""
									: c.getcAName());
							map.put("CAIdNumber" + j,
									c.getcAIdNumber() == null ? "" : c
											.getcAIdNumber());
							map.put("cAge" + j,
									c.getAge() == 0 ? "" : String.valueOf(c
											.getAge()));
							map.put("companyName2" + j,
									c.getCompanyName() == null ? "" : c
											.getCompanyName());
							map.put("CAphoneNumber" + j,
									c.getcAPhoneNumber() == null ? "" : c
											.getcAPhoneNumber());
							j++;
						}
						for (int i = 2; i >= j; i--) {
							map.put("CAName" + i, "");
							map.put("CAIdNumber" + i, "");
							map.put("cAge" + i, "");
							map.put("companyName2" + i, "");
							map.put("CAphoneNumber" + i, "");
						}
					} else {
						for (int i = 0; i < 3; i++) {// 设置共借人
							map.put("CAName" + i, "");
							map.put("CAIdNumber" + i, "");
							map.put("cAge" + i, "");
							map.put("companyName2" + i, "");
							map.put("CAphoneNumber" + i, "");
						}
					}
					// 设置单个抵押物信息
					map.put("houseType",
							mo.getHouseType() == null ? "" : mo.getHouseType());
					map.put("acreage",BigDecimalExUtils.formatBigDecimal(mo.getAcreage(), ""));
					map.put("houseArea",mo.getHouseArea() == null ? "" : 
						mo.getHouseArea().replace("{", "").replace("}", "").replace("#", "")
						);
					map.put("mhouseValue", BigDecimalExUtils.formatBigDecimal(mo.getMhouseValue(), ""));
					map.put("nbComfirmValue",BigDecimalExUtils.formatBigDecimal(mo.getNbComfirmValue(), ""));
					map.put("wuhouseValue",BigDecimalExUtils.formatBigDecimal(mo.getWuhouseValue(), ""));
					map.put("gAddress",
							mo.getgAddress() == null ? "" : mo.getgAddress());
					System.out.println("~~~~~~~~~~~~~map is:" + map);

					type = "授信决议表" + mo.getmHId();// 文件名

					files.add(WordGenerator.createDoc(map, type, source));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return files;
	}

	/**
	 * 
	 * @Title: docPrintLoan
	 * @Description: TODO word下载放款
	 * @param @param req
	 * @param @param sc 传入参数封装类
	 * @param @return 参数
	 * @return List<File> 多个文件集合
	 * @throws
	 */
	@Override
	public List<File> docPrintLoan(HttpServletRequest req, SearchCondition sc) {
		List<File> files = new ArrayList<File>();// 打包的原始文件
		String type = "";// 临时文件名
		String source = "printLoan.ftl";// 源模版文件

		// 提示：在调用工具类生成Word文档之前应当检查所有字段是否完整
		// 否则Freemarker的模板引擎在处理时可能会因为找不到值而报错 这里暂时忽略这个步骤了
		File file = null;// 写入后的文件
		try {
			PrintLoanView pl = selectePrintLoanView(sc);
			pl.setpType("好事贷-JY");
			System.out.println(pl);

			Map<String, Object> map = new HashMap<String, Object>();

			if (pl != null) {
				Field[] fields = pl.getClass().getDeclaredFields();// 使用reflect进行对象转换map
				for (Field field : fields) {
					field.setAccessible(true);
					map.put(field.getName(), field.get(pl));
				}
				System.out.println("~~~~~~~~~~~~~map is:" + map);
			}

			type = "放款审批表" + sc.getLoanId();
			// 调用工具类WordGenerator的createDoc方法生成Word文档,并将map写入进去
			file = WordGenerator.createDoc(map, type, source);

			files.add(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return files;
	}

	/**
	 * @throws
	 * 
	 * @Title: templetPrintLoanView
	 * @Description: TODO 打印放款
	 * @param @param file
	 * @param @throws Exception 参数
	 * @return void 返回类型
	 * @throws
	 */
	@Override
	public List<File> templetPrintLoanView(HttpServletRequest req,
			SearchCondition sc) {
		List<File> files = new ArrayList<File>();// 打包的原始文件
		PdfReader reader;
		try {

			PrintLoanView pl = selectePrintLoanView(sc);
			pl.setpType("好事贷-JY");
			System.out.println(pl);

			TempletPrintLoanServiceImpl pdfpl = new TempletPrintLoanServiceImpl();

			System.out.println(req.getSession().getServletContext()
					.getRealPath("resource\\doc\\printLoan.pdf"));

			pdfpl.setTemplatePdfPath(req.getSession().getServletContext()
					.getRealPath("resource\\doc\\printLoan.pdf"));
			// 定义下载路径
			File fileDownload = new File(req.getSession().getServletContext()
					.getRealPath("resource\\download\\"));
			if (!fileDownload.exists()) {
				fileDownload.mkdirs();
			}
			// 模板
			pdfpl.setTargetPdfpath(req.getSession().getServletContext()
					.getRealPath("resource\\download\\printLoan.pdf"));
			pdfpl.setPrintLoanView(pl);

			// 临时文件
			File file = null;

			file = new File(req
					.getSession()
					.getServletContext()
					.getRealPath(
							"resource\\download\\" + sc.getLoanId()
									+ "放款审批表.pdf"));
			if (file.exists()) {
				file.delete();
			} else {
				file.createNewFile();
			}
			reader = new PdfReader(pdfpl.getTemplatePdfPath());

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			PdfStamper ps = new PdfStamper(reader, bos);

			/* 使用中文字体 */
			BaseFont bf = BaseFont.createFont("C:/Windows/Fonts/simsun.ttc,1",
					BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			ArrayList<BaseFont> fontList = new ArrayList<BaseFont>();
			fontList.add(bf);

			AcroFields s = ps.getAcroFields();
			s.setSubstitutionFonts(fontList);

			s.setField("name", pl.getName());
			s.setField("pType", pl.getpType());
			s.setField("periods", pl.getPeriods());
			s.setField("repayCardNo", pl.getRepayCardNo());
			s.setField("repayWay", pl.getRepayWay());
			s.setField("loanPurpose", pl.getLoanPurpose());
			s.setField("rate", pl.getRate());
			s.setField("cCardNumber", pl.getcCardNumber());

			ps.setFormFlattening(true);
			ps.close();

			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bos.toByteArray());
			fos.close();
			bos.close();
			reader.close();

			files.add(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return files;
	}

	/**
	 * 
	 * @Title: templetPrintCreditView
	 * @Description: TODO 打印授信
	 * @param @param file
	 * @param @throws Exception 参数
	 * @return void 返回类型
	 * @throws
	 */
	public List<File> templetPrintCreditView(HttpServletRequest req,
			SearchCondition sc) {
		List<File> files = new ArrayList<File>();//

		PrintCreditView pc = selectePrintCreditView(sc);// 通过查询参数得到打印授信基本信息

		Account account = accountService.queryByUId(sc.getcUserId());// 得到用户实体
		pc.setuName(account.getUserName());// 设置用户名
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		pc.setlTime(sdf.format(new Date()));// 设置操作时间

		TempletPrintLoanServiceImpl pdfpl = new TempletPrintLoanServiceImpl();

		System.out.println(req.getSession().getServletContext()
				.getRealPath("resource\\doc\\printCredit.pdf"));

		pdfpl.setTemplatePdfPath(req.getSession().getServletContext()
				.getRealPath("resource\\doc\\printCredit.pdf"));
		// 定义下载路径
		File fileDownload = new File(req.getSession().getServletContext()
				.getRealPath("resource\\download\\"));
		if (!fileDownload.exists()) {
			fileDownload.mkdirs();
		}
		// 模板
		pdfpl.setTargetPdfpath(req.getSession().getServletContext()
				.getRealPath("resource\\download\\printCredit.pdf"));
		pdfpl.setPrintCreditView(pc);
		// 临时文件

		System.out.println(pdfpl);

		List<MortgageHouse> mh = pc.getMortgageHouse();

		for (MortgageHouse mo : mh) {
			try {

				File file = new File(req
						.getSession()
						.getServletContext()
						.getRealPath(
								"resource\\download\\" + mo.getmHId()
										+ "授信决议表.pdf"));
				file.createNewFile();

				PdfReader reader = new PdfReader(pdfpl.getTemplatePdfPath());
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				PdfStamper ps = new PdfStamper(reader, bos);

				/* 使用中文字体 */
				BaseFont bf = BaseFont.createFont(
						"C:/Windows/Fonts/simsun.ttc,1", BaseFont.IDENTITY_H,
						BaseFont.EMBEDDED);
				ArrayList<BaseFont> fontList = new ArrayList<BaseFont>();
				fontList.add(bf);

				AcroFields s = ps.getAcroFields();
				s.setSubstitutionFonts(fontList);

				s.setField("name", pc.getName());
				s.setField("idNumber", pc.getIdNumber());
				s.setField("apAge", String.valueOf(pc.getAge()));
				s.setField("companyName1", pc.getCompanyName());
				s.setField("phoneNumber", pc.getPhoneNumber());
				s.setField("periods", String.valueOf(pc.getPeriods()));
				s.setField("repayWay", pc.getRepayWay());
				s.setField("rate", pc.getRate());
				s.setField("loanPurpose", pc.getLoanPurpose());
				s.setField("uName", pc.getuName());
				s.setField("lTime", pc.getlTime());

				List<CommonApplicant> co = pc.getCommonApplicant();
				if (co != null) {

					for (int i = 0; i < 3; i++) {

						if (co.size() <= i) {
							break;
						}
						s.setField("CAName" + i, co.get(i).getcAName());
						s.setField("CAIdNumber" + i, co.get(i).getcAIdNumber());
						s.setField("cAge" + i,
								String.valueOf(co.get(i).getAge()));
						s.setField("companyName2" + i, co.get(i)
								.getCompanyName());
						s.setField("CAphoneNumber" + i, co.get(i)
								.getcAPhoneNumber());

					}
				}

				s.setField("houseType", mo.getHouseType());
				s.setField("acreage", String.valueOf(mo.getAcreage()));
				s.setField("houseArea", mo.getHouseArea());
				s.setField("mhouseValue", String.valueOf(mo.getMhouseValue()));
				s.setField("nbComfirmValue", String.valueOf(mo
						.getNbComfirmValue() == null ? BigDecimal.ZERO : mo
						.getNbComfirmValue()));
				s.setField(
						"wuhouseValue",
						String.valueOf(mo.getWuhouseValue() == null ? BigDecimal.ZERO
								: mo.getWuhouseValue()));
				s.setField("gAddress", mo.getgAddress());

				ps.setFormFlattening(true);
				ps.close();

				FileOutputStream fos = new FileOutputStream(file);

				fos.write(bos.toByteArray());

				fos.close();
				bos.close();
				reader.close();
				files.add(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return files;

	}

	/**
	 * 
	 * @Title: packZip
	 * @Description: TODO 文件打包
	 * @param @param files
	 * @param @param LoanId
	 * @param @param req
	 * @param @param zipFile
	 * @param @return 参数
	 * @return File 返回类型
	 * @throws
	 */
	@Override
	public File packZip(List<File> files, Integer LoanId,
			HttpServletRequest req, File zipFile) {

		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;

		try {
			if (zipFile.exists()) {
				zipFile.delete();
			} else {
				zipFile.createNewFile();
			}
			fos = new FileOutputStream(zipFile);
			zos = new ZipOutputStream(new BufferedOutputStream(fos));

			byte[] bufs = new byte[1024 * 10];
			for (int i = 0; i < files.size(); i++) {

				ZipEntry zipEntry = new ZipEntry(files.get(i).getName());
				try {
					zos.putNextEntry(zipEntry);
				} catch (Exception e) {
					System.out.println(files.get(i).getName() + "文件重复");
					continue;

				}

				// 读取待压缩的文件并写进压缩包里
				fis = new FileInputStream(files.get(i));
				bis = new BufferedInputStream(fis, 1024 * 10);
				int read = 0;
				while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
					zos.write(bufs, 0, read);
				}
				bis.close();
				fis.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				zos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return zipFile;
	}

	public TempletPrintLoanServiceImpl() {
		super();
	}

	public TempletPrintLoanServiceImpl(String templatePdfPath, String ttcPath,
			String targetPdfpath, PrintLoanView printLoanView) {
		super();
		this.templatePdfPath = templatePdfPath;
		this.ttcPath = ttcPath;
		this.targetPdfpath = targetPdfpath;
		this.printLoanView = printLoanView;
	}

	public String getTemplatePdfPath() {
		return templatePdfPath;
	}

	public void setTemplatePdfPath(String templatePdfPath) {
		this.templatePdfPath = templatePdfPath;
	}

	public String getTtcPath() {
		return ttcPath;
	}

	public void setTtcPath(String ttcPath) {
		this.ttcPath = ttcPath;
	}

	public String getTargetPdfpath() {
		return targetPdfpath;
	}

	public void setTargetPdfpath(String targetPdfpath) {
		this.targetPdfpath = targetPdfpath;
	}

	public PrintLoanView getPrintLoanView() {
		return printLoanView;
	}

	public void setPrintLoanView(PrintLoanView printLoanView) {
		this.printLoanView = printLoanView;
	}

	@Override
	public String toString() {
		return "TempletPrintLoanServiceImpl [templatePdfPath="
				+ templatePdfPath + ", ttcPath=" + ttcPath + ", targetPdfpath="
				+ targetPdfpath + ", printLoanView=" + printLoanView + "]";
	}

	public PrintCreditView getPrintCreditView() {
		return printCreditView;
	}

	public void setPrintCreditView(PrintCreditView printCreditView) {
		this.printCreditView = printCreditView;
	}

}
