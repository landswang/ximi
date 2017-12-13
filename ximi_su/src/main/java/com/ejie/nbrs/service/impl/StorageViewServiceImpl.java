package com.ejie.nbrs.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ejie.nbrs.cache.RedisCache;
import com.ejie.nbrs.dao.LoanInfoDao;
import com.ejie.nbrs.dao.StorageViewDao;
import com.ejie.nbrs.dto.Emessage;
import com.ejie.nbrs.dto.NewStorageView;
import com.ejie.nbrs.dto.ProducInformation;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.dto.productDetails;
import com.ejie.nbrs.ejieinterface.entity.RepaymentSchedule;
import com.ejie.nbrs.entity.FileRPath;
import com.ejie.nbrs.entity.GrantMoney;
import com.ejie.nbrs.entity.Guarantee;
import com.ejie.nbrs.entity.LogManagement;
import com.ejie.nbrs.entity.MortgageCar;
import com.ejie.nbrs.entity.MortgageHouse;
import com.ejie.nbrs.entity.ProductView;
import com.ejie.nbrs.entity.ScratchFile;
import com.ejie.nbrs.entity.Warrant;
import com.ejie.nbrs.service.ImagesService;
import com.ejie.nbrs.service.StorageViewService;
import com.ejie.nbrs.util.ConfigConst;
import com.ejie.nbrs.util.MessageUtil;
import com.ejie.nbrs.util.ZPageUtil;

