package com.ejie.nbrs.entity;

import java.util.Date;

/**
 * 
 * ClassName:ApplicantBase 主借人信息
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年7月20日 下午5:50:39
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class ApplicantBase {
  /**
   * 主键
   */
  private Integer aBaseId;
  /**
   * 借款人姓名
   */
  private String name;
  /**
   * 证件类型
   */
  private String idType;
  /**
   * 证件号
   */
  private String idNumber;
  /**
   * 民族
   */
  private String nationality;
  /**
   * 性别
   */
  private String sex;
  /**
   * 出生年月
   */
  private Date birthday;
  /**
   * 婚姻状况
   */
  private String maritalStatus;
  /**
   * 配偶信息
   */
  private Integer mateInfoId;
  /**
   * 学历
   */
  private String educationBackground;
  /**
   * 职业
   */
  private String career;
  /**
   * 单位地址
   */
  private String companyAddress;
  /**
   * 单位名称
   */
  private String companyName;
  /**
   * 所在部门
   */
  private String companyDept;
  /**
   * 月收入
   */
  private String monthlyIncome;
  /**
   * 工作年限
   */
  private String yearsWorking;
  /**
   * 单位电话
   */
  private String companyNumber;
  /**
   * 职务
   */
  private String jobTitle;
  /**
   * 单位性质
   */
  private String companyProperty;
  /**
   * 电话
   */
  private String phoneNumber;
  /**
   * 居住地址
   */
  private String permanentAddress;
  /**
   * 户籍地址
   */
  private String residenceAddress;
  private String serialNo;

  public Integer getaBaseId() {
    return aBaseId;
  }

  public void setaBaseId(Integer aBaseId) {
    this.aBaseId = aBaseId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  public String getIdType() {
    return idType;
  }

  public void setIdType(String idType) {
    this.idType = idType == null ? null : idType.trim();
  }

  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber == null ? null : idNumber.trim();
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality == null ? null : nationality.trim();
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex == null ? null : sex.trim();
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus == null ? null : maritalStatus.trim();
  }

  public Integer getMateInfoId() {
    return mateInfoId;
  }

  public void setMateInfoId(Integer mateInfoId) {
    this.mateInfoId = mateInfoId;
  }

  public String getEducationBackground() {
    return educationBackground;
  }

  public void setEducationBackground(String educationBackground) {
    this.educationBackground = educationBackground == null ? null : educationBackground.trim();
  }

  public String getCareer() {
    return career;
  }

  public void setCareer(String career) {
    this.career = career == null ? null : career.trim();
  }

  public String getCompanyAddress() {
    return companyAddress;
  }

  public void setCompanyAddress(String companyAddress) {
    this.companyAddress = companyAddress == null ? null : companyAddress.trim();
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName == null ? null : companyName.trim();
  }

  public String getCompanyDept() {
    return companyDept;
  }

  public void setCompanyDept(String companyDept) {
    this.companyDept = companyDept == null ? null : companyDept.trim();
  }

  public String getMonthlyIncome() {
    return monthlyIncome;
  }

  public void setMonthlyIncome(String monthlyIncome) {
    this.monthlyIncome = monthlyIncome == null ? null : monthlyIncome.trim();
  }

  public String getYearsWorking() {
    return yearsWorking;
  }

  public void setYearsWorking(String yearsWorking) {
    this.yearsWorking = yearsWorking == null ? null : yearsWorking.trim();
  }

  public String getCompanyNumber() {
    return companyNumber;
  }

  public void setCompanyNumber(String companyNumber) {
    this.companyNumber = companyNumber == null ? null : companyNumber.trim();
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle == null ? null : jobTitle.trim();
  }

  public String getCompanyProperty() {
    return companyProperty;
  }

  public void setCompanyProperty(String companyProperty) {
    this.companyProperty = companyProperty == null ? null : companyProperty.trim();
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
  }

  public String getPermanentAddress() {
    return permanentAddress;
  }

  public void setPermanentAddress(String permanentAddress) {
    this.permanentAddress = permanentAddress == null ? null : permanentAddress.trim();
  }

  public String getResidenceAddress() {
    return residenceAddress;
  }

  public void setResidenceAddress(String residenceAddress) {
    this.residenceAddress = residenceAddress == null ? null : residenceAddress.trim();
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  @Override
  public String toString() {
    return "ApplicantBase [aBaseId=" + aBaseId + ", name=" + name + ", idType=" + idType
        + ", idNumber=" + idNumber + ", nationality=" + nationality + ", sex=" + sex
        + ", birthday=" + birthday + ", maritalStatus=" + maritalStatus + ", mateInfoId="
        + mateInfoId + ", educationBackground=" + educationBackground + ", career=" + career
        + ", companyAddress=" + companyAddress + ", companyName=" + companyName + ", companyDept="
        + companyDept + ", monthlyIncome=" + monthlyIncome + ", yearsWorking=" + yearsWorking
        + ", companyNumber=" + companyNumber + ", jobTitle=" + jobTitle + ", companyProperty="
        + companyProperty + ", phoneNumber=" + phoneNumber + ", permanentAddress="
        + permanentAddress + ", residenceAddress=" + residenceAddress + ", serialNo=" + serialNo
        + "]";
  }



}
