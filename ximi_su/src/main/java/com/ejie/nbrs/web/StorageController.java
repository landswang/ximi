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

import com.ejie.nbrs.cache.RedisCache;
import com.ejie.nbrs.dao.StorageViewDao;
import com.ejie.nbrs.dto.BaseResult;
import com.ejie.nbrs.dto.NewStorageView;
import com.ejie.nbrs.dto.ProducInformation;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.dto.productDetails;
import com.ejie.nbrs.ejieinterface.entity.RepaymentSchedule;
import com.ejie.nbrs.entity.ProductView;
import com.ejie.nbrs.service.StorageViewService;
import com.ejie.nbrs.util.StringExUtil;
import com.ejie.nbrs.util.ValidateUtil;
import com.ejie.nbrs.util.ZPageUtil;
import com.ejie.nbrs.util.pageUtil;

/**
 * 
 * ClassName:InStorageController 入库管理
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年7月25日 下午4:55:19
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
@Controller
@RequestMapping("/Storage")
public class StorageController {

	@Autowired
	private StorageViewService svs;
	@Autowired
	private RedisCache cache;
	@Autowired
	private StorageViewDao sv;
	/**
	 * @@@@@@@@@@最新 newProducInformationByLoanId 查看指定押品id的押品详细信息________新的！！
	 * 
	 * @param sc
	 *            loanId:需要查看的押品id
	 * @return 押品详细信息productDetails
	 */
	@RequestMapping(value = "/newProducInformationByLoanId", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public BaseResult<productDetails> newProducInformationByLoanId(
			@RequestBody SearchCondition sc) {

		int code = 0;
		String msg = "";
		productDetails zp = null;
		try {
			zp = svs.newProducInformation(sc);
			code = 1;
			msg = "执行成功";
		} catch (Exception e) {
			code = 0;
			msg = "执行失败";
			e.printStackTrace();
		}

		return new BaseResult<productDetails>(code, msg, zp);
	}

	/**
	 * searchProducInformation 查看指定押品id的押品详细信息
	 * 
	 * @param sc
	 *            loanId:需要查看的押品id
	 * @return 押品详细信息ProducInformation
	 */
	@RequestMapping(value = "/searchProducInformationById", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public BaseResult<ProducInformation> searchProducInformationById(
			@RequestBody SearchCondition sc) {

		int code = 0;
		String msg = "";
		ProducInformation zp = null;
		try {
			zp = svs.searchProducInformation(sc);
			code = 1;
			msg = "执行成功";
		} catch (Exception e) {
			code = 0;
			msg = "执行失败";
			e.printStackTrace();
		}

		return new BaseResult<ProducInformation>(code, msg, zp);
	}

	/**
	 * inStorage 押品管理-出/入库 改变押品状态接口
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
	 * @return 封装json参数
	 */
	@RequestMapping(value = "/alterStorage", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public BaseResult<Boolean> alterStorage(HttpSession session,@RequestBody SearchCondition sc) {
		System.out
				.println("---------------------执行修改条件:--------------------------"
						+ sc);
		Boolean bool = false;
		int code = 0;
		String msg = "";
		if (sc == null) {
			bool = false;
		} else {
			try {
				bool = svs.alterProductView(session,sc);
				code = 1;
				msg = "执行成功";
			} catch (Exception e) {
				code = 0;
				msg = "执行失败";
				e.printStackTrace();
			}
		}
		return new BaseResult<Boolean>(code, msg, bool);
	}

	/**
	 * alterProductView 修改附件信息——提交出库审批资料,强行出库需要提交附件信息
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
	@RequestMapping(value = "/alterProductAccessory", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public BaseResult<Boolean> alterProductAccessory(HttpSession session,
			@RequestBody SearchCondition sc) {
		System.out
				.println("---------------------执行修改条件:--------------------------"
						+ sc);
		Boolean bool = false;
		int code = 0;
		String msg = "";

		try {
			bool = svs.alterProductView(session,sc);
			code = 1;
			msg = "执行成功";
		} catch (Exception e) {
			code = 0;
			msg = "执行失败";
			e.printStackTrace();
		}

		return new BaseResult<Boolean>(code, msg, bool);

	}

	/**
	 * inStorage 押品管理-出入库——录入信息 查询对应loanId的信息
	 * 
	 * @param sc
	 *            传入loanId
	 * @return 封装json参数
	 */
	@RequestMapping(value = "/searchInOutProduct", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public BaseResult<ProductView> searchInOutProduct(
			@RequestBody SearchCondition sc) {
		System.out
				.println("---------------------执行查询条件:--------------------------"
						+ sc);

		ProductView pv = null;
		int code = 0;
		String msg = "";
		if (sc == null) {
			pv = null;
		} else {
			try {
				pv = svs.searchProductView(sc);
				code = 1;
				msg = "执行成功";
			} catch (Exception e) {
				code = 0;
				msg = "执行失败";
				e.printStackTrace();
			}
		}
		return new BaseResult<ProductView>(code, msg, pv);
	}

	/**
	 * passEnterStorage 押品管理-入库——入库申请
	 * 默认值：status=-5;显示status=0（未入库申请）、3（审核不通过）两种状态 loanId ，贷款编号 ；aBaseName
	 * ，抵押人姓名； startTime ，起始时间 ；endTime， 结束时间 ；status， 状态码； currentPage， 当前页
	 * ；pageSize， 每页显示条数；
	 * 
	 * @param sc
	 *            搜索条件
	 * @return 封装json参数
	 */
	@RequestMapping(value = "/passEnterStorage", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public BaseResult<ZPageUtil<NewStorageView>> passEnterStorage(
			@RequestBody SearchCondition sc) {

		if (sc == null) {
			sc = new SearchCondition();
			sc.setStatus(-5);// 默认值
		} else {
			sc.setStatus(-5);// 默认值
		}

		int code = 0;
		String msg = "";
		ZPageUtil<NewStorageView> zp = null;
		try {
			//zp = svs.pageStorageView(sc);//老方式
			//新方式
			zp=cache.getCache(RedisCache.CAHCENAME + "|pageStorageView|" + sc,ZPageUtil.class);
			if(zp==null){
				zp=new ZPageUtil<NewStorageView>();
				int count=svs.newSearchCountStorage(sc);
				SearchCondition searchCondition = pageUtil.getPageSearch(sc, count , "pageStorageView");
				List<NewStorageView> list = svs.newStorageViewList(searchCondition);
				if (!list.isEmpty()) {
					RepaymentSchedule rs = null;// 还款计划表信息
					Integer loanId = null;// 贷款编号
					for (NewStorageView n : list) {
						loanId = n.getLoanId();// 得到贷款编号
						rs = sv.selectRepaymentScheduleByLoanId(loanId);// 得到还款计划表信息
						n.setRepaymentSchedule(rs);
					}
				}
				zp=pageUtil.getPageResult(zp, searchCondition, count, list);
			}
			
			if (zp == null) {
				code = 0;
				msg = "没有找到符合条件对象。";
			} else {
				code = 1;
				msg = "执行成功";
			}

		} catch (Exception e) {
			code = 0;
			msg = "执行失败";
			e.printStackTrace();
		}

		return new BaseResult<ZPageUtil<NewStorageView>>(code, msg, zp);

	}

	/**
	 * outEnterStorage 押品管理-入库——历史记录； 押品管理-出库——库存中 默认值：status=-1;显示status>0所有状态
	 * 
	 * @param sc
	 *            搜索条件
	 * @return 封装json参数
	 */
	@RequestMapping(value = "/outEnterStorage", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public BaseResult<ZPageUtil<NewStorageView>> outEnterStorage(
			@RequestBody SearchCondition sc) {

		if (sc == null) {
			sc = new SearchCondition();
			sc.setStatus(-1);// 默认值
		} else {
			sc.setStatus(-1);// 默认值
		}

		int code = 0;
		String msg = "";
		ZPageUtil<NewStorageView> zp = null;
		try {
			zp = svs.pageStorageView(sc);
			code = 1;
			msg = "执行成功";
		} catch (Exception e) {
			code = 0;
			msg = "执行失败";
			e.printStackTrace();
		}

		return new BaseResult<ZPageUtil<NewStorageView>>(code, msg, zp);

	}

	/**
	 * inStorage 押品管理-出库——库存中 默认值：status=2;显示库存中并且没有申请出库的
	 * 
	 * @param sc
	 *            搜索条件
	 * @return 封装json参数
	 */
	@RequestMapping(value = "/inStorage", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public BaseResult<ZPageUtil<NewStorageView>> inStorage(
			@RequestBody SearchCondition sc) {

		if (sc == null) {
			sc = new SearchCondition();
			sc.setStatus(2);// 默认值
		} else {
			sc.setStatus(2);// 默认值
		}

		int code = 0;
		String msg = "";
		ZPageUtil<NewStorageView> zp = null;
		try {
			zp = svs.pageStorageView(sc);
			code = 1;
			msg = "执行成功";
		} catch (Exception e) {
			code = 0;
			msg = "执行失败";
			e.printStackTrace();
		}

		return new BaseResult<ZPageUtil<NewStorageView>>(code, msg, zp);

	}

	/**
	 * passComeStorage 押品管理-出库——出库申请
	 * 默认值：status=-6;显示status=7（未出库申请）、6（审核不通过）两种状态
	 * 
	 * @param sc
	 *            搜索条件
	 * @return 封装json参数
	 */
	@RequestMapping(value = "/passComeStorage", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public BaseResult<ZPageUtil<NewStorageView>> passComeStorage(
			@RequestBody SearchCondition sc) {

		if (sc == null) {
			sc = new SearchCondition();
			sc.setStatus(-6);// 默认值
		} else {
			sc.setStatus(-6);// 默认值
		}

		int code = 0;
		String msg = "";
		ZPageUtil<NewStorageView> zp = null;
		try {
			zp = svs.pageStorageView(sc);
			code = 1;
			msg = "执行成功";
		} catch (Exception e) {
			code = 0;
			msg = "执行失败";
			e.printStackTrace();
		}

		return new BaseResult<ZPageUtil<NewStorageView>>(code, msg, zp);

	}

	/**
	 * outComeStorage 押品管理-出库——历史记录
	 * 默认值：status=-2;显示status=4（审核中）、5（审核通过、已入库）、6（审核拒绝）三种状态
	 * 
	 * @param sc
	 *            搜索条件
	 * @return 封装json参数
	 */
	@RequestMapping(value = "/outComeStorage", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public BaseResult<ZPageUtil<NewStorageView>> outComeStorage(
			@RequestBody SearchCondition sc) {

		if (sc == null) {
			sc = new SearchCondition();
			sc.setStatus(-2);// 默认值
		} else {
			sc.setStatus(-2);// 默认值
		}

		int code = 0;
		String msg = "";
		ZPageUtil<NewStorageView> zp = null;
		try {
			zp = svs.pageStorageView(sc);
			code = 1;
			msg = "执行成功";
		} catch (Exception e) {
			code = 0;
			msg = "执行失败";
			e.printStackTrace();
		}

		return new BaseResult<ZPageUtil<NewStorageView>>(code, msg, zp);

	}

	/**
	 * enterStorage 押品管理-出入审批——入库审批 默认值：status=1;
	 * 
	 * @param sc
	 *            搜索条件
	 * @return 封装json参数
	 */
	@RequestMapping(value = "/enterStorage", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public BaseResult<ZPageUtil<NewStorageView>> enterStorage(
			@RequestBody SearchCondition sc) {

		if (sc == null) {
			sc = new SearchCondition();
			sc.setStatus(1);// 默认值
		} else {
			sc.setStatus(1);// 默认值
		}

		int code = 0;
		String msg = "";
		ZPageUtil<NewStorageView> zp = null;
		try {
			zp = svs.pageStorageView(sc);
			code = 1;
			msg = "执行成功";
		} catch (Exception e) {
			code = 0;
			msg = "执行失败";
			e.printStackTrace();
		}

		return new BaseResult<ZPageUtil<NewStorageView>>(code, msg, zp);

	}

	/**
	 * comeStorage 押品管理-出入审批——出库审批 默认值：status=4;
	 * 
	 * @param sc
	 *            搜索条件
	 * @return 封装json参数
	 */
	@RequestMapping(value = "/comeStorage", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public BaseResult<ZPageUtil<NewStorageView>> comeStorage(
			@RequestBody SearchCondition sc) {

		if (sc == null) {
			sc = new SearchCondition();
			sc.setStatus(4);// 默认值
		} else {
			sc.setStatus(4);// 默认值
		}

		int code = 0;
		String msg = "";
		ZPageUtil<NewStorageView> zp = null;
		try {
			zp = svs.pageStorageView(sc);
			code = 1;
			msg = "执行成功";
		} catch (Exception e) {
			code = 0;
			msg = "执行失败";
			e.printStackTrace();
		}

		return new BaseResult<ZPageUtil<NewStorageView>>(code, msg, zp);

	}

	/**
	 * outStorage 押品管理-出入审批——审批记录 默认值：status=-3;
	 * 显示status=2（入库审核通过）、3（入库审核不通过）、5（出库审核通过）、6（出库审核不通过） 4种状态
	 * 
	 * @param sc
	 *            搜索条件
	 * @return 封装json参数
	 */
	@RequestMapping(value = "/outStorage", method = RequestMethod.POST)
	@CrossOrigin
	@ResponseBody
	public BaseResult<ZPageUtil<NewStorageView>> outStorage(
			@RequestBody SearchCondition sc) {

		if (sc == null) {
			sc = new SearchCondition();
			sc.setStatus(-3);// 默认值
		} else {
			sc.setStatus(-3);// 默认值
			// sc.setStatus(0);
		}

		int code = 0;
		String msg = "";
		ZPageUtil<NewStorageView> zp = null;
		try {
			zp = svs.pageStorageView(sc);
			code = 1;
			msg = "执行成功";
		} catch (Exception e) {
			code = 0;
			msg = "执行失败";
			e.printStackTrace();
		}

		return new BaseResult<ZPageUtil<NewStorageView>>(code, msg, zp);

	}

	/**
	 * 测试区号
	 * @param sc
	 * @param req
	 * @return
	 */
	 @RequestMapping(value = "/testAreaCode", method = RequestMethod.POST)
	  @CrossOrigin
	  @ResponseBody
	  public BaseResult<Boolean> testAreaCode(HttpServletRequest req) {
	    Boolean bool = true;
	    int code = 0;
	    String msg = "";
	    try {
			String areaCode=StringExUtil.getAreaCode("房", "{北京市}{东城区}{##}", req);
		} catch (Exception e) {
			System.out.println(e);
		}
	    
	    return new BaseResult<Boolean>(code, msg, bool);

	  }
}