/**
 * 
 * ClassName:StorageViewServiceImpl 出入库业务逻辑层
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年7月25日 下午5:40:09
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
@Service
public class StorageViewServiceImpl implements StorageViewService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RedisCache cache;
	
	@Autowired
	private StorageViewDao sv;
	
	  @Autowired
	  private LoanInfoDao loanInfoDao;

	  @Autowired
	  private ImagesService imagesService;
		/**
		 * searchProductView 查询出入库信息
		 * 
		 * @param sc
		 *            查询条件，通过输入loanId贷款编号查询
		 * @return
		 */
		@Override
		@Transactional(propagation=Propagation.REQUIRES_NEW)
		public ProductView searchProductView(SearchCondition sc) {

			String cache_key = RedisCache.CAHCENAME + "|searchProductView|" + sc;

			// 先去缓存中取
			ProductView result_cache = cache.getCache(cache_key, ProductView.class);

			if (result_cache == null) {
				// 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）

				result_cache = sv.searchProductView(sc);// 出入库申请基本信息

				if (result_cache == null) {
					return result_cache;
				}
				
				String mhouseId =result_cache.getMhouseId();// 抵押房总id

				List<MortgageHouse> mhList = new ArrayList<MortgageHouse>();// 抵押房集合
				mhList=sv.selectMortgageHouseListByGmAppId(mhouseId);
				for (MortgageHouse m : mhList) {
					m.setHouseArea(m.getHouseArea().replace("{", "").replace("}", "").replace("#", ""));
					Integer warrantId=m.getWarrantId();//权证信息id
					if(warrantId!=null&&warrantId!=0){
						Warrant warrant=sv.selectWarrantByWarrantId(warrantId.toString());
						m.setWarrant(warrant);
					}

				}
				result_cache.setMhList(mhList);//抵押房集合存进结果集
				//附件上传和资料补充地址
				try {
					ConfigConst.getConfigConst();
				} catch (Exception e) {
					e.printStackTrace();
				}
				String realPath2 =ConfigConst.fileRPath;
				
				String[] realPath=realPath2.split(",");
				
				FileRPath frp=new FileRPath();
				frp.setLoan(realPath[0]);
				frp.setXw(realPath[1]);
				frp.setStorage(realPath[2]);
//				System.out.println(frp);
				
				//设置 附件上传和资料补充地址
				result_cache.setFileRPath(frp);
				 SearchCondition sc2=new SearchCondition();
			      sc2.setSerialNo(sc.getSerialNo());
			      sc2.setLoanId(sc.getLoanId());
			      sc2.seteProduct("YPGL");
			      List<ScratchFile> scratchFileList = imagesService.selectScratchFile(sc2);// 关联临时文件集合

			      result_cache.setScratchFileList(scratchFileList);// 临时上传文件记录
				// cache.putCacheWithExpireTime(cache_key, result_cache,
				// RedisCache.CAHCETIME);
				LOG.info("put cache with key:" + cache_key);
			} else {
				LOG.info("get cache with key:" + cache_key);
			}
			return result_cache;
		}
		
	/**
	 * alterProductView 修改——提交出库审批资料
	 * 
	 * @param sc
	 *            loanId：要修改的贷款编号；
	 *             status:修改后的状态码；
	 *              outReason:出库原因；
	 *            startTime：入库时间；
	 *             endTime：出库时间； 
	 *             loanVoucher：附件图片信息；
	 *            inApplyTime：入库申请时间；
	 *             outApplyTime：出库申请时间；
	 *              outRemark：出库/入库说明.
	 * @return
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public boolean alterProductView(HttpSession session,SearchCondition sc) {
		String operateIp=String.valueOf(session.getAttribute("operateIp"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if (sc.getStatus() == 5) {// 出库审核通过的押品操作
			sc.setEndTime(sdf.format(new Date()));// 出库时间
		}else if(sc.getStatus() == 7){
			sc.setOutReason("强行出库");
		}else if(sc.getStatus() == 4){
			sc.setOutReason("申请出库");
			sc.setOutApplyTime(sdf.format(new Date()));//设置出库申请时间
		}else if(sc.getStatus() == 1){
			sc.setInApplyTime(sdf.format(new Date()));//设置入库申请时间
		}
		
		boolean flag= sv.alterProductView(sc);
		
		if(sc.getOutRemark()==null){
			sc.setOutRemark("没有具体说明。");
		}
		/* productView searchProductView(SearchCondition sc) */

		if (flag) {// 如果修改操作执行成功，需要清除之前的查询缓存，否则要等到缓存时间结束，页面查询数据才会更新
			// 这个地方用的模糊清除缓存，不需要完整的key，因为sc不好确定，所以key的命名很重要
			// cache.deleteCacheWithPattern(RedisCache.CAHCENAME +
			// "|pageStorageView|");

			StringBuffer content = new StringBuffer();

			content.append("贷款编号" + sc.getLoanId() + "，提交了押品出/入库申请审批资料");
			if (sc.getLoanVoucher() != null && !sc.getLoanVoucher().equals("")) {// 上传新的附件
				content.append("，上传了新的附件图片资料");
			}
			content.append("。");
			System.out.println("----------message is :" + content);

			Emessage emessage = null;

			if (sc.getStatus() == 1) {// 未入库申请————申请入库审核中，消息推送给入库审核人员

				String title = "您有新的入库申请需要进行验证提交，请尽快处理。";
				// 消息生成时间、消息类型、消息标题、内容、发送人、接收对象；
				emessage = new Emessage(new Date(), 1, title,
						content.toString(),
						sc.getcUserId(),
						1062);
				MessageUtil.sendToTargetRole(emessage, cache);// 推送消息给指定对象群
				
				LogManagement logManagement=new LogManagement(//声明一个日志系统管理记录
						sc.getLoanId(),"提交入库申请",sc.getcUserId().toString(),new Date(),"[提交抵押物入库申请]"+sc.getOutRemark(),"押品管理",operateIp);
				
				sv.insertLogManagement(logManagement);//添加日志信息
				
			} else if (sc.getStatus() == 4) {// 未出库申请————出库申请审核中，消息推送给出库审核人员

				String title = "您有新的入出库申请需要进行验证提交，请尽快处理。";
				// 消息生成时间、消息类型、消息标题、内容、发送人、接收对象；
				emessage = new Emessage(new Date(), 4, title,
						content.toString(), sc.getcUserId(), 1062);
				MessageUtil.sendToTargetRole(emessage, cache);// 推送消息给指定对象群
				
				LogManagement logManagement=new LogManagement(//声明一个日志系统管理记录
						sc.getLoanId(),"提交出库申请",sc.getcUserId().toString(),new Date(),"[提交抵押物出库申请]"+sc.getOutRemark(),"押品管理",operateIp);
				
				sv.insertLogManagement(logManagement);//添加日志信息
				
			} else if (sc.getStatus() == 2) {
				
				LogManagement logManagement=new LogManagement(//声明一个日志系统管理记录
						sc.getLoanId(),"入库申请通过",sc.getcUserId().toString(),new Date(),"[入库申请被通过]"+sc.getOutRemark(),"押品管理",operateIp);
				
				sv.insertLogManagement(logManagement);//添加日志信息
			} else if (sc.getStatus() == 3) {
				
				LogManagement logManagement=new LogManagement(//声明一个日志系统管理记录
						sc.getLoanId(),"入库申请拒绝",sc.getcUserId().toString(),new Date(),"[入库申请拒绝]"+sc.getOutRemark(),"押品管理",operateIp);
				
				sv.insertLogManagement(logManagement);//添加日志信息
			}else if (sc.getStatus() == 5) {
				
				LogManagement logManagement=new LogManagement(//声明一个日志系统管理记录
						sc.getLoanId(),"出库申请通过",sc.getcUserId().toString(),new Date(),"[出库申请通过]"+sc.getOutRemark(),"押品管理",operateIp);
				
				sv.insertLogManagement(logManagement);//添加日志信息
			}else if (sc.getStatus() == 6) {
				
				LogManagement logManagement=new LogManagement(//声明一个日志系统管理记录
						sc.getLoanId(),"出库申请拒绝",sc.getcUserId().toString(),new Date(),"[出库申请拒绝]"+sc.getOutRemark(),"押品管理",operateIp);
				
				sv.insertLogManagement(logManagement);//添加日志信息
			}else if (sc.getStatus() == 7) {
				
				LogManagement logManagement=new LogManagement(//声明一个日志系统管理记录
						sc.getLoanId(),"强行出库",sc.getcUserId().toString(),new Date(),"[强行出库]"+sc.getOutRemark(),"押品管理",operateIp);
				
				sv.insertLogManagement(logManagement);//添加日志信息
			}/*else if (sc.getStatus() == 0) {
				
				LogManagement logManagement=new LogManagement(//声明一个日志系统管理记录
						sc.getLoanId(),"入库（重新）申请",sc.getcUserId().toString(),new Date(),"[入库（重新）申请]"+sc.getOutRemark(),"押品管理");
				
				sv.insertLogManagement(logManagement);//添加日志信息
			}*/
			System.out.println("-----------emessage is:" + emessage);
		}
		 SearchCondition sc2 = new SearchCondition();
		    sc2.setLoanId(sc.getLoanId());
		    sc2.setSerialNo(sc.getSerialNo());
		    sc2.seteProduct("YPGL");
		    boolean bool = imagesService.deleteScratchFile(sc2);
		    System.out.println("是否已经删除临时表中的图片记录？————" + bool);
		return flag;
	}

	/**
	 * searchProducInformation 查看指定押品id的押品详细信息
	 * 
	 * @param sc
	 *            loanId:需要查看的押品id
	 * @return 押品详细信息ProducInformation
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public ProducInformation searchProducInformation(SearchCondition sc) {
		return sv.searchProducInformation(sc);
	}

	/**
	 * newProducInformation 查看指定押品id的押品详细信息____________最新！！
	 * 
	 * @param sc
	 *            loanId:需要查看的押品id
	 * @return 押品详细信息productDetails
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public productDetails newProducInformation(SearchCondition sc) {
		productDetails pd = sv.newProducInformation(sc);// 得到抵押物基本信息
		
		String serialNo=sc.getSerialNo();//流水号
		Integer loanId=sc.getLoanId();//贷款编号
		Guarantee guarantee=sv.selectGuarantee(serialNo);//通过贷款编号查询抵押物
		String mcarId=guarantee.getMcarId();//抵押车总id
		String mhouseId=guarantee.getMhouseId();//抵押房总id
	
			// 得到该总抵押物下抵押车的集合
			List<MortgageCar> mortgageCarList = sv.selectMortgageCarListByGmAppId(mcarId);

			for (MortgageCar mortgageCar : mortgageCarList) {
				if (mortgageCar.getWarrantId() != null) {// 车辆可能不存在权证信息

					String warrantId = mortgageCar.getWarrantId().toString();// 得到该抵押车权证id
					Warrant warrant = sv.selectWarrantByWarrantId(warrantId);

					mortgageCar.setWarrant(warrant);
				}

			}
			pd.setMortgageCarList(mortgageCarList);

			// 得到该总抵押物下抵押房的集合
			List<MortgageHouse> mortgageHouseList = sv
					.selectMortgageHouseListByGmAppId(mhouseId);

			for (MortgageHouse mortgageHouse : mortgageHouseList) {
				mortgageHouse.setHouseArea(mortgageHouse.getHouseArea().replace("{", "").replace("}", "").replace("#", ""));
				if (mortgageHouse.getWarrantId() != null) {
					String warrantId = mortgageHouse.getWarrantId().toString();// 得到该抵押房权证id
					Warrant warrant = sv.selectWarrantByWarrantId(warrantId);

					mortgageHouse.setWarrant(warrant);
				}

			}

			pd.setMortgageHouseList(mortgageHouseList);

		GrantMoney grantMoney=null;//放款信息
		if(loanId!=null){
			grantMoney=loanInfoDao.selectGrantMoneyByLoanId(loanId.toString());
		}
		pd.setGrantMoney(grantMoney);//存入放款信息
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("logModuleType","押品管理");
		map.put("loanId", String.valueOf(loanId));
		List<LogManagement> logManagementList=sv.selectLogManagementList(map);//操作日志记录信息
		pd.setLogManagementList(logManagementList);
				
		System.out.println("_________________________________" + pd);
		return pd;
	}

	// ___________________________________________________________________________________________________

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public int newSearchCountStorage(SearchCondition sc) {
		return sv.newSearchCountStorage(sc);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<NewStorageView> newStorageViewList(SearchCondition sc) {
		return sv.newStorageViewList(sc);
	}

	/**
	 * pageStorageView 查询分页 sc:查询条件 返回页面分页的结果集
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public ZPageUtil<NewStorageView> pageStorageView(SearchCondition sc) {

		String cache_key = RedisCache.CAHCENAME + "|pageStorageView|" + sc;

		// 先去缓存中取
		@SuppressWarnings("unchecked")
		ZPageUtil<NewStorageView> result_cache = cache.getCache(cache_key,
				ZPageUtil.class);

		if (result_cache == null) {
			// 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）

			if (sc.getPageSize() == 0) {// 初始化查询条数
				sc.setPageSize(10);
			}

			int count = newSearchCountStorage(sc);// 得到总条数

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

			System.out.println("_______________sc:___________________" + sc);

			List<NewStorageView> list = newStorageViewList(sc);// 得到结果集

			// 得到返回的分页对象
			result_cache = new ZPageUtil<NewStorageView>(); // 存入缓存

			// 设置分页对象的参数

			result_cache.setCount(count);
			result_cache.setCurrentPage(sc.getCurrentPage());
			result_cache.setPageSize(pageSize);
			result_cache.setTotalPage(totalPage);

			if (list.isEmpty()) {

				return result_cache;
			} else {

				RepaymentSchedule rs = null;// 还款计划表信息
				Integer loanId = null;// 贷款编号
				for (NewStorageView n : list) {
					loanId = n.getLoanId();// 得到贷款编号
					rs = sv.selectRepaymentScheduleByLoanId(loanId);// 得到还款计划表信息
					n.setRepaymentSchedule(rs);

				}
				result_cache.setList(list);
			}

			// cache.putCacheWithExpireTime(cache_key, result_cache,
			// RedisCache.CAHCETIME);
			LOG.info("put cache with key:" + cache_key);
		} else {
			LOG.info("get cache with key:" + cache_key);
		}
		return result_cache;

	}

}
