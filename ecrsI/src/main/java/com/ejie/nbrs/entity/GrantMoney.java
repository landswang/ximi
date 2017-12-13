package com.ejie.nbrs.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * ClassName:GrantMoney 放款信息
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月16日 下午8:25:02
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class GrantMoney {
  /**
   * 主键id
   */
  private Integer id;
  /**
   * 实际放款金额
   */
  private BigDecimal realLoanMoney;
  /**
   * 放款模式
   */
  private String loanMethod;
  /**
   * 放款日期
   */
  private Date loanDate;
  /**
   * 放款凭证
   */
  private String loanImage;
  /**
   * 还款方式
   */
  private String repaymentMethod;
  /**
   * 还款期限
   */
  private String repaymentLimit;
  /**
   * 卡号
   */
  private String repaymentCardNumber;
  /**
   * 开户行
   */
  private String repaymentBank;
  /**
   * 持卡人
   */
  private String cardholder;
  /**
   * 备注
   */
  private String remark;
  /**
   * 贷款编号
   */
  private Integer loanId;


  private String serialNo;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public BigDecimal getRealLoanMoney() {
    return realLoanMoney;
  }



  public void setRealLoanMoney(BigDecimal realLoanMoney) {
    this.realLoanMoney = realLoanMoney;
  }

  public String getLoanMethod() {
    return loanMethod;
  }

  public void setLoanMethod(String loanMethod) {
    this.loanMethod = loanMethod == null ? null : loanMethod.trim();
  }

  public Date getLoanDate() {
    return loanDate;
  }

  public void setLoanDate(Date loanDate) {
    this.loanDate = loanDate;
  }

  public String getLoanImage() {
    return loanImage;
  }

  public void setLoanImage(String loanImage) {
    this.loanImage = loanImage == null ? null : loanImage.trim();
  }

  public String getRepaymentMethod() {
    return repaymentMethod;
  }

  public void setRepaymentMethod(String repaymentMethod) {
    this.repaymentMethod = repaymentMethod == null ? null : repaymentMethod.trim();
  }

  public String getRepaymentLimit() {
    return repaymentLimit;
  }

  public void setRepaymentLimit(String repaymentLimit) {
    this.repaymentLimit = repaymentLimit == null ? null : repaymentLimit.trim();
  }

  public String getRepaymentCardNumber() {
    return repaymentCardNumber;
  }

  public void setRepaymentCardNumber(String repaymentCardNumber) {
    this.repaymentCardNumber = repaymentCardNumber == null ? null : repaymentCardNumber.trim();
  }

  public String getRepaymentBank() {
    return repaymentBank;
  }

  public void setRepaymentBank(String repaymentBank) {
    this.repaymentBank = repaymentBank == null ? null : repaymentBank.trim();
  }

  public String getCardholder() {
    return cardholder;
  }

  public void setCardholder(String cardholder) {
    this.cardholder = cardholder == null ? null : cardholder.trim();
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  public Integer getLoanId() {
    return loanId;
  }

  public void setLoanId(Integer loanId) {
    this.loanId = loanId;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  @Override
  public String toString() {
    return "GrantMoney [id=" + id + ", realLoanMoney=" + realLoanMoney + ", loanMethod="
        + loanMethod + ", loanDate=" + loanDate + ", loanImage=" + loanImage + ", repaymentMethod="
        + repaymentMethod + ", repaymentLimit=" + repaymentLimit + ", repaymentCardNumber="
        + repaymentCardNumber + ", repaymentBank=" + repaymentBank + ", cardholder=" + cardholder
        + ", remark=" + remark + ", loanId=" + loanId + ", serialNo=" + serialNo + "]";
  }


}
