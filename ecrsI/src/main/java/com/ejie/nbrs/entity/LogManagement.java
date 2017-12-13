package com.ejie.nbrs.entity;

import java.util.Date;

/**
 * 
 * ClassName:LogManagement 日志管理
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月23日 下午6:32:47
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public class LogManagement {
	/**
	 * 日志主键标识
	 */
	private Integer logId;
	/**
	 * 贷款编号
	 */
	private Integer loanId;
	/**
	 * 操作类型标识
	 */
	private String logOperateType;
	/**
	 * 操作人姓名
	 */
	private String logOperator;
	/**
	 * 操作时间/生成时间
	 */
	private Date logDate;
	/**
	 * 日志详情/具体操作
	 */
	private String logDetails;
	/**
	 * 业务模块标识
	 */
	private String logModuleType;
	/**
	 * 访问者ip地址
	 */
	private String operateIp;
	
	public LogManagement() {
		super();
	}
	public LogManagement(Integer loanId, String logOperateType,
			String logOperator, Date logDate, String logDetails,
			String logModuleType,String operateIp) {
		super();
		this.operateIp = operateIp;
		this.loanId = loanId;
		this.logOperateType = logOperateType;
		this.logOperator = logOperator;
		this.logDate = logDate;
		this.logDetails = logDetails;
		this.logModuleType = logModuleType;
	}
	
	public Integer getLogId() {
		return logId;
	}
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	public String getLogOperateType() {
		return logOperateType;
	}
	public void setLogOperateType(String logOperateType) {
		this.logOperateType = logOperateType;
	}
	public String getLogOperator() {
		return logOperator;
	}
	public void setLogOperator(String logOperator) {
		this.logOperator = logOperator;
	}
	public Date getLogDate() {
		return logDate;
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	public String getLogDetails() {
		return logDetails;
	}
	public void setLogDetails(String logDetails) {
		this.logDetails = logDetails;
	}
	public String getLogModuleType() {
		return logModuleType;
	}
	public void setLogModuleType(String logModuleType) {
		this.logModuleType = logModuleType;
	}

	public String getOperateIp() {
		return operateIp;
	}
	public void setOperateIp(String operateIp) {
		this.operateIp = operateIp;
	}
	@Override
	public String toString() {
		return "LogManagement [logId=" + logId + ", loanId=" + loanId
				+ ", logOperateType=" + logOperateType + ", logOperator="
				+ logOperator + ", logDate=" + logDate + ", logDetails="
				+ logDetails + ", logModuleType=" + logModuleType
				+ ", operateIp=" + operateIp + "]";
	}
	

}
