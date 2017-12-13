/**
 * EjieDataService.java com.ejie.nbrs.ejieinterface.service
 * 
 * Function： TODO
 * 
 * ver date author ────────────────────────────────── ver1.1 2017年8月14日 torreswang
 * 
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.ejieinterface.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.ejie.nbrs.ejieinterface.dto.InterfacePara;
import com.ejie.nbrs.ejieinterface.entity.NewOrder;

/**
 * ClassName:易捷数据接口
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017年8月14日 上午9:52:48
 * @see
 */

public interface EjieDataService {



  /**
   * 
   * getNewOrder:(这里用一句话描述这个方法的作用)
   * 
   * @param @param ifp 访问请求对象（其中token，apikey，serialNo必填）
   * @return void DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  public int updateOldData(String id, HttpServletRequest request);


  /**
   * 
   * isGetInfo:是否需要调用ejie接口获取数据 (通过loanid判断是否需要调用接口获取数据)
   * 
   * @param @param loanId id
   * @param @return true 不需要
   * @return boolean DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  boolean isGetInfo(Integer loanId);

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

  public void loanInfoGet(InterfacePara ifp);

  public int updateLoanId(NewOrder sc);

  /**
   * 
   * getEjietoken:获取易捷系统访问token（）
   * 
   * @param @param ifp 访问请求对象（其中username，password，apikey必填）
   * @return void DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  public void getEjietoken(InterfacePara ifp);

  /**
   * 
   * getNewOrderIn:(这里用一句话描述这个方法的作用)
   * 
   * @param @param ls
   * @param @return 设定文件
   * @return String DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  public String getNewOrderIn(List<NewOrder> ls);

  /**
   * 
   * checkNewOrder:获取ejie最新进件 并处理
   * 
   * @param @param ifp 访问请求对象（其中token，apikey必填）
   * @return void DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  public int checkNewOrder(InterfacePara ifp);

  /**
   * 
   * getNewOrder:(这里用一句话描述这个方法的作用)
   * 
   * @param @param ifp 访问请求对象（其中token，apikey，serialNo必填）
   * @return void DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  public int getNewOrder(String id, HttpServletRequest request);

  /**
   * 
   * setEjietoken:返回ejie 本系统的token
   * 
   * @param @param ifp 访问请求对象（其中username，password，apikey必填）
   * @return InterfacePara 访问请求对象（其中token必填）
   * @throws
   * @since CodingExample　Ver 1.1
   */
  public InterfacePara setEjietoken(InterfacePara ifp);

  /**
   * 
   * pushStatus:修改状态查询（曝露给ejie接口）用户查询流水号对应贷款订单
   * 
   * @param @param ifp 访问请求对象（其中token，apikey，serialNo必填）
   * @return NewOrder 对应贷款订单（状态和serialNo必填）
   * @throws
   * @since CodingExample　Ver 1.1
   */
  public NewOrder pushStatus(InterfacePara ifp);

  /**
   * 
   * pushComfirm:查询放款确认信息（曝露给ejie接口）
   * 
   * @param @param ifp 设定文件
   * @return NewOrder 对应贷款订单（状态和serialNo必填）
   * @throws
   * @since CodingExample　Ver 1.1
   */
  public NewOrder pushComfirm(InterfacePara ifp);

  public void getRepaySched();

}
