package com.ejie.nbrs.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.ejie.nbrs.dto.AfterLoanView;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.ejieinterface.entity.RepayPlan;
import com.ejie.nbrs.ejieinterface.entity.RepaymentSchedule;

/**
 * 
 * ClassName:AfterLoanDao 贷后管理持久层
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月8日 上午11:30:16
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public interface AfterLoanDao {
	
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
	 * 通过贷款编号查看还款信息
	 * @param loanId
	 * @return
	 */
	RepaymentSchedule selectRSchedule(@Param(value="loanId") Integer loanId);
	/**
	 * 查询该贷款编号下的还款计划详情
	 * @param loanId
	 * @return
	 */
	List<RepayPlan> selectRepayPlan(@Param(value="loanId") Integer loanId);

}
