package com.ejie.nbrs.entity;

import java.util.List;

/**
 * 
 * ClassName:Mortgager 抵押人
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月16日 下午4:22:37
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class Mortgager {
  /**
   * 抵押人编号 主键
   */
  private Integer mortgagerId;

  /**
   * 抵押房编号
   */
  private String mHId;
  /**
   * 抵押车编号
   */
  private String mCId;
  /**
   * 抵押人姓名
   */
  private String mortgagerName;
  /**
   * 抵押人电话
   */
  private String mortgagerTel;
  /**
   * 证件类型
   */
  private String cType;
  /**
   * 证件号码
   */
  private String cNumber;
  /**
   * 主借人id
   */
  private Integer aBaseId;
  /**
   * 共借人id
   */
  private String cAInfoId;
  /**
   * 抵押车集合
   */
  private List<MortgageCar> mortgageCarList;
  /**
   * 抵押房集合
   */
  private List<MortgageHouse> mortgageHouseList;


  public Integer getMortgagerId() {
    return mortgagerId;
  }

  public void setMortgagerId(Integer mortgagerId) {
    this.mortgagerId = mortgagerId;
  }

  public String getmHId() {
    return mHId;
  }

  public void setmHId(String mHId) {
    this.mHId = mHId;
  }

  public String getmCId() {
    return mCId;
  }

  public void setmCId(String mCId) {
    this.mCId = mCId;
  }

  public String getMortgagerName() {
    return mortgagerName;
  }

  public void setMortgagerName(String mortgagerName) {
    this.mortgagerName = mortgagerName == null ? null : mortgagerName.trim();
  }

  public String getMortgagerTel() {
    return mortgagerTel;
  }

  public void setMortgagerTel(String mortgagerTel) {
    this.mortgagerTel = mortgagerTel == null ? null : mortgagerTel.trim();
  }

  public String getcType() {
    return cType;
  }

  public void setcType(String cType) {
    this.cType = cType == null ? null : cType.trim();
  }

  public String getcNumber() {
    return cNumber;
  }

  public void setcNumber(String cNumber) {
    this.cNumber = cNumber == null ? null : cNumber.trim();
  }

  public Integer getaBaseId() {
    return aBaseId;
  }

  public void setaBaseId(Integer aBaseId) {
    this.aBaseId = aBaseId;
  }

  public String getcAInfoId() {
    return cAInfoId;
  }

  public void setcAInfoId(String cAInfoId) {
    this.cAInfoId = cAInfoId == null ? null : cAInfoId.trim();
  }

  public List<MortgageCar> getMortgageCarList() {
    return mortgageCarList;
  }

  public void setMortgageCarList(List<MortgageCar> mortgageCarList) {
    this.mortgageCarList = mortgageCarList;
  }

  public List<MortgageHouse> getMortgageHouseList() {
    return mortgageHouseList;
  }

  public void setMortgageHouseList(List<MortgageHouse> mortgageHouseList) {
    this.mortgageHouseList = mortgageHouseList;
  }

  @Override
  public String toString() {
    return "Mortgager [mortgagerId=" + mortgagerId + ", mHId=" + mHId + ", mCId=" + mCId
        + ", mortgagerName=" + mortgagerName + ", mortgagerTel=" + mortgagerTel + ", cType="
        + cType + ", cNumber=" + cNumber + ", aBaseId=" + aBaseId + ", cAInfoId=" + cAInfoId
        + ", mortgageCarList=" + mortgageCarList + ", mortgageHouseList=" + mortgageHouseList + "]";
  }

}
