package com.ejie.nbrs.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.ejie.nbrs.ejieinterface.entity.RepaymentSchedule;


/**
 * 
 * ClassName:NewStorageView 最新押品管理基本视图
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月18日 下午3:48:02
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public class NewStorageView {
	/**
	 * 押品编号
	 */
	private String guaranteeNo;
	/**
	 * 贷款客户
	 */
	private String realName;
	/**
	 * 抵押物总id关联主键
	 */
    private Integer id;
	/**
	 * 抵押房总id
	 */
	private String mhouseId;
	/**
	 * 抵押物总id
	 */
    private String gId;
    /**
     * 贷款编号
     */
    private Integer loanId;
    /**
     * 放款确认时间
     */
    private Date finalTransferDate;
    /**
     * 押品类型
     */
    private String gmType;
    /**
     * 押品状态
     */
    private String gmStatus;
    /**
     * 抵押人姓名（废弃）
     */
    private String mortgagerName;
    /**
     * 抵押房单个价值
     */
    private BigDecimal mhouseValue;
    /**
     * 抵押人姓名
     */
    private String propertyOwner;
    /**
     * 抵押人id
     */
    private Integer gmAppId;
    /**
     * 抵押房具体id
     */
    private String mHId;
    /**
     * 入库时间
     */
    private Date gmInTime;
    /**
     * 出库说明
     */
    private String outReason;
    
    private Date gmOutTime;//出库时间
    
    private Date inApplyTime;//入库申请时间
    
    private Date outApplyTime;//出库申请时间
    
    private RepaymentSchedule repaymentSchedule;//还款计划表信息

    private String serialNo;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMhouseId() {
		return mhouseId;
	}

	public void setMhouseId(String mhouseId) {
		this.mhouseId = mhouseId;
	}

	public String getgId() {
		return gId;
	}

	public void setgId(String gId) {
		this.gId = gId;
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

	public String getGmType() {
		return gmType;
	}

	public void setGmType(String gmType) {
		this.gmType = gmType;
	}

	public String getGmStatus() {
		return gmStatus;
	}

	public void setGmStatus(String gmStatus) {
		this.gmStatus = gmStatus;
	}

	public String getMortgagerName() {
		return mortgagerName;
	}

	public void setMortgagerName(String mortgagerName) {
		this.mortgagerName = mortgagerName;
	}

	public BigDecimal getMhouseValue() {
		return mhouseValue;
	}

	public void setMhouseValue(BigDecimal mhouseValue) {
		this.mhouseValue = mhouseValue;
	}

	public String getPropertyOwner() {
		return propertyOwner;
	}

	public void setPropertyOwner(String propertyOwner) {
		this.propertyOwner = propertyOwner;
	}

	public Integer getGmAppId() {
		return gmAppId;
	}

	public void setGmAppId(Integer gmAppId) {
		this.gmAppId = gmAppId;
	}

	public String getmHId() {
		return mHId;
	}

	public void setmHId(String mHId) {
		this.mHId = mHId;
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

	public Date getGmOutTime() {
		return gmOutTime;
	}

	public void setGmOutTime(Date gmOutTime) {
		this.gmOutTime = gmOutTime;
	}

	public Date getInApplyTime() {
		return inApplyTime;
	}

	public void setInApplyTime(Date inApplyTime) {
		this.inApplyTime = inApplyTime;
	}

	public Date getOutApplyTime() {
		return outApplyTime;
	}

	public void setOutApplyTime(Date outApplyTime) {
		this.outApplyTime = outApplyTime;
	}

	public RepaymentSchedule getRepaymentSchedule() {
		return repaymentSchedule;
	}

	public void setRepaymentSchedule(RepaymentSchedule repaymentSchedule) {
		this.repaymentSchedule = repaymentSchedule;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	
	
	public String getGuaranteeNo() {
		return guaranteeNo;
	}

	public void setGuaranteeNo(String guaranteeNo) {
		this.guaranteeNo = guaranteeNo;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	@Override
	public String toString() {
		return "NewStorageView [guaranteeNo=" + guaranteeNo + ", realName="
				+ realName + ", id=" + id + ", mhouseId=" + mhouseId + ", gId="
				+ gId + ", loanId=" + loanId + ", finalTransferDate="
				+ finalTransferDate + ", gmType=" + gmType + ", gmStatus="
				+ gmStatus + ", mortgagerName=" + mortgagerName
				+ ", mhouseValue=" + mhouseValue + ", propertyOwner="
				+ propertyOwner + ", gmAppId=" + gmAppId + ", mHId=" + mHId
				+ ", gmInTime=" + gmInTime + ", outReason=" + outReason
				+ ", gmOutTime=" + gmOutTime + ", inApplyTime=" + inApplyTime
				+ ", outApplyTime=" + outApplyTime + ", repaymentSchedule="
				+ repaymentSchedule + ", serialNo=" + serialNo + "]";
	}

	
	
	
   
    
}