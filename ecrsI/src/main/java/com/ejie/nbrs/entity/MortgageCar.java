package com.ejie.nbrs.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * ClassName:MortgageCar 抵押车
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月12日 上午11:17:28
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class MortgageCar {
  /**
   * 主键
   */
  private Integer mCId;
  /**
   * 抵押物评估值
   */
  private BigDecimal mcarValue;
  /**
   * mcar_id
   */
  private String mcarId;
  /**
   * 品牌
   */
  private String mcarBrand;
  /**
   * 型号
   */
  private String mcarVersion;
  /**
   * 车牌号
   */
  private String licensePlateNumber;
  /**
   * 车架号
   */
  private String mcarVin;
  /**
   * 发动机号
   */
  private String mcarEngineNumber;
  /**
   * 购买日期
   */
  private Date mcarBuyDate;
  /**
   * 购入价格
   */
  private BigDecimal mcarBuyPrice;
  /**
   * 状态（待入库、入库申请中、已入库、出库申请中、已出库）
   */
  private String status;
  /**
   * 权证信息id
   */
  private Integer warrantId;
  /**
   * 权证信息
   */
  private Warrant warrant;

  private String serialNo;

  public Integer getmCId() {
    return mCId;
  }

  public void setmCId(Integer mCId) {
    this.mCId = mCId;
  }

  public String getMcarId() {
    return mcarId;
  }

  public void setMcarId(String mcarId) {
    this.mcarId = mcarId == null ? null : mcarId.trim();
  }

  public String getMcarBrand() {
    return mcarBrand;
  }

  public void setMcarBrand(String mcarBrand) {
    this.mcarBrand = mcarBrand == null ? null : mcarBrand.trim();
  }

  public String getMcarVersion() {
    return mcarVersion;
  }

  public void setMcarVersion(String mcarVersion) {
    this.mcarVersion = mcarVersion == null ? null : mcarVersion.trim();
  }

  public String getLicensePlateNumber() {
    return licensePlateNumber;
  }

  public void setLicensePlateNumber(String licensePlateNumber) {
    this.licensePlateNumber = licensePlateNumber == null ? null : licensePlateNumber.trim();
  }

  public String getMcarVin() {
    return mcarVin;
  }

  public void setMcarVin(String mcarVin) {
    this.mcarVin = mcarVin == null ? null : mcarVin.trim();
  }

  public String getMcarEngineNumber() {
    return mcarEngineNumber;
  }

  public void setMcarEngineNumber(String mcarEngineNumber) {
    this.mcarEngineNumber = mcarEngineNumber == null ? null : mcarEngineNumber.trim();
  }

  public Date getMcarBuyDate() {
    return mcarBuyDate;
  }

  public void setMcarBuyDate(Date mcarBuyDate) {
    this.mcarBuyDate = mcarBuyDate;
  }

  public BigDecimal getMcarBuyPrice() {
    return mcarBuyPrice;
  }

  public void setMcarBuyPrice(BigDecimal mcarBuyPrice) {
    this.mcarBuyPrice = mcarBuyPrice;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status == null ? null : status.trim();
  }

  public Integer getWarrantId() {
    return warrantId;
  }

  public void setWarrantId(Integer warrantId) {
    this.warrantId = warrantId;
  }

  public BigDecimal getMcarValue() {
    return mcarValue;
  }

  public void setMcarValue(BigDecimal mcarValue) {
    this.mcarValue = mcarValue;
  }

  public Warrant getWarrant() {
    return warrant;
  }

  public void setWarrant(Warrant warrant) {
    this.warrant = warrant;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  @Override
  public String toString() {
    return "MortgageCar [mCId=" + mCId + ", mcarValue=" + mcarValue + ", mcarId=" + mcarId
        + ", mcarBrand=" + mcarBrand + ", mcarVersion=" + mcarVersion + ", licensePlateNumber="
        + licensePlateNumber + ", mcarVin=" + mcarVin + ", mcarEngineNumber=" + mcarEngineNumber
        + ", mcarBuyDate=" + mcarBuyDate + ", mcarBuyPrice=" + mcarBuyPrice + ", status=" + status
        + ", warrantId=" + warrantId + ", warrant=" + warrant + ", serialNo=" + serialNo + "]";
  }

}
