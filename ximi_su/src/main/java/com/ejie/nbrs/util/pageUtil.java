package com.ejie.nbrs.util;

import java.util.List;

import com.ejie.nbrs.dto.SearchCondition;

/**
 * 分页工具类
 * 						使用步骤:1.先判断缓存中有无数据  2.查询总条数  3.调用getPageSearch方法封装查询对象  4.查询所需list  5.使用getPageResult()返回分页对象
 * @author 黄振威
 * 
 */
public class pageUtil {

	/**
	 * 
	 * @param sc
	 * @param count
	 *            数据库总满足条件的总条数
	 * @param cacheString
	 *            缓存名
	 * @return 查询条件
	 * @throws Exception
	 */
	public static SearchCondition getPageSearch(SearchCondition sc, int count,
			String cacheString) throws Exception {
		if (sc.getPageSize() == 0) {// 初始化查询条数
			sc.setPageSize(10);
		}
		int pageSize = sc.getPageSize();// 每页显示条数
		int totalPage = count % pageSize == 0 ? count / pageSize
				: (count / pageSize) + 1;// 得到总页数
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
		return sc;
	}
	
	public static ZPageUtil getPageResult(ZPageUtil zp,SearchCondition searchCondition,int count,List list) throws Exception {
		int totalPage = count % searchCondition.getPageSize() == 0 ? count / searchCondition.getPageSize() : (count / searchCondition.getPageSize()) + 1;
		zp.setCount(count);
		zp.setCurrentPage(searchCondition.getCurrentPage());
		zp.setPageSize(searchCondition.getPageSize());
		zp.setTotalPage(totalPage);
		zp.setList(list);
		return zp;
	}
}
