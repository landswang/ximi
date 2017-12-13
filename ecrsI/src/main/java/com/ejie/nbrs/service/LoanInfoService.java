/**
 * LoanInfoService.java com.ejie.nbrs.service
 * 
 * Function： TODO
 * 
 * ver date author ────────────────────────────────── ver1.1 2017年7月13日 torreswang
 * 
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ejie.nbrs.dto.AccessoryInfo;
import com.ejie.nbrs.dto.BaseResult;
import com.ejie.nbrs.dto.LoaninfoIndex;
import com.ejie.nbrs.dto.NewLoanView;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.entity.FilePathView;
import com.ejie.nbrs.entity.LoanInfo;
import com.ejie.nbrs.util.ZPageUtil;

/**
 * ClassName:LoanInfoService
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017年7月13日 下午5:25:05
 * @see
 */

public interface LoanInfoService {
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
   * 查询所有产品类型
   * 
   * @return
   */
  List<LoanInfo> searchAllProduct();

  /**
   * 查询某个人档案详情
   * 
   * @param 通过传入loanId查询 ，查询loanid（主借人id）
   * @return 返回个人档案详情
   */
  NewLoanView showLoanView(SearchCondition sc);

  /**
   * showWarrantByLoanId 查看该贷款编号下关联的押品权证信息
   * 
   * @param sc loanid 贷款编号
   * @return
   */
  NewLoanView showWarrantByLoanId(SearchCondition sc);

  /**
   * 查询文件列表
   * 
   * @param fp
   * @return
   */
  BaseResult<List<FilePathView>> getFilePath(FilePathView fp);
  /**
   * 查询文件列表
   * 
   * @param fp
   * @return
   */
  BaseResult<List<FilePathView>> getXwFilePath(SearchCondition sc);
  
  /**
   * 
  * @Title: searchLoanConmmon 
  * @Description: TODO 根据条件查询分页结果
  * @param @param sc
  * currentPage：查询页数；pageSize：每页显示条数；
  * startTime：查询起始时间；endTime：查询结束时间；
  * aBaseName：贷款客户姓名；eProduct：贷款产品；
  * status：审核结果；
  * nodeStatus：节点标记码；flowStatus：流程状态码；
  * @param @return    参数
  * @return ZPageUtil<LoaninfoIndex>    返回类型
  * @throws
   */
  ZPageUtil<LoaninfoIndex> searchLoanCommon(SearchCondition sc);
  
  /**
   * alterLoanCommon 贷款审批节点码、流程状态修改
   * 
   * @param sc 
   * loanId，需要修改状态的id(loanId)； 
   * nodeStatus，修改后的节点码；flowStatus：修改后的流程状态码；
   *  startTime，放款日期； eProduct，放款模式;
   *  loanVoucher,上传凭证；
   * @return 返回成功否
   */
  int alterLoanCommon(HttpSession session,SearchCondition sc);

  /**
   * 
  * @Title: alterLoanCommon
  * @Description: TODO 修改抵押物：我行评估价值、总价值、抵押率
  * @param @param sc
  * @param @return    参数
  * @return boolean    返回类型
  * @throws
   */
  public boolean alterLoanValue(SearchCondition sc) ;

  public ZPageUtil<LoaninfoIndex> pageSearchAllNewOrder(SearchCondition sc);

}
