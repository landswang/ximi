package com.ejie.nbrs.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejie.nbrs.dto.AccessoryInfo;
import com.ejie.nbrs.dto.BaseResult;
import com.ejie.nbrs.dto.LoaninfoIndex;
import com.ejie.nbrs.dto.NewLoanView;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.ejieinterface.service.EjieDataService;
import com.ejie.nbrs.entity.FilePathView;
import com.ejie.nbrs.entity.LoanInfo;
import com.ejie.nbrs.service.LoanInfoService;
import com.ejie.nbrs.service.TempletPrintLoanService;
import com.ejie.nbrs.util.ValidateUtil;
import com.ejie.nbrs.util.ZPageUtil;

/**
 * 
 * ClassName:LoanController 贷款审批
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年7月20日 上午10:38:52
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
@Controller
@RequestMapping("/loanManage")
public class LoanController {

  @Autowired
  private LoanInfoService loanService;
  @Autowired
  private EjieDataService ejieDataService;
  @Autowired
  private TempletPrintLoanService tpService;

  /**
   * 
   * listSelectAccessoryInfo: （通过上传方标识status）查询所有附件上传规则
   * 
   * @param @param sc status：上传方标识，1--易捷，2--新网
   * @param @return 设定文件
   * @return List<AccessoryInfo> DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  @RequestMapping(value = "/listSelectAccessoryInfo", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<List<AccessoryInfo>> listSelectAccessoryInfo(SearchCondition sc) {

    System.out.println("-----------------------------------------------" + sc);
    int code = 0;
    String msg = "";
    List<AccessoryInfo> accessoryInfoList = null;
    try {
      if (sc.getStatus() == null) {
        sc.setStatus(2);
      }
      accessoryInfoList = loanService.listSelectAccessoryInfo(sc);
      code = 1;
      msg = "执行成功";
    } catch (Exception e) {
      code = 0;
      msg = "执行失败";
      e.printStackTrace();
    }

    return new BaseResult<List<AccessoryInfo>>(code, msg, accessoryInfoList);
  }

  /**
   * 
   * @Title: financialCommissioner 金融专员查询接口
   * @Description: TODO 根据不同的节点码、状态码返回不同数据
   * @param @param sc currentPage：查询页数；pageSize：每页显示条数； startTime：查询起始时间；endTime：查询结束时间；
   *        aBaseName：贷款客户姓名；eProduct：贷款产品； status：审核结果；1、通过，2、不通过，3全部 flowStatus：流程状态码；
   *        10--待处理；11--进行中；12--已完成；（flowStatus>=10的情况表示此为授信专员通道） List<MortgageHouse>
   *        evaluate:我行评估金额
   *        “新增”——outReason：状态筛选；1、新进件预审，2、新进件以外的状态；
   * @param @return 参数
   * @return BaseResult<ZPageUtil<LoaninfoIndex>> 返回类型
   * @throws
   */
  @RequestMapping(value = "/financialCommissioner", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<ZPageUtil<LoaninfoIndex>> financialCommissioner(@RequestBody SearchCondition sc) {

    System.out.println("-----------------------------------------------" + sc);
    int code = 0;
    String msg = "";
    ZPageUtil<LoaninfoIndex> zp = null;
    try {
      zp = loanService.searchLoanCommon(sc);
      code = 1;
      msg = "执行成功";
    } catch (Exception e) {
      code = 0;
      msg = "执行失败";
      e.printStackTrace();
    }

    return new BaseResult<ZPageUtil<LoaninfoIndex>>(code, msg, zp);

  }

  /**
   * 
   * @Title: loanConmmon 贷款审批通用基本接口
   * @Description: TODO 根据不同的节点码、状态码返回不同数据
   * @param @param sc currentPage：查询页数；pageSize：每页显示条数； startTime：查询起始时间；endTime：查询结束时间；
   *        aBaseName：贷款客户姓名；eProduct：贷款产品； status：审核结果；1、通过，2、不通过，3全部 nodeStatus：节点标记码；
   *        flowStatus：流程状态码；1、通过，2、不通过，0、审核中，3、正在补充资料 List<MortgageHouse> evaluate:我行评估金额
   * @param @return 参数
   * @return BaseResult<ZPageUtil<LoaninfoIndex>> 返回类型
   * @throws
   */
  @RequestMapping(value = "/loanCommon", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<ZPageUtil<LoaninfoIndex>> loanCommon(@RequestBody SearchCondition sc) {
    System.out.println("-----------------------------------------------" + sc);
    int code = 0;
    String msg = "";
    ZPageUtil<LoaninfoIndex> zp = null;
    try {
      zp = loanService.searchLoanCommon(sc);
      code = 1;
      msg = "执行成功";
    } catch (Exception e) {
      code = 0;
      msg = "执行失败";
      e.printStackTrace();
    }

    return new BaseResult<ZPageUtil<LoaninfoIndex>>(code, msg, zp);

  }

  /**
   * 
   * @Title: alterAuditAffirm
   * @Description: TODO 授信审核、放款确认:1、状态修改，2、放款模式、放款日期修改，
   * @param @param sc
   * @param @return 参数 loanId，需要修改状态的id(loanId)； nodeStatus：节点标记码； flowStatus：流程状态码；1、通过，2、不通过，0、审核中
   *        ； startTime：修改后的放款日期； eProduct：修改后的放款模式； outRemark：备注； loanVoucher：上传凭证；
   *        realLoanMoney：实际放款金额；
   * @return BaseResult<Boolean> 成功否
   * @throws
   */
  @RequestMapping(value = "/alterAuditAffirm", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<Boolean> alterAuditAffirm(HttpSession session,@RequestBody SearchCondition sc,
      HttpServletRequest req) {
    System.out.println("---------------------执行修改条件:--------------------------" + sc);
    Boolean bool = false;
    int code = 0;
    String msg = "";
    if (sc == null) {
      bool = false;
    } else {
      if (!ValidateUtil.validateNumber(sc.getRealLoanMoney(), 12)) {
        msg = "输入的实际放款金额长度不合法！";
        return new BaseResult<Boolean>(code, msg, null);
      }
      if (!ValidateUtil.validateString(sc.getOutRemark(), 300)) {
        msg = "输入的备注信息长度不合法！";
        return new BaseResult<Boolean>(code, msg, null);
      }

      try {
        int tg = 0;
        tg = loanService.alterLoanCommon(session,sc);
        if (tg == 1) {
          bool = true;
          code = 1;
          msg = "执行成功";
        } else if (tg == 3) {
          bool = false;
          code = 0;
          msg = "抵押率超过理论值，请核对您输入的我行评估金额。";
        } else {
          bool = false;
          code = 0;
          msg = "执行失败";
        }

      } catch (Exception e) {
        code = 0;
        msg = "执行失败";
        e.printStackTrace();
      }
    }
    return new BaseResult<Boolean>(code, msg, bool);

  }

  /**
   * warrantDetails 查询贷款人关联的共借人、抵押物的权证信息 (打印)
   * 
   * @param sc 通过传入loanId查询，查询loanId（贷款id）
   * @return 详情信息
   */
  @RequestMapping(value = "/warrantDetails", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<NewLoanView> warrantDetails(@RequestBody SearchCondition sc) {
    int code = 0;
    String msg = "";
    NewLoanView lv = null;

    try {
      lv = loanService.showWarrantByLoanId(sc);
      if (lv != null) {
        code = 1;
        msg = "执行成功";
      } else {
        code = 0;
        msg = "没有查到结果";
      }

    } catch (Exception e) {
      code = 0;
      msg = "执行失败";
      e.printStackTrace();
    }

    System.out.println("````````````````lv:````````````````" + lv);
    return new BaseResult<NewLoanView>(code, msg, lv);
  }


  /**
   * applicantDetails 查询贷款人（申请）详细信息
   * 
   * @param sc 通过传入loanId查询，查询loanId（贷款id）
   * @return 详情信息
   */
  @RequestMapping(value = "/applicantDetails", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<NewLoanView> applicantDetails(@RequestBody SearchCondition sc,
      HttpServletRequest request) {
    int code = 0;
    String msg = "";
    NewLoanView lv = null;
    try {
      String d = sc.getLoanId() + "";
      if (d == null || d.equals("null") || d.equals("0")) {
        ejieDataService.getNewOrder(sc.getSerialNo() + "", request);
        // int s = ejieDataService.queryLoanIdBySerialNo(sc.getSerialNo());
        // sc.setLoanId(s);
        // ejieDataService.updateLoanId(new NewOrder(s + "", sc.getSerialNo()));
      }

      lv = loanService.showLoanView(sc);

      if (lv != null) {
        code = 1;
        msg = "执行成功";
      } else {
        code = 0;
        msg = "没有查到结果";
      }

    } catch (Exception e) {
      code = 0;
      msg = "执行失败";
      e.printStackTrace();
    }

    System.out.println("````````````````lv:````````````````" + lv);
    return new BaseResult<NewLoanView>(code, msg, lv);
  }

  /**
   * 查询所有的贷款类型 (未完成)
   * 
   * @param sc 搜索条件
   * 
   * @return
   */
  @RequestMapping(value = "/allProduct", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<String> allProduct() {

    int code = 0;
    String msg = "";
    List<LoanInfo> li = null;
    try {
      li = loanService.searchAllProduct();
      if (li != null) {
        code = 1;
        msg = "执行成功";
      } else {
        code = 0;
        msg = "没有查到结果";
      }
    } catch (Exception e) {
      code = 0;
      msg = "执行失败";
      e.printStackTrace();
    }
    String ll = "";
    for (LoanInfo l : li) {
      ll += l.geteProduct() + ",";
    }

    return new BaseResult<String>(code, msg, ll);
  }

  /**
   * 
   * getFilePath:文件路径返回给前台
   * 
   * @param @param request
   * @param @param model
   * @param @param la
   * @param @return 设定文件
   * @return BaseResult<Account> DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  @RequestMapping(value = "/getFilePath", method = RequestMethod.POST)
  @ResponseBody
  @CrossOrigin
  public BaseResult<List<FilePathView>> getFilePath(HttpServletRequest request,
      @RequestBody FilePathView la) {

    if (la.getSourceFlag() != null && "1".equals(la.getSourceFlag())) {// 易捷来源
      return loanService.getFilePath(la);
    } else if (la.getSourceFlag() != null && "2".equals(la.getSourceFlag())) {// 新网来源
      SearchCondition sc = new SearchCondition();
      sc.setSerialNo(la.getLoanId());
      sc.setOutReason(la.getDoc());
      return loanService.getXwFilePath(sc);
    }
    return loanService.getFilePath(la);
  }

  // /**
  // *
  // * getXwFilePath: 文件路径返回给前台
  // * @param @param request
  // * @param @param sc
  // * serialNo：业务流水号；
  // * outReason：文件类目；
  // * @param @return 设定文件
  // * @return BaseResult<FilePathView> DOM对象
  // * @throws
  // * @since CodingExample　Ver 1.1
  // */
  // @RequestMapping(value = "/getXwFilePath", method = RequestMethod.POST)
  // @ResponseBody
  // @CrossOrigin
  // public BaseResult<List<FilePathView>> getXwFilePath(@RequestBody SearchCondition sc) {
  // return loanService.getXwFilePath(sc);
  // }
}
