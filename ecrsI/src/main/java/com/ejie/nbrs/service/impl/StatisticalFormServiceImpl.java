package com.ejie.nbrs.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejie.nbrs.cache.RedisCache;
import com.ejie.nbrs.dao.LoanInfoDao;
import com.ejie.nbrs.dao.StatisticalFormDao;
import com.ejie.nbrs.dto.LogView;
import com.ejie.nbrs.dto.NewLoanView;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.entity.GuaranteeValue;
import com.ejie.nbrs.entity.HSDentity;
import com.ejie.nbrs.entity.InAStatisticalEntity;
import com.ejie.nbrs.entity.InAStatisticalExcelEntity;
import com.ejie.nbrs.entity.LendingForm;
import com.ejie.nbrs.entity.MortgageHouse;
import com.ejie.nbrs.entity.StatisticalForm;
import com.ejie.nbrs.entity.TzFormView;
import com.ejie.nbrs.service.LoanInfoService;
import com.ejie.nbrs.service.StatisticalFormService;
import com.ejie.nbrs.util.BigDecimalExUtils;
import com.ejie.nbrs.util.ZPageUtil;

/**
 * 
 * ClassName:StatisticalFormServiceImpl 统计报表业务逻辑
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月22日 下午2:28:45
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
@Service
public class StatisticalFormServiceImpl implements StatisticalFormService {

  private final Logger LOG = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private RedisCache cache;
  @Autowired
  private StatisticalFormDao sdao;
  @Autowired
  private LoanInfoService loanInfoService;
  @Autowired
  private LoanInfoDao loanInfoDao;

  /**
   * dataIndex：查看年份； eProduct：报表类型；
   */
  @Override
  public List<StatisticalForm> searchStatisticalForm(SearchCondition sc) {

    String cache_key = RedisCache.CAHCENAME + "|searchStatisticalForm|" + sc;

    // 先去缓存中取
    List<StatisticalForm> result_cache = cache.getListCache(cache_key, StatisticalForm.class);

    if (result_cache == null) {
      // 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）

      Map<String, Object> map = new HashMap<String, Object>();
      List<StatisticalForm> list = new ArrayList<StatisticalForm>();
      if (sc == null) {// 如果没有请求参数默认查询2017年的授信、放款报表
        sc = new SearchCondition();
        sc.setDataIndex(2017);// 默认显示授信报表。2017年
        sc.seteProduct("1");
      } else {// 如果没有选择类型，1为授信，2为放款；
        if (sc.geteProduct() == null) {
          sc.seteProduct("1");
        }
        if (sc.getDataIndex() == 0) {
          sc.setDataIndex(2017);// 默认显示授信报表。2017年
        }

      }
      map.put("type1", sc.geteProduct());

      map.put("starttime", sc.getDataIndex() + "-01-01");
      map.put("endtime", sc.getDataIndex() + "-12-31");
      StatisticalForm listYear = sdao.searchStatisticalForm(map);
      list.add(listYear);
      map.put("starttime", sc.getDataIndex() + "-01-01");
      map.put("endtime", sc.getDataIndex() + "-01-31");
      StatisticalForm listMonth1 = sdao.searchStatisticalForm(map);
      list.add(listMonth1);
      map.put("starttime", sc.getDataIndex() + "-02-01");
      map.put("endtime", sc.getDataIndex() + "-02-29");
      StatisticalForm listMonth2 = sdao.searchStatisticalForm(map);
      list.add(listMonth2);
      map.put("starttime", sc.getDataIndex() + "-03-01");
      map.put("endtime", sc.getDataIndex() + "-03-31");
      StatisticalForm listMonth3 = sdao.searchStatisticalForm(map);
      list.add(listMonth3);
      map.put("starttime", sc.getDataIndex() + "-04-01");
      map.put("endtime", sc.getDataIndex() + "-04-30");
      StatisticalForm listMonth4 = sdao.searchStatisticalForm(map);
      list.add(listMonth4);
      map.put("starttime", sc.getDataIndex() + "-05-01");
      map.put("endtime", sc.getDataIndex() + "-05-31");
      StatisticalForm listMonth5 = sdao.searchStatisticalForm(map);
      list.add(listMonth5);
      map.put("starttime", sc.getDataIndex() + "-06-01");
      map.put("endtime", sc.getDataIndex() + "-06-30");
      StatisticalForm listMonth6 = sdao.searchStatisticalForm(map);
      list.add(listMonth6);
      map.put("starttime", sc.getDataIndex() + "-07-01");
      map.put("endtime", sc.getDataIndex() + "-07-31");
      StatisticalForm listMonth7 = sdao.searchStatisticalForm(map);
      list.add(listMonth7);
      map.put("starttime", sc.getDataIndex() + "-08-01");
      map.put("endtime", sc.getDataIndex() + "-08-31");
      StatisticalForm listMonth8 = sdao.searchStatisticalForm(map);
      list.add(listMonth8);
      map.put("starttime", sc.getDataIndex() + "-09-01");
      map.put("endtime", sc.getDataIndex() + "-09-30");
      StatisticalForm listMonth9 = sdao.searchStatisticalForm(map);
      list.add(listMonth9);
      map.put("starttime", sc.getDataIndex() + "-10-01");
      map.put("endtime", sc.getDataIndex() + "-10-31");
      StatisticalForm listMonth10 = sdao.searchStatisticalForm(map);
      list.add(listMonth10);
      map.put("starttime", sc.getDataIndex() + "-11-01");
      map.put("endtime", sc.getDataIndex() + "-11-30");
      StatisticalForm listMonth11 = sdao.searchStatisticalForm(map);
      list.add(listMonth11);
      map.put("starttime", sc.getDataIndex() + "-12-01");
      map.put("endtime", sc.getDataIndex() + "-12-31");
      StatisticalForm listMonth12 = sdao.searchStatisticalForm(map);
      list.add(listMonth12);

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~" + list);


      result_cache = list;

      // cache.putCacheWithExpireTime(cache_key, result_cache,
      // RedisCache.CAHCETIME);
      LOG.info("put cache with key:" + cache_key);
    } else {
      LOG.info("get cache with key:" + cache_key);
    }
    return result_cache;
  }


  /**
   * 查询授信报表
   * 
   * @param sc dataIndex：查看年份；
   * @return
   */
  @Override
  public List<LendingForm> searchLendingForm(SearchCondition sc) {

    String cache_key = RedisCache.CAHCENAME + "|searchLendingForm|" + sc;

    // 先去缓存中取
    List<LendingForm> result_cache = cache.getListCache(cache_key, LendingForm.class);

    if (result_cache == null) {
      // 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）

      Map<String, Object> map = new HashMap<String, Object>();
      List<LendingForm> list = new ArrayList<LendingForm>();

      if (sc == null) {
        sc = new SearchCondition();
        sc.setDataIndex(2017);
      } else {
        if (sc.getDataIndex() == 0) {
          sc.setDataIndex(2017);
        }
      }
      map.put("starttime", sc.getDataIndex() + "-01-01");
      map.put("endtime", sc.getDataIndex() + "-12-31");
      LendingForm listYear = sdao.searchLendingForm(map);
      list.add(listYear);
      map.put("starttime", sc.getDataIndex() + "-01-01");
      map.put("endtime", sc.getDataIndex() + "-01-31");
      LendingForm listMonth1 = sdao.searchLendingForm(map);
      list.add(listMonth1);
      map.put("starttime", sc.getDataIndex() + "-02-01");
      map.put("endtime", sc.getDataIndex() + "-02-29");
      LendingForm listMonth2 = sdao.searchLendingForm(map);
      list.add(listMonth2);
      map.put("starttime", sc.getDataIndex() + "-03-01");
      map.put("endtime", sc.getDataIndex() + "-03-31");
      LendingForm listMonth3 = sdao.searchLendingForm(map);
      list.add(listMonth3);
      map.put("starttime", sc.getDataIndex() + "-04-01");
      map.put("endtime", sc.getDataIndex() + "-04-30");
      LendingForm listMonth4 = sdao.searchLendingForm(map);
      list.add(listMonth4);
      map.put("starttime", sc.getDataIndex() + "-05-01");
      map.put("endtime", sc.getDataIndex() + "-05-31");
      LendingForm listMonth5 = sdao.searchLendingForm(map);
      list.add(listMonth5);
      map.put("starttime", sc.getDataIndex() + "-06-01");
      map.put("endtime", sc.getDataIndex() + "-06-30");
      LendingForm listMonth6 = sdao.searchLendingForm(map);
      list.add(listMonth6);
      map.put("starttime", sc.getDataIndex() + "-07-01");
      map.put("endtime", sc.getDataIndex() + "-07-31");
      LendingForm listMonth7 = sdao.searchLendingForm(map);
      list.add(listMonth7);
      map.put("starttime", sc.getDataIndex() + "-08-01");
      map.put("endtime", sc.getDataIndex() + "-08-31");
      LendingForm listMonth8 = sdao.searchLendingForm(map);
      list.add(listMonth8);
      map.put("starttime", sc.getDataIndex() + "-09-01");
      map.put("endtime", sc.getDataIndex() + "-09-30");
      LendingForm listMonth9 = sdao.searchLendingForm(map);
      list.add(listMonth9);
      map.put("starttime", sc.getDataIndex() + "-10-01");
      map.put("endtime", sc.getDataIndex() + "-10-31");
      LendingForm listMonth10 = sdao.searchLendingForm(map);
      list.add(listMonth10);
      map.put("starttime", sc.getDataIndex() + "-11-01");
      map.put("endtime", sc.getDataIndex() + "-11-30");
      LendingForm listMonth11 = sdao.searchLendingForm(map);
      list.add(listMonth11);
      map.put("starttime", sc.getDataIndex() + "-12-01");
      map.put("endtime", sc.getDataIndex() + "-12-31");
      LendingForm listMonth12 = sdao.searchLendingForm(map);
      list.add(listMonth12);

      System.out.println("~~~~~~~~~~~~~~~~~~~~~~" + list);

      result_cache = list;

      // cache.putCacheWithExpireTime(cache_key, result_cache,
      // RedisCache.CAHCETIME);
      LOG.info("put cache with key:" + cache_key);
    } else {
      LOG.info("get cache with key:" + cache_key);
    }
    return result_cache;
  }

  /**
   * 进件统计查询 (non-Javadoc)
   * 
   * @see com.ejie.nbrs.service.StatisticalFormService#searchInAStatistical(java.util.Map)
   */
  @Override
  public List<InAStatisticalEntity> searchInAStatistical(SearchCondition sc) {
    String cache_key = RedisCache.CAHCENAME + "|searchInAStatistical|" + sc;
    // 先去缓存中取
    List<InAStatisticalEntity> result_cache =
        cache.getListCache(cache_key, InAStatisticalEntity.class);

    if (result_cache == null) {
      // 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
      Map<String, Object> map = new HashMap<String, Object>();
      List<InAStatisticalEntity> list = new ArrayList<InAStatisticalEntity>();

      if (sc != null) {
        if (sc.getStartTime() == null || "".equals(sc.getStartTime())) {
          map.put("starttime", "2017-01-01");
        } else {
          map.put("starttime", sc.getStartTime());
        }
        if (sc.getEndTime() == null || "".equals(sc.getEndTime())) {
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          map.put("endtime", sdf.format(new Date()));
        } else {
          map.put("endtime", sc.getEndTime()+" 23:59:59");
        }
        if ("-1".equals(sc.getLoanVoucher())) {
          map.put("lending_channel", null);
        } else {
          map.put("lending_channel", sc.getLoanVoucher());
        }
        if (sc.getaBaseName() == null || "".equals(sc.getaBaseName())) {
          map.put("city1", null);
        } else {
          map.put("city1", sc.getaBaseName());
        }
        System.out.println("`````````````````````````````" + map);
        if (sc.geteProduct() != null) {// 如果筛选贷款用途有输入值，查询的结果将只有一条
          map.put("loan_purpose1", sc.geteProduct());
          InAStatisticalEntity obj1 = sdao.searchInAStatistical(map);
          list.add(obj1);
        } else {// 如果筛选贷款用途没有有输入值，查询的结果将有3种情况
          map.put("loan_purpose1", "1");
          InAStatisticalEntity obj1 = sdao.searchInAStatistical(map);
          list.add(obj1);

          map.put("loan_purpose1", "2");
          InAStatisticalEntity obj2 = sdao.searchInAStatistical(map);
          list.add(obj2);

          map.put("loan_purpose1", "3");
          InAStatisticalEntity obj3 = sdao.searchInAStatistical(map);
          list.add(obj3);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~" + list);
        for (InAStatisticalEntity in : list) {
          if (sc.getaBaseName() == null || "".equals(sc.getaBaseName())) {
            in.setCity1("全国");
          }
          if ("1802".equals(in.getLendingChannel())) {
            in.setLendingChannel("外贸信托");
          } else if ("1804".equals(in.getLendingChannel())) {
            in.setLendingChannel("新网银行");
          } else {
            in.setLendingChannel("全部");
          }
          if ("1".equals(in.getLoanPurpose1())) {
            in.setLoanPurpose1("综合消费");
          } else if ("2".equals(in.getLoanPurpose1())) {
            in.setLoanPurpose1("生产经营");
          } else {
            in.setLoanPurpose1("全部");
          }
        }


        result_cache = list;


      }

      LOG.info("put cache with key:" + cache_key);
    } else {
      LOG.info("get cache with key:" + cache_key);
    }
    return result_cache;

  }

  /**
   * 准备写入excel的map (non-Javadoc)
   * 
   * @see com.ejie.nbrs.service.StatisticalFormService#mapFromDate(java.util.List,
   *      com.ejie.nbrs.dto.SearchCondition)
   */
  @Override
  public Map<String, Object> mapFromDate(List<InAStatisticalEntity> list, SearchCondition sc) {

    List<InAStatisticalExcelEntity> dataList = new ArrayList<InAStatisticalExcelEntity>();
    for (InAStatisticalEntity l : list) {
      InAStatisticalExcelEntity in = new InAStatisticalExcelEntity();
      in.setStarttime(l.getStarttime() == null ? "" : String.valueOf(l.getStarttime()));
      in.setEndtime(l.getEndtime() == null ? "" : String.valueOf(l.getEndtime()));
      System.out.println("````````````````" + in.getStarttime());
      System.out.println("````````````````" + in.getEndtime());
      if ("1082".equals(l.getLendingChannel())) {
        in.setLendingChannel("外贸信托");
      } else if ("1084".equals(l.getLendingChannel())) {
        in.setLendingChannel("新网银行");
      } else {
        in.setLendingChannel("");
      }
      in.setLendingChannel(l.getLendingChannel() == null ? "" : String.valueOf(l
          .getLendingChannel()));
      in.setCity1(l.getCity1() == null ? "" : String.valueOf(l.getCity1()));
      in.setLoanPurpose1(l.getLoanPurpose1() == null ? "" : String.valueOf(l.getLoanPurpose1()));

      in.setAdvancePiecePay(BigDecimalExUtils.formatBigDecimal(l.getAdvancePiecePay(), ""));
      in.setAdvancePieceCount(String.valueOf(l.getAdvancePieceCount()));
      in.setPassCreditPpay(BigDecimalExUtils.formatBigDecimal(l.getPassCreditPpay(), ""));
      in.setPassCreditCount(String.valueOf(l.getPassCreditCount()));
      in.setPassLoanPay(BigDecimalExUtils.formatBigDecimal(l.getPassLoanPay(), ""));
      in.setPassLoanCount(String.valueOf(l.getPassLoanCount()));
      in.setFinishLoanPay(BigDecimalExUtils.formatBigDecimal(l.getFinishLoanPay(), ""));
      in.setFinishLoanCount(String.valueOf(l.getFinishLoanCount()));

      dataList.add(in);
    }
    // 测试Excel文件生成
    Map<String, Object> data = new HashMap<String, Object>();
    data.put("list", dataList);

    System.out.println("Map<String,Object> data id:" + data);
    return data;

  }

  @Override
  public ZPageUtil<String> showLoanViewList(SearchCondition sc) {
    // return sdao.showLoanViewList(sc);
    String cache_key = RedisCache.CAHCENAME + "|showLoanViewList|" + sc;

    System.out.println("```````````````````````````````````" + cache_key);
    // 先去缓存中取
    @SuppressWarnings("unchecked")
    ZPageUtil<String> result_cache = cache.getCache(cache_key, ZPageUtil.class);

    if (result_cache == null) {
      // 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
      if (sc.getStartTime() == null || "".equals(sc.getStartTime())) {
        sc.setStartTime("2017-01-01");
      } else {
        sc.setStartTime(sc.getStartTime());
      }
      if (sc.getEndTime() == null || "".equals(sc.getEndTime())) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sc.setEndTime(sdf.format(new Date())+" 23:59:59");
      } else {
        sc.setEndTime(sc.getEndTime());
      }
      if ("-1".equals(sc.getLoanVoucher())) {
        sc.setLoanVoucher(null);
      } else {
        sc.setLoanVoucher(sc.getLoanVoucher());
      }
      // 是否设置每页显示条数
      if (sc.getPageSize() == 0) {
        sc.setPageSize(10);
      }

      int count = sdao.SearchCount(sc);// 得到总条数

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

      List<String> li = sdao.showLoanViewList(sc);// 得到查询结果集

      ZPageUtil<String> zp = new ZPageUtil<String>();// 初始分页对象
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

  @Override
  public Map<String, Object> mapFromDate1(ZPageUtil<String> zplist, SearchCondition sc) {

    List<HSDentity> dataList = new ArrayList<HSDentity>();
    List<String> list = zplist.getList();
    int i = 1;
    for (String str : list) {
      sc.setSerialNo(str);
      NewLoanView lv = loanInfoService.showLoanView(sc);

      HSDentity hsd = new HSDentity();
      hsd.setId(String.valueOf(i));
      hsd.setCity(lv.getCity() == null ? "" : lv.getCity());
      hsd.setName(lv.getName() == null ? "" : lv.getName());
      hsd.setIdNumber(lv.getIdNumber() == null ? "" : lv.getIdNumber());
      hsd.setAge(String.valueOf(lv.getAge()));
      hsd.setMaritalStatus(lv.getMaritalStatus() == null ? "" : lv.getMaritalStatus());
      hsd.setPhoneNumber(lv.getPhoneNumber() == null ? "" : lv.getPhoneNumber());
      hsd.setCompanyName(lv.getCompanyName() == null ? "" : lv.getCompanyName());
      if (lv.getMateInfo() != null) {
        hsd.setMateName(lv.getMateInfo().getMateName() == null ? "" : lv.getMateInfo()
            .getMateName());
        hsd.setMateIdNumber(lv.getMateInfo().getMateIdNumber() == null ? "" : lv.getMateInfo()
            .getMateIdNumber());
        hsd.setMatePhoneNumber(lv.getMateInfo().getMatePhoneNumber() == null ? "" : lv
            .getMateInfo().getMatePhoneNumber());
      } else {
        hsd.setMateName("");
        hsd.setMateIdNumber("");
        hsd.setMatePhoneNumber("");
      }
      List<MortgageHouse> list2 = lv.getMortgageHouse();
      String gAddress = "";
      String HouseArea = "";
      String WarrantId = "";
      String AndStatus = "";
      String Acreage = "";
      String WuhouseValue = "";
      String NbComfirmValue = "";
      for (MortgageHouse mh : list2) {
        gAddress += mh.getgAddress() == null ? "" : mh.getgAddress() + ";";
        HouseArea += mh.getHouseArea() == null ? "" : mh.getHouseArea() + ";";
        WarrantId += mh.getWarrantId() == null ? "" : mh.getWarrantId() + ";";
        AndStatus += mh.getAndStatus() == null ? "" : mh.getAndStatus() + ";";
        Acreage += mh.getAcreage() == null ? "" : mh.getAcreage() + ";";
        WuhouseValue += mh.getWuhouseValue() == null ? "" : mh.getWuhouseValue() + ";";
        NbComfirmValue += mh.getNbComfirmValue() == null ? "" : mh.getNbComfirmValue() + ";";
      }

      hsd.setgAddress(gAddress);
      hsd.setHouseArea(HouseArea);
      hsd.setWarrantId(WarrantId);
      hsd.setAndStatus(AndStatus);
      hsd.setAcreage(Acreage);
      hsd.setWuComfirmValue(WuhouseValue);
      hsd.setNbComfirmValue(NbComfirmValue);

      GuaranteeValue gua = lv.getGuaranteeValue();
      if (gua != null) {
        hsd.setNbCRate(String.valueOf(gua.getNbCRate()));
      } else {
        hsd.setNbCRate("");
      }

      hsd.setAppMoney(String.valueOf(lv.getAppMoney()));
      hsd.setPeriods(String.valueOf(lv.getPeriods()));
      hsd.setRepayWay(lv.getRepayWay() == null ? "" : lv.getRepayWay());

      List<LogView> list3 = lv.getLogViewList();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      if (list3 == null || list3.size() == 0) {
        hsd.setAuditingTime("");
      } else {
        List<Integer> strList = new ArrayList<Integer>();
        for (LogView logView : list3) {
          if (logView.getFlowNode() == 1002) {
            if ("1".equals(logView.getStatus())) {
              strList.add(1);
            } else if ("2".equals(logView.getStatus())) {
              strList.add(2);
            }
          } else if (logView.getFlowNode() == 1001) {
            if ("1".equals(logView.getStatus())) {
              strList.add(0);
            }
          }
        }
        if (strList.contains(1)) {
          for (LogView logView : list3) {
            if (logView.getFlowNode() == 1002 && "1".equals(logView.getStatus())) {
              hsd.setAuditingTime(logView.getAuditingTime() == null ? "" : sdf.format(logView
                  .getAuditingTime()));
            }
          }
        } else if (strList.contains(2)) {
          hsd.setAuditingTime("不通过");
        } else if (strList.contains(0)) {
          hsd.setAuditingTime("审核中");
        } else {
          hsd.setAuditingTime("");
        }
      }
      hsd.setArg1("");
      dataList.add(hsd);
      i++;
    }
    // //测试Excel文件生成
    Map<String, Object> data = new HashMap<String, Object>();
    data.put("dataList", dataList);
    // ZPageUtil<HSDentity> zp = new ZPageUtil<HSDentity>();// 初始分页对象
    // 得到当前页数
    // zp.setCurrentPage(sc.getCurrentPage());
    // zp.setCount(zplist.getCount());
    // zp.setPageSize(zplist.getPageSize());
    // zp.setTotalPage(zplist.getTotalPage());
    // zp.setList(dataList);
    return data;

  }


//  @Override
//  public ZPageUtil<HSD_TZentity> mapFromDate2(ZPageUtil<String> zplist, SearchCondition sc) {
//
//    List<HSD_TZentity> dataList = new ArrayList<HSD_TZentity>();
//    List<String> list = zplist.getList();
//    int i = 1;
//    for (String str : list) {
//      sc.setSerialNo(str);
//      NewLoanView lv = loanInfoService.showLoanView(sc);
//
//      HSD_TZentity hsd = new HSD_TZentity();
//      hsd.setId(String.valueOf(i));
//
//      hsd.setChannelCode(lv.getChannelCode() == null? 0 : lv.getChannelCode() );
//      hsd.setCity(lv.getCity() == null ? "" : lv.getCity());
//      hsd.setName(lv.getName() == null ? "" : lv.getName());
//      hsd.setIdNumber(lv.getIdNumber() == null ? "" : lv.getIdNumber());
//      hsd.setAppMoney(String.valueOf(lv.getAppMoney()));
//      hsd.setPeriods(String.valueOf(lv.getPeriods()));
//      hsd.setRepayWay(lv.getRepayWay() == null ? "" : lv.getRepayWay());
//      List<MortgageHouse> list2 = lv.getMortgageHouse();
//      String NbComfirmValue = "";
//      for (MortgageHouse mh : list2) {
//        NbComfirmValue += mh.getNbComfirmValue() == null ? "" : mh.getNbComfirmValue() + ";";
//      }
//      hsd.setNbComfirmValue(NbComfirmValue);
//      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//
//      hsd.setAppDate(lv.getAppDate() == null ? "" : sdf.format(lv.getAppDate()));
//      List<LogView> list3 = lv.getLogViewList();
//      if (list3 == null || list3.size() == 0) {
//        hsd.setAuditingTime("");
//      } else {
//        List<Integer> strList = new ArrayList<Integer>();
//        for (LogView logView : list3) {
//          if (logView.getFlowNode() == 1002) {
//            if ("1".equals(logView.getStatus())) {
//              strList.add(1);
//            } else if ("2".equals(logView.getStatus())) {
//              strList.add(2);
//            }
//          } else if (logView.getFlowNode() == 1001) {
//            if ("1".equals(logView.getStatus())) {
//              strList.add(0);
//            }
//          }
//        }
//        if (strList.contains(1)) {
//          for (LogView logView : list3) {
//            if (logView.getFlowNode() == 1002 && "1".equals(logView.getStatus())) {
//              hsd.setAuditingTime(logView.getAuditingTime() == null ? "" : sdf.format(logView
//                  .getAuditingTime()));
//            }
//          }
//        } else if (strList.contains(2)) {
//          hsd.setAuditingTime("不通过");
//        } else if (strList.contains(0)) {
//          hsd.setAuditingTime("审核中");
//        } else {
//          hsd.setAuditingTime("");
//        }
//      }
//      dataList.add(hsd);
//      i++;
//    }
//    // 测试Excel文件生成
//    // Map<String,Object> data = new HashMap<String, Object>();
//    // data.put("dataList", dataList);
//    ZPageUtil<HSD_TZentity> zp = new ZPageUtil<HSD_TZentity>();// 初始分页对象
//    // 得到当前页数
//    zp.setCurrentPage(sc.getCurrentPage());
//    zp.setCount(zplist.getCount());
//    zp.setPageSize(zplist.getPageSize());
//    zp.setTotalPage(zplist.getTotalPage());
//    zp.setList(dataList);
//    return zp;
//
//  }


@Override
public ZPageUtil<TzFormView> searchTzFormViewlist(SearchCondition sc) {
    String cache_key = RedisCache.CAHCENAME + "|searchTzFormViewlist|" + sc;

    System.out.println("```````````````````````````````````" + cache_key);
    // 先去缓存中取
    @SuppressWarnings("unchecked")
    ZPageUtil<TzFormView> result_cache = cache.getCache(cache_key, ZPageUtil.class);

    if (result_cache == null) {
      // 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
      if (sc.getStartTime() == null || "".equals(sc.getStartTime())) {
        sc.setStartTime("2017-01-01");
      } else {
        sc.setStartTime(sc.getStartTime());
      }
      if (sc.getEndTime() == null || "".equals(sc.getEndTime())) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sc.setEndTime(sdf.format(new Date())+" 23:59:59");
      } else {
        sc.setEndTime(sc.getEndTime()+" 23:59:59");
      }
      if ("-1".equals(sc.getLoanVoucher())) {
        sc.setLoanVoucher(null);
      } else {
        sc.setLoanVoucher(sc.getLoanVoucher());
      }
      // 是否设置每页显示条数
      if (sc.getPageSize() == 0) {
        sc.setPageSize(10);
      }

      int count = sdao.searchTzFormViewCount(sc);// 得到总条数

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

      List<TzFormView> li = sdao.searchTzFormViewlist(sc);// 得到查询结果集
      if (li == null) {
          return result_cache;
        } 
      for (TzFormView tz : li) {
//    	  if("1802".equals(tz.getChannelCode())){
//    		  tz.setChannelCode("外贸信托");
//    	  }else if("1804".equals(tz.getChannelCode())){
//    		  tz.setChannelCode("新网银行");
//    	  }
    	  //通过遍历的每个对象中取得抵押房总id去找到抵押房的集合
          List<MortgageHouse> list2 = loanInfoDao.selectMortgageHouseListByMhouseId(tz.getMhouseId());
          String NbComfirmValue = "";
          for (MortgageHouse mh : list2) {
            NbComfirmValue += mh.getNbComfirmValue() == null ? "" : mh.getNbComfirmValue();
          }
          tz.setNbComfirmValue(NbComfirmValue);
          
          List<LogView> logViewList = loanInfoDao.selectLogList(tz.getLoanId());// 得到操作日志信息
          SimpleDateFormat sd = new SimpleDateFormat("MM-dd HH:mm");
          if (logViewList == null || logViewList.size() == 0) {
        	  tz.setAuditingTime("");
            } else {
              List<Integer> strList = new ArrayList<Integer>();
              for (LogView logView : logViewList) {
                if (logView.getFlowNode() == 1002) {
                  if ("1".equals(logView.getStatus())) {
                    strList.add(1);
                  } else if ("2".equals(logView.getStatus())) {
                    strList.add(2);
                  }
                } else if (logView.getFlowNode() == 1001) {
                  if ("1".equals(logView.getStatus())) {
                    strList.add(0);
                  }
                }
              }
              if (strList.contains(1)) {
                for (LogView logView : logViewList) {
                  if (logView.getFlowNode() == 1002 && "1".equals(logView.getStatus())) {
//                	  tz.setAuditingTime(StringExUtil.StringPattern(tz.getAuditingTime(), "yyyy-MM-dd HH:mm:ss", "MM-dd HH:mm"));
                	  tz.setAuditingTime(logView.getAuditingTime() == null ? "" : sd.format(logView
                        .getAuditingTime()));
                  }
                }
              } else if (strList.contains(2)) {
            	  tz.setAuditingTime("不通过");
              } else if (strList.contains(0)) {
            	  tz.setAuditingTime("审核中");
              } else {
            	  tz.setAuditingTime("");
              }
            }
      }

      ZPageUtil<TzFormView> zp = new ZPageUtil<TzFormView>();// 初始分页对象
      // 得到当前页数
      zp.setCurrentPage(sc.getCurrentPage());
      zp.setCount(count);
      zp.setPageSize(pageSize);
      zp.setTotalPage(totalPage);
      zp.setList(li);
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


}
