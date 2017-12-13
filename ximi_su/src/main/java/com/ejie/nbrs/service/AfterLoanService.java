package com.ejie.nbrs.service;

import java.util.List;

import com.ejie.nbrs.dto.AfterLoanView;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.util.ZPageUtil;

/**
 * 
 * ClassName:AfterLoanService 贷后管理服务接口
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月8日 上午11:40:29
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public interface AfterLoanService {
	
	/**
	 * AfterLoanViewList 通过条件查询贷后管理的结果集
	 * @param sc 条件包括：
	 * 1.贷款编号loanId；2.客户姓名name；3.查看放款起始日期startTime-查看放款结束日期endTime
	 * @return 贷后管理的结果集
	 */
	List<AfterLoanView> afterLoanViewList(SearchCondition sc);
	
	/**
	 * AfterLoanViewCount 查询贷后管理满足查询条件的总条数
	 * @param sc 条件包括：
	 * 1.贷款编号loanId；2.客户姓名name；3.查看放款起始日期startTime-查看放款结束日期endTime
	 * @return 满足条件的总条数
	 */
	int afterLoanViewCount(SearchCondition sc);
	
	/**
	 * AfterLoanViewById 通过贷款编号查看贷款详细信息
	 * @param sc loanId贷款编号
	 * @return 贷款详细信息
	 */
	AfterLoanView afterLoanViewById(SearchCondition sc);
	
	/**
	 * AfterLoanViewPage 查询分页的贷后管理结果集
	 * @param sc 搜索条件封装类
	 * @return
	 */
	ZPageUtil<AfterLoanView> afterLoanViewPage(SearchCondition sc);
}
