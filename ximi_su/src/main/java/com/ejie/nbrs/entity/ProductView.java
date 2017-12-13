package com.ejie.nbrs.entity;

import java.math.BigDecimal;
import java.util.List;
/**
 * 
 * ClassName:productView 出入库申请信息
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月21日 下午4:52:15
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public class ProductView {
	/**
	 * 押品管理主键
	 */
	private Integer gMId;
	/**
	 * 抵押物总编号
	 */
	private String gId;
	/**
	 * 押品类型
	 */
	private String gmType;
	/**
	 * 贷款编号
	 */
	private Integer loanId;
	/**
	 * 出库说明
	 */
	private String outRemark;
	/**
	 * 资方确认价值
	 */
	private BigDecimal comfirmValue;
	/**
	 * 押品原值
	 */
	private BigDecimal oldValue;
	/**
	 * 出库原因
	 */
	private String outReason;
	/**
	 * 附件
	 */
	private String gmAccessory;

	/**
	 * 抵押房编号
	 */
	private String mhouseId;
	/**
	 * 附件图片信息
	 */
	private String loanImage;
	/**
	 * 申请入库时间
	 */
	private String inApplyTime;
	/**
	 * 申请出库时间
	 */
	private String outApplyTime;
	/**
	 * 抵押房集合
	 */
	private List<MortgageHouse> mhList;
	/**
	 * 押品文件存/取路径
	 */
	private FileRPath fileRPath;
	/**
	 * 易捷序列号
	 */
	private String serialNo;
	 /**
	   * 临时文件表中关联图片名集合
	   */
	  private List<ScratchFile> scratchFileList;
	public Integer getgMId() {
		return gMId;
	}
	public void setgMId(Integer gMId) {
		this.gMId = gMId;
	}
	public String getgId() {
		return gId;
	}
	public void setgId(String gId) {
		this.gId = gId;
	}
	public String getGmType() {
		return gmType;
	}
	public void setGmType(String gmType) {
		this.gmType = gmType;
	}
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	public String getOutRemark() {
		return outRemark;
	}
	public void setOutRemark(String outRemark) {
		this.outRemark = outRemark;
	}
	public BigDecimal getComfirmValue() {
		return comfirmValue;
	}
	public void setComfirmValue(BigDecimal comfirmValue) {
		this.comfirmValue = comfirmValue;
	}
	public BigDecimal getOldValue() {
		return oldValue;
	}
	public void setOldValue(BigDecimal oldValue) {
		this.oldValue = oldValue;
	}
	public String getOutReason() {
		return outReason;
	}
	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}
	public String getGmAccessory() {
		return gmAccessory;
	}
	public void setGmAccessory(String gmAccessory) {
		this.gmAccessory = gmAccessory;
	}
	public String getMhouseId() {
		return mhouseId;
	}
	public void setMhouseId(String mhouseId) {
		this.mhouseId = mhouseId;
	}
	public String getLoanImage() {
		return loanImage;
	}
	public void setLoanImage(String loanImage) {
		this.loanImage = loanImage;
	}
	public String getInApplyTime() {
		return inApplyTime;
	}
	public void setInApplyTime(String inApplyTime) {
		this.inApplyTime = inApplyTime;
	}
	public String getOutApplyTime() {
		return outApplyTime;
	}
	public void setOutApplyTime(String outApplyTime) {
		this.outApplyTime = outApplyTime;
	}
	public List<MortgageHouse> getMhList() {
		return mhList;
	}
	public void setMhList(List<MortgageHouse> mhList) {
		this.mhList = mhList;
	}
	public FileRPath getFileRPath() {
		return fileRPath;
	}
	public void setFileRPath(FileRPath fileRPath) {
		this.fileRPath = fileRPath;
	}
	
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	public List<ScratchFile> getScratchFileList() {
		return scratchFileList;
	}
	public void setScratchFileList(List<ScratchFile> scratchFileList) {
		this.scratchFileList = scratchFileList;
	}
	@Override
	public String toString() {
		return "ProductView [gMId=" + gMId + ", gId=" + gId + ", gmType="
				+ gmType + ", loanId=" + loanId + ", outRemark=" + outRemark
				+ ", comfirmValue=" + comfirmValue + ", oldValue=" + oldValue
				+ ", outReason=" + outReason + ", gmAccessory=" + gmAccessory
				+ ", mhouseId=" + mhouseId + ", loanImage=" + loanImage
				+ ", inApplyTime=" + inApplyTime + ", outApplyTime="
				+ outApplyTime + ", mhList=" + mhList + ", fileRPath="
				+ fileRPath + ", serialNo=" + serialNo + ", scratchFileList="
				+ scratchFileList + "]";
	}
	
	
	

	
}