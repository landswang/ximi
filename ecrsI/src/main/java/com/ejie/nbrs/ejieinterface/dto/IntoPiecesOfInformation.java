package com.ejie.nbrs.ejieinterface.dto;

/**
 * 
 * ClassName:进件基本内容信息
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月10日 下午6:26:44
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class IntoPiecesOfInformation {
	private String serialNo;
	private String city;
	private String applyDate;
	private String garantyType;
	private float applyAmount;
	private String repayMethod;
	private float loanRate;
	private int loanLimit;
	private String loanUse;

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getGarantyType() {
		return garantyType;
	}

	public void setGarantyType(String garantyType) {
		this.garantyType = garantyType;
	}

	public float getApplyAmount() {
		return applyAmount;
	}

	public void setApplyAmount(float applyAmount) {
		this.applyAmount = applyAmount;
	}

	public String getRepayMethod() {
		return repayMethod;
	}

	public void setRepayMethod(String repayMethod) {
		this.repayMethod = repayMethod;
	}

	public float getLoanRate() {
		return loanRate;
	}

	public void setLoanRate(float loanRate) {
		this.loanRate = loanRate;
	}

	public int getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(int loanLimit) {
		this.loanLimit = loanLimit;
	}

	public String getLoanUse() {
		return loanUse;
	}

	public void setLoanUse(String loanUse) {
		this.loanUse = loanUse;
	}

	@Override
	public String toString() {
		return "Ejie01 [serialNo=" + serialNo + ", city=" + city
				+ ", applyDate=" + applyDate + ", garantyType=" + garantyType
				+ ", applyAmount=" + applyAmount + ", repayMethod="
				+ repayMethod + ", loanRate=" + loanRate + ", loanLimit="
				+ loanLimit + ", loanUse=" + loanUse + "]";
	}

}
