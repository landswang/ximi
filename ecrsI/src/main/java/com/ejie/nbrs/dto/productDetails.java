package com.ejie.nbrs.dto;

import java.util.List;

import com.ejie.nbrs.entity.GrantMoney;
import com.ejie.nbrs.entity.LogManagement;
import com.ejie.nbrs.entity.MortgageCar;
import com.ejie.nbrs.entity.MortgageHouse;
/**
 * 
 * ClassName:productDetails 押品详细信息
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月16日 下午4:47:09
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public class productDetails {
	private Integer loanId;//贷款编号
	
	private Integer gmAppId;//抵押人id
	
	private String outRemark;//出库说明
	
	private String outReason;//出库原因
	
	private String introductceAccessory;//介绍信
	
	private String logoffAccessory;//注销登记申请书
	
	private String cleanAccessory;//结清证明
	
	private String otherAaccessory;//其他附件
	
	private String gId;//抵押物总id

	/**
	 * 放款信息
	 */
	private GrantMoney grantMoney;
	
//	private List<Mortgager> mortgagerList;//抵押人集合
	/**
	 * 抵押房集合
	 */
	private List<MortgageHouse> mortgageHouseList;
	/**
	 * 抵押车集合
	 */
	private List<MortgageCar> mortgageCarList;
	/**
	 * 操作日志信息
	 */
	private List<LogManagement> logManagementList;
	
	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public Integer getGmAppId() {
		return gmAppId;
	}

	public void setGmAppId(Integer gmAppId) {
		this.gmAppId = gmAppId;
	}

	public String getOutRemark() {
		return outRemark;
	}

	public void setOutRemark(String outRemark) {
		this.outRemark = outRemark;
	}

	public String getOutReason() {
		return outReason;
	}

	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}

	public String getIntroductceAccessory() {
		return introductceAccessory;
	}

	public void setIntroductceAccessory(String introductceAccessory) {
		this.introductceAccessory = introductceAccessory;
	}

	public String getLogoffAccessory() {
		return logoffAccessory;
	}

	public void setLogoffAccessory(String logoffAccessory) {
		this.logoffAccessory = logoffAccessory;
	}

	public String getCleanAccessory() {
		return cleanAccessory;
	}

	public void setCleanAccessory(String cleanAccessory) {
		this.cleanAccessory = cleanAccessory;
	}

	public String getOtherAaccessory() {
		return otherAaccessory;
	}

	public void setOtherAaccessory(String otherAaccessory) {
		this.otherAaccessory = otherAaccessory;
	}

	public GrantMoney getGrantMoney() {
		return grantMoney;
	}

	public void setGrantMoney(GrantMoney grantMoney) {
		this.grantMoney = grantMoney;
	}

	public String getgId() {
		return gId;
	}

	public void setgId(String gId) {
		this.gId = gId;
	}

	public List<MortgageHouse> getMortgageHouseList() {
		return mortgageHouseList;
	}

	public void setMortgageHouseList(List<MortgageHouse> mortgageHouseList) {
		this.mortgageHouseList = mortgageHouseList;
	}

	public List<MortgageCar> getMortgageCarList() {
		return mortgageCarList;
	}

	public void setMortgageCarList(List<MortgageCar> mortgageCarList) {
		this.mortgageCarList = mortgageCarList;
	}

	public List<LogManagement> getLogManagementList() {
		return logManagementList;
	}

	public void setLogManagementList(List<LogManagement> logManagementList) {
		this.logManagementList = logManagementList;
	}

	@Override
	public String toString() {
		return "productDetails [loanId=" + loanId + ", gmAppId=" + gmAppId
				+ ", outRemark=" + outRemark + ", outReason=" + outReason
				+ ", introductceAccessory=" + introductceAccessory
				+ ", logoffAccessory=" + logoffAccessory + ", cleanAccessory="
				+ cleanAccessory + ", otherAaccessory=" + otherAaccessory
				+ ", gId=" + gId + ", grantMoney=" + grantMoney
				+ ", mortgageHouseList=" + mortgageHouseList
				+ ", mortgageCarList=" + mortgageCarList
				+ ", logManagementList=" + logManagementList + "]";
	}

	
	
}
