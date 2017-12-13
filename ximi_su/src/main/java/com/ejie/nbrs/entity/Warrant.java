package com.ejie.nbrs.entity;

import java.util.Date;

/**
 * 
 * ClassName:Warrant 权证信息
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月16日 下午4:30:24
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class Warrant {
	/**
	 * 主键
	 */
	private Integer warrantId;
	/**
	 * 权证类型
	 */
	private String warrantType;
	/**
	 * 权证号码
	 */
	private String cType;
	/**
	 * 是否完整
	 */
	private String isComplete;
	/**
	 * 不完整原因
	 */
	private String incompleteReason;
	/**
	 * 出证机构名称
	 */
	private String issueDept;
	/**
	 * 出证时间
	 */
	private Date issueDate;
	/**
	 * 经办机构
	 */
	private String handleDept;
	/**
	 * 保管机构
	 */
	private String storageDept;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 状态
	 */
	private Integer status;

	public Integer getWarrantId() {
		return warrantId;
	}

	public void setWarrantId(Integer warrantId) {
		this.warrantId = warrantId;
	}

	public String getWarrantType() {
		return warrantType;
	}

	public void setWarrantType(String warrantType) {
		this.warrantType = warrantType == null ? null : warrantType.trim();
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType == null ? null : cType.trim();
	}

	public String getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(String isComplete) {
		this.isComplete = isComplete == null ? null : isComplete.trim();
	}

	public String getIncompleteReason() {
		return incompleteReason;
	}

	public void setIncompleteReason(String incompleteReason) {
		this.incompleteReason = incompleteReason == null ? null
				: incompleteReason.trim();
	}

	public String getIssueDept() {
		return issueDept;
	}

	public void setIssueDept(String issueDept) {
		this.issueDept = issueDept == null ? null : issueDept.trim();
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getHandleDept() {
		return handleDept;
	}

	public void setHandleDept(String handleDept) {
		this.handleDept = handleDept == null ? null : handleDept.trim();
	}

	public String getStorageDept() {
		return storageDept;
	}

	public void setStorageDept(String storageDept) {
		this.storageDept = storageDept == null ? null : storageDept.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Warrant [warrantId=" + warrantId + ", warrantType="
				+ warrantType + ", cType=" + cType + ", isComplete="
				+ isComplete + ", incompleteReason=" + incompleteReason
				+ ", issueDept=" + issueDept + ", issueDate=" + issueDate
				+ ", handleDept=" + handleDept + ", storageDept=" + storageDept
				+ ", remark=" + remark + ", status=" + status + "]";
	}
	
}