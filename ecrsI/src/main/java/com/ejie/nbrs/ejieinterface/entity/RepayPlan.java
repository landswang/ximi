package com.ejie.nbrs.ejieinterface.entity;


/**
 * 
 * RepayPlan 还款计划
 * 
 * @author torreswang
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月10日 下午6:41:13
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class RepayPlan {
  private int id;// 主键
  private String serialNo;// 业务流水号
  private int loanId;// 新网贷款编号
  private int index;// 分期数
  private String repaydate;// 还款日期/每月
  private float capital;// 本金
  private float interest;// 利息
  private float total;// 档期已还总额
  private String completeDate;// 本期完成日期，未完成则传递空字符
  private int pIndex;// 分期数

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  public int getLoanId() {
    return loanId;
  }

  public void setLoanId(int loanId) {
    this.loanId = loanId;
  }

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public String getRepaydate() {
    return repaydate;
  }

  public void setRepaydate(String repaydate) {
    this.repaydate = repaydate;
  }

  public float getCapital() {
    return capital;
  }

  public void setCapital(float capital) {
    this.capital = capital;
  }

  public float getInterest() {
    return interest;
  }

  public void setInterest(float interest) {
    this.interest = interest;
  }

  public float getTotal() {
    return total;
  }

  public void setTotal(float total) {
    this.total = total;
  }

  public String getCompleteDate() {
    return completeDate;
  }

  public void setCompleteDate(String completeDate) {
    this.completeDate = completeDate;
  }


  public int getpIndex() {
    return pIndex;
  }

  public void setpIndex(int pIndex) {
    this.pIndex = pIndex;
  }

  @Override
  public String toString() {
    return "RepayPlan [id=" + id + ", serialNo=" + serialNo + ", loanId=" + loanId + ", index="
        + index + ", repaydate=" + repaydate + ", capital=" + capital + ", interest=" + interest
        + ", total=" + total + ", completeDate=" + completeDate + ", pIndex=" + pIndex + "]";
  }



}
