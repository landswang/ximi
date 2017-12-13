package com.ejie.nbrs.service;

import java.util.List;
import java.util.Map;

import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.entity.InAStatisticalEntity;
import com.ejie.nbrs.entity.LendingForm;
import com.ejie.nbrs.entity.StatisticalForm;
import com.ejie.nbrs.entity.TzFormView;
import com.ejie.nbrs.util.ZPageUtil;

public interface StatisticalFormService {

	/**
	 * 查询授信报表
	 * 
	 * @param sc
	 *            dataIndex：查看年份； eProduct：报表类型；
	 * @return
	 */
	List<StatisticalForm> searchStatisticalForm(SearchCondition sc);

	/**
	 * 查询授信报表
	 * 
	 * @param sc
	 *            dataIndex：查看年份；
	 * @return
	 */
	List<LendingForm> searchLendingForm(SearchCondition sc);

	/**
	 * searchInAStatistical: 进件统计查询
	 * 
	 * @param @param map
	 * @param @return 设定文件
	 * @return InAStatisticalEntity DOM对象
	 * @throws
	 * @since CodingExample　Ver 1.1
	 */
	List<InAStatisticalEntity> searchInAStatistical(SearchCondition sc);

	/**
	 * 
	 * mapFromDate: 写入excel的准备工作，把list转为map
	 * 
	 * @param @param list
	 * @param @param sc
	 * @param @return 设定文件
	 * @return Map<String,Object> DOM对象
	 * @throws
	 * @since CodingExample　Ver 1.1
	 */
	Map<String, Object> mapFromDate(List<InAStatisticalEntity> list,
			SearchCondition sc);

	/**
	 * 查询时间段内档案详情集合
	 * 
	 * @param 通过传入startTime
	 *            、endTime查询 ，
	 * @return 返回个人档案详情
	 */
	ZPageUtil<String> showLoanViewList(SearchCondition sc);
	/**
	 * 
	 * mapFromDate: 写入excel的准备工作，把list转为map
	 * @param  @param list
	 * @param  @param sc
	 * @param  @return    设定文件
	 * @return Map<String,Object>    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
	 Map<String,Object> mapFromDate1(ZPageUtil<String> list, SearchCondition sc);
	
//	ZPageUtil<HSD_TZentity> mapFromDate2(ZPageUtil<String> list,SearchCondition sc);
	
	  /**
	   * 
	   * searchTzFormViewlist: 查询台账表单数据
	   * @param  @param sc
	   * @param  @return    设定文件
	   * @return ZPageUtil<TzFormView>    DOM对象
	   * @throws 
	   * @since  CodingExample　Ver 1.1
	   */
	ZPageUtil<TzFormView> searchTzFormViewlist(SearchCondition sc);
}
