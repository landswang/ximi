package com.ejie.nbrs.dao;

import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.entity.PrintCreditView;
import com.ejie.nbrs.entity.PrintLoanView;

/**
 * 
 * ClassName:TempletPrintLoanDao 
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月30日 下午5:27:49
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public interface TempletPrintLoanDao {
	  
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
}
