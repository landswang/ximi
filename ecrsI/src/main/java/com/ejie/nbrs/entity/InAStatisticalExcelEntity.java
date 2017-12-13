/**
 * InAStatisticalExcelEntity.java
 * com.ejie.nbrs.entity
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   ver1.1  2017年9月27日 		zlg
 *
 * Copyright (c) 2017, EJie All Rights Reserved.
*/

package com.ejie.nbrs.entity;


/**
 * ClassName:InAStatisticalExcelEntity
 * @author   zlg
 * @version  
 * @since    Ver 1.1
 * @Date	 2017年9月27日		下午2:27:11
 * @see 	 
 */
public class InAStatisticalExcelEntity {
	/**
	 * 筛选开始时间
	 */
	private String starttime;
	/**
	 * 筛选结束时间
	 */
	private String endtime;
	/**
	 * 放款渠道
	 */
	private String lendingChannel;
	/**
	 * 筛选城市
	 */
  	private String city1; 
  	/**
  	 * 筛选贷款用途；1：综合消费；2：生产经营。其他：全部。。
  	 */
  	private String loanPurpose1;
  	/**
  	 * 进件申请金额
  	 */
	private String advancePiecePay; 
	/**
	 * 进件申请笔数
	 */
	private String advancePieceCount;
	/**
	 * 授信通过金额
	 */
	private String passCreditPpay; 
	/**
	 * 授信通过笔数
	 */
	private String passCreditCount;
	/**
	 * 放款通过金额
	 */
	private String passLoanPay; 
	/**
	 * 放款通过笔数
	 */
	private String passLoanCount;
	/**
	 * 放款完成金额
	 */
	private String finishLoanPay; 
	/**
	 * 放款完成笔数
	 */
	private String finishLoanCount;
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getLendingChannel() {
		return lendingChannel;
	}
	public void setLendingChannel(String lendingChannel) {
		this.lendingChannel = lendingChannel;
	}
	public String getCity1() {
		return city1;
	}
	public void setCity1(String city1) {
		this.city1 = city1;
	}
	public String getLoanPurpose1() {
		return loanPurpose1;
	}
	public void setLoanPurpose1(String loanPurpose1) {
		this.loanPurpose1 = loanPurpose1;
	}
	public String getAdvancePiecePay() {
		return advancePiecePay;
	}
	public void setAdvancePiecePay(String advancePiecePay) {
		this.advancePiecePay = advancePiecePay;
	}
	public String getAdvancePieceCount() {
		return advancePieceCount;
	}
	public void setAdvancePieceCount(String advancePieceCount) {
		this.advancePieceCount = advancePieceCount;
	}
	public String getPassCreditPpay() {
		return passCreditPpay;
	}
	public void setPassCreditPpay(String passCreditPpay) {
		this.passCreditPpay = passCreditPpay;
	}
	public String getPassCreditCount() {
		return passCreditCount;
	}
	public void setPassCreditCount(String passCreditCount) {
		this.passCreditCount = passCreditCount;
	}
	public String getPassLoanPay() {
		return passLoanPay;
	}
	public void setPassLoanPay(String passLoanPay) {
		this.passLoanPay = passLoanPay;
	}
	public String getPassLoanCount() {
		return passLoanCount;
	}
	public void setPassLoanCount(String passLoanCount) {
		this.passLoanCount = passLoanCount;
	}
	public String getFinishLoanPay() {
		return finishLoanPay;
	}
	public void setFinishLoanPay(String finishLoanPay) {
		this.finishLoanPay = finishLoanPay;
	}
	public String getFinishLoanCount() {
		return finishLoanCount;
	}
	public void setFinishLoanCount(String finishLoanCount) {
		this.finishLoanCount = finishLoanCount;
	}
	@Override
	public String toString() {
		return "InAStatisticalExcelEntity [starttime=" + starttime
				+ ", endtime=" + endtime + ", lendingChannel=" + lendingChannel
				+ ", city1=" + city1 + ", loanPurpose1=" + loanPurpose1
				+ ", advancePiecePay=" + advancePiecePay
				+ ", advancePieceCount=" + advancePieceCount
				+ ", passCreditPpay=" + passCreditPpay + ", passCreditCount="
				+ passCreditCount + ", passLoanPay=" + passLoanPay
				+ ", passLoanCount=" + passLoanCount + ", finishLoanPay="
				+ finishLoanPay + ", finishLoanCount=" + finishLoanCount + "]";
	}
	
	
}

