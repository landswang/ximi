package com.ejie.nbrs.entity;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * GuaranteeValue 抵押物价值
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月12日 上午11:17:01
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class GuaranteeValue {
  /**
   * 抵押物价值主键
   */
  private Integer guaVId;
  /**
   * 押品原值
   */
  private BigDecimal oldValue;

  /**
   * ejie评估价值
   */
  private BigDecimal ejieComfirmValue;
  /**
   * 世联确认价值
   */
  private BigDecimal wuComfirmValue;
  /**
   * 我行评估价值
   */
  private BigDecimal nbComfirmValue;
  /**
   * 易捷抵押率
   */
  private float gRate;
  /**
   * 世联抵押率
   */
  private float wuRate;// wu_rate
  /**
   * 我行评估抵押率
   */
  private float nbCRate;
  /**
   * 确认时间
   */
  private Date comfirmDate;
  /**
   * 押品状态
   */
  private String gStatus;


  /**
   * 抵押物id
   */
  private String guaranteeId;
  /**
   * 抵押物id
   */
  private String serialNo;



  public GuaranteeValue() {}

  public GuaranteeValue(String guaranteeId, float comfirmValue, float ejieValue, float wuRate,
      float gRate, int gStatus, String serialNo) {
    this.guaranteeId = guaranteeId;
    this.ejieComfirmValue = BigDecimal.valueOf(ejieValue);
    this.wuComfirmValue = BigDecimal.valueOf(comfirmValue);
    this.wuRate = wuRate;
    this.gRate = gRate;
    this.gStatus = "" + gStatus;
    this.serialNo = serialNo;
  }

  public GuaranteeValue(String guaranteeId, float comfirmValue, int gStatus) {
    this.guaranteeId = guaranteeId;
    this.ejieComfirmValue = BigDecimal.valueOf(comfirmValue);
    this.gStatus = "" + gStatus;
  }

  public Integer getGuaVId() {
    return guaVId;
  }

  public void setGuaVId(Integer guaVId) {
    this.guaVId = guaVId;
  }

  public BigDecimal getOldValue() {
    return oldValue;
  }

  public void setOldValue(BigDecimal oldValue) {
    this.oldValue = oldValue;
  }

  public float getWuRate() {
    return wuRate;
  }

  public void setWuRate(float wuRate) {
    this.wuRate = wuRate;
  }

  public BigDecimal getEjieComfirmValue() {
    return ejieComfirmValue;
  }

  public void setEjieComfirmValue(BigDecimal ejieComfirmValue) {
    this.ejieComfirmValue = ejieComfirmValue;
  }



  public Date getComfirmDate() {
    return comfirmDate;
  }

  public void setComfirmDate(Date comfirmDate) {
    this.comfirmDate = comfirmDate;
  }

  public String getgStatus() {
    return gStatus;
  }

  public void setgStatus(String gStatus) {
    this.gStatus = gStatus;
  }

  public float getgRate() {
    return gRate;
  }

  public void setgRate(float gRate) {
    this.gRate = gRate;
  }

  public String getGuaranteeId() {
    return guaranteeId;
  }

  public void setGuaranteeId(String guaranteeId) {
    this.guaranteeId = guaranteeId;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  public BigDecimal getWuComfirmValue() {
    return wuComfirmValue;
  }

  public void setWuComfirmValue(BigDecimal wuComfirmValue) {
    this.wuComfirmValue = wuComfirmValue;
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
    return "GuaranteeValue [guaVId=" + guaVId + ", oldValue=" + oldValue + ", ejieComfirmValue="
        + ejieComfirmValue + ", wuComfirmValue=" + wuComfirmValue + ", nbComfirmValue="
        + nbComfirmValue + ", gRate=" + gRate + ", wuRate=" + wuRate + ", nbCRate=" + nbCRate
        + ", comfirmDate=" + comfirmDate + ", gStatus=" + gStatus + ", guaranteeId=" + guaranteeId
        + ", serialNo=" + serialNo + "]";
  }

}
