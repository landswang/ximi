package com.ejie.nbrs.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ProducInformation {
    private String mortgagerName;

    private String cNumber;

    private String mhouseId;

    private String gCategory;

    private BigDecimal mhouseValue;

    private String propertyRightNumber;

    private String propertyOwner;

    private BigDecimal acreage;

    private String gAddress;

    private String houseArea;

    private BigDecimal oldValue;

    private String isComplete;

    private String incompleteReason;

    private String warrantType;

    private String issueDept;

    private Date issueDate;

    private String storageDept;

    private Integer loanId;
    /**
     * 附件
     */
    private String gmAccessory;
	public String getMortgagerName() {
		return mortgagerName;
	}
	public void setMortgagerName(String mortgagerName) {
		this.mortgagerName = mortgagerName;
	}
	public String getcNumber() {
		return cNumber;
	}
	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}
	public String getMhouseId() {
		return mhouseId;
	}
	public void setMhouseId(String mhouseId) {
		this.mhouseId = mhouseId;
	}
	public String getgCategory() {
		return gCategory;
	}
	public void setgCategory(String gCategory) {
		this.gCategory = gCategory;
	}
	public BigDecimal getMhouseValue() {
		return mhouseValue;
	}
	public void setMhouseValue(BigDecimal mhouseValue) {
		this.mhouseValue = mhouseValue;
	}
	public String getPropertyRightNumber() {
		return propertyRightNumber;
	}
	public void setPropertyRightNumber(String propertyRightNumber) {
		this.propertyRightNumber = propertyRightNumber;
	}
	public String getPropertyOwner() {
		return propertyOwner;
	}
	public void setPropertyOwner(String propertyOwner) {
		this.propertyOwner = propertyOwner;
	}
	public BigDecimal getAcreage() {
		return acreage;
	}
	public void setAcreage(BigDecimal acreage) {
		this.acreage = acreage;
	}
	public String getgAddress() {
		return gAddress;
	}
	public void setgAddress(String gAddress) {
		this.gAddress = gAddress;
	}
	public String getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}
	public BigDecimal getOldValue() {
		return oldValue;
	}
	public void setOldValue(BigDecimal oldValue) {
		this.oldValue = oldValue;
	}
	public String getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(String isComplete) {
		this.isComplete = isComplete;
	}
	public String getIncompleteReason() {
		return incompleteReason;
	}
	public void setIncompleteReason(String incompleteReason) {
		this.incompleteReason = incompleteReason;
	}
	public String getWarrantType() {
		return warrantType;
	}
	public void setWarrantType(String warrantType) {
		this.warrantType = warrantType;
	}
	public String getIssueDept() {
		return issueDept;
	}
	public void setIssueDept(String issueDept) {
		this.issueDept = issueDept;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public String getStorageDept() {
		return storageDept;
	}
	public void setStorageDept(String storageDept) {
		this.storageDept = storageDept;
	}
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	public String getGmAccessory() {
		return gmAccessory;
	}
	public void setGmAccessory(String gmAccessory) {
		this.gmAccessory = gmAccessory;
	}
	@Override
	public String toString() {
		return "ProducInformation [mortgagerName=" + mortgagerName
				+ ", cNumber=" + cNumber + ", mhouseId=" + mhouseId
				+ ", gCategory=" + gCategory + ", mhouseValue=" + mhouseValue
				+ ", propertyRightNumber=" + propertyRightNumber
				+ ", propertyOwner=" + propertyOwner + ", acreage=" + acreage
				+ ", gAddress=" + gAddress + ", houseArea=" + houseArea
				+ ", oldValue=" + oldValue + ", isComplete=" + isComplete
				+ ", incompleteReason=" + incompleteReason + ", warrantType="
				+ warrantType + ", issueDept=" + issueDept + ", issueDate="
				+ issueDate + ", storageDept=" + storageDept + ", loanId="
				+ loanId + ", gmAccessory=" + gmAccessory + "]";
	}


    
}