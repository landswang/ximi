package com.ejie.nbrs.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.ejie.nbrs.cache.RedisCache;
import com.ejie.nbrs.dao.LoanInfoDao;
import com.ejie.nbrs.dao.StorageViewDao;
import com.ejie.nbrs.dto.AccessoryInfo;
import com.ejie.nbrs.dto.BaseResult;
import com.ejie.nbrs.dto.Emessage;
import com.ejie.nbrs.dto.LoaninfoIndex;
import com.ejie.nbrs.dto.LogView;
import com.ejie.nbrs.dto.NewLoanView;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.ejieinterface.dao.NewOrderDao;
import com.ejie.nbrs.entity.Account;
import com.ejie.nbrs.entity.CommonApplicant;
import com.ejie.nbrs.entity.FilePathView;
import com.ejie.nbrs.entity.FileRPath;
import com.ejie.nbrs.entity.GrantMoney;
import com.ejie.nbrs.entity.GuaranteeManagement;
import com.ejie.nbrs.entity.GuaranteeValue;
import com.ejie.nbrs.entity.LoanAudit;
import com.ejie.nbrs.entity.LoanInfo;
import com.ejie.nbrs.entity.LogManagement;
import com.ejie.nbrs.entity.MateInfo;
import com.ejie.nbrs.entity.MortgageCar;
import com.ejie.nbrs.entity.MortgageHouse;
import com.ejie.nbrs.entity.PropertyOwner;
import com.ejie.nbrs.entity.ScratchFile;
import com.ejie.nbrs.service.AccountService;
import com.ejie.nbrs.service.ImagesService;
import com.ejie.nbrs.service.LoanInfoService;
import com.ejie.nbrs.util.ConfigConst;
import com.ejie.nbrs.util.Number2CN;
import com.ejie.nbrs.util.SpringContextUtil;
import com.ejie.nbrs.util.ZPageUtil;

@Service
public class LoanInfoServiceImpl implements LoanInfoService {

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
  private StorageViewDao svdao;
  @Autowired
  private ImagesService imagesService;

  /**
   * 
   * listSelectAccessoryInfo: 查询上传附件
   * 
   * @param @return 设定文件
   * @return List<AccessoryInfo> DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public List<AccessoryInfo> listSelectAccessoryInfo(SearchCondition sc) {
    return loanInfoDao.listSelectAccessoryInfo(sc);
  }

  /**
   * 
   * @Title: searchLoanConmmon
   * @Description: TODO 根据条件查询分页结果
   * @param @param sc currentPage：查询页数；pageSize：每页显示条数； startTime：查询起始时间；endTime：查询结束时间；
   *        aBaseName：贷款客户姓名；eProduct：贷款产品； status：审核结果；1、通过，2、不通过，3全部 nodeStatus：节点标记码；
   *        flowStatus：流程状态码；1、通过，2、不通过，0、审核中
   * @param @return 参数
   * @return ZPageUtil<LoaninfoIndex> 返回类型
   * @throws
   */
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public ZPageUtil<LoaninfoIndex> searchLoanCommon(SearchCondition sc) {
    // 是否设置每页显示条数
    if (sc.getPageSize() == 0) {
      sc.setPageSize(10);
    }
    if (sc.getEndTime() != null && !"".equals(sc.getEndTime())) {
      sc.setEndTime(sc.getEndTime() + " 23:59:59");
    }
    int count = 0;
    if (sc.getFlowStatus() >= 10) {// 授信专员通道
      count = loanInfoDao.fcCount(sc);// 得到总条数
    } else {// 普通通道
      count = loanInfoDao.loanConmmonCount(sc);// 得到总条数
    }

    int pageSize = sc.getPageSize(); // 得到每页显示条数

    int totalPage = count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1; // 得到总页数

    // 通过用户输入页数转换查看起始条数
    if (sc.getCurrentPage() <= 1) {
      sc.setCurrentPage(1);// 初始话查看页码
      sc.setDataIndex(0);// 查询起始下标
    } else if (sc.getCurrentPage() > totalPage) {
      sc.setCurrentPage(totalPage);// 不能超过总页数
      sc.setDataIndex((sc.getCurrentPage() - 1) * sc.getPageSize());// 查询起始下标
    } else {
      sc.setDataIndex((sc.getCurrentPage() - 1) * sc.getPageSize());// 查询起始下标
    }

    System.out.println("_______________sc:___________________" + sc);
    List<LoaninfoIndex> li = null;
    if (sc.getFlowStatus() >= 10) {// 授信专员通道
      li = loanInfoDao.fcList(sc);// 得到查询结果集
    } else {// 普通通道
      li = loanInfoDao.loanConmmonList(sc);// 得到查询结果集
    }

    for (LoaninfoIndex l : li) {
      // 查找传入 节点最后一次操作记录的时间、上一个节点最后一次操作时间
      doReceiveTime(sc, l);
    }

    ZPageUtil<LoaninfoIndex> zp = new ZPageUtil<LoaninfoIndex>();// 初始分页对象
    // 得到当前页数
    zp.setCurrentPage(sc.getCurrentPage());
    zp.setCount(count);
    zp.setPageSize(pageSize);
    zp.setTotalPage(totalPage);
    zp.setList(li);

    System.out.println("zp:____________________________________________" + zp);

    return zp;

  };

