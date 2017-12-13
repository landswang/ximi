package com.ejie.nbrs.ejieinterface.entity;

/**
 * 
 * ClassName:CollateralInformation 抵押物信息
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月10日 下午6:34:14
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class EMortgager {
  private int mCarid;
  private String mCId;
  private String mHId;
  private int mHouseid;
  private String garantyType;
  private String guarantyId;
  private String guarantyNo;

  private String certificateNo;

  private String houseType;
  private String serialNo;

  /**
   * 抵押人姓名
   */
  private String ownerName;// mortgagerName

  private String certificateAddr;

  private float buildArea;

  private String location;

  private float priceRate;

  private String brandModel;

  private String plateNumber;

  private String frameNumber;
  private String engineNumber;
  private String buyTime;
  private float totalPrice;
  /**
   * 抵押人电话
   */
  private String mortgagerTel;
  /**
   * 抵押人证件类型
   */
  private String cType;
  /**
   * 抵押人证件号码
   */
  private String IDNumber;
  /**
   * 抵押对象
   */
  private String garantyObject;
  /**
   * 世联评估金额
   */
  private float worldUniteAssessTotal;
  /**
   * 世联抵押率
   */
  private float worldUnite;


  public String getMortgagerTel() {
    return mortgagerTel;
  }

  public void setMortgagerTel(String mortgagerTel) {
    this.mortgagerTel = mortgagerTel;
  }

  public String getcType() {
    return cType;
  }

  public void setcType(String cType) {
    this.cType = cType;
  }

  public String getIDNumber() {
    return IDNumber;
  }

  public void setIDNumber(String iDNumber) {
    IDNumber = iDNumber;
  }

  public String getmCId() {
    return mCId;
  }

  public void setmCId(String mCId) {
    this.mCId = mCId;
  }

  public String getmHId() {
    return mHId;
  }

  public void setmHId(String mHId) {
    this.mHId = mHId;
  }

  public int getmCarid() {
    return mCarid;
  }

  public void setmCarid(int mCarid) {
    this.mCarid = mCarid;
  }

  public int getmHouseid() {
    return mHouseid;
  }

  public void setmHouseid(int mHouseid) {
    this.mHouseid = mHouseid;
  }

  public String getGarantyType() {
    return garantyType;
  }

  public void setGarantyType(String garantyType) {
    this.garantyType = garantyType;
  }

  public String getCertificateNo() {
    return certificateNo;
  }

  public void setCertificateNo(String certificateNo) {
    this.certificateNo = certificateNo;
  }

  public String getHouseType() {
    return houseType;
  }

  public void setHouseType(String houseType) {
    this.houseType = houseType;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public String getCertificateAddr() {
    return certificateAddr;
  }

  public void setCertificateAddr(String certificateAddr) {
    this.certificateAddr = certificateAddr;
  }

  public float getBuildArea() {
    return buildArea;
  }

  public void setBuildArea(float buildArea) {
    this.buildArea = buildArea;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public float getPriceRate() {
    return priceRate;
  }

  public void setPriceRate(float priceRate) {
    this.priceRate = priceRate;
  }

  public String getBrandModel() {
    return brandModel;
  }

  public void setBrandModel(String brandModel) {
    this.brandModel = brandModel;
  }

  public String getPlateNumber() {
    return plateNumber;
  }

  public void setPlateNumber(String plateNumber) {
    this.plateNumber = plateNumber;
  }

  public String getFrameNumber() {
    return frameNumber;
  }

  public void setFrameNumber(String frameNumber) {
    this.frameNumber = frameNumber;
  }

  public String getEngineNumber() {
    return engineNumber;
  }

  public void setEngineNumber(String engineNumber) {
    this.engineNumber = engineNumber;
  }

  public String getBuyTime() {
    return buyTime;
  }

  public void setBuyTime(String buyTime) {
    this.buyTime = buyTime;
  }

  public float getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(float totalPrice) {
    this.totalPrice = totalPrice;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  public String getGarantyObject() {
    return garantyObject;
  }

  public void setGarantyObject(String garantyObject) {
    this.garantyObject = garantyObject;
  }

  public float getWorldUniteAssessTotal() {
    return worldUniteAssessTotal;
  }

  public void setWorldUniteAssessTotal(float worldUniteAssessTotal) {
    this.worldUniteAssessTotal = worldUniteAssessTotal;
  }

  public float getWorldUnite() {
    return worldUnite;
  }

  public void setWorldUnite(float worldUnite) {
    this.worldUnite = worldUnite;
  }

  public String getGuarantyId() {
    return guarantyId;
  }

  public void setGuarantyId(String guarantyId) {
    this.guarantyId = guarantyId;
  }

  public String getGuarantyNo() {
    return guarantyNo;
  }

  public void setGuarantyNo(String guarantyNo) {
    this.guarantyNo = guarantyNo;
  }

  @Override
  public String toString() {
    return "EMortgager [mCarid=" + mCarid + ", mCId=" + mCId + ", mHId=" + mHId + ", mHouseid="
        + mHouseid + ", garantyType=" + garantyType + ", guarantyId=" + guarantyId
        + ", guarantyNo=" + guarantyNo + ", certificateNo=" + certificateNo + ", houseType="
        + houseType + ", serialNo=" + serialNo + ", ownerName=" + ownerName + ", certificateAddr="
        + certificateAddr + ", buildArea=" + buildArea + ", location=" + location + ", priceRate="
        + priceRate + ", brandModel=" + brandModel + ", plateNumber=" + plateNumber
        + ", frameNumber=" + frameNumber + ", engineNumber=" + engineNumber + ", buyTime="
        + buyTime + ", totalPrice=" + totalPrice + ", mortgagerTel=" + mortgagerTel + ", cType="
        + cType + ", IDNumber=" + IDNumber + ", garantyObject=" + garantyObject
        + ", worldUniteAssessTotal=" + worldUniteAssessTotal + ", worldUnite=" + worldUnite + "]";
  }

}
