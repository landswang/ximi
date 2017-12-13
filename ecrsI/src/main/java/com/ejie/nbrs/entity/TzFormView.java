/**
 * TzFormView.java
 * com.ejie.nbrs.entity
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   ver1.1  2017年10月16日 		zlg
 *
 * Copyright (c) 2017, EJie All Rights Reserved.
*/

package com.ejie.nbrs.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * ClassName:TzFormView 台账报表表单视图实体
 * @author   zlg
 * @version  
 * @since    Ver 1.1
 * @Date	 2017年10月16日		下午7:40:31
 * @see 	 
 */
public class TzFormView {

	public TzFormView() {

		// TODO Auto-generated constructor stub

	}
	/**
	 * 进件渠道
	 */
	private Integer channelCode;
	/**
	 * 所属城市
	 */
	private String city;
	/**
	 * 贷款人姓名
	 */
	private String name;
	/**
	 * 身份证号
	 */
	private String idNumber;
	/**
	 * 申请金额
	 */
	private BigDecimal appMoney;
	/**
	 * 期数
	 */
	private Integer periods;
	/**
	 * 还款方式
	 */
	private String repayWay;
	/**
	 * 进件时间
	 */
	private Date appDate;
	/**
	 * 业务流水号
	 */
	private String serialNo;
	/**
	 * 我行评估总额
	 */
	private String nbComfirmValue;
	/**
	 * 授信时间
	 */
	private String auditingTime;
	/**
	 * 抵押房总id
	 */
	private String mhouseId;
	/**
	 * 贷款编号
	 */
	private Integer loanId;
	
	public Integer getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(Integer channelCode) {
		this.channelCode = channelCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public BigDecimal getAppMoney() {
		return appMoney;
	}
	public void setAppMoney(BigDecimal appMoney) {
		this.appMoney = appMoney;
	}
	public Integer getPeriods() {
		return periods;
	}
	public void setPeriods(Integer periods) {
		this.periods = periods;
	}
	public String getRepayWay() {
		return repayWay;
	}
	public void setRepayWay(String repayWay) {
		this.repayWay = repayWay;
	}
	public Date getAppDate() {
		return appDate;
	}
	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getNbComfirmValue() {
		return nbComfirmValue;
	}
	public void setNbComfirmValue(String nbComfirmValue) {
		this.nbComfirmValue = nbComfirmValue;
	}
	public String getAuditingTime() {
		return auditingTime;
	}
	public void setAuditingTime(String auditingTime) {
		this.auditingTime = auditingTime;
	}
	public String getMhouseId() {
		return mhouseId;
	}
	public void setMhouseId(String mhouseId) {
		this.mhouseId = mhouseId;
	}
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	@Override
	public String toString() {
		return "TzFormView [channelCode=" + channelCode + ", city=" + city
				+ ", name=" + name + ", idNumber=" + idNumber + ", appMoney="
				+ appMoney + ", periods=" + periods + ", repayWay=" + repayWay
				+ ", appDate=" + appDate + ", serialNo=" + serialNo
				+ ", nbComfirmValue=" + nbComfirmValue + ", auditingTime="
				+ auditingTime + ", mhouseId=" + mhouseId + ", loanId="
				+ loanId + "]";
	}

	
}

