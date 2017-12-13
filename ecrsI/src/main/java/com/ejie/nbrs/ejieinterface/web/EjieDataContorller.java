/**
 * EjieDataContorller.java com.ejie.nbrs.ejieinterface.web
 * 
 * Function： TODO
 * 
 * ver date author ────────────────────────────────── ver1.1 2017年8月14日 torreswang
 * 
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.ejieinterface.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejie.nbrs.cache.RedisCache;
import com.ejie.nbrs.dto.BaseResult;
import com.ejie.nbrs.dto.LoaninfoIndex;
import com.ejie.nbrs.dto.NewLoanView;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.ejieinterface.dto.InterfacePara;
import com.ejie.nbrs.ejieinterface.service.EjieDataService;
import com.ejie.nbrs.service.LoanInfoService;
import com.ejie.nbrs.util.ZPageUtil;

/**
 * ClassName:EjieDataContorller
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017年8月14日 上午10:28:19
 * @see
 */
@Controller
@RequestMapping("/ejie/")
public class EjieDataContorller {

  @Autowired
  private EjieDataService ejieDataService;
  @Autowired
  private LoanInfoService loanInfoService;
  @Autowired
  private RedisCache redisdao;


  @RequestMapping(value = "updateOldData", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<NewLoanView> updateOldData(@RequestBody SearchCondition sc,
      HttpServletRequest request) {

    System.out.println("getDetail getSession is " + request.getSession());
    int r = ejieDataService.updateOldData(sc.getSerialNo(), request);
    return null;
  }

  @RequestMapping(value = "getDetail", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<NewLoanView> getDetail(@RequestBody SearchCondition sc,
      HttpServletRequest request) {
    System.out.println("getDetail getSession is " + request.getSession());
    int code = 0;
    String msg = "请求错误，参数不能为空";
    NewLoanView nv = null;
    if (sc.getSerialNo() != null && !sc.getSerialNo().equals("")) {
      try {
        if (sc.getLoanId() == null || sc.getLoanId() == 0
            || ejieDataService.isGetInfo(sc.getLoanId())) {
          int r = ejieDataService.getNewOrder(sc.getSerialNo(), request);
        }
        nv = loanInfoService.showLoanView(sc);
        code = 1;
        msg = "查询到订单详情";
      } catch (Exception e) {
        code = 0;
        msg = "获取数据错误";
        e.printStackTrace();
      }

    }
    return new BaseResult<NewLoanView>(code, msg, nv);
  }

  @RequestMapping(value = "checkNewOrder", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<ZPageUtil<LoaninfoIndex>> checkNew(@RequestBody SearchCondition sc) {
    System.out.println("---------------------执行修改条件:--------------------------" + sc);
    int code = 0;
    String msg = "请求过于频繁，2分钟后再试";
    Integer flag = 0;
    // flag = redisdao.getCache(RedisCache.CURREN_NEWEJIEORDER_FLAG, Integer.class);
    if (flag != 0) {
      return new BaseResult<ZPageUtil<LoaninfoIndex>>(code, msg, null);
    }
    ZPageUtil<LoaninfoIndex> zp = null;
    try {
      ejieDataService.checkNewOrder(null);//
      redisdao.deleteCacheWithPattern("pageSearchAllNewOrder");
      code = 1;
      msg = "刷新成功";
    } catch (Exception e) {
      code = 0;
      msg = "网络错误";
      e.printStackTrace();
      return new BaseResult<ZPageUtil<LoaninfoIndex>>(code, msg, zp);
    }
    return new BaseResult<ZPageUtil<LoaninfoIndex>>(code, msg, zp);
  }

  @RequestMapping(value = "newOrderList", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<ZPageUtil<LoaninfoIndex>> getNewOrderList(@RequestBody SearchCondition sc) {
    System.out.println("---------------------执行修改条件:--------------------------" + sc);
    int code = 0;
    String msg = "";
    ZPageUtil<LoaninfoIndex> zp = null;
    try {
      sc.setStatus(0);
      zp = loanInfoService.pageSearchAllNewOrder(sc);
      code = 1;
      msg = "执行成功";
    } catch (Exception e) {
      code = 0;
      msg = "执行失败";
      e.printStackTrace();
    }
    return new BaseResult<ZPageUtil<LoaninfoIndex>>(code, msg, zp);
  }

  @RequestMapping(value = "getLoanNewInfo", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<ZPageUtil<LoaninfoIndex>> getLoanNewInfo(@RequestBody SearchCondition sc) {
    System.out.println("---------------------执行修改条件:--------------------------" + sc);
    int code = 0;
    String msg = "";
    ZPageUtil<LoaninfoIndex> zp = null;
    try {
      sc.setStatus(0);
      ejieDataService.loanInfoGet(new InterfacePara(sc.getSerialNo()));
      code = 1;
      msg = "执行成功";
    } catch (Exception e) {
      code = 0;
      msg = "执行失败";
      e.printStackTrace();
    }
    return new BaseResult<ZPageUtil<LoaninfoIndex>>(code, msg, zp);
  }

  @RequestMapping(value = "getRepaySched", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public void getRepaySched() {


    try {

      ejieDataService.getRepaySched();
    } catch (Exception e) {

      e.printStackTrace();
    }
  }


}
