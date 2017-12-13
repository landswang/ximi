package com.ejie.nbrs.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import com.ejie.nbrs.dto.NewStorageView;
import com.ejie.nbrs.dto.ProducInformation;
import com.ejie.nbrs.dto.StorageView;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.dto.productDetails;
import com.ejie.nbrs.ejieinterface.entity.RepaymentSchedule;
import com.ejie.nbrs.entity.Guarantee;
import com.ejie.nbrs.entity.GuaranteeManagement;
import com.ejie.nbrs.entity.LogManagement;
import com.ejie.nbrs.entity.MortgageCar;
import com.ejie.nbrs.entity.MortgageHouse;
import com.ejie.nbrs.entity.Mortgager;
import com.ejie.nbrs.entity.Warrant;
import com.ejie.nbrs.entity.ProductView;

/**
 * 
 * ClassName:InStorageViewDao 出入库持久化操作
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年7月25日 下午5:10:07
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public interface StorageViewDao {

	/**
	 * insertStorage 添加数据
	 * 
	 * @return
	 */
	int insertStorage(GuaranteeManagement gm);

	/**
	 * searchCountStorage 查询出入库条数
	 * 
	 * @param sc
	 *            查询条件
	 * @return 条数
	 */
	int searchCountStorage(SearchCondition sc);

	/**
	 * storageViewList 出入库结果集
	 * 
	 * @param sc
	 *            查询条件
	 * @return 记录结果集
	 */
	List<StorageView> storageViewList(SearchCondition sc);

	/**
	 * alterInStorage 修改押品状态
	 * 
	 * @param sc
	 *            修改条件，传入修改后的状态：status和修改的id：dataIndex
	 * @return 修改是否成功
	 */
	boolean alterInStorage(SearchCondition sc);

	/**
	 * searchProductView 查询出入库信息
	 * 
	 * @param sc
	 *            查询条件，通过输入loanId贷款编号查询
	 * @return
	 */
	ProductView searchProductView(SearchCondition sc);

	/**
	 * alterProductView 修改——提交出库审批资料
	 * 
	 * @param sc
	 *            loanId：要修改的贷款编号；
	 *             status:修改后的状态码；
	 *              outReason:出库原因；
	 *            startTime：入库时间；
	 *             endTime：出库时间； 
	 *             loanVoucher：附件图片信息；
	 *            inApplyTime：入库申请时间；
	 *             outApplyTime：出库申请时间；
	 *              outRemark：出库/入库说明.
	 * @return
	 */
	boolean alterProductView(SearchCondition sc);

	/**
	 * searchProducInformation 查看指定押品id的押品详细信息
	 * 
	 * @param sc
	 *            loanId:需要查看的押品id
	 * @return 押品详细信息ProducInformation
	 */
	ProducInformation searchProducInformation(SearchCondition sc);

	/**
	 * newProducInformation 查看指定押品id的押品详细信息____________最新！！
	 * 
	 * @param sc
	 *            loanId:需要查看的押品id
	 * @return 押品详细信息productDetails
	 */
	productDetails newProducInformation(SearchCondition sc);

	/**
	 * 根据抵押人id查询抵押人
	 * 
	 * @return
	 */
	List<Mortgager> selectMortgagerListByGmAppId(@Param(value = "gmAppId") Integer gmAppId);

	/**
	 * 根据抵押车id查询 查询抵押车
	 * 
	 * @return
	 */
	List<MortgageCar> selectMortgageCarListByGmAppId(
			@Param(value = "mcarId")String mcarId);

	/**
	 * 根据抵押房id查询 查询抵押房
	 * 
	 * @return
	 */
	List<MortgageHouse> selectMortgageHouseListByGmAppId(
			@Param(value = "mhouseId")String mhouseId);
	
	/**
	 * 根据权证id查询权证信息
	 * @return
	 */
	Warrant selectWarrantByWarrantId(@Param(value = "warrantId")String warrantId);
	

	/**
	 * searchCountStorage 新:查询出入库条数
	 * 
	 * @param sc
	 *            查询条件
	 * @return 条数
	 */
	int newSearchCountStorage(SearchCondition sc);
	

	/**
	 * storageViewList 新：出入库结果集
	 * 
	 * @param sc
	 *            查询条件
	 * @return 记录结果集
	 */
	List<NewStorageView> newStorageViewList(SearchCondition sc);
	
	/**
	 * 查询还款计划表信息
	 * @param warrantId
	 * @return
	 */
	RepaymentSchedule selectRepaymentScheduleByLoanId(@Param(value = "loanId") Integer loanId);
	/**
	 * 通过贷款id查询抵押物
	 * @return
	 */
	Guarantee selectGuarantee(@Param(value = "serialNo") String serialNo);
	
	/**
	 * 新增日志管理记录
	 * @param logManagement
	 * @return
	 */
	int insertLogManagement(LogManagement logManagement);
	/**
	 * 通过贷款编号查看操作日志信息
	 * @param loanId
	 * @return
	 */
	List<LogManagement> selectLogManagementList(Map<String,String> map);
}
