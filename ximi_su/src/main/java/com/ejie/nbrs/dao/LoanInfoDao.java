package com.ejie.nbrs.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import com.ejie.nbrs.dto.AccessoryInfo;
import com.ejie.nbrs.dto.LoaninfoIndex;
import com.ejie.nbrs.dto.LogView;
import com.ejie.nbrs.dto.NewLoanView;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.entity.CommonApplicant;
import com.ejie.nbrs.entity.FilePathView;
import com.ejie.nbrs.entity.GrantMoney;
import com.ejie.nbrs.entity.GuaranteeValue;
import com.ejie.nbrs.entity.LoanAudit;
import com.ejie.nbrs.entity.LoanInfo;
import com.ejie.nbrs.entity.MateInfo;
import com.ejie.nbrs.entity.MortgageCar;
import com.ejie.nbrs.entity.MortgageHouse;

public interface LoanInfoDao {

  /**
   * 查询所有产品类型
   * 
   * @return
   */
  List<LoanInfo> searchAllProduct();

  int insertByMasterInfo(LoanInfo loaninfo);

  /**
   * alterStatus 授信审核、放款确认状态修改
   * 
   * @param sc loanId，需要修改状态的id(loanId)； status，修改后的状态；
   * @return 返回成功否
   */
  boolean alterStatus(SearchCondition sc);

  /**
   * alterLoanView 授信审核、放款确认状态修改
   * 
   * @param sc loanId，需要修改状态的id(loanId)； status，修改后的状态； startTime，放款日期； eProduct，放款模式;
   *        loanVoucher,上传凭证；
   * @return 返回成功否
   */
  boolean alterLoanView(SearchCondition sc);

  /**
   * 查询某个人档案详情
   * 
   * @param 通过传入loanId查询 ，查询loanId（贷款id）
   * @return 返回个人档案详情
   */
  NewLoanView showLoanView(SearchCondition sc);

  /**
   * 根据主借人编号查询共借人信息 通过主借人id去找共借人
   * 
   * @param loanId
   * @return
   */
  List<CommonApplicant> selectCommonApplicantByCAInfoId(@Param(value = "cAInfoId") Integer cAInfoId);

  // /**
  // * 根据贷款编号查询抵押物信息
  // * @param loanId
  // * @return
  // */
  // Guarantee selectGuaranteeByGuaranteeId(Integer guaranteeId);

  /**
   * 根据抵押物中抵押车编号查询 查询贷款人抵押车
   * 
   * @return
   */
  List<MortgageCar> selectMortgageCarListByMcarId(@Param(value = "mcarId") String mcarId);

  /**
   * 根据抵押物中抵押房编号查询 查询贷款人抵押房
   * 
   * @return
   */
  List<MortgageHouse> selectMortgageHouseListByMhouseId(@Param(value = "mhouseId") String mhouseId);

  /**
   * 根据贷款编号编号查询 查询放款信息
   * 
   * @return
   */
  GrantMoney selectGrantMoneyByLoanId(@Param(value = "loanId") String loanId);

  /**
   * showWarrantByLoanId 查看该贷款编号下关联的押品权证信息
   * 
   * @param sc loanid 贷款编号
   * @return
   */
  NewLoanView showWarrantByLoanId(SearchCondition sc);

  /**
   * 获取文件路径列表
   * 
   * @param fp
   * @return
   */
  List<FilePathView> getFilePath(FilePathView fp);
  
  /**
   * 获取文件路径列表
   * 
   * @param fp
   * @return
   */
  List<FilePathView> getXwFilePath(SearchCondition sc);

  /**
   * 添加放款信息
   * 
   * @param loanInfo 贷款信息
   * @return
   */
  int insertGrantMoney(LoanInfo loanInfo);

  /**
   * 通过贷款编号查看贷款信息
   * 
   * @param loanId
   * @return
   */
  LoanInfo selectLoanInfoByLoanId(@Param(value = "loanId") Integer loanId);

  /**
   * 根据配偶id查询配偶信息
   * 
   * @return
   */
  MateInfo selectMateInfo(@Param(value = "mateInfoId") Integer mateInfoId);

