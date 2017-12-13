package com.ejie.nbrs.entity;

import java.math.BigDecimal;
import java.util.Date;

public class LoanInfo {
  /**
   * 贷款编号——主键
   */
  private Integer loanId;
  /**
   * 业务城市
   */
  private String city;
  /**
   * 申请时间
   */
  private Date appDate;
  /**
   * 贷款产品
   */
  private String eProduct;
  /**
   * 还款方式
   */
  private String repayWay;
  /**
   * 申请金额
   */
  private BigDecimal appMoney;
  /**
   * 平台及利率
   */
  private String rate;
  /**
   * 期数
   */
  private Integer periods;
  /**
   * 资金用途
   */
  private String loanPurpose;
  /**
   * 下款总额
   */
  private BigDecimal loanMoney;
  /**
   * 主借人id
   */
  private Integer aBaseId;
  /**
   * 共借人id
   */
  private Integer cAInfoId;
  /**
   * 卡号
   */
  private String cCardNumber;
  /**
   * 开户行
   */
  private String cCardBank;
  /**
   * 持卡人
   */
  private String cCardName;
  /**
   * 放款方式
   */
  private String loanMethod;
  /**
   * 当前状态: 0 ：授信终审-待审核 ，1：授信终审-通过/待放款审批， 2：授信终审-未通过，3：放款审批-通过/待放款，4：放款审批-未通过 ，5：放款确认-已放款，6：放款确认-拒绝放款
   */
  private Integer status;
  /**
   * 放款凭证
   */
  private String payCertificate;
  /**
   * 放款时间
   */
  private String loanDate;
  /**
   * 授信审核时间
   */
  private String grantCreditDate;
  /**
   * 放款审核时间
   */
  private Date giveMoenyDate;
  /**
   * 放款时间
   */
  private Date finalTransferDate;
  /**
   * 备注
   */
  private String remark;
  /**
   * 抵押对象 单位or个人
   */
  private String guaranteeObject;
  /**
   * 授信审核人
   */
  private String grantAutidUser;
  /**
   * 放款审批人
   */
  private String giveMoenyUser;
  /**
   * 放款确认人
   */
  private String finalTransferUser;
  /**
   * 流水号
   */
  private String serialno;
  /**
   * 抵押物id
   */
  private String guaranteeId;
  private String branchBank;
  private String repayCardNo;// 还款银行账号
  private String repayCardBank;// 还款银行名称
  private String repayCardBranck;// 还款支行
  private String repayCardUser; // 还款持卡人
  private String realName;// 贷款人姓名
  private String garantyType;// 贷款产品
  private Integer channelCode;// 渠道代码 1802：外贸信托，1804：新网银行
  private String ejieSendTime;// 贷款产品



  /**
   * 节点码
   */
  private Integer nodeStatus;
  /**
   * 状态码
   */
  private Integer flowStatus;

  /**
   * @return the realName
   */
  public String getRealName() {
    return realName;
  }

  /**
   * @param realName the realName to set
   */
  public void setRealName(String realName) {
    this.realName = realName;
  }

  public Integer getChannelCode() {
    return channelCode;
  }

  public void setChannelCode(Integer channelCode) {
    this.channelCode = channelCode;
  }

  /**
   * @return the garantyType
   */
  public String getGarantyType() {
    return garantyType;
  }

  public String getEjieSendTime() {
    return ejieSendTime;
  }

  public void setEjieSendTime(String ejieSendTime) {
    this.ejieSendTime = ejieSendTime;
  }

  /**
   * @param garantyType the garantyType to set
   */
  public void setGarantyType(String garantyType) {
    this.garantyType = garantyType;
  }

  public String getSerialno() {
    return serialno;
  }

  public void setSerialno(String serialno) {
    this.serialno = serialno;
  }

  public String getBranchBank() {
    return branchBank;
  }

  public void setBranchBank(String branchBank) {
    this.branchBank = branchBank;
  }

  public Integer getLoanId() {
    return loanId;
  }

