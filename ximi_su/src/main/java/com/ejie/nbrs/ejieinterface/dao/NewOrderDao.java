/**
 * NewOrderDao.java com.ejie.nbrs.ejieinterface
 * 
 * Function： TODO
 * 
 * ver date author ────────────────────────────────── ver1.1 2017年8月14日 torreswang
 * 
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.ejieinterface.dao;

import java.util.List;

import com.ejie.nbrs.dto.LoaninfoIndex;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.ejieinterface.entity.NewOrder;

/**
 * ClassName:NewOrderDao
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017年8月14日 下午12:19:02
 * @see
 */
public interface NewOrderDao {

  List<LoaninfoIndex> searchAllNew(SearchCondition sc);

  int SearchCount(SearchCondition sc);

  int updateLoanId(NewOrder sc);

  /**
   * 
   * insert:插入一条数据
   * 
   * @param @param neworder
   * @param @return 设定文件
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  public int insert(NewOrder neworder);

  /**
   * 
   * insertList:插入集合
   * 
   * @param @param neworder
   * @param @return 设定文件
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  public int insertList(List<NewOrder> neworder);

}