  /**
   * 
   * @Title: alterLoanValue
   * @Description: TODO 修改抵押物：我行评估价值、总价值、抵押率
   * @param @param sc
   * @param @return 参数
   * @return boolean 返回类型
   * @throws
   */
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public boolean alterLoanValue(SearchCondition sc) {
    NewLoanView nl = showLoanView(sc);;// 通过贷款loanId查看贷款详细信息
    List<MortgageHouse> list = sc.getEvaluate();// 前端传入抵押房我行评估价值信息
    Integer mHId2 = null;// 抵押房具体id

    float nbComfirmValue = 0;// 我行评估金额
    float nbAll = 0;// 我行评估抵押物总额

    String serialNo = null;// 业务流水号

    for (MortgageHouse l : list) {
      mHId2 = l.getmHId();
      nbComfirmValue = l.getNbComfirmValue().floatValue();
      System.out.println("抵押物id为：" + mHId2 + "的我行评估价值是：" + nbComfirmValue);

      nbAll += nbComfirmValue;// 抵押物总额等于每个抵押物价值
      boolean bool1 = loanInfoDao.alterNbComfirmValue(l);// 修改抵押房中我行评估价值
      System.out.println(bool1);
    }
    float appMoney = nl.getAppMoney().floatValue();// 初审贷款金额
    Float nbCRate = appMoney / nbAll;// 我行抵押率

    System.out.println("我行评估抵押物总额:" + nbAll);
    System.out.println("我行抵押率为：" + nbCRate);
    if (nbCRate > 100) {// 抵押率超过理论值
      return false;
    }
    serialNo = sc.getSerialNo();// 根据业务流水号，修改抵押物价值表中，对应我行评估总价值、我行抵押率
    GuaranteeValue gv = new GuaranteeValue();// 声明一个抵押物价值信息
    gv.setSerialNo(serialNo);
    gv.setNbComfirmValue(new BigDecimal(nbAll));
    gv.setNbCRate(nbCRate * 100);
    boolean bool2 = loanInfoDao.alterNbAll(gv);// 根据传入抵押物价值流水号，修改我行评估总额、我行抵押率
    System.out.println(bool2);
    return bool2;

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
  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  // REQUIRES_NEW：如当前有transaction，则在transaction状态下执行；如果当前没有transaction，在无transaction状态下执行；
  public int alterLoanCommon(HttpSession session, SearchCondition sc) {
    int tg = 0;
    // 开启事务
    // DataSourceTransactionManager transactionManager = getTransactionManager();
    // TransactionStatus status = getStatus(transactionManager);
    boolean bo = false;
    try {
      boolean flag;
      LoanInfo nl = loanInfoDao.selectLoanInfoByLoanId(sc.getLoanId());// 通过贷款loanId查看贷款详细信息
      List<MortgageHouse> evaluate = sc.getEvaluate();
      if (evaluate != null) {
        if (evaluate.size() > 0) {// 取到传入的抵押物信息，主要是为了取到每个抵押物的我行评估金额
          boolean bool = alterLoanValue(sc);
          if (!bool) {
            tg = 3;
            return tg;
          }

        }
      }

      if (sc.getNodeStatus() == 1006 && sc.getFlowStatus() == 1) {// 如果是放款确认通过

        LoanInfo loanInfo = loanInfoDao.selectLoanInfoByLoanId(sc.getLoanId());// 得到贷款信息
        if (loanInfo != null) {// 添加信息到放款信息表
          loanInfo.setLoanMoney(sc.getRealLoanMoney());// 实际放款金额
          int i = loanInfoDao.insertGrantMoney(loanInfo);
          System.out.println(i);
        }

      }
      // 判断是否有放款模式或者放款时间的输入，有输入数据，说明此次修改是放款确认修改。则进入不同的修改通道
      if ((sc.getStartTime() != null && !sc.getStartTime().equals(""))
          || (sc.geteProduct() != null && !sc.geteProduct().equals(""))) {
        flag = loanInfoDao.alterLoanView(sc);// 修改状态还要修改其他信息的情况
      } else {
        flag = loanInfoDao.alterStatus(sc);// 只是修改状态的情况
      }

      if (flag) {// 如果修改操作执行成功，需要清除之前的查询缓存，否则要等到缓存时间结束，页面查询数据才会更新
        // 这个地方用的模糊清除缓存，不需要完整的key，因为sc不好确定，所以key的命名很重要
        // cache.deleteCacheWithPattern(RedisCache.CAHCENAME
        // + "|pageSearchAll|");

        // Integer userId, Integer loanId, Integer flowNode,
        // String status, String conent, String accessoryImg, String remark
        if (sc.getOutRemark() == null) {
          sc.setOutRemark("无");
        }
        if (sc.getNodeStatus() == 1081 && sc.getFlowStatus() == -1) {
          LoanAudit loanAudit =
              new LoanAudit(sc.getcUserId(), sc.getLoanId(), sc.getSerialNo(),// 声明一个订单审核记录表
                  nl.getNodeStatus(), String.valueOf(nl.getFlowStatus()), 1002, "1",
                  sc.getOutRemark(), sc.getLoanVoucher(), "无");
          int i = loanInfoDao.insertLoanAudit(loanAudit);// 添加订单审核记录表信息
          System.out.println(i);
        } else {
          LoanAudit loanAudit =
              new LoanAudit(sc.getcUserId(), sc.getLoanId(), sc.getSerialNo(),// 声明一个订单审核记录表
                  nl.getNodeStatus(), String.valueOf(nl.getFlowStatus()), sc.getNodeStatus(), sc
                      .getFlowStatus().toString(), sc.getOutRemark(), sc.getLoanVoucher(), "无");
          int i = loanInfoDao.insertLoanAudit(loanAudit);// 添加订单审核记录表信息
          System.out.println(i);
        }

        if (sc.getNodeStatus() == 1006 && sc.getFlowStatus() == 1) { // 添加审核通过数据到入库管理

          GuaranteeManagement gm = new GuaranteeManagement();

          gm.setLoanId(nl.getLoanId());// 贷款编号
          gm.setgId(nl.getGuaranteeId());// 抵押物编号
          gm.setGmAppId(nl.getaBaseId());// 未确认---------------抵押人id
          String dateString = sc.getStartTime();
          Date date = null;
          try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(dateString);
          } catch (ParseException e) {
            System.out.println(e.getMessage());
          }
          gm.setFinalTransferDate(date);// 放款时间
          gm.setGmInTime(new Date());// 押品入库时间

          gm.setGmType("住房");
          svdao.insertStorage(gm);

          // List<MortgageCar> mortgageCar = nl.getMortgageCar();
          // for (MortgageCar mc : mortgageCar) {
          // gm.setgCHId(mc.getMcarId());
          // gm.setGmType("车辆");
          // svdao.insertStorage(gm);
          // }

        }

        sendMessage(session, sc);// 消息推送、以及操作记录保存

      }
      SearchCondition sc2 = new SearchCondition();
      sc2.setLoanId(sc.getLoanId());
      sc2.setSerialNo(sc.getSerialNo());
      sc2.seteProduct("-1");
      boolean bool = imagesService.deleteScratchFile(sc2);
      System.out.println("是否已经删除临时表中的图片记录？————" + bool);

      // 提交事务 如果出现异常继续执行下一条
      // transactionManager.commit(status);
      bo = true;
    } catch (Exception e) {
      e.printStackTrace();
      // transactionManager.rollback(status);
      // 回滚事务
    }
    if (bo) {
      tg = 1;
    } else {
      tg = 2;
    }
    return tg;
  }

