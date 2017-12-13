/**
 * EjieDataServiceimpl.java com.ejie.nbrs.ejieinterface.service.impl
 * 
 * Function： TODO
 * 
 * ver date author ────────────────────────────────── ver1.1 2017年8月14日 torreswang
 * 
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.ejieinterface.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ejie.nbrs.cache.RedisCache;
import com.ejie.nbrs.dao.ApplicantDao;
import com.ejie.nbrs.dao.LoanInfoDao;
import com.ejie.nbrs.ejieinterface.dao.NewOrderDao;
import com.ejie.nbrs.ejieinterface.dto.EjieLoanRS;
import com.ejie.nbrs.ejieinterface.dto.EjieReSchRS;
import com.ejie.nbrs.ejieinterface.dto.EjieResultSet;
import com.ejie.nbrs.ejieinterface.dto.InterfacePara;
import com.ejie.nbrs.ejieinterface.entity.ECommonCustomer;
import com.ejie.nbrs.ejieinterface.entity.EMortgager;
import com.ejie.nbrs.ejieinterface.entity.MasterInfo;
import com.ejie.nbrs.ejieinterface.entity.NewOrder;
import com.ejie.nbrs.ejieinterface.entity.RepayPlan;
import com.ejie.nbrs.ejieinterface.entity.RepaymentSchedule;
import com.ejie.nbrs.ejieinterface.service.EjieDataService;
import com.ejie.nbrs.entity.Guarantee;
import com.ejie.nbrs.entity.GuaranteeValue;
import com.ejie.nbrs.entity.LoanInfo;
import com.ejie.nbrs.service.AccountService;
import com.ejie.nbrs.util.HttpsGet;
import com.ejie.nbrs.util.Json2Obj;
import com.ejie.nbrs.util.StringExUtil;
import com.ejie.nbrs.util.TokenGenerator;

/**
 * ClassName:EjieDataServiceimpl 易捷数据接口实现
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017年8月14日 上午10:23:09
 * @see
 */
@Service
public class EjieDataServiceImpl implements EjieDataService {

  private final Logger LOG = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private LoanInfoDao loanInfoDao;
  @Autowired
  private NewOrderDao newOrderDao;
  @Autowired
  private RedisCache cache;
  @Autowired
  private AccountService accountService;
  @Autowired
  private HttpsGet httpsGet;
  @Autowired
  private ApplicantDao appDao;
  @Value("${ejie.interface.project}")
  String project;

  @Value("${ejie.interface.channelCodes}")
  String channelCodes;
  @Value("${ejie.interface.wmxtTime}")
  String wmxtTime;

  @Override
  public void getEjietoken(InterfacePara ifp) {

  }