  /**
   * 查询抵押物价值
   * 
   * @param guaranteeId
   * @return
   */
  GuaranteeValue selectGuaranteeValuebyGuaranteeId(@Param(value = "guaranteeId") String guaranteeId);
  
/**
 * 
* @Title: loanConmmonList 
* @Description: TODO 根据不同的节点码、状态码返回不同数据
* @param @param sc
* currentPage：查询页数；pageSize：每页显示条数；
* startTime：查询起始时间；endTime：查询结束时间；
* aBaseName：贷款客户姓名；eProduct：贷款产品；
* status：审核结果；
* nodeStatus：节点标记码；flowStatus：流程状态码；
* @param @return    参数
* @return List<LoaninfoIndex>    返回类型
* @throws
 */
  List<LoaninfoIndex> loanConmmonList(SearchCondition sc);
  
  /**
   * 
  * @Title: loanConmmonCount
  * @Description: TODO 查询满足条件总条数
  * @param @param sc
* currentPage：查询页数；pageSize：每页显示条数；
* startTime：查询起始时间；endTime：查询结束时间；
* aBaseName：贷款客户姓名；eProduct：贷款产品；
* status：审核结果；
* nodeStatus：节点标记码；flowStatus：流程状态码；
  * @param @return    参数
  * @return int    返回类型
  * @throws
   */
  int loanConmmonCount(SearchCondition sc);
/**
 * 
* @Title: insertLoanAuditByLoanId
* @Description: TODO 增加订单审核记录表信息 
* @param @param loanAudit
* @param @return    参数
* @return int    返回类型
* @throws
 */
  int insertLoanAudit(LoanAudit loanAudit);

  
  /**
   * 
  * @Title: alterNbComfirmValue
  * @Description: TODO 根据抵押物具体id修改我行评估价值
  * @param @return    参数
  * @return boolean    返回类型
  * @throws
   */
  boolean alterNbComfirmValue(MortgageHouse mh);
  
  /**
   * 
  * @Title: alterNbAll
  * @Description: TODO 根据业务流水号，修改我行平率总额、我行抵押率
  * @param @param serialNo
  * @param @return    参数
  * @return boolean    返回类型
  * @throws
   */
  boolean alterNbAll(GuaranteeValue gv);

  /**
   * 
  * @Title: selectLoanAudit
  * @Description: TODO 查看某贷款编号下最近一次操作日志信息，主要是为了获取最近一次操作时间
  * @param @param map
  * @param @return    参数
  * @return LoanAudit    返回类型
  * @throws
   */
  LoanAudit selectLoanAudit(Map<String,Integer> map);
  
  /**
   * 
  * @Title: selectLogList
  * @Description: TODO 查看该贷款编号下所有授信模块操作日志
  * @param @param loanId
  * @param @return    参数
  * @return List<LogView>    返回类型
  * @throws
   */
  List<LogView> selectLogList(@Param(value = "loanId") Integer loanId);
  
  /**
   * 
  * @Title: fcList 
  * @Description: TODO 根据不同的节点码、状态码返回不同数据
  * @param @param sc
  * currentPage：查询页数；pageSize：每页显示条数；
  * startTime：查询起始时间；endTime：查询结束时间；
  * aBaseName：贷款客户姓名；eProduct：贷款产品；
  * status：审核结果；flowStatus：流程状态码；
  * @param @return    参数
  * @return List<LoaninfoIndex>    返回类型
  * @throws
   */
    List<LoaninfoIndex> fcList(SearchCondition sc);
    
    /**
     * 
    * @Title: fcCount
    * @Description: TODO 查询满足条件总条数
    * @param @param sc
  * currentPage：查询页数；pageSize：每页显示条数；
  * startTime：查询起始时间；endTime：查询结束时间；
  * aBaseName：贷款客户姓名；eProduct：贷款产品；
  * status：审核结果；flowStatus：流程状态码；
    * @param @return    参数
    * @return int    返回类型
    * @throws
     */
    int fcCount(SearchCondition sc);
    /**
     * 
     * listSelectAccessoryInfo: 查询上传附件
     * @param  @return    设定文件
     * @return List<AccessoryInfo>    DOM对象
     * @throws 
     * @since  CodingExample　Ver 1.1
     */
    List<AccessoryInfo> listSelectAccessoryInfo(SearchCondition sc);
    /**
     * 
     * alterReceiveTime: 修改订单接受时间
     * @param  @return    设定文件
     * @return boolean    DOM对象
     * @throws 
     * @since  CodingExample　Ver 1.1
     */
    boolean alterReceiveTime(Map<String,String> map);
}