  /**
   * 得到全部贷款类型
   */
  @Override
  public List<LoanInfo> searchAllProduct() {

    return loanInfoDao.searchAllProduct();
  }

  /**
   * showLoanView 查询某个人档案详情
   * 
   * @param id 通过传入loanId查询，查询loanId（主借人id）
   * @return 返回个人档案详情
   * 
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public NewLoanView showLoanView(SearchCondition sc) {

    String cache_key = RedisCache.CAHCENAME + "|showLoanView|" + sc;

    // 先去缓存中取
    NewLoanView result_cache = cache.getCache(cache_key, NewLoanView.class);

    if (result_cache == null) {
      // 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）

      // LoanInfo loanInfo = loanInfoDao.selectLoanInfoByLoanId(sc.getLoanId());//查询该贷款编号的基本信息
      result_cache = loanInfoDao.showLoanView(sc);// 查到贷款人详细信息表

      if (result_cache == null) {// 没有查询结果的情况，在存入缓存之前直接返回空
        return result_cache;
      }

      List<CommonApplicant> cp;// 声明一个新的共借人集合
      Integer cAInfoId = result_cache.getaBaseId();// 得到主借人id,通过主借人id去找共借人
      cp = loanInfoDao.selectCommonApplicantByCAInfoId(cAInfoId);

      List<MortgageHouse> mh = new ArrayList<MortgageHouse>();// 声明一个新的抵押房集合
      String mhouseId = result_cache.getMhouseId();
      mh = loanInfoDao.selectMortgageHouseListByMhouseId(mhouseId);
      /*** 格式化房屋区域 begin ***/
      for (int i = 0; i < mh.size(); i++) {
        if (true) {
          mh.get(i).setHouseArea(
              mh.get(i).getHouseArea().replaceAll("\\{", "").replaceAll("\\}", "")
                  .replaceAll("##", ""));
        }

      }
      /*** 格式化房屋区域 end ***/

      List<MortgageCar> mc = new ArrayList<MortgageCar>();// 声明一个新的抵押车集合
      String mcarId = result_cache.getMcarId();
      mc = loanInfoDao.selectMortgageCarListByMcarId(mcarId);

      // 查询到该贷款编号下的放款确认信息
      GrantMoney gm = loanInfoDao.selectGrantMoneyByLoanId(result_cache.getLoanId().toString());
      System.out.println("..................." + result_cache.getLoanId().toString());
      Integer mateInfoId = result_cache.getMateInfoId();// 得到配偶id
      MateInfo mateInfo = loanInfoDao.selectMateInfo(mateInfoId);// 得到配偶信息

      String guaranteeId = result_cache.getSerialNo();// 得到抵押物价值id
      GuaranteeValue guaranteeValue = loanInfoDao.selectGuaranteeValuebyGuaranteeId(guaranteeId);// 得到抵押物价值信息

      result_cache.setCommonApplicant(cp);
      result_cache.setMortgageHouse(mh);
      result_cache.setMortgageCar(mc);
      result_cache.setGrantMoney(gm);
      result_cache.setMateInfo(mateInfo);
      result_cache.setGuaranteeValue(guaranteeValue);

      List<LogView> logViewList = loanInfoDao.selectLogList(result_cache.getLoanId());// 得到操作日志信息

      // 因为新进件的时候传送状态码为“0”，节点码为1001，在数据库读出时只根据节点做判断，会判断为授信初审
      if (logViewList != null) {
        for (LogView logView : logViewList) {

          // if (logView.getFlowNode()==1001&&"0".equals(logView.getStatus())) {
          // logView.setNodeName("新进件");
          // }
          // if (logView.getFlowNode()==1003&&"0".equals(logView.getStatus())) {
          // logView.setNodeName("放款预审");
          // }

          if ("-1".equals(logView.getOldStatus())) {
            if (1080 == logView.getOldFlowNode()) {
              logView.setNodeName("新进件");
            } else if (1081 == logView.getOldFlowNode()) {
              logView.setNodeName("放款预审");
            }
          }

          if ("3".equals(logView.getOldStatus())) {
            if ("0".equals(logView.getStatus())) {
              logView.setNodeName(logView.getNodeName() + "  补充资料完成");
            } else {
              logView.setNodeName(logView.getNodeName() + " 补充资料");
            }
          }
        }
      }

      result_cache.setLogViewList(logViewList);// 加入日志操作记录信息

      SearchCondition sc2 = new SearchCondition();
      sc2.setSerialNo(sc.getSerialNo());
      sc2.setLoanId(sc.getLoanId());
      sc2.seteProduct("-1");
      List<ScratchFile> scratchFileList = imagesService.selectScratchFile(sc2);// 关联临时文件集合

      result_cache.setScratchFileList(scratchFileList);// 临时上传文件记录


      // 附件上传和资料补充地址
      try {
        ConfigConst.getConfigConst();
      } catch (Exception e) {
        e.printStackTrace();
      }
      String realPath2 = ConfigConst.fileRPath;

      String[] realPath = realPath2.split(",");

