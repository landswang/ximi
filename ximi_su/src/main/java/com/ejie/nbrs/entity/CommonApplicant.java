package com.ejie.nbrs.entity;

/**
 * 
 * ClassName:CommonApplicant 共借人
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月15日 上午10:43:44
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class CommonApplicant {
  private Integer cAInfoId;

  private String cAType;

  private String cAName;

  private String cARelationship;
  /**
   * 性别
   */
  private String cAAge;

  private String cAIdNumber;

  private String cAPhoneNumber;

  private String cAResidenceAddress;

  private String cAIdAddress;

  private String cAReason;

  private String cABirthday;

  private String cACardno;

  private String cABankname;

  private String cABank;

  private String cACardowner;

  private String cAOwnerid;

  private Integer aBaseId;

  private String serialNo;
  /**
   * 年龄
   */
  private Integer age;
  /**
   * 公司名
   */
  private String companyName;

  public Integer getcAInfoId() {
    return cAInfoId;
  }

  public void setcAInfoId(Integer cAInfoId) {
    this.cAInfoId = cAInfoId;
  }

  public String getcAType() {
    return cAType;
  }

  public void setcAType(String cAType) {
    this.cAType = cAType == null ? null : cAType.trim();
  }

  public String getcAName() {
    return cAName;
  }

  public void setcAName(String cAName) {
    this.cAName = cAName == null ? null : cAName.trim();
  }

  public String getcARelationship() {
    return cARelationship;
  }

  public void setcARelationship(String cARelationship) {
    this.cARelationship = cARelationship == null ? null : cARelationship.trim();
  }

  public String getcAAge() {
    return cAAge;
  }

  public void setcAAge(String cAAge) {
    this.cAAge = cAAge == null ? null : cAAge.trim();
  }

  public String getcAIdNumber() {
    return cAIdNumber;
  }

  public void setcAIdNumber(String cAIdNumber) {
    this.cAIdNumber = cAIdNumber == null ? null : cAIdNumber.trim();
  }

  public String getcAPhoneNumber() {
    return cAPhoneNumber;
  }

  public void setcAPhoneNumber(String cAPhoneNumber) {
    this.cAPhoneNumber = cAPhoneNumber == null ? null : cAPhoneNumber.trim();
  }

  public String getcAResidenceAddress() {
    return cAResidenceAddress;
  }

  public void setcAResidenceAddress(String cAResidenceAddress) {
    this.cAResidenceAddress = cAResidenceAddress == null ? null : cAResidenceAddress.trim();
  }

  public String getcAIdAddress() {
    return cAIdAddress;
  }

  public void setcAIdAddress(String cAIdAddress) {
    this.cAIdAddress = cAIdAddress == null ? null : cAIdAddress.trim();
  }

  public String getcAReason() {
    return cAReason;
  }

  public void setcAReason(String cAReason) {
    this.cAReason = cAReason == null ? null : cAReason.trim();
  }

  public String getcABirthday() {
    return cABirthday;
  }

  public void setcABirthday(String cABirthday) {
    this.cABirthday = cABirthday == null ? null : cABirthday.trim();
  }

  public String getcACardno() {
    return cACardno;
  }

  public void setcACardno(String cACardno) {
    this.cACardno = cACardno == null ? null : cACardno.trim();
  }

  public String getcABankname() {
    return cABankname;
  }

  public void setcABankname(String cABankname) {
    this.cABankname = cABankname == null ? null : cABankname.trim();
  }

  public String getcABank() {
    return cABank;
  }

  public void setcABank(String cABank) {
    this.cABank = cABank == null ? null : cABank.trim();
  }

  public String getcACardowner() {
    return cACardowner;
  }

  public void setcACardowner(String cACardowner) {
    this.cACardowner = cACardowner == null ? null : cACardowner.trim();
  }

  public String getcAOwnerid() {
    return cAOwnerid;
  }

  public void setcAOwnerid(String cAOwnerid) {
    this.cAOwnerid = cAOwnerid == null ? null : cAOwnerid.trim();
  }

  public Integer getaBaseId() {
    return aBaseId;
  }

  public void setaBaseId(Integer aBaseId) {
    this.aBaseId = aBaseId;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

public Integer getAge() {
	return age;
}

public void setAge(Integer age) {
	this.age = age;
}

public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

@Override
public String toString() {
	return "CommonApplicant [cAInfoId=" + cAInfoId + ", cAType=" + cAType
			+ ", cAName=" + cAName + ", cARelationship=" + cARelationship
			+ ", cAAge=" + cAAge + ", cAIdNumber=" + cAIdNumber
			+ ", cAPhoneNumber=" + cAPhoneNumber + ", cAResidenceAddress="
			+ cAResidenceAddress + ", cAIdAddress=" + cAIdAddress
			+ ", cAReason=" + cAReason + ", cABirthday=" + cABirthday
			+ ", cACardno=" + cACardno + ", cABankname=" + cABankname
			+ ", cABank=" + cABank + ", cACardowner=" + cACardowner
			+ ", cAOwnerid=" + cAOwnerid + ", aBaseId=" + aBaseId
			+ ", serialNo=" + serialNo + ", age=" + age + ", companyName="
			+ companyName + "]";
}



}
