package com.ejie.nbrs.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejie.nbrs.cache.RedisCache;
import com.ejie.nbrs.dao.AfterLoanDao;
import com.ejie.nbrs.dto.AfterLoanView;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.ejieinterface.entity.RepayPlan;
import com.ejie.nbrs.ejieinterface.entity.RepaymentSchedule;
import com.ejie.nbrs.ejieinterface.service.EjieDataService;
import com.ejie.nbrs.service.AfterLoanService;
import com.ejie.nbrs.util.ZPageUtil;

/**
 * 
 * ClassName:AfterLoanServiceImpl 贷后管理业务逻辑层
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月8日 下午2:07:18
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
@Service
public class AfterLoanServiceImpl implements AfterLoanService {

  private final Logger LOG = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private RedisCache cache;
  @Autowired
  private AfterLoanDao afterLoanDao;
  @Autowired
  private EjieDataService ejieDataService;

  /**
   * AfterLoanViewList 通过条件查询贷后管理的结果集
   * 
   * @param sc 条件包括： 1.贷款编号loanId；2.客户姓名name；3.查看放款起始日期startTime-查看放款结束日期endTime
   * @return 贷后管理的结果集
   */
  @Override
  public List<AfterLoanView> afterLoanViewList(SearchCondition sc) {
    return afterLoanDao.afterLoanViewList(sc);
  }

  /**
   * AfterLoanViewCount 查询贷后管理满足查询条件的总条数
   * 
   * @param sc 条件包括： 1.贷款编号loanId；2.客户姓名name；3.查看放款起始日期startTime-查看放款结束日期endTime
   * @return 满足条件的总条数
   */
  @Override
  public int afterLoanViewCount(SearchCondition sc) {
    return afterLoanDao.afterLoanViewCount(sc);
  }

  /**
   * AfterLoanViewById 通过贷款编号查看贷款详细信息
   * 
   * @param sc loanId贷款编号
   * @return 贷款详细信息
   */
  @Override
  public AfterLoanView afterLoanViewById(SearchCondition sc) {
    AfterLoanView afterLoanView = afterLoanDao.afterLoanViewById(sc);// 贷款信息

    Integer loanId = sc.getLoanId();// 贷款编号
    // 还款基本信息
    RepaymentSchedule repaymentSchedule = afterLoanDao.selectRSchedule(loanId);

    if (repaymentSchedule == null) {
      return afterLoanView;
    }

    afterLoanView.setRepaymentSchedule(repaymentSchedule);// 存入贷款基本信息

    // 还款详细信息
    List<RepayPlan> plants = afterLoanDao.selectRepayPlan(loanId);
    for (RepayPlan repayPlan : plants) {
      repayPlan.setIndex(repayPlan.getpIndex());
    }

    repaymentSchedule.setPlants(plants);// 存入详细信息
    return afterLoanView;
  }

  /**
   * AfterLoanViewPage 查询分页的贷后管理结果集
   * 
   * @param sc 搜索条件封装类
   * @return
   */
  @Override
  public ZPageUtil<AfterLoanView> afterLoanViewPage(SearchCondition sc) {
    // 创建一个独有的缓存key
    String cache_key = RedisCache.CAHCENAME + "|AfterLoanViewPage|" + sc;

    // 先去缓存中取
    @SuppressWarnings("unchecked")
    ZPageUtil<AfterLoanView> result_cache = cache.getCache(cache_key, ZPageUtil.class);

    if (result_cache == null) {
      // 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）

      if (sc == null || sc.getPageSize() == 0) {// 初始化查询条数
        sc.setPageSize(10);
      }

      int count = afterLoanViewCount(sc);// 得到总条数

      int pageSize = sc.getPageSize();// 得到每页显示条数

      int totalPage = count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1;// 得到总页数

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

      List<AfterLoanView> list = afterLoanViewList(sc);// 得到结果集

      // 得到返回的分页对象
      result_cache = new ZPageUtil<AfterLoanView>(); // 存入缓存
      // 设置分页对象的参数
      result_cache.setCount(count);
      result_cache.setCurrentPage(sc.getCurrentPage());
      result_cache.setPageSize(pageSize);
      result_cache.setTotalPage(totalPage);

      Integer loanId = null;
      for (AfterLoanView alv : list) {
        loanId = alv.getLoanId();// 每个贷款编号
        // 还款基本信息
        RepaymentSchedule repaymentSchedule = afterLoanDao.selectRSchedule(loanId);
        alv.setRepaymentSchedule(repaymentSchedule);// 存入贷款基本信息
      }
      result_cache.setList(list);

      System.out.println("________________result_cache:___________________" + result_cache);
      // cache.putCacheWithExpireTime(cache_key, result_cache,RedisCache.CAHCETIME);
      LOG.info("put cache with key:" + cache_key);
    } else {
      LOG.info("get cache with key:" + cache_key);
    }
    return result_cache;
  }

}
