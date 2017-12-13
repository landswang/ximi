package com.ejie.nbrs.test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ejie.nbrs.dao.AccountDao;
import com.ejie.nbrs.dao.AfterLoanDao;
import com.ejie.nbrs.dao.GoodsDao;
import com.ejie.nbrs.dao.LoanInfoDao;
import com.ejie.nbrs.dao.RoleInfoDao;
import com.ejie.nbrs.dao.StatisticalFormDao;
import com.ejie.nbrs.dao.StorageViewDao;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.dto.StorageView;
import com.ejie.nbrs.entity.Account;
import com.ejie.nbrs.entity.Goods;
import com.ejie.nbrs.entity.LendingForm;
import com.ejie.nbrs.entity.RoleInfo;
import com.ejie.nbrs.entity.StatisticalForm;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class GoodsDaoTest{

	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private RoleInfoDao riDao;
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private LoanInfoDao loanInfoDao;
	@Autowired
	private StorageViewDao svDao;
	@Autowired
	private AfterLoanDao afterLoanDao;
	@Autowired
	private StatisticalFormDao sfdao;
	
	//@Test
	public void searchLendingForm(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<LendingForm> list= new ArrayList<LendingForm>();
		map.put("starttime", "2017-07-01");
		map.put("endtime", "2017-07-06");
		LendingForm l1=sfdao.searchLendingForm(map);
		list.add(l1);
		map.put("starttime", "2017-07-06");
		map.put("endtime", "2017-08-01");
		LendingForm l2=sfdao.searchLendingForm(map);
		list.add(l2);
		System.out.println("~~~~~~~~~~"+list);
		
	}
	
	//@Test
	public void searchStatisticalForm() throws ParseException{
		//"2017-07-01""2017-08-01"
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<StatisticalForm> list = new ArrayList<StatisticalForm>();
		map.put("type1", "1");
		
		map.put("starttime", "2017-07-01");
		map.put("endtime", "2017-07-07");
		StatisticalForm listYear=sfdao.searchStatisticalForm(map);
		list.add(listYear);
		map.put("starttime", "2017-07-07");
		map.put("endtime", "2017-08-01");
		StatisticalForm listMonth1=sfdao.searchStatisticalForm(map);
		list.add(listMonth1);
		
		System.out.println(list);
		
	}
	
	//@Test
	public void testAfterLoanDao(){
		SearchCondition sc=new SearchCondition();
		sc.setLoanId(7002000);//贷款编号
//		sc.setaBaseName("丑");//贷款客户
//		sc.setStartTime("2017-07-01");//查询起始放款日期
//		sc.setEndTime("2017-08-01");//查询起始结束日期
		
//		System.out.println("-----------------------总条数："+afterLoanDao.afterLoanViewCount(sc));//总条数
		System.out.println("-----------------------贷款详情："+afterLoanDao.afterLoanViewById(sc));//贷款详情
//		System.out.println("-----------------------结果集："+afterLoanDao.afterLoanViewList(sc));//结果集
	}
	
	
	
	
	//@Test
	public void testsearchProducInformation(){
		SearchCondition sc=new SearchCondition();
		sc.setLoanId(5320);//查看的押品id 对应字段是mhouse_id

		System.out.println("~~~~~~~~~~~~~~"+svDao.searchProducInformation(sc));
	}
	
	//@Test
	public void testalterProductView(){
		SearchCondition sc=new SearchCondition();
		sc.setLoanId(7000000);//设置需要修改的贷款标号
		sc.setOutRemark("快进快就不能");
		sc.setStatus(0);
		
//		sc.setStartTime("qqq");//介绍信
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~"+sc);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~"+svDao.alterProductView(sc));
	}
	
	@Test
	public void testalterLoanView(){
		SearchCondition sc=new SearchCondition();
		sc.setLoanId(7000000);//设置需要修改的id
		
		sc.setStatus(2);//修改后的状态码
		
		sc.setStartTime("2011-11-11");//设置放款日期
		sc.seteProduct("z111模式");//设置放款模式
		
		sc.setLoanVoucher("www.jpg,eee.png,rrr.gif");//设置放款凭证
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+loanInfoDao.alterLoanView(sc));
		
	}
	
	//@Test
	public void searchProductView(){
		SearchCondition sc=new SearchCondition();
		sc.setLoanId(7000001);
		
		System.out.println("___________________________________"+svDao.searchProductView(sc));
	}
	
	//@Test
	public void testalterInStorage(){
		
		SearchCondition sc=new SearchCondition();
		sc.setStatus(2);
		sc.setDataIndex(10005);//设置修改的id
		
		System.out.println("_____________________________________________"+svDao.alterInStorage(sc));
	}
	
	//@Test
	public void teststorageViewList(){
		SearchCondition sc=new SearchCondition();
		sc.setDataIndex(0);
		sc.setPageSize(10);
		sc.setStatus(0);//true
		
//		sc.setaBaseName("张");
//		sc.setLoanId(10);
//		sc.setStartTime("2017-06-10");
//		sc.setEndTime("2017-07-02");

		List<StorageView> list=svDao.storageViewList(sc);
		
		int count=svDao.searchCountStorage(sc);
		System.out.println(sc);
		System.out.println("~~~~~~~~~~~~~list:~~~~~~~~~~~~~~~~"+list);
		System.out.println("~~~~~~~~~~~~~count:~~~~~~~~~~~~~~~~"+count);
		
	}
	//@Test
