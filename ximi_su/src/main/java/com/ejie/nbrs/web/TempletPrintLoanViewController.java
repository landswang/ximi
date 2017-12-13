package com.ejie.nbrs.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejie.nbrs.dto.BaseResult;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.service.TempletPrintLoanService;

/**
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/TempletPrint")
public class TempletPrintLoanViewController {
	@Autowired
	private TempletPrintLoanService tpService;

//	/**
//	 * 
//	 * @Title: downCredit
//	 * @Description: TODO 打印授信
//	 * @param @param sc
//	 * @param @param req
//	 * @param @return
//	 * @param @throws Exception 参数
//	 * @return ResponseEntity<byte[]> 返回类型
//	 * @throws
//	 */
//	@RequestMapping("/downCredit")
//	@CrossOrigin
//	@ResponseBody
//	public File downCredit(@RequestBody SearchCondition sc,
//			HttpServletRequest req) throws Exception {
//
//		List<File> files = null;// 打包的原始文件
//		req.setCharacterEncoding("utf-8");
//
//		files = tpService.templetPrintCreditView(req, sc);
//
//		File endFile = null;// 打包后的zip文件
//
//		File zipFile = new File(req
//				.getSession()
//				.getServletContext()
//				.getRealPath(
//						"resource\\download\\" + sc.getLoanId()
//								+ "printCredit.zip"));
//		endFile = tpService.packZip(files, sc.getLoanId(), req, zipFile);//
//
//		for (File fi : files) {
//			fi.delete();
//		}
//
//		return endFile;
//
//	}
//
//	/**
//	 * 
//	 * @Title: downLoan
//	 * @Description: TODO 打印放款
//	 * @param @param sc
//	 * @param @param req
//	 * @param @return
//	 * @param @throws Exception 参数
//	 * @return ResponseEntity<byte[]> 返回类型
//	 * @throws
//	 */
//	@RequestMapping("/downLoan")
//	@CrossOrigin
//	@ResponseBody
//	public File downLoan(@RequestBody SearchCondition sc, HttpServletRequest req)
//			throws Exception {
//		List<File> files = null;// 打包的原始文件
//		req.setCharacterEncoding("utf-8");
//
//		files = tpService.templetPrintLoanView(req, sc);
//
//		File endFile = null;// 打包后的zip文件
//
//		File zipFile = new File(req
//				.getSession()
//				.getServletContext()
//				.getRealPath(
//						"resource\\download\\" + sc.getLoanId()
//								+ "printLoan.zip"));
//		endFile = tpService.packZip(files, sc.getLoanId(), req, zipFile);//
//
//		for (File fi : files) {
//			fi.delete();
//		}
//
//		return endFile;
//
//	}

	/**
	 * 
	 * @Title: downCreditZip
	 * @Description: TODO 下载授信压缩包
	 * @param @param sc 
	 * cUserId：用户id；serialNo：流水号； loanId ：贷款编号；
	 * @param @param req
	 * @param @return
	 * @param @throws Exception 参数
	 * @return BaseResult<File> 返回类型
	 * @throws
	 */
	@RequestMapping("/downCreditZip2")
	@CrossOrigin
	@ResponseBody
	public BaseResult<File> downCreditZip(@RequestParam (value="loanId")Integer loanId,
			@RequestParam (value="serialNo")String serialNo,@RequestParam (value="cUserId")Integer cUserId,
			HttpServletRequest req, HttpServletResponse response)throws Exception {
		SearchCondition sc=new SearchCondition();
		sc.setLoanId(loanId);
		sc.setSerialNo(serialNo);
		sc.setcUserId(cUserId);
		int code = 0;
		String msg = "";
//		String str = "";

		List<File> files = null;// 打包的原始文件
		req.setCharacterEncoding("utf-8");

		files = tpService.templetPrintCreditView(req, sc);//写入模版得到写入后的文件结果集

		File endFile = null;// 打包后的zip文件

		File zipFile = new File(req
				.getSession()
				.getServletContext()
				.getRealPath(
						"resource\\download\\" + sc.getLoanId()
								+ "授信决议表.zip"));
		endFile = tpService.packZip(files, sc.getLoanId(), req, zipFile);//得到压缩包

		for (File fi : files) {
			fi.delete();
		}

		if (endFile.exists()) {
			response.setContentType("application/octet-stream");
			// 这里为避免下载时中文乱码，需要进行url编码
			String name = URLEncoder.encode(endFile.getName(), "UTF-8");
			response.setHeader("Content-disposition", "attachment;filename="
					+ name);
			OutputStream os = response.getOutputStream();
			IOUtils.copy(new FileInputStream(endFile), os);
			os.flush();
			os.close();
//			endFile.delete();//下载完毕，删除临时文件
			
			code = 1;
			msg = "请求成功，开始下载。。。";
		} else {
			msg = "没有文件";
		}
		return new BaseResult<File>(code, msg, null);

	}
	/**
	 * 
	* @Title: downLoanZip
	* @Description: TODO 下载放款压缩包
	* @param @param sc
	* cUserId：用户id；serialNo：流水号； loanId ：贷款编号；
	* @param @param req
	* @param @param response
	* @param @return
	* @param @throws Exception    参数
	* @return BaseResult<File>    返回类型
	* @throws
	 */
	@RequestMapping("/downLoanZip2")
	@CrossOrigin
	@ResponseBody
	public BaseResult<File> downLoanZip(@RequestParam (value="loanId")Integer loanId,
			@RequestParam (value="serialNo")String serialNo,@RequestParam (value="cUserId")Integer cUserId,
			HttpServletRequest req, HttpServletResponse response) throws Exception {
		SearchCondition sc=new SearchCondition();
		sc.setLoanId(loanId);
		sc.setSerialNo(serialNo);
		sc.setcUserId(cUserId);
		int code = 0;
		String msg = "";
//		String str = "";

		List<File> files = null;// 打包的原始文件
		req.setCharacterEncoding("utf-8");

		files = tpService.templetPrintLoanView(req, sc);//写入模版得到写入后的文件结果集

		File endFile = null;// 打包后的zip文件

		File zipFile = new File(req
				.getSession()
				.getServletContext()
				.getRealPath(
						"resource\\download\\" + sc.getLoanId()
								+ "放款审批表.zip"));
		endFile = tpService.packZip(files, sc.getLoanId(), req, zipFile);//得到压缩包

		for (File fi : files) {
			fi.delete();
		}
		if (endFile.exists()) {
			
			response.setContentType("application/octet-stream");
			// 这里为避免下载时中文乱码，需要进行url编码
			String name = URLEncoder.encode(endFile.getName(), "UTF-8");
			response.setHeader("Content-disposition", "attachment;filename="
					+ name);
			OutputStream os = response.getOutputStream();
			IOUtils.copy(new FileInputStream(endFile), os);
			os.flush();
			os.close();
//			endFile.delete();//下载完毕，删除临时文件
			
			code = 1;
			msg = "请求成功，开始下载。。。";
		} else {
			msg = "没有文件";
		}
		return new BaseResult<File>(code, msg, null);

	}
	
	
	/**
	 * 
	* @Title: docLoanZip
	* @Description: TODO 下载word格式放款审批表
	* @param @param req
	* @param @param response
	* @param @param sc
	* @param @return
	* @param @throws Exception    参数
	* @return BaseResult<File>    返回类型
	* @throws
	 */
	@RequestMapping("/downLoanZip")
	@CrossOrigin
	@ResponseBody
	public BaseResult<File> docLoanZip(HttpServletRequest req, HttpServletResponse response,@RequestParam (value="loanId")Integer loanId,
			@RequestParam (value="serialNo")String serialNo,@RequestParam (value="cUserId")Integer cUserId) throws Exception{
		req.setCharacterEncoding("utf-8");
		int code = 0;
		String msg = "";
		List<File> files = null;// 打包的原始文件
		File endFile = null;// 打包后的zip文件
		
		SearchCondition sc=new SearchCondition();
		sc.setLoanId(loanId);
		sc.setSerialNo(serialNo);
		sc.setcUserId(cUserId);
		
		files=tpService.docPrintLoan(req, sc);
		
		// 定义下载路径
		File fileDownload = new File(req.getSession().getServletContext()
				.getRealPath("resource\\download\\"));
		if (!fileDownload.exists()) {
			fileDownload.mkdirs();
		}
		
		File zipFile = new File(req
				.getSession()
				.getServletContext()
				.getRealPath(
						"resource\\download\\" 
								+ "放款审批表"+ sc.getLoanId()+".zip"));
		endFile = tpService.packZip(files, sc.getLoanId(), req, zipFile);//得到压缩包

		for (File fi : files) {
			fi.delete();
		}
		if (endFile.exists()) {
			response.setContentType("application/zip");
			// 这里为避免下载时中文乱码，需要进行url编码
			String name = URLEncoder.encode(endFile.getName(), "UTF-8");
			response.setHeader("Content-disposition", "attachment;filename="+ name);
			OutputStream os = response.getOutputStream();
			IOUtils.copy(new FileInputStream(endFile), os);
			os.flush();
			os.close();
//			endFile.delete();//下载完毕，删除临时文件
			
			code = 1;
			msg = "请求成功，开始下载。。。";
		} else {
			msg = "没有文件";
		}
		
		return new BaseResult<File>(code, msg, null);
		
	}

	/**
	 * 
	* @Title: docCreditZip
	* @Description: TODO 下载word格式授信决议表
	* @param @param req
	* @param @param response
	* @param @param sc
	* @param @return
	* @param @throws Exception    参数
	* @return BaseResult<File>    返回类型
	* @throws
	 */
	@RequestMapping("/downCreditZip")
	@CrossOrigin
	@ResponseBody
	public BaseResult<File> docCreditZip(HttpServletRequest req, HttpServletResponse response,@RequestParam (value="loanId")Integer loanId,
			@RequestParam (value="serialNo")String serialNo,@RequestParam (value="cUserId")Integer cUserId) throws Exception{
		req.setCharacterEncoding("utf-8");
		int code = 0;
		String msg = "";
		List<File> files = null;// 打包的原始文件
		File endFile = null;// 打包后的zip文件
		
		SearchCondition sc=new SearchCondition();
		sc.setLoanId(loanId);
		sc.setSerialNo(serialNo);
		sc.setcUserId(cUserId);
		
		files=tpService.docPrintCredit(req, sc);
		
		// 定义下载路径
		File fileDownload = new File(req.getSession().getServletContext()
				.getRealPath("resource\\download\\"));
		if (!fileDownload.exists()) {
			fileDownload.mkdirs();
		}
		
		File zipFile = new File(req
				.getSession()
				.getServletContext()
				.getRealPath(
						"resource\\download\\" 
								+ "授信决议表"+ sc.getLoanId()+".zip"));
		endFile = tpService.packZip(files, sc.getLoanId(), req, zipFile);//得到压缩包

		for (File fi : files) {
			fi.delete();
		}
		if (endFile.exists()) {
			response.setContentType("application/zip");
			// 这里为避免下载时中文乱码，需要进行url编码
			String name = URLEncoder.encode(endFile.getName(), "UTF-8");
			response.setHeader("Content-disposition", "attachment;filename="+ name);
			OutputStream os = response.getOutputStream();
			IOUtils.copy(new FileInputStream(endFile), os);
			os.flush();
			os.close();
//			endFile.delete();//下载完毕，删除临时文件
			
			code = 1;
			msg = "请求成功，开始下载。。。";
		} else {
			msg = "没有文件";
		}
		
		return new BaseResult<File>(code, msg, null);
		
	}
}