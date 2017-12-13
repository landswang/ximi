package com.ejie.nbrs.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejie.nbrs.dto.BaseResult;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.entity.InAStatisticalEntity;
import com.ejie.nbrs.entity.TzFormView;
import com.ejie.nbrs.service.LoanInfoService;
import com.ejie.nbrs.service.StatisticalFormService;
import com.ejie.nbrs.util.StringExUtil;
import com.ejie.nbrs.util.WordGenerator;
import com.ejie.nbrs.util.ZPageUtil;

/**
 * 
 * ClassName:StatisticalFormController 统计报表
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月10日 下午2:57:00
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
@Controller
@RequestMapping("/statisticalForm")
public class StatisticalFormController {
	

	@Autowired
	private LoanInfoService loanService;
	@Autowired
	private StatisticalFormService sfs;
	
	/**
	 * 
	 * downInAStatisticalExcel: 下载进件统计excel表
	 * @param  @param req
	 * @param  @param response
	 * @param  @param sc
	 * startTime：筛选开始时间；
	 * endTime：筛选结束时间；
	 * loanVoucher：筛选放款渠道；
	 * aBaseName：筛选城市；
	 * eProduct：筛选贷款用途；1：综合消费；2：生产经营。其他：全部。。；
	 * @param  @throws Exception    设定文件
	 * @return void    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
	@RequestMapping("/downInAStatisticalExcel")
	public void downInAStatisticalExcel(HttpServletRequest req, HttpServletResponse response,
			SearchCondition sc) throws Exception {
		req.setCharacterEncoding("utf-8");
		File file = null;// 临时文件
		List<InAStatisticalEntity> list=sfs.searchInAStatistical(sc);
		// 写入值准备
		Map<String, Object> data = sfs.mapFromDate(list, sc);
		// 创建写入后的模版文件
		file = WordGenerator.createExcel(data, "HSD-JJ" + sc.getStartTime()
				+ "_" + sc.getEndTime(), "HSD-JJ.ftl");
		if (file.exists()) {
			response.setContentType("application/zip");
			// 这里为避免下载时中文乱码，需要进行url编码
			String name = URLEncoder.encode(file.getName(), "UTF-8");
			response.setHeader("Content-disposition", "attachment;filename="
					+ name);
			OutputStream os = response.getOutputStream();
			IOUtils.copy(new FileInputStream(file), os);
			os.flush();
			os.close();
			file.delete();// 下载完毕，删除临时文件
		} else {
		}
	}
	
	/**
	 * 
	 * inAStatistical: 进件统计查询接口
	 * @param  @param sc
	 * startTime：筛选开始时间；
	 * endTime：筛选结束时间；
	 * loanVoucher：筛选放款渠道；
	 * aBaseName：筛选城市；
	 * eProduct：筛选贷款用途；1：综合消费；2：生产经营。其他：全部。。；
	 * @param  @return    设定文件
	 * @return BaseResult<List<StatisticalForm>>    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
	@RequestMapping(value = "/inAStatistical", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public BaseResult<List<InAStatisticalEntity>> inAStatistical(@RequestBody SearchCondition sc){
		System.out.println(sc);
		int code = 0;
		String msg = "";
		List<InAStatisticalEntity> list=null;
		
		try {
			list=sfs.searchInAStatistical(sc);
			if(list==null){
				code=0;
				msg="执行成功，但是没有查到结果。";
			}
			code = 1;
			msg = "执行成功";
		} catch (Exception e) {
			code = 0;
			msg = "执行失败";
			e.printStackTrace();
		}
		System.out.println(list);
		return new BaseResult<List<InAStatisticalEntity>>(code, msg, list);
	}
	
	
	/**
	 * 
	 * downExcel: 台账导出excel
	 * 
	 * @param @param req
	 * @param @param response
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @throws
	 * @since CodingExample　Ver 1.1
	 */
	@RequestMapping("/downExcel")
	public void downExcel(HttpServletRequest req, HttpServletResponse response,
			SearchCondition sc) throws Exception {
		req.setCharacterEncoding("utf-8");
		File file = null;// 临时文件
		sc.setPageSize(10000);//最大显示10000条
		ZPageUtil<String> list = sfs.showLoanViewList(sc);
		// 写入值准备
		Map<String, Object> data = sfs.mapFromDate1(list, sc);
		// 创建写入后的模版文件
		file = WordGenerator.createExcel(data, "HSD-TZ" + sc.getStartTime()
				+ "_" + StringExUtil.StringPattern(sc.getEndTime(), "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd") , "HSD.ftl");

		if (file.exists()) {
			response.setContentType("application/zip");
			// 这里为避免下载时中文乱码，需要进行url编码
			String name = URLEncoder.encode(file.getName(), "UTF-8");
			response.setHeader("Content-disposition", "attachment;filename="
					+ name);
			OutputStream os = response.getOutputStream();
			IOUtils.copy(new FileInputStream(file), os);
			os.flush();
			os.close();
			file.delete();// 下载完毕，删除临时文件
		} else {
		}
	}

	/**
	 * 
	 * downExcelList: 台账查询excel表单内容
	 * 
	 * @param @param req
	 * @param @param response
	 * @param @param sc
	 * startTime：筛选开始时间；
	 * endTime：筛选结束时间；
	 * loanVoucher：筛选放款渠道；
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return Map<String,Object> DOM对象
	 * @throws
	 * @since CodingExample　Ver 1.1
	 */
	@RequestMapping("/excelList")
	@CrossOrigin
	@ResponseBody
	public BaseResult<ZPageUtil<TzFormView>> excelList(HttpServletRequest req,
			HttpServletResponse response, @RequestBody SearchCondition sc) throws Exception {
		System.out.println(sc);
		int code = 0;
		String msg = "";
		req.setCharacterEncoding("utf-8");
		ZPageUtil<TzFormView> list = null;
		try {
			list = sfs.searchTzFormViewlist(sc);
				code = 1;
				msg = "执行成功";

		} catch (Exception e) {
			code = 0;
			msg = "执行失败";
			e.printStackTrace();
		}
		return new BaseResult<ZPageUtil<TzFormView>>(code, msg, list);
	}
	
	
	
	
	
	
