package com.ejie.nbrs.ejieinterface.entity;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * ClassName:EjieLoan
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月10日 上午9:39:15
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class NewOrder {


  private String loanId;
  private String status;
  private int id;

  /**
   * 还款期限
   */
  private int loanLimit;
  /**
   * 业务流水号（唯一）
   */
  private String serialNo;
  /**
   * city
   */
  private String city;
  /**
   * 申请日期
   */
  private String loanDate;
  /**
   * 客户姓名
   */
  private String realName;
  /**
   * 申请金额 （初审贷款金额（万）
   */
  private BigDecimal loanAmount;
  /**
   * 还款方式
   */
  private String repayMethod;
  /**
   * 贷款产品（如房贷一抵，押车贷等）
   */
  private String garantyType;
  /**
   * 利率
   */
  private float loanRate;

  private Date getTime;


  private String createTime;

  private Date modifyTime;

  private String channelCode;// '进件渠道代码：1804 新网 1802：外贸信托 1807 ： 四川信托';
  private String sendDate;// 推送时间

  public NewOrder() {

    // TODO Auto-generated constructor stub

  }

  public NewOrder(String loanid, String serid) {
    this.loanId = loanid;
    this.serialNo = serid;
  }

  //
  /* 以下是get、set方法 */



  public Date getGetTime() {
    return getTime;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public Date getModifyTime() {
    return modifyTime;
  }

  public void setModifyTime(Date modifyTime) {
    this.modifyTime = modifyTime;
  }

  public String getLoanId() {
    return loanId;
  }

  public void setLoanId(String loanId) {
    this.loanId = loanId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setGetTime(Date getTime) {
    this.getTime = getTime;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getLoanLimit() {
    return loanLimit;
  }

  public String getGarantyType() {
    return garantyType;
  }

  public void setGarantyType(String garantyType) {
    this.garantyType = garantyType;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public float getLoanRate() {
    return loanRate;
  }

  public void setLoanRate(float loanRate) {
    this.loanRate = loanRate;
  }

  public void setLoanLimit(int loanLimit) {
    this.loanLimit = loanLimit;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  public BigDecimal getLoanAmount() {
    return loanAmount;
  }

  public void setLoanAmount(BigDecimal loanAmount) {
    this.loanAmount = loanAmount;
  }

  public String getRepayMethod() {
    return repayMethod;
  }

  public void setRepayMethod(String repayMethod) {
    this.repayMethod = repayMethod;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getLoanDate() {
    return loanDate;
  }

  public void setLoanDate(String loanDate) {
    this.loanDate = loanDate;
  }

  /**
   * @return the channelCodes
   */
  public String getChannelCodes() {
    return channelCode;
  }

  /**
   * @param channelCodes the channelCodes to set
   */
  public void setChannelCodes(String channelCodes) {
    this.channelCode = channelCodes;
  }

  public String getChannelCode() {
    return channelCode;
  }

  public void setChannelCode(String channelCode) {
    this.channelCode = channelCode;
  }

  public String getSendDate() {
    return sendDate;
  }

  public void setSendDate(String sendDate) {
    this.sendDate = sendDate;
  }

  @Override
  public String toString() {
    return "NewOrder [loanId=" + loanId + ", status=" + status + ", id=" + id + ", loanLimit="
        + loanLimit + ", serialNo=" + serialNo + ", city=" + city + ", loanDate=" + loanDate
        + ", realName=" + realName + ", loanAmount=" + loanAmount + ", repayMethod=" + repayMethod
        + ", garantyType=" + garantyType + ", loanRate=" + loanRate + ", getTime=" + getTime
        + ", createTime=" + createTime + ", modifyTime=" + modifyTime + ", channelCode="
        + channelCode + ", sendDate=" + sendDate + "]";
  }



}