  @Override
  public void loanInfoGet(InterfacePara ifp) {
    RepaymentSchedule rschedule = null;
    String apiUrl = project;
    apiUrl +=
        "/service/v1/plant/get.action?token=2351211dfbn2&app_key=2351211dfbn2&serial_no="
            + ifp.getSerialNo();
    String rs = "";
    try {

      rs = httpsGet.httpsRequestsGet(apiUrl);
      EjieReSchRS ersrs = Json2Obj.j2o(rs, EjieReSchRS.class);
      rschedule = ersrs.getResult();
      rschedule.setLastDate(rschedule.getPlants().get(rschedule.getPlants().size() - 1)
          .getRepaydate());
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  @Override
  public int checkNewOrder(InterfacePara ifp) {
    String apiUrl = project;
    apiUrl +=
        "/service/v1/prepare/get.action?token=2351211dfbn2&app_key=2351211dfbn2&channelCode="
            + channelCodes;
    String rs = "";
    int rscount = 0;
    List<NewOrder> list = null;
    try {
      rs = httpsGet.httpsRequestsGet(apiUrl);
      LOG.info("访问易捷结果：" + rs);
      EjieResultSet ers = Json2Obj.j2o(rs, EjieResultSet.class);
      if (ers != null) {
        list = ers.getResult().getData();
        // cache.deleteCache(RedisCache.CURREN_NEWEJIEORDER_FLAG);
        // cache.putCache(RedisCache.CURREN_NEWEJIEORDER_FLAG, "0");
        cache.deleteCache(RedisCache.CURREN_NEWEJIEORDER_FLAG);
        cache.putCacheWithExpireTime(RedisCache.CURREN_NEWEJIEORDER_FLAG, "0", 120);
        LOG.debug("获取到数据：" + ers);
        if (list != null) {
          for (int i = 0; i < list.size(); i++) {
            // 开启事务
            // DataSourceTransactionManager transactionManager = getTransactionManager();
            // TransactionStatus status = getStatus(transactionManager);
            try {
              /*
               * list.get(i).setStatus("0");
               * list.get(i).setCreateTime(TimeUtils.getCurrentTimeInString());
               * System.out.println("this is " + i + " list.get(i).setModifyTime  " +
               * list.get(i).getModifyTime()); rscount += newOrderDao.insert(list.get(i));
               */

              System.out.println("list.get(i).getSendDate() is " + list.get(i).getSendDate() + "  "
                  + list.get(i));
              /* 当进件通道为外贸信托（1802）加入时间限制 */
              // 获取外贸信托进件添加时间限制
              if (list.get(i).getChannelCode().equals("1804")
                  || new SimpleDateFormat("yyyy-MM-dd").parse(list.get(i).getSendDate()).after(
                      new SimpleDateFormat("yyyy-MM-dd").parse(wmxtTime))) {


                // list.get(i).setChannelCode(channelCodes);

                // 流水号 城市 初贷金额 还款方式 利率 还款期限

                // 客户姓名没有
                // 贷款产品
                LoanInfo dl = new LoanInfo();
                dl.setSerialno(list.get(i).getSerialNo());// 流水号
                dl.setCity(list.get(i).getCity());// 所属城市
                dl.setAppMoney(list.get(i).getLoanAmount());// 贷款金额
                dl.setRepayWay(list.get(i).getRepayMethod());// 还款方式
                dl.setRate(String.valueOf(list.get(i).getLoanRate()));// 利率
                dl.setPeriods(list.get(i).getLoanLimit());// 还款期数
                dl.setRealName(list.get(i).getRealName());// 客户姓名
                dl.setGarantyType(list.get(i).getGarantyType());// 贷款类型其他平台获取用这个参数
                dl.setAppDate(new Date());
                dl.setChannelCode(new Integer(list.get(i).getChannelCode()));
                dl.setEjieSendTime(list.get(i).getSendDate());
                rscount += loanInfoDao.insertBaseLoanInfo(dl);// 保存贷款信息
                // ALTER TABLE `ejie_nbrs`.`loan_info`
                // ADD COLUMN `real_name` VARCHAR(20) NULL COMMENT '贷款人姓名' AFTER `channelCode`,
                // ADD COLUMN `garanty_type` VARCHAR(20) NULL COMMENT '贷款产品' AFTER `real_name`;
                // rscount += getNewOrder(list.get(i).getSerialNo()) ;
                // rscount += getNewOrder("YJCD2017081600004") ;

                // 提交事务 如果出现异常继续执行下一条

                // transactionManager.commit(status);
              }
            } catch (Exception e) {
              e.printStackTrace();
              // transactionManager.rollback(status);
              // 回滚事务
              continue;
            }
          }
          rs = rscount + "";
        }
      }

    } catch (Exception e) {
      e.printStackTrace();

    }

    return rscount;
  }

  /**
   * 
   * 获取新进件详情（持久化）
   * 
   * @param @param serid
   * @param @return 设定文件
   * @return String DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  @Override
  public String getNewOrderIn(List<NewOrder> ls) {
    return "";
  }

  @Override
  public boolean isGetInfo(Integer loanId) {
    boolean rs = false;
    LoanInfo loanInfo = loanInfoDao.selectLoanInfoByLoanId(loanId);
    if (loanInfo.getaBaseId() == null || loanInfo.getGuaranteeId() == null) {
      rs = true;
    }
    return rs;
  }

  @Override
  public int getNewOrder(String serid, HttpServletRequest request) {
    if (serid != null || !"".equals(serid)) {
      // 获取信息接口访问拼装
      String apiUrl = project;
      apiUrl +=
          "/service/v1/baseinfo/get.action?token=325wf4&app_key=325wf344" + "&serial_no=" + serid;
      String rs = "";// http响应结果
      try {
        rs = httpsGet.httpsRequestsGet(apiUrl);// 访问服务器
        EjieLoanRS ers = Json2Obj.j2o(rs, EjieLoanRS.class);// 结果集封装
        // 判断执行结果
        if (ers.getCode() == 1) {
          // return ers.getMsg();
        }
        MasterInfo mi = ers.getResult();// 获取主借人、贷款信息等
        if (mi.getSerialNo() == null || !mi.getSerialNo().equals(serid)) {// 判断数据有效性
          // return "没有该条数据";

          return 0;
        }
        /*-下面是保存MasterInfo（分别保存到loaninfo/applica）处理（未完成）-*/
        int lrs = 0;
        lrs += appDao.insertCouple(mi);// 配偶信息保存
        lrs += appDao.insertApplicant(mi);// 主借人信息保存
        /* 共借人处理 */
        List<ECommonCustomer> dd = mi.getOtherBorrower();
        List<String> ename = new ArrayList<String>();
        ename.add(mi.getRealName());
        if (dd != null) {
          for (ECommonCustomer e : dd) {
            ename.add(e.getRealName());
            e.setAppBaseId(mi.getAppBaseId());
            e.setSerialNo(mi.getSerialNo());
            lrs += appDao.insertCommonApplicant(e);
          }
        }
        /* 贷款信息 */
        String guaranteeId = TokenGenerator.generateValue();// 抵押物id
        String go = mi.getGarantyObject();// 抵押物id
        if (go == null || go.equals("")) {
          go = mi.getGuaranties().get(0).getGarantyObject();
        }
        mi.setGuaranteeId(guaranteeId);// 抵押物id
        LoanInfo dl =
            new LoanInfo(mi.getSerialNo(), mi.getCity(), new BigDecimal(mi.getApplyAmount()),
                mi.getRepayMethod(), mi.getLoanRate() + "", new Integer(mi.getLoanLimit()),
                mi.getLoanUse(), new Integer(mi.getAppBaseId()), mi.getBankNumber(),
                mi.getBankBranch(), mi.getBankUser(), mi.getBankName(), guaranteeId,
                mi.getRepayCardNo(), mi.getRepayCardUser(), mi.getRepayCardBank(),
                mi.getRepayCardBranck(), go, new Integer(mi.getChannelCode()));
        dl.setRealName(mi.getRealName());
        dl.setGarantyType(mi.getGarantyType());
        loanInfoDao.insertByMasterInfo(dl);// 保存贷款信息
        /* 抵押物处理 */
        List<EMortgager> ddd = mi.getGuaranties();
        System.out.println(ddd);
        float eValue = 0;// 易捷评估值
        float wValue = 0;// 世联评估值
        String mcarId = TokenGenerator.generateValue();// 抵押物id
        String mhouseId = TokenGenerator.generateValue();// 抵押物id
        if (ddd != null) {
          for (EMortgager e : ddd) {
            if (e.getGarantyType().endsWith("02")) {
              e.setmCId(mcarId);
              e.setSerialNo(mi.getSerialNo());
              lrs += appDao.insertMortgagerCar(e);
              eValue += e.getTotalPrice();// 抵押物总估值累加
            } else {
              e.setmHId(mhouseId);
              e.setSerialNo(mi.getSerialNo());
              /* 处理多个抵押人名字拼装问题 */
              if (ename.size() > 1) {
                String ownerName = e.getOwnerName();
                String roName = "";
                for (int i = 0; i < ename.size(); i++) {
                  if (ownerName.contains(ename.get(i))) {
                    roName += ename.get(i) + "/";// 重新将抵押人名字拼装为 & 分割
                  };
                }
                e.setOwnerName(roName);
                roName = "";
              } else {
                e.setOwnerName(e.getOwnerName()); // 重新将抵押人名字拼装为 & 分割
              }/* end 处理多个抵押人名字拼装问题 */
              e.setGuarantyNo(StringExUtil.getAreaCode("房", e.getLocation(), request));
              // syso
              lrs += appDao.insertMortgagerHouse(overEMortgager(e, mi));
              eValue += e.getTotalPrice();// 抵押物总估值累加
              wValue += e.getWorldUniteAssessTotal();
            }
          }
        }
        float guRant = 0;// 易捷抵押率
        float wuRant = 0;// 易捷抵押率
        if (eValue > 0) {
          guRant = mi.getApplyAmount() / eValue * 100;// 计算易捷抵押率
        }
        if (wValue > 0) {
          wuRant = mi.getApplyAmount() / wValue * 100;// 计算世联抵押率
        }
        appDao.insertGuarantee(new Guarantee(guaranteeId, dl.getLoanId(), mhouseId, mcarId, mi
            .getSerialNo()));// 保存抵押物信息
        appDao.insertGuaranteeValue(new GuaranteeValue(guaranteeId, wValue, eValue, wuRant, guRant,
            0, mi.getSerialNo()));// 保存抵押物价值
        rs = "0";
        makeSureGetIn(serid);
        return 1;
      } catch (Exception e) {
        rs = "请求数据失败网络错误";
        e.printStackTrace();
        return 0;
      }
    } else {
      return 0;
    }

  }


  public int makeSureGetIn(String serid) {
    if (serid != null || !"".equals(serid)) {
      // 获取信息接口访问拼装
      String apiUrl = project;
      apiUrl +=
          "/service/v1/baseinfo/getSure.action?token=325wf4&app_key=325wf344" + "&serial_no="
              + serid;
      String rs = "";// http响应结果
      rs = httpsGet.httpsRequestsGet(apiUrl);// 访问服务器
      System.out.println(rs);
    }
    return 1;
  }

  @Override
  public int updateOldData(String serid, HttpServletRequest request) {
    List<EMortgager> s = appDao.updateLoanInfo(null);
    for (EMortgager em : s) {
      serid = em.getSerialNo();
      if (serid != null || !"".equals(serid)) {

        // 获取信息接口访问拼装
        String apiUrl = project;
        apiUrl +=
            "/service/v1/baseinfo/get.action?token=325wf4&app_key=325wf344" + "&serial_no=" + serid;
        String rs = "";// http响应结果
        try {
          rs = httpsGet.httpsRequestsGet(apiUrl);// 访问服务器
          EjieLoanRS ers = Json2Obj.j2o(rs, EjieLoanRS.class);// 结果集封装
          // 判断执行结果
          if (ers.getCode() == 1) {
            // return ers.getMsg();
          }
          MasterInfo mi = ers.getResult();// 获取主借人、贷款信息等
          /* 抵押物处理 */
          List<EMortgager> ddd = mi.getGuaranties();

          if (ddd != null) {
            for (EMortgager e : ddd) {
              if (e.getGarantyType().endsWith("02")) {
              } else {
                e.setSerialNo(serid);
                e.setGuarantyNo(StringExUtil.getAreaCode("房", e.getLocation(), request));
                // syso
                appDao.updateMortgagerHouse(e);
              }
            }
          }

        } catch (Exception e) {
          rs = "请求数据失败网络错误";
          e.printStackTrace();
        }
      } else {
      }
    }
    return 0;

  }

  /**
   * 
   * overEMortgager:(这里用一句话描述这个方法的作用)
   * 
   * @param @param em
   * @param @param mi
   * @param @return 设定文件
   * @return EMortgager DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  private EMortgager overEMortgager(EMortgager em, MasterInfo mi) {
    String rName = mi.getRealName();// 主借人姓名
    String pName = em.getOwnerName();// 产权人姓名
    if (rName.equals(pName)) {
      em.setMortgagerTel(mi.getTelePhone());
      em.setIDNumber(mi.getIdNo());
      return em;
    }
    List<ECommonCustomer> dd = mi.getOtherBorrower();
    for (ECommonCustomer e : dd) {
      if (pName.equals(e.getRealName())) {
        em.setMortgagerTel(e.getTelePhone());
        em.setIDNumber(e.getIdNo());
        return em;
      }
    }
    return em;
  }

  private void getLoanInfo(NewOrder newOrder) {
    System.out.println(newOrder);
  }

  @Override
  public InterfacePara setEjietoken(InterfacePara ifp) {

    // TODO Auto-generated method stub
    return null;

  }

  @Override
  public NewOrder pushStatus(InterfacePara ifp) {

    // TODO Auto-generated method stub
    return null;

  }

  @Override
  public NewOrder pushComfirm(InterfacePara ifp) {

    // TODO Auto-generated method stub
    return null;

  }

  @Override
  public int updateLoanId(NewOrder sc) {
    return newOrderDao.updateLoanId(sc);

  }

  @Override
  public Integer queryLoanIdBySerialNo(String serialNo) {
    return appDao.queryLoanIdBySerialNo(serialNo);
  }

  // 后台轮询接口插入还款计划两张表数据
  @Override
  public void getRepaySched() {
    RepaymentSchedule rschedule = null;
    // 拉取还款计划节点为1006 状态为通过的。
    HashMap<String, String> hm = new HashMap<String, String>();
    hm.put("nodeStatus", "1006");
    hm.put("flowStatus", "1");
    List<LoanInfo> list = appDao.selectLoanInfoStatus(hm);
    // LoanInfo li=new LoanInfo();
    // li.setLoanId(11111);
    // li.setSerialno("YJCD201706210009501");
    // List<LoanInfo> list= new ArrayList<LoanInfo>();
    // list.add(li);

    System.out.println("获取loan_info" + list.toString());

    for (LoanInfo lif : list) {
      // DataSourceTransactionManager transactionManager = getTransactionManager();
      // TransactionStatus status = getStatus(transactionManager);

      String apiUrl =
          project
              + "/service/v1/plant/get.action?token=2351211dfbn2&app_key=2351211dfbn2&serial_no="
              + lif.getSerialno();


      try {
        String rs = "";
        rs = httpsGet.httpsRequestsGet(apiUrl);
        EjieReSchRS ersrs = Json2Obj.j2o(rs, EjieReSchRS.class);
        rschedule = ersrs.getResult();
        List<RepayPlan> rps = rschedule.getPlants();
        if (rschedule != null) {
          rschedule.setLoanId(Integer.valueOf(lif.getLoanId()));
          rschedule.setSerialNo(lif.getSerialno());
          if (rps != null) {
            rschedule.setLastDate(rschedule.getPlants().get(rschedule.getPlants().size() - 1)
                .getRepaydate());
          }
          // 设置获取时间
          SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
          rschedule.setAcquireDate(df.format(new Date()));
          appDao.saverSchedule(rschedule);
          if (rps != null && rps.size() > 0) {
            for (RepayPlan rp : rps) {
              rp.setLoanId(lif.getLoanId());
              rp.setSerialNo(lif.getSerialno());
            }
            appDao.saveRepayPlan(rps);
          }


        }
        System.out.println("&loanInfoGet& rs is " + rs);
        System.out.println(rschedule);
        // 修改已清贷的订单节点码为1099 提高效率//现改成1079
        if (rschedule.getClearDate() != null && !"".equals(rschedule.getClearDate())) {
          Map<String, String> map = new HashMap<String, String>();
          map.put("loanId", String.valueOf(lif.getLoanId()));
          // map.put("nodeStatus", "1099");
          map.put("nodeStatus", "1079");
          appDao.alterNodeStatus(map);
        }


        // transactionManager.commit(status);
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
        // transactionManager.rollback(status);
        continue;
      }
    }



  }
  // // 事务工具类 start
  // // 获取DataSourceTransactionManager
  // public DataSourceTransactionManager getTransactionManager() {
  // ApplicationContext appCtx = SpringContextUtil.getApplicationContext();
  // DataSourceTransactionManager transactionManager =
  // appCtx.getBean("transactionManager", DataSourceTransactionManager.class);
  // return transactionManager;
  // }
  //
  // // 获取TransactionStatus
  // public TransactionStatus getStatus(DataSourceTransactionManager transactionManager) {
  // DefaultTransactionDefinition def = new DefaultTransactionDefinition();
  // def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
  // TransactionStatus status = transactionManager.getTransaction(def);
  // return status;
  // }
  // // 事务工具类 end


}
