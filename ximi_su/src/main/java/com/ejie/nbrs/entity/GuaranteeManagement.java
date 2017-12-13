package com.ejie.nbrs.entity;

import java.util.Date;
/**
 * 
 * ClassName:GuaranteeManagement 押品管理
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月15日 下午7:21:38
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public class GuaranteeManagement {
	private Date finalTransferDate;
	
    private Integer gMId;

    private Integer loanId;

    private String gId;

	private Integer gmAppId;

    private String gmStatus;

    private String gmType;

    private Date gmOutTime;

    private Date gmInTime;

    private String outReason;

    private String outRemark;

    private String introductceAccessory;

    private String logoffAccessory;

    private String cleanAccessory;

    private String otherAccessory;


    public Integer getgMId() {
        return gMId;
    }

    public void setgMId(Integer gMId) {
        this.gMId = gMId;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public Integer getGmAppId() {
        return gmAppId;
    }

    public void setGmAppId(Integer gmAppId) {
        this.gmAppId = gmAppId;
    }

    public String getGmStatus() {
        return gmStatus;
    }

    public void setGmStatus(String gmStatus) {
        this.gmStatus = gmStatus == null ? null : gmStatus.trim();
    }

    public String getGmType() {
        return gmType;
    }

    public void setGmType(String gmType) {
        this.gmType = gmType == null ? null : gmType.trim();
    }

    public Date getGmOutTime() {
        return gmOutTime;
    }

    public void setGmOutTime(Date gmOutTime) {
        this.gmOutTime = gmOutTime;
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
        this.outReason = outReason == null ? null : outReason.trim();
    }

    public String getOutRemark() {
        return outRemark;
    }

    public void setOutRemark(String outRemark) {
        this.outRemark = outRemark == null ? null : outRemark.trim();
    }

    public String getIntroductceAccessory() {
        return introductceAccessory;
    }

    public void setIntroductceAccessory(String introductceAccessory) {
        this.introductceAccessory = introductceAccessory == null ? null : introductceAccessory.trim();
    }

    public String getLogoffAccessory() {
        return logoffAccessory;
    }

    public void setLogoffAccessory(String logoffAccessory) {
        this.logoffAccessory = logoffAccessory == null ? null : logoffAccessory.trim();
    }

    public String getCleanAccessory() {
        return cleanAccessory;
    }

    public void setCleanAccessory(String cleanAccessory) {
        this.cleanAccessory = cleanAccessory == null ? null : cleanAccessory.trim();
    }

    public String getOtherAccessory() {
        return otherAccessory;
    }

    public void setOtherAccessory(String otherAccessory) {
        this.otherAccessory = otherAccessory == null ? null : otherAccessory.trim();
    }

	public Date getFinalTransferDate() {
		return finalTransferDate;
	}

	public void setFinalTransferDate(Date finalTransferDate) {
		this.finalTransferDate = finalTransferDate;
	}

	@Override
	public String toString() {
		return "GuaranteeManagement [finalTransferDate=" + finalTransferDate
				+ ", gMId=" + gMId + ", loanId=" + loanId + ", gId=" + gId
				+ ", gmAppId=" + gmAppId + ", gmStatus=" + gmStatus
				+ ", gmType=" + gmType + ", gmOutTime=" + gmOutTime
				+ ", gmInTime=" + gmInTime + ", outReason=" + outReason
				+ ", outRemark=" + outRemark + ", introductceAccessory="
				+ introductceAccessory + ", logoffAccessory=" + logoffAccessory
				+ ", cleanAccessory=" + cleanAccessory + ", otherAccessory="
				+ otherAccessory + "]";
	}

	

	

    
}