package com.ejie.nbrs.dao;


import java.util.List;
import java.util.Map;

import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.entity.InAStatisticalEntity;
import com.ejie.nbrs.entity.LendingForm;
import com.ejie.nbrs.entity.StatisticalForm;
import com.ejie.nbrs.entity.TzFormView;



/**
 * 
 * ClassName:StatisticalFormDao
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月10日 下午4:32:27
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public interface StatisticalFormDao {

	/**
	 * 统计报表——进件统计
	 * @param map
	 * @return 授信、放款报表信息
	 */
	StatisticalForm searchStatisticalForm(Map<String, Object> map);
	
	/**
	 * 统计报表——放款统计
	 * @param map
	 * @return 放款统计信息
	 */
	LendingForm searchLendingForm(Map<String, Object> map);
	
	/**
	 * searchInAStatistical: 进件统计查询
	 * @param  @param map
	 * @param  @return    设定文件
	 * @return InAStatisticalEntity    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
	InAStatisticalEntity searchInAStatistical(Map<String, Object> map);
	  
	  /**
	   * 查询时间段内档案详情集合
	   * 
	   * @param 通过传入startTime、endTime查询 ，
	   * @return 返回个人档案详情
	   */
	  List<String> showLoanViewList(SearchCondition sc);
	  /**
	   * 
	   * SearchCount: 查询满足条件条数
	   * @param  @param sc
	   * @param  @return    设定文件
	   * @return int    DOM对象
	   * @throws 
	   * @since  CodingExample　Ver 1.1
	   */
	  int SearchCount(SearchCondition sc);
	  
	  /**
	   * 
	   * searchTzFormViewlist: 查询台账表单数据
	   * @param  @param sc
	   * @param  @return    设定文件
	   * @return List<TzFormView>    DOM对象
	   * @throws 
	   * @since  CodingExample　Ver 1.1
	   */
	  List<TzFormView> searchTzFormViewlist(SearchCondition sc);
	  
	  /**
	   * 
	   * searchTzFormViewCount: 查询满足条件台账报表条数
	   * @param  @param sc
	   * @param  @return    设定文件
	   * @return int    DOM对象
	   * @throws 
	   * @since  CodingExample　Ver 1.1
	   */
	  int searchTzFormViewCount(SearchCondition sc);
	  
	  
}