      FileRPath frp = new FileRPath();
      frp.setLoan(realPath[0]);
      frp.setXw(realPath[1]);
      frp.setStorage(realPath[2]);
      // System.out.println(frp);

      // 设置 附件上传和资料补充地址
      result_cache.setFileRPath(frp);
      System.out.println("——————————————————————————————————————" + result_cache);

      // 将K-V存放进入缓存
      // cache.putCacheWithExpireTime(cache_key, result_cache,
      // RedisCache.CAHCETIME);
      // 打印缓存新增K
      LOG.info("put cache with key:" + cache_key);
      // 输出查看缓存基本信息
      // System.out.println(" result_cache.size() is " +
      // result_cache.size());
      System.out.println(" result_cache is " + result_cache);
      System.out.println(" RedisCache.CAHCETIME is " + RedisCache.CAHCETIME);
    } else {
      LOG.info("get cache with key:" + cache_key);
    }
    return result_cache;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.ejie.nbrs.service.LoanInfoService#getFilePath()
   * 
   * 获取文件列表
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public BaseResult<List<FilePathView>> getFilePath(FilePathView fp) {
    int code = 1;
    String msg = "";
    List<FilePathView> fplist = null;

    // fplist = loanInfoDao.getFilePath(fp);
    // 一期二期对应方法,返回fplist
    fplist = getFplistByOneToTwoAndSourceTypeEqualsOne(fp);

    int size = fplist.size();
    if (size == 0) {
      code = 0;
      msg = "没有图片";
    } else {
      msg = "有" + size + "张图片";
      for (FilePathView f : fplist) {
        String str = f.getName();
        if (str != null && !"".equals(str)) {
          int start = str.lastIndexOf("/");
          int end = str.lastIndexOf(".");
          f.setFilename(str.substring(start + 1, end - 17).toString());
        }
      }

    }

    return new BaseResult<List<FilePathView>>(code, msg, fplist);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.ejie.nbrs.service.LoanInfoService#getFilePath()
   * 
   * 获取文件列表
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public BaseResult<List<FilePathView>> getXwFilePath(SearchCondition sc) {
    int code = 1;
    String msg = "";
    List<FilePathView> list = null;

    try {

      // list = loanInfoDao.getXwFilePath(sc);
      // 一期二期对应方法,返回fplist
      list = getListByOneToTwoAndSourceTypeEqualsTwo(sc);

      int size = list.size();
      if (size == 0) {
        code = 0;
        msg = "没有图片";
      } else {
        msg = "有" + size + "张图片";
        for (FilePathView f : list) {
          String str = f.getName();
          if (str != null && !"".equals(str)) {
            int start = str.lastIndexOf("/");
            int end = str.lastIndexOf(".");
            f.setFilename(str.substring(start + 1, end - 17).toString());
          }
        }

      }
    } catch (Exception e) {
      code = 0;
      msg = "执行失败";
      e.printStackTrace();
    }



    return new BaseResult<List<FilePathView>>(code, msg, list);
  }

  /**
   * showWarrantByLoanId 查看该贷款编号下关联的押品权证信息
   * 
   * @param sc loanid 贷款编号
   * @return
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public NewLoanView showWarrantByLoanId(SearchCondition sc) {

    String cache_key = RedisCache.CAHCENAME + "|showWarrantByLoanId|" + sc;

    // 先去缓存中取
    NewLoanView result_cache = cache.getCache(cache_key, NewLoanView.class);

    if (result_cache == null) {
      // 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）

      NewLoanView nl = loanInfoDao.showWarrantByLoanId(sc);// 得到该贷款编号下的基本信息

      if (nl == null) {
        return result_cache;
      }

      if (nl != null) {
        Integer cAInfoId = nl.getaBaseId();// 得到主借人id,通过主借人id去找共借人
        String mhouseId = nl.getMhouseId();// 得到抵押房id
        List<CommonApplicant> cp = loanInfoDao.selectCommonApplicantByCAInfoId(cAInfoId);
        List<MortgageHouse> mh = loanInfoDao.selectMortgageHouseListByMhouseId(mhouseId);// 通过抵押房id查询到抵押房集合
        List<Integer> houseWarrantIdList = new ArrayList<Integer>();// 声明一个存放房子权证信息id的集合
        List<PropertyOwner> poList = new ArrayList<PropertyOwner>();// 抵押人集合
        /* 抵押人的业务逻辑：主借人必须为抵押人，共借人可能为抵押人 */
        /* 业务逻辑生成抵押人集合，返回给前端 begin */
        PropertyOwner po =
            new PropertyOwner(nl.getName(), nl.getIdNumber(), nl.getPhoneNumber(),
                nl.getPermanentAddress());// 主借人信息放入抵押人集合
        poList.add(po);
        if (cp != null) {
          for (MortgageHouse h : mh) { // 遍历抵押房集合，把每个房子的权证信息存进房子权证信息集合
            houseWarrantIdList.add(h.getWarrantId());
            String[] pos = h.getPropertyOwner().split("/");// 取出每个抵押物抵押人集合
            if (pos.length > 1) {// 判断该抵押物有多个抵押人
              for (int i = 0; i < pos.length; i++) {// 抵押物对应的抵押人
                for (CommonApplicant p : cp) {// 循环共借人集合匹配抵押人
                  if (pos[i].equals(p.getcAName())) {// 判断抵押物对应的抵押人和共借人名字相等
                    /* 将匹配到的抵押人信息放到集合 */
                    po =
                        new PropertyOwner(p.getcAName(), p.getcAIdNumber(), p.getcAPhoneNumber(),
                            p.getcAResidenceAddress());
                    poList.add(po);
                  }
                }
              }
            }
          }
        }/* 业务逻辑生成抵押人集合，返回给前端 end */
        /*
         * 贷款用途 新网 和易捷的匹配 当易捷贷款用途为 ：经营周转、创业、长期投资、临时周转时 对应新网的 生产经营； 当易捷贷款用途为 ：个人消费、购房购车、装修时
         * 对应新网的综合消费；
         */
        if (nl.getLoanPurpose() != null) {
          if (nl.getLoanPurpose().equals("经营周转") || nl.getLoanPurpose().equals("创业")
              || nl.getLoanPurpose().equals("长期投资") || nl.getLoanPurpose().equals("临时周转")) {
            nl.setLoanPurpose("生产经营");
          } else if (nl.getLoanPurpose().equals("个人消费") || nl.getLoanPurpose().equals("购房购车")
              || nl.getLoanPurpose().equals("装修")) {
            nl.setLoanPurpose("综合消费");
          }
        }

        nl.setHouseWarrantId(houseWarrantIdList);// 存进实体

        List<MortgageCar> mc = new ArrayList<MortgageCar>();// 声明一个新的抵押车集合
        String mcarId = nl.getMcarId();
        mc = loanInfoDao.selectMortgageCarListByMcarId(mcarId);
        List<Integer> carWarrantIdList = new ArrayList<Integer>();// 声明一个存放车子权证信息id的集合
        for (MortgageCar c : mc) { // 遍历抵押房集合，把每个车子的权证信息存进房子权证信息集合
          houseWarrantIdList.add(c.getWarrantId());
        }
        nl.setCarWarrantId(carWarrantIdList);// 存进实体
        // 查询到该贷款编号下的放款确认信息
        GrantMoney gm = loanInfoDao.selectGrantMoneyByLoanId(sc.getLoanId().toString());
        BigDecimal appMoney = nl.getAppMoney();// 得到送审放款金额
        String capitalization = Number2CN.number2CNMontrayUnit(appMoney);// 转成人民币大写金额
        nl.setCommonApplicant(cp);// 共借人
        nl.setMortgageHouse(mh);// 抵押房
        nl.setMortgageCar(mc);// 抵押车
        nl.setGrantMoney(gm);// 放款信息
        nl.setPoList(poList);// 抵押人
        nl.setCapitalization(capitalization);// 大写人名币金额
        result_cache = nl;
      }
      // 将K-V存放进入缓存
      // cache.putCacheWithExpireTime(cache_key, result_cache,
      // RedisCache.CAHCETIME);
      // 打印缓存新增K
      LOG.info("put cache with key:" + cache_key);
      System.out.println(" result_cache is " + result_cache);
      System.out.println(" RedisCache.CAHCETIME is " + RedisCache.CAHCETIME);
    } else {
      LOG.info("get cache with key:" + cache_key);
    }
    return result_cache;
  }

  /**
   * 分页-查询贷款信息
   */
  @Override
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public ZPageUtil<LoaninfoIndex> pageSearchAllNewOrder(SearchCondition sc) {

    String cache_key = RedisCache.CAHCENAME + "|pageSearchAllNewOrder|" + sc;

    System.out.println("```````````````````````````````````" + cache_key);
    // 先去缓存中取
    @SuppressWarnings("unchecked")
    ZPageUtil<LoaninfoIndex> result_cache = cache.getCache(cache_key, ZPageUtil.class);

    if (result_cache == null) {
      // 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）

      // 是否设置每页显示条数
      if (sc.getPageSize() == 0) {
        sc.setPageSize(10);
      }

      int count = newOrderDao.SearchCount(sc);// 得到总条数

      int pageSize = sc.getPageSize(); // 得到每页显示条数

      int totalPage = count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1; // 得到总页数

      // 通过用户输入页数转换查看起始条数
      if (sc.getCurrentPage() <= 1) {
        sc.setCurrentPage(1);// 初始话查看页码
        sc.setDataIndex(0);// 查询起始下标
      } else if (sc.getCurrentPage() > totalPage) {
        sc.setCurrentPage(totalPage);// 不能超过总页数
        sc.setDataIndex((sc.getCurrentPage() - 1) * sc.getPageSize());// 查询起始下标
      } else {
        sc.setDataIndex((sc.getCurrentPage() - 1) * sc.getPageSize());// 查询起始下标
      }

      System.out.println("_______________sc:___________________" + sc);

      List<LoaninfoIndex> li = newOrderDao.searchAllNew(sc);// 得到查询结果集

      ZPageUtil<LoaninfoIndex> zp = new ZPageUtil<LoaninfoIndex>();// 初始分页对象
      // 得到当前页数
      zp.setCurrentPage(sc.getCurrentPage());
      zp.setCount(count);
      zp.setPageSize(pageSize);
      zp.setTotalPage(totalPage);

      if (li == null) {
        return result_cache;
      } else {
        zp.setList(li);
      }
      result_cache = zp;

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~ zp" + zp);
      // cache.putCacheWithExpireTime(cache_key, result_cache,
      // RedisCache.CAHCETIME);
      LOG.info("put cache with key:" + cache_key);
    } else {
      LOG.info("get cache with key:" + cache_key);
    }

    return result_cache;
  }

  // 事务工具类 start
  // 获取DataSourceTransactionManager
  public DataSourceTransactionManager getTransactionManager() {
    ApplicationContext appCtx = SpringContextUtil.getApplicationContext();
    DataSourceTransactionManager transactionManager =
        appCtx.getBean("transactionManager", DataSourceTransactionManager.class);
    return transactionManager;
  }

  // 获取TransactionStatus
  public TransactionStatus getStatus(DataSourceTransactionManager transactionManager) {
    DefaultTransactionDefinition def = new DefaultTransactionDefinition();
    def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
    TransactionStatus status = transactionManager.getTransaction(def);
    return status;
  }

  // 事务工具类 end

  /**
   * 
   * sendMessage: TODO 消息推送，保存操作记录
   * 
   * @param @param sc 设定文件
   * @return void DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void sendMessage(HttpSession session, SearchCondition sc) {
    String operateIp = String.valueOf(session.getAttribute("operateIp"));
    Account account = accountService.queryByUId(sc.getcUserId());
    // 消息内容
    String content = "";
    // 操作人姓名
    String userName = "";
    // 操作人id（暂时不用，保留--）
    int roleId = account.getRoleId();
    if (account != null) {
      userName = account.getUserName();
    }
    content = "————操作人姓名：" + userName + "，操作人id：" + roleId + "。";
    // if (sc.getStartTime() != null && !sc.getStartTime().equals("")) {
    // content.append("，放款日期被修改为：" + sc.getStartTime());
    // }
    // if ((sc.geteProduct() != null && !sc.geteProduct().equals(""))) {
    // content.append("，放款模式被修改为：" + sc.geteProduct());
    // }
    // if ((sc.getLoanVoucher() != null && !sc.getLoanVoucher().equals(""))) {
    // content.append("，放款凭证被修改为：" + sc.getLoanVoucher());
    // }
    // if ((sc.getOutRemark() != null && !sc.getOutRemark().equals(""))) {
    // content.append("，备注说明被修改为：" + sc.getOutRemark());
    // }

    // content.append("。");
    // System.out.println("----------message is :" + content);
    Emessage emessage = null;
    if (sc.getOutRemark() == null) {
      sc.setOutRemark("没有具体说明。");
    }
    if (account != null) {
      // 操作类型标识
      String otype = "";
      // 节点名
      String nodeName = "";

      // 授信初审消息
      if (sc.getNodeStatus() == 1001) {
        nodeName = "授信初审";
        if (sc.getFlowStatus() == 1) {
          otype = "授信初审-通过";
          nodeName = "授信复审";
        } else if (sc.getFlowStatus() == 2) {
          otype = "授信初审-拒绝";
        } else if (sc.getFlowStatus() == 3) {
          otype = "授信初审-补充资料";
        } else if (sc.getFlowStatus() == 0) {
          otype = "新进件";
        }
        // 授信复审消息
      } else if (sc.getNodeStatus() == 1002) {
        nodeName = "授信复审";
        if (sc.getFlowStatus() == 1) {
          otype = "授信复审-通过";
          nodeName = "资料补充";
        } else if (sc.getFlowStatus() == 2) {
          otype = "授信复审-拒绝";
        } else if (sc.getFlowStatus() == 3) {
          otype = "授信复审-补充资料";
        } else if (sc.getFlowStatus() == 0) {
          otype = "授信复审-待审核";
        }
        // 放款初审消息
      } else if (sc.getNodeStatus() == 1003) {
        nodeName = "放款初审";
        if (sc.getFlowStatus() == 1) {
          otype = "放款初审-通过";
          nodeName = "放款复审";
        } else if (sc.getFlowStatus() == 2) {
          otype = "放款初审-拒绝";
        } else if (sc.getFlowStatus() == 3) {
          otype = "放款初审-补充资料";
        } else if (sc.getFlowStatus() == 0) {
          otype = "放款初审-待审核";
        }
        // 放款复审消息
      } else if (sc.getNodeStatus() == 1004) {
        nodeName = "放款复审";
        if (sc.getFlowStatus() == 1) {
          otype = "放款复审-通过";
          nodeName = "放款终审";
        } else if (sc.getFlowStatus() == 2) {
          otype = "放款复审-拒绝";
        } else if (sc.getFlowStatus() == 3) {
          otype = "放款复审-补充资料";
        } else if (sc.getFlowStatus() == 0) {
          otype = "放款复审-待审核";
        }
        // 放款终审消息
      } else if (sc.getNodeStatus() == 1005) {
        nodeName = "放款终审";
        if (sc.getFlowStatus() == 1) {
          otype = "放款终审-通过";
          nodeName = "账务确认";
        } else if (sc.getFlowStatus() == 2) {
          otype = "放款终审-拒绝";
        } else if (sc.getFlowStatus() == 3) {
          otype = "放款终审-补充资料";
        } else if (sc.getFlowStatus() == 0) {
          otype = "放款终审-待审核";
        }
        // 账务确认消息
      } else if (sc.getNodeStatus() == 1006) {
        nodeName = "账务确认";
        if (sc.getFlowStatus() == 1) {
          otype = "放款确认-通过";
          nodeName = "入库审批";
        } else if (sc.getFlowStatus() == 2) {
          otype = "放款确认-拒绝";
        } else if (sc.getFlowStatus() == 0) {
          otype = "放款确认-待审核";
        }
        // 放款预审消息
      } else if (sc.getNodeStatus() == 1081) {
        nodeName = "放款预审";
        if (sc.getFlowStatus() == -1) {
          otype = "授信复审-通过";
          nodeName = "资料补充";
        } else if (sc.getFlowStatus() == 3) {
          otype = "资料补充";
        }
      }

      // 需要跳转到的节点，默认本节点
      int type = sc.getNodeStatus();
      // 资料补充，跳转到金融专员页面
      if (sc.getFlowStatus() == 3) {
        type = 1081;
        nodeName = "资料补充";
      }
      // 本节点通过跳转到下一个节点页面，最后一个节点保留
      if (sc.getFlowStatus() == 1) {
        type = sc.getNodeStatus() + 1;
        if (sc.getNodeStatus() == 1006) {
          type = 1006;
        }
      }
      // 消息标题
      String title = "您有新的贷款申请需要进行" + nodeName + "，请尽快处理。";
      content = title + content;
      System.out.println("````````````````````````" + content);
      // 测试默认推送给1000 超级管理员
      emessage = new Emessage(new Date(), type, title, content.toString(), sc.getcUserId(), 1000);
      emessage.setLoanId(sc.getLoanId());
      // 推送消息给指定对象群
      // MessageUtil.sendToTargetRole(emessage, cache);

      // 声明一个日志系统管理记录
      LogManagement logManagement =
          new LogManagement(sc.getLoanId(), otype, sc.getcUserId().toString(), new Date(), otype
              + "————" + sc.getOutRemark(), "贷款审批", operateIp);
      // 添加日志信息
      svdao.insertLogManagement(logManagement);
    }
    System.out.println("-----------emessage is:" + emessage);
  }

  /**
   * 
   * doReceiveTime: 接收时间特殊处理
   * 
   * @param 设定文件
   * @return void DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void doReceiveTime(SearchCondition sc, LoaninfoIndex l) {
    // 得到上一个节点最后一次操作日志信息--------start
    Map<String, Integer> map2 = new HashMap<String, Integer>();
    if (sc.getNodeStatus() != null && !"".equals(sc.getNodeStatus())) {
      map2.put("loanId", l.getLoanId());
      if (sc.getNodeStatus() == 1001) {
        map2.put("nodeStatus", 1001);
        map2.put("status", 0);
      } else if (sc.getNodeStatus() == 1003) {
        map2.put("nodeStatus", 1003);
        map2.put("status", 0);
      } else {
        map2.put("nodeStatus", sc.getNodeStatus() - 1);
      }
      LoanAudit loanAudit2 = loanInfoDao.selectLoanAudit(map2);// 得到上一个节点最后一次操作日志信息
      if (loanAudit2 != null) {
        l.setReceiveTime(loanAudit2.getAuditingTime());// 上一个节点最后一次操作时间
        Map<String, String> map3 = new HashMap<String, String>();
        map3.put("serialNo", l.getSerialNo());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        map3.put("receiveTime", sdf.format(loanAudit2.getAuditingTime()));
        loanInfoDao.alterReceiveTime(map3);// 修改loan_info表中接受时间
      }
    }
    // 得到上一个节点最后一次操作日志信息--------end

    // 得到本节点最后一次操作日志信息--------start
    Map<String, Integer> map = new HashMap<String, Integer>();
    if (sc.getNodeStatus() != null && !"".equals(sc.getNodeStatus())) {
      map.put("loanId", l.getLoanId());
      map.put("nodeStatus", sc.getNodeStatus());
      LoanAudit loanAudit = loanInfoDao.selectLoanAudit(map);// 得到同id的最新操作日志信息

      if (loanAudit != null) {
        l.setAuditingTime(loanAudit.getAuditingTime());// 最新一次操作日志时间，最后一次操作时间
      }
    }
    // 得到本节点最后一次操作日志信息--------end
  }


  public List<FilePathView> getFplistByOneToTwoAndSourceTypeEqualsOne(FilePathView fp) {
    List<FilePathView> fplist = null;
    LinkedList<String> docArr = new LinkedList<String>();
    if ("GRSRZM".equals(fp.getDoc())) {
      docArr.add("GRSRZM");
      docArr.add("DKYTZMWJ");
      docArr.add("FKSCSPB");
    }
    if ("DKYTZMWJ".equals(fp.getDoc())) {
      docArr.add("DKYTZMWJ");
      docArr.add("FKSCSPB");
    }
    if ("QTFYJDBCJ".equals(fp.getDoc())) {
      docArr.add("QTFYJDBCJ");
    }
    if ("HKB".equals(fp.getDoc())) {
      docArr.add("HKB");
    }
    if ("SFZ".equals(fp.getDoc())) {
      docArr.add("SFZ");
    }
    if ("HYZM".equals(fp.getDoc())) {
      docArr.add("HYZM");
    }
    if ("JKRHKYHK".equals(fp.getDoc())) {
      docArr.add("JKRHKYHK");
    }
    if ("FCZHGTZBDCDJZ".equals(fp.getDoc())) {
      docArr.add("FCZHGTZBDCDJZ");
      docArr.add("FKSCSPB");
    }
    if ("XHZP".equals(fp.getDoc())) {
      docArr.add("XHZP");
      docArr.add("XHZPJYJPGXX");
    }
    if ("KHSSHZXAJQKCL".equals(fp.getDoc())) {
      docArr.add("KHSSHZXAJQKCL");
      docArr.add("QT");
    }
    if ("FWXXZYS".equals(fp.getDoc())) {
      docArr.add("FWXXZYSYJ");
      docArr.add("FWXXZYS");
    }
    if ("ZXBG".equals(fp.getDoc())) {
      docArr.add("FKSCSPB");
      docArr.add("ZXBG");
      docArr.add("GRZXXJBYJ");
    }
    if ("PGXX".equals(fp.getDoc())) {
      docArr.add("PGXX");
    }
    if ("GRDKSQSPS".equals(fp.getDoc())) {
      docArr.add("XWYHGRDKSQSPS");
      docArr.add("GRDKSQSPS");
      docArr.add("FKSCSPB");
    }
    if ("ZXCXSYSQSSX".equals(fp.getDoc())) {
      // docArr.add("FKSCSPB");
      docArr.add("GRZXDXXCXJSYSQSSX");
      // docArr.add("ZXBG");
      docArr.add("ZXCXSYSQSSX");
    }
    if ("QT".equals(fp.getDoc())) {
      docArr.add("QT");
    }
    if ("DYDJSLHZD".equals(fp.getDoc())) {
      docArr.add("DYDJSLHZD");
      docArr.add("FGJSLHZDZPHSMJ");
    }
    if ("DYSQBJJSX".equals(fp.getDoc())) {
      docArr.add("DYDJSQHFGJJSXYJ");
      docArr.add("DYSQBJJSX");
    }
    if ("STZFSQSSKRSFZJYHK".equals(fp.getDoc())) {
      docArr.add("STZFSQSKRYHKFYJ");
      docArr.add("STZFSQSSKRSFZJYHK");
    }
    if ("BZJZYQRH".equals(fp.getDoc())) {
      docArr.add("BZJZYQRHSMJ");
      docArr.add("BZJZYQRH");
    }
    if ("DBJKHT".equals(fp.getDoc())) {
      docArr.add("JKEDHT");
      docArr.add("DBJKHT");
    }
    if ("DKSPSX".equals(fp.getDoc())) {
      docArr.add("DKSPSX");
    }
    if ("EDZYD".equals(fp.getDoc())) {
      docArr.add("EDZYD");
    }
    if ("FKSCSPB".equals(fp.getDoc())) {
      docArr.add("FKSCSPB");
    }
    if ("FWZTSM".equals(fp.getDoc())) {
      docArr.add("FWZTSM");
      docArr.add("FKSCSPB");
    }
    if ("JJ".equals(fp.getDoc())) {
      docArr.add("JJ");
    }
    if ("MQZP".equals(fp.getDoc())) {
      docArr.add("MQZP");
    }
    if ("WTKKSQS".equals(fp.getDoc())) {
      docArr.add("WTKKSQS");
      docArr.add("ZHWTKKSQS");
    }
    if ("YHKLS".equals(fp.getDoc())) {
      docArr.add("FKSCSPB");
      docArr.add("YHKLS");
    }
    if ("ZXCXSYSQSFK".equals(fp.getDoc())) {
      docArr.add("GRZXDXXCXJSYSQSDY");
      docArr.add("ZXCXSYSQSFK");
    }
    fp.setDocArr((String[]) docArr.toArray(new String[docArr.size()]));
    fplist = loanInfoDao.getFilePath(fp);
    return fplist;
  }

  public List<FilePathView> getListByOneToTwoAndSourceTypeEqualsTwo(SearchCondition sc) {
    List<FilePathView> fplist = null;
    LinkedList<String> docArr = new LinkedList<String>();
    if ("GRSRZM".equals(sc.getOutReason())) {
      docArr.add("GRSRZM");
      docArr.add("DKYTZMWJ");
      docArr.add("FKSCSPB");
    }
    if ("DKYTZMWJ".equals(sc.getOutReason())) {
      docArr.add("DKYTZMWJ");
      docArr.add("FKSCSPB");
    }
    if ("QTFYJDBCJ".equals(sc.getOutReason())) {
      docArr.add("QTFYJDBCJ");
    }
    if ("HKB".equals(sc.getOutReason())) {
      docArr.add("HKB");
    }
    if ("SFZ".equals(sc.getOutReason())) {
      docArr.add("SFZ");
    }
    if ("HYZM".equals(sc.getOutReason())) {
      docArr.add("HYZM");
    }
    if ("JKRHKYHK".equals(sc.getOutReason())) {
      docArr.add("JKRHKYHK");
    }
    if ("FCZHGTZBDCDJZ".equals(sc.getOutReason())) {
      docArr.add("FCZHGTZBDCDJZ");
      docArr.add("FKSCSPB");
    }
    if ("XHZP".equals(sc.getOutReason())) {
      docArr.add("XHZP");
      docArr.add("XHZPJYJPGXX");
    }
    if ("KHSSHZXAJQKCL".equals(sc.getOutReason())) {
      docArr.add("KHSSHZXAJQKCL");
      docArr.add("QT");
    }
    if ("FWXXZYS".equals(sc.getOutReason())) {
      docArr.add("FWXXZYSYJ");
      docArr.add("FWXXZYS");
    }
    if ("ZXBG".equals(sc.getOutReason())) {
      docArr.add("FKSCSPB");
      docArr.add("ZXBG");
      docArr.add("GRZXXJBYJ");
    }
    if ("PGXX".equals(sc.getOutReason())) {
      docArr.add("PGXX");
    }
    if ("GRDKSQSPS".equals(sc.getOutReason())) {
      docArr.add("XWYHGRDKSQSPS");
      docArr.add("GRDKSQSPS");
      docArr.add("FKSCSPB");
    }
    if ("ZXCXSYSQSSX".equals(sc.getOutReason())) {
      // docArr.add("FKSCSPB");
      docArr.add("GRZXDXXCXJSYSQSSX");
      // docArr.add("ZXBG");
      docArr.add("ZXCXSYSQSSX");
    }
    if ("QT".equals(sc.getOutReason())) {
      docArr.add("QT");
    }
    if ("DYDJSLHZD".equals(sc.getOutReason())) {
      docArr.add("DYDJSLHZD");
      docArr.add("FGJSLHZDZPHSMJ");
    }
    if ("DYSQBJJSX".equals(sc.getOutReason())) {
      docArr.add("DYDJSQHFGJJSXYJ");
      docArr.add("DYSQBJJSX");
    }
    if ("STZFSQSSKRSFZJYHK".equals(sc.getOutReason())) {
      docArr.add("STZFSQSKRYHKFYJ");
      docArr.add("STZFSQSSKRSFZJYHK");
    }
    if ("BZJZYQRH".equals(sc.getOutReason())) {
      docArr.add("BZJZYQRHSMJ");
      docArr.add("BZJZYQRH");
    }
    if ("DBJKHT".equals(sc.getOutReason())) {
      docArr.add("JKEDHT");
      docArr.add("DBJKHT");
    }
    if ("DKSPSX".equals(sc.getOutReason())) {
      docArr.add("DKSPSX");
    }
    if ("EDZYD".equals(sc.getOutReason())) {
      docArr.add("EDZYD");
    }
    if ("FKSCSPB".equals(sc.getOutReason())) {
      docArr.add("FKSCSPB");
    }
    if ("FWZTSM".equals(sc.getOutReason())) {
      docArr.add("FWZTSM");
      docArr.add("FKSCSPB");
    }
    if ("JJ".equals(sc.getOutReason())) {
      docArr.add("JJ");
    }
    if ("MQZP".equals(sc.getOutReason())) {
      docArr.add("MQZP");
    }
    if ("WTKKSQS".equals(sc.getOutReason())) {
      docArr.add("WTKKSQS");
      docArr.add("ZHWTKKSQS");
    }
    if ("YHKLS".equals(sc.getOutReason())) {
      docArr.add("FKSCSPB");
      docArr.add("YHKLS");
    }
    if ("ZXCXSYSQSFK".equals(sc.getOutReason())) {
      docArr.add("GRZXDXXCXJSYSQSDY");
      docArr.add("ZXCXSYSQSFK");
    }
    sc.setDocArr((String[]) docArr.toArray(new String[docArr.size()]));
    fplist = loanInfoDao.getXwFilePath(sc);
    return fplist;
  }
}
