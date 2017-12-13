package com.ejie.nbrs.entity;

import java.util.Date;
/**
 * 
 * ClassName:LoanAudit 订单审核记录表
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月29日 下午2:14:55
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public class LoanAudit {
	/**
	 * 主键
	 */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 贷款id
     */
    private Integer loanId;
    /**
     * 业务流水号
     */
    private String serialNo;
    /**
     * 原本所在节点
     */
    private Integer oldFlowNode;
    /**
     * 原本所处状态码
     */
    private String oldStatus;
    /**
     * 流程节点 1001 1002 1003 1004 1005 1006
     */
    private Integer flowNode;
    /**
     * 审核结果 0：审核中 1：审核通过 2：审核不通过 3：修改通过
     */
    private String status;
    /**
     * 审核内容 审核时填写的备注信息
     */
    private String conent;
    /**
     * 附件信息
     */
    private String accessoryImg;
    /**
     * 备注 备用字段
     */
    private String remark;
    /**
     * 审核时间 数据库默认记录时间
     */
    private Date auditingTime;


    
    public LoanAudit() {
		super();
	}

	public LoanAudit(Integer userId, Integer loanId,String serialNo,
			Integer oldFlowNode,String oldStatus,Integer flowNode,
			String status, String conent, String accessoryImg, String remark) {
		super();
		this.userId = userId;
		this.loanId = loanId;
		this.serialNo = serialNo;
		this.oldFlowNode = oldFlowNode;
		this.oldStatus = oldStatus;
		this.flowNode = flowNode;
		this.status = status;
		this.conent = conent;
		this.accessoryImg = accessoryImg;
		this.remark = remark;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Integer getFlowNode() {
        return flowNode;
    }

    public void setFlowNode(Integer flowNode) {
        this.flowNode = flowNode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getConent() {
        return conent;
    }

    public void setConent(String conent) {
        this.conent = conent == null ? null : conent.trim();
    }

    public String getAccessoryImg() {
        return accessoryImg;
    }

    public void setAccessoryImg(String accessoryImg) {
        this.accessoryImg = accessoryImg == null ? null : accessoryImg.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getAuditingTime() {
        return auditingTime;
    }

    public void setAuditingTime(Date auditingTime) {
        this.auditingTime = auditingTime;
    }

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getOldFlowNode() {
		return oldFlowNode;
	}

	public void setOldFlowNode(Integer oldFlowNode) {
		this.oldFlowNode = oldFlowNode;
	}

	public String getOldStatus() {
		return oldStatus;
	}

	public void setOldStatus(String oldStatus) {
		this.oldStatus = oldStatus;
	}

	@Override
	public String toString() {
		return "LoanAudit [id=" + id + ", userId=" + userId + ", loanId="
				+ loanId + ", serialNo=" + serialNo + ", oldFlowNode="
				+ oldFlowNode + ", oldStatus=" + oldStatus + ", flowNode="
				+ flowNode + ", status=" + status + ", conent=" + conent
				+ ", accessoryImg=" + accessoryImg + ", remark=" + remark
				+ ", auditingTime=" + auditingTime + "]";
	}


    
}