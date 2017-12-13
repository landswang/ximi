package com.ejie.nbrs.entity;

import java.math.BigDecimal;

/**
 * 
 * ClassName:MortgageHouse 抵押房
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月12日 上午11:17:12
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class MortgageHouse {
  /**
   * 主键
   */
  private Integer mHId;
  /**
   * 抵押房编号
   */
  private String mhouseId;
  /**
   * 抵押品类别
   */
  private String gCategory;
  /**
   * 抵押物评估值
   */
  private BigDecimal mhouseValue;
  /**
   * 产权证号
   */
  private String propertyRightNumber;
  /**
   * 产权人
   */
  private String propertyOwner;
  /**
   * 面积
   */
  private BigDecimal acreage;
  /**
   * 产权地址
   */
  private String gAddress;
  /**
   * 押品土地性质
   */
  private String andStatus;
  /**
   * 房屋区域
   */
  private String houseArea;
  /**
   * 土地证书
   */
  private String landCertificate;
  /**
   * 获取方式
   */
  private String getMethod;
  /**
   * 权证信息id
   */
  private Integer warrantId;
  /**
   * 状态(待入库、入库申请中、已入库、出库申请中、已出库)'
   */
  private String status;

  /**
   * 权证信息
   */
  private Warrant warrant;

  /**
   * 产权人
   */
  private PropertyOwner pOwner;
  /**
   * 抵押人电话
   */
  private String mortgagerTel;
  /**
   * 抵押人身份证号码
   */
  private String Cnumber;
  /**
   * 流水号
   */
  private String serialNo;
  /**
   * 我行评估金额
   */
  private BigDecimal nbComfirmValue;
  /**
   * 世联评估金额
   */
  private BigDecimal wuhouseValue;
  /**
   * 房产类型
   */
  private String houseType;
  /**
   * 押品编号
   */
  private String guaranteeNo;

  public Integer getmHId() {
    return mHId;
  }

  public void setmHId(Integer mHId) {
    this.mHId = mHId;
  }

  public String getMhouseId() {
    return mhouseId;
  }

  public void setMhouseId(String mhouseId) {
    this.mhouseId = mhouseId;
  }

  public String getgCategory() {
    return gCategory;
  }

  public void setgCategory(String gCategory) {
    this.gCategory = gCategory;
  }

  public BigDecimal getMhouseValue() {
    return mhouseValue;
  }

  public void setMhouseValue(BigDecimal mhouseValue) {
    this.mhouseValue = mhouseValue;
  }

  public String getPropertyRightNumber() {
    return propertyRightNumber;
  }

  public void setPropertyRightNumber(String propertyRightNumber) {
    this.propertyRightNumber = propertyRightNumber;
  }

  public String getPropertyOwner() {
    return propertyOwner;
  }

  public void setPropertyOwner(String propertyOwner) {
    this.propertyOwner = propertyOwner;
  }

  public BigDecimal getAcreage() {
    return acreage;
  }

  public void setAcreage(BigDecimal acreage) {
    this.acreage = acreage;
  }

  public String getgAddress() {
    return gAddress;
  }

  public void setgAddress(String gAddress) {
    this.gAddress = gAddress;
  }

  public String getAndStatus() {
    return andStatus;
  }

  public void setAndStatus(String andStatus) {
    this.andStatus = andStatus;
  }

  public String getHouseArea() {
    return houseArea;
  }

  public void setHouseArea(String houseArea) {
    this.houseArea = houseArea;
  }

  public String getLandCertificate() {
    return landCertificate;
  }

  public void setLandCertificate(String landCertificate) {
    this.landCertificate = landCertificate;
  }

  public String getGetMethod() {
    return getMethod;
  }

  public void setGetMethod(String getMethod) {
    this.getMethod = getMethod;
  }

  public Integer getWarrantId() {
    return warrantId;
  }

  public void setWarrantId(Integer warrantId) {
    this.warrantId = warrantId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Warrant getWarrant() {
    return warrant;
  }

  public void setWarrant(Warrant warrant) {
    this.warrant = warrant;
  }

  public PropertyOwner getpOwner() {
    return pOwner;
  }

  public void setpOwner(PropertyOwner pOwner) {
    this.pOwner = pOwner;
  }

  public String getMortgagerTel() {
    return mortgagerTel;
  }

  public void setMortgagerTel(String mortgagerTel) {
    this.mortgagerTel = mortgagerTel;
  }

  public String getCnumber() {
    return Cnumber;
  }

  public void setCnumber(String cnumber) {
    Cnumber = cnumber;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

public BigDecimal getNbComfirmValue() {
	return nbComfirmValue;
}

public void setNbComfirmValue(BigDecimal nbComfirmValue) {
	this.nbComfirmValue = nbComfirmValue;
}

public BigDecimal getWuhouseValue() {
	return wuhouseValue;
}

public void setWuhouseValue(BigDecimal wuhouseValue) {
	this.wuhouseValue = wuhouseValue;
}

public String getHouseType() {
	return houseType;
}

public void setHouseType(String houseType) {
	this.houseType = houseType;
}

public String getGuaranteeNo() {
	return guaranteeNo;
}

public void setGuaranteeNo(String guaranteeNo) {
	this.guaranteeNo = guaranteeNo;
}

@Override
public String toString() {
	return "MortgageHouse [mHId=" + mHId + ", mhouseId=" + mhouseId
			+ ", gCategory=" + gCategory + ", mhouseValue=" + mhouseValue
			+ ", propertyRightNumber=" + propertyRightNumber
			+ ", propertyOwner=" + propertyOwner + ", acreage=" + acreage
			+ ", gAddress=" + gAddress + ", andStatus=" + andStatus
			+ ", houseArea=" + houseArea + ", landCertificate="
			+ landCertificate + ", getMethod=" + getMethod + ", warrantId="
			+ warrantId + ", status=" + status + ", warrant=" + warrant
			+ ", pOwner=" + pOwner + ", mortgagerTel=" + mortgagerTel
			+ ", Cnumber=" + Cnumber + ", serialNo=" + serialNo
			+ ", nbComfirmValue=" + nbComfirmValue + ", wuhouseValue="
			+ wuhouseValue + ", houseType=" + houseType + ", guaranteeNo="
			+ guaranteeNo + "]";
}




}
