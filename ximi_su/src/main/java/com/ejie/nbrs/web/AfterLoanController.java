package com.ejie.nbrs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejie.nbrs.dto.AfterLoanView;
import com.ejie.nbrs.dto.BaseResult;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.service.AfterLoanService;
import com.ejie.nbrs.util.ZPageUtil;

/**
 * 
 * ClassName:AfterLoanController 贷后管理控制层
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月8日 上午11:03:39
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
@Controller
@RequestMapping("/AfterLoan")
public class AfterLoanController {

  @Autowired
  private AfterLoanService afterLoanService;

  /**
   * InCreditCustomer 在贷客户
   * 
   * @param sc 条件包括： 1.贷款编号loanId；2.客户姓名name； 3.查看放款起始日期startTime-查看放款结束日期endTime；
   *        4.当前页、查看页码，currentPage；
   * @return
   */
  @RequestMapping(value = "/InCreditCustomer", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<ZPageUtil<AfterLoanView>> InCreditCustomer(@RequestBody SearchCondition sc) {
    sc.setNodeStatus(1006);
    sc.setFlowStatus(1);
    int code = 0;
    String msg = "";
    ZPageUtil<AfterLoanView> zp = null;
    try {
      zp = afterLoanService.afterLoanViewPage(sc);
      code = 1;
      msg = "执行成功";
    } catch (Exception e) {
      code = 0;
      msg = "执行失败";
      e.printStackTrace();
    }

    return new BaseResult<ZPageUtil<AfterLoanView>>(code, msg, zp);
  }

  /**
   * ClearCreditCustomer 清贷客户
   * 
   * @param sc 条件包括： 1.贷款编号loanId；2.客户姓名name； 3.查看放款起始日期startTime-查看放款结束日期endTime；
   *        4.当前页、查看页码，currentPage； 5.每页显示条数，pageSize；
   * @return
   */
  @RequestMapping(value = "/ClearCreditCustomer", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<ZPageUtil<AfterLoanView>> ClearCreditCustomer(@RequestBody SearchCondition sc) {
    sc.setNodeStatus(1079);
    int code = 0;
    String msg = "";
    ZPageUtil<AfterLoanView> zp = null;
    try {
      zp = afterLoanService.afterLoanViewPage(sc);
      code = 1;
      msg = "执行成功";
    } catch (Exception e) {
      code = 0;
      msg = "执行失败";
      e.printStackTrace();
    }

    return new BaseResult<ZPageUtil<AfterLoanView>>(code, msg, zp);
  }

  /**
   * loanInformation 贷款详细信息
   * 
   * @param sc 条件包括： 贷款编号loanId；
   * @return
   */
  @RequestMapping(value = "/loanInformation", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<AfterLoanView> loanInformation(@RequestBody SearchCondition sc) {

    int code = 0;
    String msg = "";
    AfterLoanView zp = null;
    try {
      zp = afterLoanService.afterLoanViewById(sc);

      if (zp == null) {
        code = 0;
        msg = "没有查到该loanId的相关信息";
      } else {
        code = 1;
        msg = "执行成功";
      }
    } catch (Exception e) {
      code = 0;
      msg = "执行失败";
      e.printStackTrace();
    }

    return new BaseResult<AfterLoanView>(code, msg, zp);
  }

}
