package com.ejie.nbrs.ejieinterface.entity;

import java.util.Date;

/**
 * 
 * ClassName: 共借人信息
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月10日 下午6:37:12
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class ECommonCustomer {

  private String serialNo;
  private int commonInfoId;
  private int appBaseId;// 主借人id
  private String customerType;

  private String relationship;

  private String reason;

  private String realName;

  private String gender;

  private String idNo;

  private Date birthday;

  private String liveAddress;

  private String domicileAddress;

  private String bankNumber;

  private String bankName;

  private String bankBranch;

  private String bankUser;

  private String bankIdno;

  private String telePhone;// 共借人电话

  private int age;

  private String companyName;

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }



  public int getCommonInfoId() {
    return commonInfoId;
  }

  public void setCommonInfoId(int commonInfoId) {
    this.commonInfoId = commonInfoId;
  }

  public int getAppBaseId() {
    return appBaseId;
  }

  public void setAppBaseId(int appBaseId) {
    this.appBaseId = appBaseId;
  }

  public String getCustomerType() {
    return customerType;
  }

  public void setCustomerType(String customerType) {
    this.customerType = customerType;
  }

  public String getRelationship() {
    return relationship;
  }

  public void setRelationship(String relationship) {
    this.relationship = relationship;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getIdNo() {
    return idNo;
  }

  public void setIdNo(String idNo) {
    this.idNo = idNo;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getLiveAddress() {
    return liveAddress;
  }

  public void setLiveAddress(String liveAddress) {
    this.liveAddress = liveAddress;
  }

  public String getDomicileAddress() {
    return domicileAddress;
  }

  public void setDomicileAddress(String domicileAddress) {
    this.domicileAddress = domicileAddress;
  }

  public String getBankNumber() {
    return bankNumber;
  }

  public void setBankNumber(String bankNumber) {
    this.bankNumber = bankNumber;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getBankBranch() {
    return bankBranch;
  }

  public void setBankBranch(String bankBranch) {
    this.bankBranch = bankBranch;
  }

  public String getBankUser() {
    return bankUser;
  }

  public void setBankUser(String bankUser) {
    this.bankUser = bankUser;
  }

  public String getBankIdno() {
    return bankIdno;
  }

  public void setBankIdno(String bankIdno) {
    this.bankIdno = bankIdno;
  }

  public String getTelePhone() {
    return telePhone;
  }

  public void setTelePhone(String telePhone) {
    this.telePhone = telePhone;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  @Override
  public String toString() {
    return "ECommonCustomer [serialNo=" + serialNo + ", commonInfoId=" + commonInfoId
        + ", appBaseId=" + appBaseId + ", customerType=" + customerType + ", relationship="
        + relationship + ", reason=" + reason + ", realName=" + realName + ", gender=" + gender
        + ", idNo=" + idNo + ", birthday=" + birthday + ", liveAddress=" + liveAddress
        + ", domicileAddress=" + domicileAddress + ", bankNumber=" + bankNumber + ", bankName="
        + bankName + ", bankBranch=" + bankBranch + ", bankUser=" + bankUser + ", bankIdno="
        + bankIdno + ", telePhone=" + telePhone + ", age=" + age + ", companyName=" + companyName
        + "]";
  }

}