//	public void testShowView(){
//		LoanView lv=loanInfoDao.showLoanView(8000035);
//		System.out.println("`````````````````````````lv:`````````````````````````"+lv);
//	}
	
	//@Test
//	public void testoutSearchAll(){
//		SearchCondition sc=new SearchCondition();
//		
//		sc.setCurrentPage(3);
//		sc.setPageSize(5);
//		List<LoanInfo> list=loanInfoDao.outSearchAll(sc);
//		
//		System.out.println(list);
//		
//	}
	
	//@Test
	public void testSearchAllProduct(){
		System.out.println("qqqqqqqqqqqqqqqqq"+loanInfoDao.searchAllProduct());
	}
	
	
	//@Test
	public void testSearchAll2() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		SearchCondition sc=new SearchCondition();
		sc.setStatus(2);

		
//		int count=loanInfoDao.outSearchCount(sc);
		
//		int count2=loanInfoDao.passSearchCount();
//		System.out.println("count"+count);
		
//		System.out.println("count2:"+count2);
		


//		sc.setPageSize(10);

//		List<LoanInfo> list=loanInfoDao.outSearchAll(sc);
		
//		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!++"
//				+ list);
		

		
	}

	// @Test
	public void testSelectByUId() {
		Integer useId = 1043;
		System.out.println("~~~~~~~~~~" + accountDao.selectByUId(useId));
	}

	// @Test
	public void testAccountDao() {
		Account account = new Account();
		account.setStatus("2");
		account.setStatusRemark("龙下次v");
		account.setUserId(1041);
		System.out.println(account);
		accountDao.modifyAccount(account);
	}

	// @Test
	public void testRIAll() {
		List<RoleInfo> list = riDao.selectAll();
		for (RoleInfo goods : list) {
			System.out.println(goods);
		}
		System.out.println("--------------------------");
	}

	// @Test
	public void testQueryAll() {
		List<Goods> list = goodsDao.queryAll(0, 100);
		for (Goods goods : list) {
			System.out.println(goods);
		}
		System.out.println("--------------------------");
	}

	// @Test
	public void testReduceNumber() {
		int result = goodsDao.reduceNumber(1000);
		System.out.println("testReduceNumber result:" + result);
		System.out.println("--------------------------");
	}

	// @Test
	public void testBugWithProcedure() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", 1000L);
		map.put("goodsId", 1000L);
		map.put("title", "抢购iPhone7");
		map.put("result", null);
		goodsDao.bugWithProcedure(map);
		// 获取result
		System.out.println("testBugWithProcedure result:" + map.get("result"));
	}

}
