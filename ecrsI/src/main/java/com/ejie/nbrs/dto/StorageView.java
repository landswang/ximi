package com.ejie.nbrs.dto;

import java.math.BigDecimal;
import java.util.Date;

public class StorageView {
    private Integer guaranteeId;

    private Integer loanId;

    private Date finalTransferDate;

    private String gCategory;

    private String propertyOwner;

    private String mortgagerName;

    private BigDecimal comfirmValue;

    private String gStatus;

    private Date repaymentDate;
    
    private Date gmInTime;
    
    private String outReason;
    
    private String outRemark;
    
    private Date gmOutTime;

	public Integer getGuaranteeId() {
		return guaranteeId;
	}

	public void setGuaranteeId(Integer guaranteeId) {
		this.guaranteeId = guaranteeId;
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public Date getFinalTransferDate() {
		return finalTransferDate;
	}

	public void setFinalTransferDate(Date finalTransferDate) {
		this.finalTransferDate = finalTransferDate;
	}

	public String getgCategory() {
		return gCategory;
	}

	public void setgCategory(String gCategory) {
		this.gCategory = gCategory;
	}

	public String getPropertyOwner() {
		return propertyOwner;
	}

	public void setPropertyOwner(String propertyOwner) {
		this.propertyOwner = propertyOwner;
	}

	public String getMortgagerName() {
		return mortgagerName;
	}

	public void setMortgagerName(String mortgagerName) {
		this.mortgagerName = mortgagerName;
	}

	public BigDecimal getComfirmValue() {
		return comfirmValue;
	}

	public void setComfirmValue(BigDecimal comfirmValue) {
		this.comfirmValue = comfirmValue;
	}

	public String getgStatus() {
		return gStatus;
	}

	public void setgStatus(String gStatus) {
		this.gStatus = gStatus;
	}

	public Date getRepaymentDate() {
		return repaymentDate;
	}

	public void setRepaymentDate(Date repaymentDate) {
		this.repaymentDate = repaymentDate;
	}

	public Date getGmInTime() {
		return gmInTime;
	}

	public void setGmInTime(Date gmInTime) {
		this.gmInTime = gmInTime;
	}

	public String getOutReason() {
		return outReason;
	}

	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}

	public String getOutRemark() {
		return outRemark;
	}

	public void setOutRemark(String outRemark) {
		this.outRemark = outRemark;
	}

	public Date getGmOutTime() {
		return gmOutTime;
	}

	public void setGmOutTime(Date gmOutTime) {
		this.gmOutTime = gmOutTime;
	}

	@Override
	public String toString() {
		return "StorageView [guaranteeId=" + guaranteeId + ", loanId=" + loanId
				+ ", finalTransferDate=" + finalTransferDate + ", gCategory="
				+ gCategory + ", propertyOwner=" + propertyOwner
				+ ", mortgagerName=" + mortgagerName + ", comfirmValue="
				+ comfirmValue + ", gStatus=" + gStatus + ", repaymentDate="
				+ repaymentDate + ", gmInTime=" + gmInTime + ", outReason="
				+ outReason + ", outRemark=" + outRemark + ", gmOutTime="
				+ gmOutTime + "]";
	}

    
    
}