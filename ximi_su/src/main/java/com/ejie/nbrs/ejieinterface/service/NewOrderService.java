/**
 * NewOrderService.java com.ejie.nbrs.ejieinterface.service
 * 
 * Function： TODO
 * 
 * ver date author ────────────────────────────────── ver1.1 2017年8月14日 torreswang
 * 
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.ejieinterface.service;

import com.ejie.nbrs.ejieinterface.entity.NewOrder;


/**
 * ClassName:NewOrderService
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017年8月14日 下午12:24:00
 * @see
 */
public interface NewOrderService {
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
  public int insertNewOrder(NewOrder neworder);
}
