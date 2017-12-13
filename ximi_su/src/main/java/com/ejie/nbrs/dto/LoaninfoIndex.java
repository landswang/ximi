package com.ejie.nbrs.dto;

import java.math.BigDecimal;
import java.util.Date;

public class LoaninfoIndex {
  private Integer loanId;

  private String serialNo;

  private Date appDate;

  private String eProduct;

  private String city;

  private Integer status;

  private String name;

  private String idNumber;

  private BigDecimal appMoney;

  private String rate;

  private String repayWay;

  private BigDecimal ejieComfirmValue;

  private Float gRate;

  private Date grantCreditDate;

  private Date giveMoenyDate;// 放款审核时间

  private Date finalTransferDate;
  /**
   * 节点标记码(1001：授信初审；1002：授信复审；1003：放款初审； 1004：放款复审；1005：放款终审；1006：放款确认)
   */
  private Integer nodeStatus;
  /**
   * 流程状态码(0:默认;1:通过;2:拒绝)
   */
  private Integer flowStatus;
  /**
   *   接收时间：
   */
  private Date receiveTime;

  /**
   * 被操作的时间/审核时间
   */
  private Date auditingTime;
  /**
   * 我行抵押物评估总额
   */
  private BigDecimal nbComfirmValue;
  /**
   * 我行抵押率
   */
  private float nbCRate;


  private Integer channelCode;


  public Integer getChannelCode() {
    return channelCode;
  }

  public void setChannelCode(Integer channelCode) {
    this.channelCode = channelCode;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  public Integer getLoanId() {
    return loanId;
  }

  public void setLoanId(Integer loanId) {
    this.loanId = loanId;
  }

  public Date getAppDate() {
    return appDate;
  }

  public void setAppDate(Date appDate) {
    this.appDate = appDate;
  }

  public String geteProduct() {
    return eProduct;
  }

  public void seteProduct(String eProduct) {
    this.eProduct = eProduct == null ? null : eProduct.trim();
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city == null ? null : city.trim();
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber == null ? null : idNumber.trim();
  }

  public BigDecimal getAppMoney() {
    return appMoney;
  }

  public void setAppMoney(BigDecimal appMoney) {
    this.appMoney = appMoney;
  }

  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate == null ? null : rate.trim();
  }

  public String getRepayWay() {
    return repayWay;
  }

  public void setRepayWay(String repayWay) {
    this.repayWay = repayWay == null ? null : repayWay.trim();
  }

  public BigDecimal getEjieComfirmValue() {
    return ejieComfirmValue;
  }

  public void setEjieComfirmValue(BigDecimal ejieComfirmValue) {
    this.ejieComfirmValue = ejieComfirmValue;
  }

  public Float getgRate() {
    return gRate;
  }

  public void setgRate(Float gRate) {
    this.gRate = gRate;
  }

  public Date getGrantCreditDate() {
    return grantCreditDate;
  }

  public void setGrantCreditDate(Date grantCreditDate) {
    this.grantCreditDate = grantCreditDate;
  }

  public Date getGiveMoenyDate() {
    return giveMoenyDate;
  }

  public void setGiveMoenyDate(Date giveMoenyDate) {
    this.giveMoenyDate = giveMoenyDate;
  }

  public Date getFinalTransferDate() {
    return finalTransferDate;
  }

  public void setFinalTransferDate(Date finalTransferDate) {
    this.finalTransferDate = finalTransferDate;
  }

  public Integer getNodeStatus() {
    return nodeStatus;
  }

  public void setNodeStatus(Integer nodeStatus) {
    this.nodeStatus = nodeStatus;
  }

  public Integer getFlowStatus() {
    return flowStatus;
  }

  public void setFlowStatus(Integer flowStatus) {
    this.flowStatus = flowStatus;
  }

  public Date getAuditingTime() {
    return auditingTime;
  }

  public void setAuditingTime(Date auditingTime) {
    this.auditingTime = auditingTime;
  }

  public BigDecimal getNbComfirmValue() {
    return nbComfirmValue;
  }

  public void setNbComfirmValue(BigDecimal nbComfirmValue) {
    this.nbComfirmValue = nbComfirmValue;
  }

  public float getNbCRate() {
    return nbCRate;
  }

  public void setNbCRate(float nbCRate) {
    this.nbCRate = nbCRate;
  }
  

@Override
public String toString() {
	return "LoaninfoIndex [loanId=" + loanId + ", serialNo=" + serialNo
			+ ", appDate=" + appDate + ", eProduct=" + eProduct + ", city="
			+ city + ", status=" + status + ", name=" + name + ", idNumber="
			+ idNumber + ", appMoney=" + appMoney + ", rate=" + rate
			+ ", repayWay=" + repayWay + ", ejieComfirmValue="
			+ ejieComfirmValue + ", gRate=" + gRate + ", grantCreditDate="
			+ grantCreditDate + ", giveMoenyDate=" + giveMoenyDate
			+ ", finalTransferDate=" + finalTransferDate + ", nodeStatus="
			+ nodeStatus + ", flowStatus=" + flowStatus + ", receiveTime="
			+ receiveTime + ", auditingTime=" + auditingTime
			+ ", nbComfirmValue=" + nbComfirmValue + ", nbCRate=" + nbCRate
			+ ", channelCode=" + channelCode + "]";
}

public Date getReceiveTime() {
	return receiveTime;
}

public void setReceiveTime(Date receiveTime) {
	this.receiveTime = receiveTime;
}



}
