package com.ejie.nbrs.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * ClassName:LendingForm 放款统计报表
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月14日 下午2:23:22
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public class LendingForm {
	private Date starttime;
	
	private Date endtime;
	
	private BigDecimal appliedAmount;
	
	private BigDecimal actualAmount;
	
	private BigDecimal guaranteeAmount;
	
	private BigDecimal loanRate;
	
	private BigDecimal guaranteeRate;

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public BigDecimal getAppliedAmount() {
		return appliedAmount;
	}

	public void setAppliedAmount(BigDecimal appliedAmount) {
		this.appliedAmount = appliedAmount;
	}

	public BigDecimal getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(BigDecimal actualAmount) {
		this.actualAmount = actualAmount;
	}

	public BigDecimal getGuaranteeAmount() {
		return guaranteeAmount;
	}

	public void setGuaranteeAmount(BigDecimal guaranteeAmount) {
		this.guaranteeAmount = guaranteeAmount;
	}

	public BigDecimal getLoanRate() {
		return loanRate;
	}

	public void setLoanRate(BigDecimal loanRate) {
		this.loanRate = loanRate;
	}

	public BigDecimal getGuaranteeRate() {
		return guaranteeRate;
	}

	public void setGuaranteeRate(BigDecimal guaranteeRate) {
		this.guaranteeRate = guaranteeRate;
	}

	@Override
	public String toString() {
		return "LendingForm [starttime=" + starttime + ", endtime=" + endtime
				+ ", appliedAmount=" + appliedAmount + ", actualAmount="
				+ actualAmount + ", guaranteeAmount=" + guaranteeAmount
				+ ", loanRate=" + loanRate + ", guaranteeRate=" + guaranteeRate
				+ "]";
	}
	
}
