package com.ejie.nbrs.entity;


/**
 * 
 * ClassName:Guarantee 抵押物
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月12日 上午11:17:01
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class Guarantee extends GuaranteeKey {
/**
 * 主键
 */
  private Integer id;
/**
 * 抵押物总id
 */
  private String guaranteeId;
/**
 * 贷款编号
 */
  private Integer loanId;
/**
 * 抵押房总id
 */
  private String mhouseId;
/**
 * 抵押车总id
 */
  private String mcarId;
  
  private String serialNo;
  
  public Guarantee(){}
  
  public Guarantee(String guaranteeId, Integer i, String mhouseId, String mcarId, String serialNo) {
    this.guaranteeId = guaranteeId;
    this.loanId = i;
    this.mhouseId = mhouseId;
    this.mcarId = mcarId;
    this.serialNo = serialNo;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getGuaranteeId() {
    return guaranteeId;
  }

  public void setGuaranteeId(String guaranteeId) {
    this.guaranteeId = guaranteeId;
  }

  public Integer getLoanId() {
    return loanId;
  }

  public void setLoanId(Integer loanId) {
    this.loanId = loanId;
  }

  public String getMhouseId() {
    return mhouseId;
  }

  public void setMhouseId(String mhouseId) {
    this.mhouseId = mhouseId;
  }

  public String getMcarId() {
    return mcarId;
  }

  public void setMcarId(String mcarId) {
    this.mcarId = mcarId;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  @Override
  public String toString() {
    return "Guarantee [id=" + id + ", guaranteeId=" + guaranteeId + ", loanId=" + loanId
        + ", mhouseId=" + mhouseId + ", mcarId=" + mcarId + ", serialNo=" + serialNo + "]";
  }



}
