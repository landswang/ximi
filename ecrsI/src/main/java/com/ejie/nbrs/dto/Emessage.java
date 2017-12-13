/**
 * Emessage.java com.ejie.nbrs.dto
 * 
 * Function： TODO
 * 
 * ver date author ────────────────────────────────── ver1.1 2017年8月3日 torreswang
 * 
 * Copyright (c) 2017, EJie All Rights Reserved.
 */
package com.ejie.nbrs.dto;

import java.util.Date;

/**
 * ClassName:系统消息
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017年8月3日 下午5:29:38
 * @see
 */
public class Emessage {
  /**
   * 消息标题
   */
  private String title;
  /**
   * 消息内容
   */
  private String content;
  /**
   * 消息类型        授信终审  0  放款审批1  放款确认 2  入库3  出库4  出入审批5
   */
  private int type; 
  /**
   * 发送者
   */
  private int sendUserId;
  /**
   * 接收者
   */
  private int receiveUserId;
  /**
   * 接收群组
   */
  private int receiveRoleId;
  /**
   * 目标连接
   */
  private String targetUrl;
  /**
   * 初生时间
   */
  private Date initTime;
  /**
   * 有效时间
   */
  private Date validTime;
  /**
   * 最后修改时间
   */
  private Date modifyTime;
  /**
   * 业务id 这里用贷款编号
   */
  
  private int loanId;
  /**
   * 消息状态 ：0 未读 1 已读
   */
  private int status;
  /**
   * 创建一条基础的消息 Creates a new base-message
   * @param initTime 消息生成时间
   * @param type 消息类型
   * @param title 消息标题
   * @param content 消息内容
   * @param sendUserId 发送者
   * @param receiveRoleId 接收者
   */
  public Emessage(Date initTime,int type,String title, String content, int sendUserId, int receiveRoleId) {
    this.title = title;
    this.content = content;
    this.sendUserId = sendUserId;
    this.receiveRoleId = receiveRoleId;
    this.initTime=initTime;
    this.type=type;
  }
  
  
  public Emessage(){}
/**
   * 创建一条基础的消息 Creates a new base-message
   * 
   * @param title 消息标题
   * @param content 消息内容
   * @param sendUserId 发送
   * @param receiveRoleId 接收者
   */
  public Emessage(String title, String content, int sendUserId, int receiveRoleId) {
    this.title = title;
    this.content = content;
    this.sendUserId = sendUserId;
    this.receiveRoleId = receiveRoleId;
  }

  /* getter setter */
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getSendUserId() {
    return sendUserId;
  }

  public void setSendUserId(int sendUserId) {
    this.sendUserId = sendUserId;
  }

  public int getReceiveUserId() {
    return receiveUserId;
  }

  public void setReceiveUserId(int receiveUserId) {
    this.receiveUserId = receiveUserId;
  }

  public int getReceiveRoleId() {
    return receiveRoleId;
  }

  public void setReceiveRoleId(int receiveRoleId) {
    this.receiveRoleId = receiveRoleId;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public Date getInitTime() {
    return initTime;
  }

  public void setInitTime(Date initTime) {
    this.initTime = initTime;
  }

  public Date getValidTime() {
    return validTime;
  }

  public void setValidTime(Date validTime) {
    this.validTime = validTime;
  }

  public Date getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(Date modifyTime) {
    this.modifyTime = modifyTime;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getTargetUrl() {
    return targetUrl;
  }

  public void setTargetUrl(String targetUrl) {
    this.targetUrl = targetUrl;
  }
  
  public int getLoanId() {
	return loanId;
}

public void setLoanId(int loanId) {
	this.loanId = loanId;
}

@Override
public String toString() {
	return "Emessage [title=" + title + ", content=" + content + ", type="
			+ type + ", sendUserId=" + sendUserId + ", receiveUserId="
			+ receiveUserId + ", receiveRoleId=" + receiveRoleId
			+ ", targetUrl=" + targetUrl + ", initTime=" + initTime
			+ ", validTime=" + validTime + ", modifyTime=" + modifyTime
			+ ", loanId=" + loanId + ", status=" + status + "]";
}

}
