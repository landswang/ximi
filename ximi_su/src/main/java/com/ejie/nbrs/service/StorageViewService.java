package com.ejie.nbrs.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ejie.nbrs.dto.NewStorageView;
import com.ejie.nbrs.dto.ProducInformation;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.dto.productDetails;
import com.ejie.nbrs.entity.ProductView;
import com.ejie.nbrs.util.ZPageUtil;

/**
 * 
 * ClassName:StorageViewService 出入库服务层
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年7月25日 下午5:38:19
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public interface StorageViewService {

//	/**
//	 * searchCountStorage 查询出入库条数
//	 * 
//	 * @param sc
//	 *            查询条件
//	 * @return 条数
//	 */
//	int searchCountStorage(SearchCondition sc);
//
//	/**
//	 * storageViewList 出入库结果集
//	 * 
//	 * @param sc
//	 *            查询条件
//	 * @return 记录结果集
//	 */
//	List<StorageView> storageViewList(SearchCondition sc);
//
//	/**
//	 * 分页-查询出入库信息
//	 * 
//	 * @param sc
//	 *            搜索条件封装类
//	 * @return
//	 */
//	ZPageUtil<StorageView> pageStorageView(SearchCondition sc);
//
//	/**
//	 * alterInStorage 修改押品状态
//	 * 
//	 * @param sc
//	 *            修改条件，传入修改后的状态：status和修改的id：dataIndex
//	 * @return 修改是否成功
//	 */
//	boolean alterInStorage(SearchCondition sc);

	/**
	 * searchProductView 查询出入库信息
	 * 
	 * @param sc
	 *            查询条件，通过输入loanId贷款编号查询
	 * @return
	 */
	ProductView searchProductView(SearchCondition sc);

	/**
	 * alterProductView 修改——提交出库审批资料
	 * 
	 * @param sc
	 *            loanId：要修改的贷款编号；
	 *             修改后的状态码：status ;
	 *             修改后的出入库说明：outRemark ;
	 *             介绍信：introductce_accessory：startTime;
	 *              注销登记申请书：logoff_accessory：endTime ;
	 *              结清证明： clean_accessory：eProduct ;
	 *              其他：other_accessory：aBaseName
	 * @return
	 */
	boolean alterProductView(HttpSession session,SearchCondition sc);
	
	/**
	 * searchProducInformation 查看指定押品id的押品详细信息
	 * @param sc loanId:需要查看的押品id
	 * @return	押品详细信息ProducInformation
	 */
	ProducInformation searchProducInformation(SearchCondition sc);
	
	/**
	 * newProducInformation 查看指定押品id的押品详细信息____________最新！！
	 * @param sc loanId:需要查看的押品id
	 * @return	押品详细信息productDetails
	 */
	productDetails newProducInformation(SearchCondition sc);
//_________________________________________________________________________________________________

	/**
	 * searchCountStorage 查询出入库条数
	 * 
	 * @param sc
	 *            查询条件
	 * @return 条数
	 */
	int newSearchCountStorage(SearchCondition sc);

	/**
	 * storageViewList 出入库结果集
	 * 
	 * @param sc
	 *            查询条件
	 * @return 记录结果集
	 */
	List<NewStorageView> newStorageViewList(SearchCondition sc);

	/**
	 * 分页-查询出入库信息
	 * 
	 * @param sc
	 *            搜索条件封装类
	 * @return
	 */
	ZPageUtil<NewStorageView> pageStorageView(SearchCondition sc);
}
