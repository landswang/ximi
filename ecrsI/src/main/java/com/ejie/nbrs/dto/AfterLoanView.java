package com.ejie.nbrs.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.ejie.nbrs.ejieinterface.entity.RepaymentSchedule;

public class AfterLoanView {
  private String name;

  private Integer loanId;

  private String eProduct;

  private String city;

  private BigDecimal loanMoney;

  private Integer periods;

  private String repayWay;

  private String rate;

  private Date finalTransferDate;

  private String idNumber;

  private String cCardNumber;

  private String cCardBank;

  private String cCardName;

  private String loanMethod;

  private String remark;

  private RepaymentSchedule repaymentSchedule;

  private Integer nodeStatus;

  private Integer flowStatus;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getLoanId() {
    return loanId;
  }

  public void setLoanId(Integer loanId) {
    this.loanId = loanId;
  }

  public String geteProduct() {
    return eProduct;
  }

  public void seteProduct(String eProduct) {
    this.eProduct = eProduct;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public BigDecimal getLoanMoney() {
    return loanMoney;
  }

  public void setLoanMoney(BigDecimal loanMoney) {
    this.loanMoney = loanMoney;
  }

  public Integer getPeriods() {
    return periods;
  }

  public void setPeriods(Integer periods) {
    this.periods = periods;
  }

  public String getRepayWay() {
    return repayWay;
  }

  public void setRepayWay(String repayWay) {
    this.repayWay = repayWay;
  }

  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public Date getFinalTransferDate() {
    return finalTransferDate;
  }

  public void setFinalTransferDate(Date finalTransferDate) {
    this.finalTransferDate = finalTransferDate;
  }

  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }

  public String getcCardNumber() {
    return cCardNumber;
  }

  public void setcCardNumber(String cCardNumber) {
    this.cCardNumber = cCardNumber;
  }

  public String getcCardBank() {
    return cCardBank;
  }

  public void setcCardBank(String cCardBank) {
    this.cCardBank = cCardBank;
  }

  public String getcCardName() {
    return cCardName;
  }

  public void setcCardName(String cCardName) {
    this.cCardName = cCardName;
  }

  public String getLoanMethod() {
    return loanMethod;
  }

  public void setLoanMethod(String loanMethod) {
    this.loanMethod = loanMethod;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public RepaymentSchedule getRepaymentSchedule() {
    return repaymentSchedule;
  }

  public void setRepaymentSchedule(RepaymentSchedule repaymentSchedule) {
    this.repaymentSchedule = repaymentSchedule;
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

  @Override
  public String toString() {
    return "AfterLoanView [name=" + name + ", loanId=" + loanId + ", eProduct=" + eProduct
        + ", city=" + city + ", loanMoney=" + loanMoney + ", periods=" + periods + ", repayWay="
        + repayWay + ", rate=" + rate + ", finalTransferDate=" + finalTransferDate + ", idNumber="
        + idNumber + ", cCardNumber=" + cCardNumber + ", cCardBank=" + cCardBank + ", cCardName="
        + cCardName + ", loanMethod=" + loanMethod + ", remark=" + remark + ", repaymentSchedule="
        + repaymentSchedule + ", nodeStatus=" + nodeStatus + ", flowStatus=" + flowStatus + "]";
  }



}
