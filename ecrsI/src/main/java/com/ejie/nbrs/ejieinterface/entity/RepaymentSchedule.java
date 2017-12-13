package com.ejie.nbrs.ejieinterface.entity;

import java.util.List;

/**
 * 
 * ClassName:RepaymentSchedule 还款计划
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月10日 下午6:41:13
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class RepaymentSchedule {
  private int loanId;// 贷款编号
  private String serialNo;// 业务流水号
  private float loanAmount;// 放款金额
  private String loanDate;// 放款日期（日期格式）
  private int repayLimit;// 还款期限
  private String repayMethod;// 还款方式
  private float loanRate;// 利率
  private String startDate;// 首期还款日
  private String lastDate;// 最后一期还款日
  private float leftCapital;// 剩余应还本金
  private float allOverdueDays;// 累计逾期天数
  private String clearDate;// 结清日期
  private String acquireDate;//获取时间戳
  private List<RepayPlan> plants;// 还款计划列表

  /**
 * @return the acquireDate
 */
public String getAcquireDate() {
	return acquireDate;
}

/**
 * @param acquireDate the acquireDate to set
 */
public void setAcquireDate(String acquireDate) {
	this.acquireDate = acquireDate;
}

public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
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

  public float getLoanRate() {
    return loanRate;
  }

  public void setLoanRate(float loanRate) {
    this.loanRate = loanRate;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getLastDate() {
    return lastDate;
  }

  public void setLastDate(String lastDate) {
    this.lastDate = lastDate;
  }

  public float getLeftCapital() {
    return leftCapital;
  }

  public void setLeftCapital(float leftCapital) {
    this.leftCapital = leftCapital;
  }

  public float getAllOverdueDays() {
    return allOverdueDays;
  }

  public void setAllOverdueDays(float allOverdueDays) {
    this.allOverdueDays = allOverdueDays;
  }

  public String getClearDate() {
    return clearDate;
  }

  public void setClearDate(String clearDate) {
    this.clearDate = clearDate;
  }

  public List<RepayPlan> getPlants() {
    return plants;
  }

  public void setPlants(List<RepayPlan> plants) {
    this.plants = plants;
  }

  /**
 * @return the loanId
 */
public int getLoanId() {
	return loanId;
}

/**
 * @param loanId the loanId to set
 */
public void setLoanId(int loanId) {
	this.loanId = loanId;
}

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "RepaymentSchedule [loanId=" + loanId + ", serialNo=" + serialNo
			+ ", loanAmount=" + loanAmount + ", loanDate=" + loanDate
			+ ", repayLimit=" + repayLimit + ", repayMethod=" + repayMethod
			+ ", loanRate=" + loanRate + ", startDate=" + startDate
			+ ", lastDate=" + lastDate + ", leftCapital=" + leftCapital
			+ ", allOverdueDays=" + allOverdueDays + ", clearDate=" + clearDate
			+ ", acquireDate=" + acquireDate + ", plants=" + plants + "]";
}


}