//	/**
//	 * scForm 查询放款、授信报表
//	 * 
//	 * @param map dataIndex：查看年份；
//	 * eProduct：报表类型； 1为授信，2为放款；
//	 * @return
//	 */
//	@RequestMapping(value = "/scForm", method = RequestMethod.POST)
//	@CrossOrigin
//	@ResponseBody
//	public BaseResult<List<StatisticalForm>> scForm(@RequestBody SearchCondition sc){
//		System.out.println(sc);
//		int code = 0;
//		String msg = "";
//		List<StatisticalForm> list=null;
//		
//		try {
//			list=sfs.searchStatisticalForm(sc);
//			code = 1;
//			msg = "执行成功";
//		} catch (Exception e) {
//			code = 0;
//			msg = "执行失败";
//			e.printStackTrace();
//		}
//		System.out.println(list);
//		return new BaseResult<List<StatisticalForm>>(code, msg, list);
//	}
//
//	/**
//	 * scForm 查询放款、授信报表
//	 * 
//	 * @param map dataIndex：查看年份；
//	 * @return
//	 */
//	@RequestMapping(value = "/lendingForm", method = RequestMethod.POST)
//	@CrossOrigin
//	@ResponseBody
//	public BaseResult<List<LendingForm>> lendingForm(@RequestBody SearchCondition sc){
//		System.out.println(sc);
//		int code = 0;
//		String msg = "";
//		List<LendingForm> list=null;
//		
//		try {
//			list=sfs.searchLendingForm(sc);
//			code = 1;
//			msg = "执行成功";
//		} catch (Exception e) {
//			code = 0;
//			msg = "执行失败";
//			e.printStackTrace();
//		}
//		System.out.println(list);
//		return new BaseResult<List<LendingForm>>(code, msg, list);
//	}
	
}
