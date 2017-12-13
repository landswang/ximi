package com.ejie.nbrs.entity;
/**
 * 
 * ClassName:PrintLoanView 新网银行个人授信业务放款审查审批表审查审批决议表
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月29日 下午7:43:20
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public class PrintLoanView {
	/**
	 * 借款人姓名
	 */
	private String name;
	/**
	 * 业务种类
	 */
	private String pType;
	/**
	 * 还款卡卡号
	 */
	private String repayCardNo;
	/**
	 * 业务期限
	 */
	private String periods;
	/**
	 * 结息方式
	 */
	private String repayWay;
	/**
	 * 资金用途
	 */
	private String loanPurpose;
	/**
	 * 利率
	 */
	private String rate;
	/**
	 * 借款卡号
	 */
	private String cCardNumber;
	/**
	 * 贷款编号
	 */
	private Integer loanId;
	/**
	 * 业务流水号
	 */
	private String serialNo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public String getRepayCardNo() {
		return repayCardNo;
	}
	public void setRepayCardNo(String repayCardNo) {
		this.repayCardNo = repayCardNo;
	}
	public String getPeriods() {
		return periods;
	}
	public void setPeriods(String periods) {
		this.periods = periods;
	}
	public String getRepayWay() {
		return repayWay;
	}
	public void setRepayWay(String repayWay) {
		this.repayWay = repayWay;
	}
	public String getLoanPurpose() {
		return loanPurpose;
	}
	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getcCardNumber() {
		return cCardNumber;
	}
	public void setcCardNumber(String cCardNumber) {
		this.cCardNumber = cCardNumber;
	}
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
	@Override
	public String toString() {
		return "PrintLoanView [name=" + name + ", pType=" + pType
				+ ", repayCardNo=" + repayCardNo + ", periods=" + periods
				+ ", repayWay=" + repayWay + ", loanPurpose=" + loanPurpose
				+ ", rate=" + rate + ", cCardNumber=" + cCardNumber
				+ ", loanId=" + loanId + ", serialNo=" + serialNo + "]";
	}
	
}
