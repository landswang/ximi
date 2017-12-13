package com.ejie.nbrs.ejieinterface.dto;

import java.util.List;

/**
 * 
 * ClassName:DepositConfirm 放款确认
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月10日 下午6:47:01
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class DepositConfirm {
  private String serialNo;
  private String platformNo;
  private String contractNo;
  private float loanAmount;
  private String loanDate;
  private int repayLimit;
  private String repayMethod;
  private String loanModel;
  private float loanRate;
  private String bankNumber;
  private String bankName;
  private String bankBranch;
  private String bankUser;
  private String bankIdno;
  private List screenShots;
  private String title;
  private String url;

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  public String getPlatformNo() {
    return platformNo;
  }

  public void setPlatformNo(String platformNo) {
    this.platformNo = platformNo;
  }

  public String getContractNo() {
    return contractNo;
  }

  public void setContractNo(String contractNo) {
    this.contractNo = contractNo;
  }

  public float getLoanAmount() {
    return loanAmount;
  }

  public void setLoanAmount(float loanAmount) {
    this.loanAmount = loanAmount;
  }

  public String getLoanDate() {
    return loanDate;
  }

  public void setLoanDate(String loanDate) {
    this.loanDate = loanDate;
  }

  public int getRepayLimit() {
    return repayLimit;
  }

  public void setRepayLimit(int repayLimit) {
    this.repayLimit = repayLimit;
  }

  public String getRepayMethod() {
    return repayMethod;
  }

  public void setRepayMethod(String repayMethod) {
    this.repayMethod = repayMethod;
  }

  public String getLoanModel() {
    return loanModel;
  }

  public void setLoanModel(String loanModel) {
    this.loanModel = loanModel;
  }

  public float getLoanRate() {
    return loanRate;
  }

  public void setLoanRate(float loanRate) {
    this.loanRate = loanRate;
  }

  public String getBankNumber() {
    return bankNumber;
  }

  public void setBankNumber(String bankNumber) {
    this.bankNumber = bankNumber;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getBankBranch() {
    return bankBranch;
  }

  public void setBankBranch(String bankBranch) {
    this.bankBranch = bankBranch;
  }

  public String getBankUser() {
    return bankUser;
  }

  public void setBankUser(String bankUser) {
    this.bankUser = bankUser;
  }

  public String getBankIdno() {
    return bankIdno;
  }

  public void setBankIdno(String bankIdno) {
    this.bankIdno = bankIdno;
  }

  public List getScreenShots() {
    return screenShots;
  }

  public void setScreenShots(List screenShots) {
    this.screenShots = screenShots;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public String toString() {
    return "Ejie06 [serialNo=" + serialNo + ", platformNo=" + platformNo + ", contractNo="
        + contractNo + ", loanAmount=" + loanAmount + ", loanDate=" + loanDate + ", repayLimit="
        + repayLimit + ", repayMethod=" + repayMethod + ", loanModel=" + loanModel + ", loanRate="
        + loanRate + ", bankNumber=" + bankNumber + ", bankName=" + bankName + ", bankBranch="
        + bankBranch + ", bankUser=" + bankUser + ", bankIdno=" + bankIdno + ", screenShots="
        + screenShots + ", title=" + title + ", url=" + url + "]";
  }

}
