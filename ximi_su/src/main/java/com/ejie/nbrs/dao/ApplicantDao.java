package com.ejie.nbrs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ejie.nbrs.ejieinterface.entity.ECommonCustomer;
import com.ejie.nbrs.ejieinterface.entity.EMortgager;
import com.ejie.nbrs.ejieinterface.entity.MasterInfo;
import com.ejie.nbrs.ejieinterface.entity.RepayPlan;
import com.ejie.nbrs.ejieinterface.entity.RepaymentSchedule;
import com.ejie.nbrs.entity.Guarantee;
import com.ejie.nbrs.entity.GuaranteeValue;
import com.ejie.nbrs.entity.LoanInfo;

/**
 * 
 * ClassName:ApplicantDao
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年7月20日 上午9:39:35
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public interface ApplicantDao {


  List<EMortgager> updateLoanInfo(EMortgager record);

  Integer updateMortgagerHouse(EMortgager record);

  /**
   * queryLoanIdBySerialNo:根据serialno 返回 loanid
   * 
   * @param @param serialNo
   * @param @return 设定文件
   * @return Integer DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  Integer queryLoanIdBySerialNo(@Param("serialNo") String serialNo);

  /**
   * insert:插入一条主借人信息信息(未完成 )
   * 
   * @param @param record
   * @param @return 设定文件
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  int insertApplicant(MasterInfo record);

  int deleteBySerialNo(@Param("serialNo") String userId);

  /**
   * insert:插入一条共借人信息(未完成 )
   * 
   * @param @param record
   * @param @return 设定文件
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  int insertCommonApplicant(ECommonCustomer record);

  /**
   * insert:插入一条配偶信息(未完成 )
   * 
   * @param @param record
   * @param @return 设定文件
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  int insertCouple(MasterInfo record);

  /**
   * insert:插入一条抵押车信息(未完成 )
   * 
   * @param @param record
   * @param @return 设定文件
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  int insertMortgagerCar(EMortgager record);

  /**
   * insert:插入一条抵押房信息(未完成 )
   * 
   * @param @param record
   * @param @return 设定文件
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  int insertMortgagerHouse(EMortgager record);

  /**
   * 
   * insertGuarantee:插入一条抵押物对应关系表
   * 
   * @param @return 设定文件
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  int insertGuarantee(Guarantee g);

  /**
   * 
   * insertGuarantee:插入一条抵押物对应关系表
   * 
   * @param @return 设定文件
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  int insertGuaranteeValue(GuaranteeValue gv);

  /**
   * 
   * insertRepaySchInfo:(这里用一句话描述这个方法的作用)
   * 
   * @param @param rs
   * @param @return 设定文件
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  int insertRepaySchInfo(RepaymentSchedule rs);

  List<LoanInfo> selectLoanInfoStatus(HashMap<String, String> hm);

  int saverSchedule(RepaymentSchedule rschedule);

  int saveRepayPlan(List<RepayPlan> rps);

  int alterNodeStatus(Map<String, String> map);
}
