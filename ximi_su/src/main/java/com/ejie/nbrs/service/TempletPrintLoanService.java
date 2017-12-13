package com.ejie.nbrs.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.entity.PrintCreditView;
import com.ejie.nbrs.entity.PrintLoanView;

/**
 * 
 * ClassName:TempletPrintLoanService
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月30日 下午5:30:36
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public interface TempletPrintLoanService {
	  
	  /**
	   * 
	  * @Title: selectePrintLoanView
	  * @Description: TODO 查询打印放款
	  * @param @param sc
	  * @param @return    参数
	  * @return PrintLoanView    返回类型
	  * @throws
	   */
	  PrintLoanView selectePrintLoanView(SearchCondition sc);
	  /**
	   * 
	  * @Title: selectePrintCreditView
	  * @Description: TODO 查询打印授信
	  * @param @param sc
	  * @param @return    参数
	  * @return PrintLoanView    返回类型
	  * @throws
	   */
	  PrintCreditView selectePrintCreditView(SearchCondition sc);
	  
	  /**
	   * 
	  * @Title: templetPrintLoanView
	  * @Description: TODO pdf下载放款
	  * @param @param req
	  * @param @param sc
	  * @param @return    参数
	  * @return List<File>    返回类型
	  * @throws
	   */
	  List<File> templetPrintLoanView(HttpServletRequest req, SearchCondition sc);
	  /**
	   * 
	  * @Title: templetPrintCreditView
	  * @Description: TODO pdf下载授信
	  * @param @param req
	  * @param @param sc
	  * @param @return    参数
	  * @return List<File>    返回类型
	  * @throws
	   */
	  List<File> templetPrintCreditView(HttpServletRequest req,SearchCondition sc);
	  /**
	   * 
	  * @Title: packZip
	  * @Description: TODO 文件打包
	  * @param @param files
	  * @param @param LoanId
	  * @param @param req
	  * @param @param zipFile
	  * @param @return    参数
	  * @return File    返回类型
	  * @throws
	   */
	  File packZip(List<File> files,Integer LoanId,HttpServletRequest req,File zipFile);
		/**
		 * 
		* @Title: docPrintLoan
		* @Description: TODO word下载放款
		* @param @param req
		* @param @param sc 传入参数封装类
		* @param @return    参数
		* @return List<File>    多个文件集合
		* @throws
		 */
	  List<File> docPrintLoan(HttpServletRequest req, SearchCondition sc);
		/**
		 * 
		* @Title: docPrintCredit
		* @Description: TODO word下载授信
		* @param @param req
		* @param @param sc 传入参数封装类
		* @param @return    参数
		* @return List<File>    多个文件集合
		* @throws
		 */
	  List<File> docPrintCredit(HttpServletRequest req, SearchCondition sc) ;
}
