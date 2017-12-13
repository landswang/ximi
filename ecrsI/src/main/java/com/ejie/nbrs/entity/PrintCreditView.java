package com.ejie.nbrs.entity;

import java.util.List;

/**
 * 
 * ClassName:PrintCreditView 打印授信
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月30日 下午5:50:05
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public class PrintCreditView {
	/**
	 * 贷款编号
	 */
	private Integer loanId;
	/**
	 * 业务流水号
	 */
	private String serialNo;
	/**
	 * 主借人姓名
	 */
	private String name;
	/**
	 * 身份证号码
	 */
	private String idNumber;
	/**
	 * 主借人年龄
	 */
	private Integer age;
	/**
	 * 公司名
	 */
	private String companyName;
	/**
	 * 电话号码
	 */
	private String phoneNumber;
	/**
	 * 期限
	 */
	private Integer periods;
	/**
	 * 还款方式
	 */
	private String repayWay;
	/**
	 * 利率
	 */
	private String rate;
	/**
	 * 资金用途
	 */
	private String loanPurpose;
	/**
	 * 操作人/审查人
	 */
	private String uName;
	/**
	 * 审查时间
	 */
	private String lTime;
	
	/**
	 * 共借人集合
	 */
	private List<CommonApplicant> commonApplicant;
	/**
	 * 抵押房集合
	 */
	private List<MortgageHouse> mortgageHouse;
	
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getLoanPurpose() {
		return loanPurpose;
	}
	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}

	public List<CommonApplicant> getCommonApplicant() {
		return commonApplicant;
	}
	public void setCommonApplicant(List<CommonApplicant> commonApplicant) {
		this.commonApplicant = commonApplicant;
	}
	public List<MortgageHouse> getMortgageHouse() {
		return mortgageHouse;
	}
	public void setMortgageHouse(List<MortgageHouse> mortgageHouse) {
		this.mortgageHouse = mortgageHouse;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getlTime() {
		return lTime;
	}
	public void setlTime(String lTime) {
		this.lTime = lTime;
	}
	@Override
	public String toString() {
		return "PrintCreditView [loanId=" + loanId + ", serialNo=" + serialNo
				+ ", name=" + name + ", idNumber=" + idNumber + ", age=" + age
				+ ", companyName=" + companyName + ", phoneNumber="
				+ phoneNumber + ", periods=" + periods + ", repayWay="
				+ repayWay + ", rate=" + rate + ", loanPurpose=" + loanPurpose
				+ ", uName=" + uName + ", lTime=" + lTime
				+ ", commonApplicant=" + commonApplicant + ", mortgageHouse="
				+ mortgageHouse + "]";
	}


	
}
