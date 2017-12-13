/**
 * InAStatisticalEntity.java
 * com.ejie.nbrs.entity
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   ver1.1  2017年9月26日 		zlg
 *
 * Copyright (c) 2017, EJie All Rights Reserved.
*/

package com.ejie.nbrs.entity;

import java.math.BigDecimal;

/**
 * ClassName:InAStatisticalEntity 进件统计实体
 * @author   zlg
 * @version  
 * @since    Ver 1.1
 * @Date	 2017年9月26日		上午10:18:03
 * @see 	 
 */
public class InAStatisticalEntity {
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
	private BigDecimal advancePiecePay; 
	/**
	 * 进件申请笔数
	 */
	private int advancePieceCount;
	/**
	 * 授信通过金额
	 */
	private BigDecimal passCreditPay; 
	/**
	 * 授信通过笔数
	 */
	private int passCreditCount;
	/**
	 * 授信拒绝金额
	 */
	private BigDecimal outCreditPay; 
	/**
	 * 授信拒绝笔数
	 */
	private int outCreditCount;
	/**
	 * 放款通过金额
	 */
	private BigDecimal passLoanPay; 
	/**
	 * 放款通过笔数
	 */
	private int passLoanCount;
	/**
	 * 放款拒绝金额
	 */
	private BigDecimal outLoanPay; 
	/**
	 * 放款拒绝笔数
	 */
	private int outLoanCount;
	/**
	 * 放款完成金额
	 */
	private BigDecimal finishLoanPay; 
	/**
	 * 放款完成笔数
	 */
	private int finishLoanCount;
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
	public BigDecimal getAdvancePiecePay() {
		return advancePiecePay;
	}
	public void setAdvancePiecePay(BigDecimal advancePiecePay) {
		this.advancePiecePay = advancePiecePay;
	}
	public int getAdvancePieceCount() {
		return advancePieceCount;
	}
	public void setAdvancePieceCount(int advancePieceCount) {
		this.advancePieceCount = advancePieceCount;
	}
	public BigDecimal getPassCreditPpay() {
		return passCreditPay;
	}
	public void setPassCreditPay(BigDecimal passCreditPay) {
		this.passCreditPay = passCreditPay;
	}
	public int getPassCreditCount() {
		return passCreditCount;
	}
	public void setPassCreditCount(int passCreditCount) {
		this.passCreditCount = passCreditCount;
	}
	public BigDecimal getOutCreditPay() {
		return outCreditPay;
	}
	public void setOutCreditPay(BigDecimal outCreditPay) {
		this.outCreditPay = outCreditPay;
	}
	public int getOutCreditCount() {
		return outCreditCount;
	}
	public void setOutCreditCount(int outCreditCount) {
		this.outCreditCount = outCreditCount;
	}
	public BigDecimal getPassLoanPay() {
		return passLoanPay;
	}
	public void setPassLoanPay(BigDecimal passLoanPay) {
		this.passLoanPay = passLoanPay;
	}
	public int getPassLoanCount() {
		return passLoanCount;
	}
	public void setPassLoanCount(int passLoanCount) {
		this.passLoanCount = passLoanCount;
	}
	public BigDecimal getOutLoanPay() {
		return outLoanPay;
	}
	public void setOutLoanPay(BigDecimal outLoanPay) {
		this.outLoanPay = outLoanPay;
	}
	public int getOutLoanCount() {
		return outLoanCount;
	}
	public void setOutLoanCount(int outLoanCount) {
		this.outLoanCount = outLoanCount;
	}
	public BigDecimal getFinishLoanPay() {
		return finishLoanPay;
	}
	public void setFinishLoanPay(BigDecimal finishLoanPay) {
		this.finishLoanPay = finishLoanPay;
	}
	public int getFinishLoanCount() {
		return finishLoanCount;
	}
	public void setFinishLoanCount(int finishLoanCount) {
		this.finishLoanCount = finishLoanCount;
	}
	public String getLendingChannel() {
		return lendingChannel;
	}
	public void setLendingChannel(String lendingChannel) {
		this.lendingChannel = lendingChannel;
	}
	@Override
	public String toString() {
		return "InAStatisticalEntity [starttime=" + starttime + ", endtime="
				+ endtime + ", lendingChannel=" + lendingChannel + ", city1="
				+ city1 + ", loanPurpose1=" + loanPurpose1
				+ ", advancePiecePay=" + advancePiecePay
				+ ", advancePieceCount=" + advancePieceCount
				+ ", passCreditPay=" + passCreditPay + ", passCreditCount="
				+ passCreditCount + ", outCreditPay=" + outCreditPay
				+ ", outCreditCount=" + outCreditCount + ", passLoanPay="
				+ passLoanPay + ", passLoanCount=" + passLoanCount
				+ ", outLoanPay=" + outLoanPay + ", outLoanCount="
				+ outLoanCount + ", finishLoanPay=" + finishLoanPay
				+ ", finishLoanCount=" + finishLoanCount + "]";
	}




}