  public void setLoanId(Integer loanId) {
    this.loanId = loanId;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city == null ? null : city.trim();
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

  public String getRepayWay() {
    return repayWay;
  }

  public void setRepayWay(String repayWay) {
    this.repayWay = repayWay == null ? null : repayWay.trim();
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

  public Integer getPeriods() {
    return periods;
  }

  public void setPeriods(Integer periods) {
    this.periods = periods;
  }

  public String getLoanPurpose() {
    return loanPurpose;
  }

  public void setLoanPurpose(String loanPurpose) {
    this.loanPurpose = loanPurpose == null ? null : loanPurpose.trim();
  }

  public BigDecimal getLoanMoney() {
    return loanMoney;
  }

  public void setLoanMoney(BigDecimal loanMoney) {
    this.loanMoney = loanMoney;
  }

  public Integer getaBaseId() {
    return aBaseId;
  }

  public void setaBaseId(Integer aBaseId) {
    this.aBaseId = aBaseId;
  }

  public Integer getcAInfoId() {
    return cAInfoId;
  }

  public void setcAInfoId(Integer cAInfoId) {
    this.cAInfoId = cAInfoId;
  }

  public String getcCardNumber() {
    return cCardNumber;
  }

  public void setcCardNumber(String cCardNumber) {
    this.cCardNumber = cCardNumber == null ? null : cCardNumber.trim();
  }

  public String getcCardBank() {
    return cCardBank;
  }

  public void setcCardBank(String cCardBank) {
    this.cCardBank = cCardBank == null ? null : cCardBank.trim();
  }

  public String getcCardName() {
    return cCardName;
  }

  public void setcCardName(String cCardName) {
    this.cCardName = cCardName == null ? null : cCardName.trim();
  }

  public String getLoanMethod() {
    return loanMethod;
  }

  public void setLoanMethod(String loanMethod) {
    this.loanMethod = loanMethod == null ? null : loanMethod.trim();
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getPayCertificate() {
    return payCertificate;
  }

  public void setPayCertificate(String payCertificate) {
    this.payCertificate = payCertificate == null ? null : payCertificate.trim();
  }

  public String getLoanDate() {
    return loanDate;
  }

  public void setLoanDate(String loanDate) {
    this.loanDate = loanDate == null ? null : loanDate.trim();
  }

  public String getGrantCreditDate() {
    return grantCreditDate;
  }

  public void setGrantCreditDate(String grantCreditDate) {
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

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  public String getGuaranteeObject() {
    return guaranteeObject;
  }

  public void setGuaranteeObject(String guaranteeObject) {
    this.guaranteeObject = guaranteeObject == null ? null : guaranteeObject.trim();
  }

  public String getGrantAutidUser() {
    return grantAutidUser;
  }

  public void setGrantAutidUser(String grantAutidUser) {
    this.grantAutidUser = grantAutidUser == null ? null : grantAutidUser.trim();
  }

  public String getGiveMoenyUser() {
    return giveMoenyUser;
  }

  public void setGiveMoenyUser(String giveMoenyUser) {
    this.giveMoenyUser = giveMoenyUser == null ? null : giveMoenyUser.trim();
  }

  public String getFinalTransferUser() {
    return finalTransferUser;
  }

  public void setFinalTransferUser(String finalTransferUser) {
    this.finalTransferUser = finalTransferUser == null ? null : finalTransferUser.trim();
  }

  public String getSerialNo() {
    return serialno;
  }

  public void setSerialNo(String serialno) {
    this.serialno = serialno == null ? null : serialno.trim();
  }

  public String getGuaranteeId() {
    return guaranteeId;
  }

  public void setGuaranteeId(String guaranteeId) {
    this.guaranteeId = guaranteeId == null ? null : guaranteeId.trim();
  }

  public String getRepayCardNo() {
    return repayCardNo;
  }

  public void setRepayCardNo(String repayCardNo) {
    this.repayCardNo = repayCardNo;
  }

  public String getRepayCardBank() {
    return repayCardBank;
  }

  public void setRepayCardBank(String repayCardBank) {
    this.repayCardBank = repayCardBank;
  }

  public String getRepayCardBranck() {
    return repayCardBranck;
  }

  public void setRepayCardBranck(String repayCardBranck) {
    this.repayCardBranck = repayCardBranck;
  }

  public String getRepayCardUser() {
    return repayCardUser;
  }

  public void setRepayCardUser(String repayCardUser) {
    this.repayCardUser = repayCardUser;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  // @Override
  // public String toString() {
  // return "LoanInfo [loanId=" + loanId + ", city=" + city + ", appDate=" + appDate + ", eProduct="
  // + eProduct + ", repayWay=" + repayWay + ", appMoney=" + appMoney + ", rate=" + rate
  // + ", periods=" + periods + ", loanPurpose=" + loanPurpose + ", loanMoney=" + loanMoney
  // + ", aBaseId=" + aBaseId + ", cAInfoId=" + cAInfoId + ", cCardNumber=" + cCardNumber
  // + ", cCardBank=" + cCardBank + ", cCardName=" + cCardName + ", loanMethod=" + loanMethod
  // + ", status=" + status + ", payCertificate=" + payCertificate + ", loanDate=" + loanDate
  // + ", grantCreditDate=" + grantCreditDate + ", giveMoenyDate=" + giveMoenyDate
  // + ", finalTransferDate=" + finalTransferDate + ", remark=" + remark + ", guaranteeObject="
  // + guaranteeObject + ", grantAutidUser=" + grantAutidUser + ", giveMoenyUser="
  // + giveMoenyUser + ", finalTransferUser=" + finalTransferUser + ", serialno=" + serialno
  // + ", guaranteeId=" + guaranteeId + ", branchBank=" + branchBank + ", repayCardNo="
  // + repayCardNo + ", repayCardBank=" + repayCardBank + ", repayCardBranck=" + repayCardBranck
  // + ", repayCardUser=" + repayCardUser + ", realName=" + realName + ", garantyType="
  // + garantyType + ", channelCodes=" + channelCodes + ", getRealName()=" + getRealName()
  // + ", getGarantyType()=" + getGarantyType() + ", getChannelCodes()=" + getChannelCodes()
  // + ", getSerialno()=" + getSerialno() + ", getBranchBank()=" + getBranchBank()
  // + ", getLoanId()=" + getLoanId() + ", getCity()=" + getCity() + ", getAppDate()="
  // + getAppDate() + ", geteProduct()=" + geteProduct() + ", getRepayWay()=" + getRepayWay()
  // + ", getAppMoney()=" + getAppMoney() + ", getRate()=" + getRate() + ", getPeriods()="
  // + getPeriods() + ", getLoanPurpose()=" + getLoanPurpose() + ", getLoanMoney()="
  // + getLoanMoney() + ", getaBaseId()=" + getaBaseId() + ", getcAInfoId()=" + getcAInfoId()
  // + ", getcCardNumber()=" + getcCardNumber() + ", getcCardBank()=" + getcCardBank()
  // + ", getcCardName()=" + getcCardName() + ", getLoanMethod()=" + getLoanMethod()
  // + ", getStatus()=" + getStatus() + ", getPayCertificate()=" + getPayCertificate()
  // + ", getLoanDate()=" + getLoanDate() + ", getGrantCreditDate()=" + getGrantCreditDate()
  // + ", getGiveMoenyDate()=" + getGiveMoenyDate() + ", getFinalTransferDate()="
  // + getFinalTransferDate() + ", getRemark()=" + getRemark() + ", getGuaranteeObject()="
  // + getGuaranteeObject() + ", getGrantAutidUser()=" + getGrantAutidUser()
  // + ", getGiveMoenyUser()=" + getGiveMoenyUser() + ", getFinalTransferUser()="
  // + getFinalTransferUser() + ", getSerialNo()=" + getSerialNo() + ", getGuaranteeId()="
  // + getGuaranteeId() + ", getRepayCardNo()=" + getRepayCardNo() + ", getRepayCardBank()="
  // + getRepayCardBank() + ", getRepayCardBranck()=" + getRepayCardBranck()
  // + ", getRepayCardUser()=" + getRepayCardUser() + ", getClass()=" + getClass()
  // + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
  // }



  public LoanInfo() {}

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
    return "LoanInfo [loanId=" + loanId + ", city=" + city + ", appDate=" + appDate + ", eProduct="
        + eProduct + ", repayWay=" + repayWay + ", appMoney=" + appMoney + ", rate=" + rate
        + ", periods=" + periods + ", loanPurpose=" + loanPurpose + ", loanMoney=" + loanMoney
        + ", aBaseId=" + aBaseId + ", cAInfoId=" + cAInfoId + ", cCardNumber=" + cCardNumber
        + ", cCardBank=" + cCardBank + ", cCardName=" + cCardName + ", loanMethod=" + loanMethod
        + ", status=" + status + ", payCertificate=" + payCertificate + ", loanDate=" + loanDate
        + ", grantCreditDate=" + grantCreditDate + ", giveMoenyDate=" + giveMoenyDate
        + ", finalTransferDate=" + finalTransferDate + ", remark=" + remark + ", guaranteeObject="
        + guaranteeObject + ", grantAutidUser=" + grantAutidUser + ", giveMoenyUser="
        + giveMoenyUser + ", finalTransferUser=" + finalTransferUser + ", serialno=" + serialno
        + ", guaranteeId=" + guaranteeId + ", branchBank=" + branchBank + ", repayCardNo="
        + repayCardNo + ", repayCardBank=" + repayCardBank + ", repayCardBranck=" + repayCardBranck
        + ", repayCardUser=" + repayCardUser + ", realName=" + realName + ", garantyType="
        + garantyType + ", channelCode=" + channelCode + ", ejieSendTime=" + ejieSendTime
        + ", nodeStatus=" + nodeStatus + ", flowStatus=" + flowStatus + "]";
  }

  /**
   * 
   * Creates a new instance of LoanInfo
   * 
   * @param serialno
   * @param city
   * @param appDate
   * @param appMoney
   * @param repayWay
   * @param rate
   * @param periods
   * @param loan_purpose
   * @param a_base_id
   * @param c_card_number
   * @param c_card_bank
   * @param c_card_name
   * @param c_bank_name
   * @param guarantee_id
   * @param status
   * 
   *        private String repayCardNo;// 还款银行账号 private String repayCardBank;// 还款银行名称 private
   *        String repayCardBranck;// 还款支行 private String repayCardUser; // 还款持卡人
   */
  public LoanInfo(String serialno, String city, BigDecimal appMoney, String repayWay, String rate,
      Integer periods, String loan_purpose, Integer a_base_id, String c_card_number,
      String branchBank, String c_card_name, String c_bank_name, String guarantee_id,
      String repayCardNo, String repayCardUser, String repayCardBank, String repayCardBranck,
      String guaranteeObject, Integer channelCode) {// ,String realName,String garantyType) {
    this.serialno = serialno;
    this.city = city;
    this.appMoney = appMoney;
    // this.appDate = new Date();
    this.repayWay = repayWay;
    this.rate = rate;
    this.periods = periods;
    this.loanPurpose = loan_purpose;
    this.guaranteeObject = guaranteeObject;
    this.aBaseId = a_base_id;
    this.cCardNumber = c_card_number;
    this.cCardBank = c_bank_name;
    this.cCardName = c_card_name;
    this.guaranteeId = guarantee_id;
    this.status = 0;
    this.branchBank = branchBank;
    this.repayCardNo = repayCardNo;
    this.repayCardUser = repayCardUser;
    this.repayCardBank = repayCardBank;
    this.repayCardBranck = repayCardBranck;
    this.channelCode = channelCode;
    // this.realName=realName;
    // this.garantyType= realName;
  }
}
