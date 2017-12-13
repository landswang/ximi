package com.ejie.nbrs.ejieinterface.entity;

import java.util.List;

/**
 * 
 * ClassName:主借人信息
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月10日 下午6:30:40
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class MasterInfo {
  private String loanId;
  private String guaranteeId;
  private String realName;// 姓名
  private String gender;// 性别
  private String idNo;// 证件号
  private int age;// 年龄
  private String birthday;// 生日
  private String maritalStatus;// 婚姻状态
  private String jobStyle;// 职业身份
  private String liveAddress;// 居住地址
  private String domicileAddress;// 户籍地址
  private String unitName;// 单位名称
  private String unitAddress;// 单位地址
  private String dute;// 职务
  private String documentType;// 证件类型
  private String education;// 学历
  private String telePhone;// 电话
  private String workDept;// 所在部门
  private float salary;// 月收入
  private String workYear;// 工作年限
  private String unitTel;// 单位电话
  private String spousePhone;// 配偶电话
  private String spouseEducation;// 配偶学历
  private String spouseHomeAddr;// 配偶居住地址
  private String spouseIdno;// 配偶身份证号码
  private String spouseAge;// 配偶年龄
  private String spouseGender;// 配偶性别
  private String spouseName;// 配偶姓名
  private String spouseRegisterAddr;// 配偶户籍地址
  private String serialNo;
  private String applyDate;
  private int appBaseId;// 主借人id（新网）
  private int mateInfo;// 配偶id （新网）
  private String garantyType;// 贷款产品（如房贷一抵，押车贷等
  private String city;// 业务城市
  private String repayMethod;// 还款方式
  private float applyAmount;// 申请金额
  private float loanRate;// 利率（百分比）
  private String bankNumber;// 银行账号
  private String bankName;// 银行名称
  private String bankBranch;// 支行
  private String bankUser; // 持卡人
  private String repayCardNo;// 还款银行账号
  private String repayCardBank;// 还款银行名称
  private String repayCardBranck;// 还款支行
  private String repayCardUser; // 还款持卡人
  private String loanLimit;// 贷款期限
  private String loanUse;// 资金用途

  private String channelCode;// '进件渠道代码：1804 新网 1802：外贸信托 1807 ： 四川信托';
  /**
   * 抵押对象
   */
  private String garantyObject;
  private List<EMortgager> guaranties; // 抵押物
  private List<ECommonCustomer> otherBorrower;// 共借人


  public String getGarantyObject() {
    return garantyObject;
  }

  public void setGarantyObject(String garantyObject) {
    this.garantyObject = garantyObject;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getSpouseRegisterAddr() {
    return spouseRegisterAddr;
  }

  public void setSpouseRegisterAddr(String spouseRegisterAddr) {
    this.spouseRegisterAddr = spouseRegisterAddr;
  }

  public String getGuaranteeId() {
    return guaranteeId;
  }

  public void setGuaranteeId(String guaranteeId) {
    this.guaranteeId = guaranteeId;
  }

  public String getLoanId() {
    return loanId;
  }

  public void setLoanId(String loanId) {
    this.loanId = loanId;
  }

  public String getLoanUse() {
    return loanUse;
  }

  public void setLoanUse(String loanUse) {
    this.loanUse = loanUse;
  }

  public int getAppBaseId() {
    return appBaseId;
  }

  public void setAppBaseId(int appBaseId) {
    this.appBaseId = appBaseId;
  }

  public int getMateInfo() {
    return mateInfo;
  }

  public void setMateInfo(int mateInfo) {
    this.mateInfo = mateInfo;
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

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public String getJobStyle() {
    return jobStyle;
  }

  public void setJobStyle(String jobStyle) {
    this.jobStyle = jobStyle;
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

  public String getUnitName() {
    return unitName;
  }

  public void setUnitName(String unitName) {
    this.unitName = unitName;
  }

  public String getUnitAddress() {
    return unitAddress;
  }

  public void setUnitAddress(String unitAddress) {
    this.unitAddress = unitAddress;
  }

  public String getDute() {
    return dute;
  }

  public void setDute(String dute) {
    this.dute = dute;
  }

  public String getSpouseName() {
    return spouseName;
  }

  public void setSpouseName(String spouseName) {
    this.spouseName = spouseName;
  }

  public String getSpouseIdno() {
    return spouseIdno;
  }

  public void setSpouseIdno(String spouseIdno) {
    this.spouseIdno = spouseIdno;
  }

  public String getSpouseAge() {
    return spouseAge;
  }

  public void setSpouseAge(String spouseAge) {
    this.spouseAge = spouseAge;
  }

  public String getSpouseGender() {
    return spouseGender;
  }

  public void setSpouseGender(String spouseGender) {
    this.spouseGender = spouseGender;
  }

  public List<EMortgager> getGuaranties() {
    return guaranties;
  }

  public void setGuaranties(List<EMortgager> guaranties) {
    this.guaranties = guaranties;
  }

  public List<ECommonCustomer> getOtherBorrower() {
    return otherBorrower;
  }

  public void setOtherBorrower(List<ECommonCustomer> otherBorrower) {
    this.otherBorrower = otherBorrower;
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

  public String getRepayMethod() {
    return repayMethod;
  }

  public void setRepayMethod(String repayMethod) {
    this.repayMethod = repayMethod;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  public String getApplyDate() {
    return applyDate;
  }

  public void setApplyDate(String applyDate) {
    this.applyDate = applyDate;
  }

  public String getGarantyType() {
    return garantyType;
  }

  public void setGarantyType(String garantyType) {
    this.garantyType = garantyType;
  }

  public float getApplyAmount() {
    return applyAmount;
  }

  public void setApplyAmount(float applyAmount) {
    this.applyAmount = applyAmount;
  }

  public float getLoanRate() {
    return loanRate;
  }

  public void setLoanRate(float loanRate) {
    this.loanRate = loanRate;
  }

  public String getBankNumber() {
    return bankNumber;
  }

  public void setBankNumber(String bankNumber) {
    this.bankNumber = bankNumber;
  }

  public String getLoanLimit() {
    return loanLimit;
  }

  public void setLoanLimit(String loanLimit) {
    this.loanLimit = loanLimit;
  }

  public void setBankUser(String bankUser) {
    this.bankUser = bankUser;
  }

  public String getDocumentType() {
    return documentType;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public String getTelePhone() {
    return telePhone;
  }

  public void setTelePhone(String telePhone) {
    this.telePhone = telePhone;
  }

  public String getWorkDept() {
    return workDept;
  }

  public void setWorkDept(String workDept) {
    this.workDept = workDept;
  }

  public float getSalary() {
    return salary;
  }

  public void setSalary(float salary) {
    this.salary = salary;
  }

  public String getWorkYear() {
    return workYear;
  }

  public void setWorkYear(String workYear) {
    this.workYear = workYear;
  }

  public String getUnitTel() {
    return unitTel;
  }

  public void setUnitTel(String unitTel) {
    this.unitTel = unitTel;
  }

  public String getSpousePhone() {
    return spousePhone;
  }

  public void setSpousePhone(String spousePhone) {
    this.spousePhone = spousePhone;
  }

  public String getSpouseEducation() {
    return spouseEducation;
  }

  public void setSpouseEducation(String spouseEducation) {
    this.spouseEducation = spouseEducation;
  }

  public String getSpouseHomeAddr() {
    return spouseHomeAddr;
  }

  public void setSpouseHomeAddr(String spouseHomeAddr) {
    this.spouseHomeAddr = spouseHomeAddr;
  }

  public String getRepayCardNo() {
    return repayCardNo;
  }

  public void setRepayCardNo(String repayCardNo) {
    this.repayCardNo = repayCardNo;
  }

  public String getRepayCardBank() {
    return repayCardBank;
  }

  public void setRepayCardBank(String repayCardBank) {
    this.repayCardBank = repayCardBank;
  }

  public String getRepayCardBranck() {
    return repayCardBranck;
  }

  public void setRepayCardBranck(String repayCardBranck) {
    this.repayCardBranck = repayCardBranck;
  }

  public String getRepayCardUser() {
    return repayCardUser;
  }

  public void setRepayCardUser(String repayCardUser) {
    this.repayCardUser = repayCardUser;
  }

  public String getChannelCode() {
    return channelCode;
  }

  public void setChannelCode(String channelCode) {
    this.channelCode = channelCode;
  }

  @Override
  public String toString() {
    return "MasterInfo [loanId=" + loanId + ", guaranteeId=" + guaranteeId + ", realName="
        + realName + ", gender=" + gender + ", idNo=" + idNo + ", age=" + age + ", birthday="
        + birthday + ", maritalStatus=" + maritalStatus + ", jobStyle=" + jobStyle
        + ", liveAddress=" + liveAddress + ", domicileAddress=" + domicileAddress + ", unitName="
        + unitName + ", unitAddress=" + unitAddress + ", dute=" + dute + ", documentType="
        + documentType + ", education=" + education + ", telePhone=" + telePhone + ", workDept="
        + workDept + ", salary=" + salary + ", workYear=" + workYear + ", unitTel=" + unitTel
        + ", spousePhone=" + spousePhone + ", spouseEducation=" + spouseEducation
        + ", spouseHomeAddr=" + spouseHomeAddr + ", spouseIdno=" + spouseIdno + ", spouseAge="
        + spouseAge + ", spouseGender=" + spouseGender + ", spouseName=" + spouseName
        + ", spouseRegisterAddr=" + spouseRegisterAddr + ", serialNo=" + serialNo + ", applyDate="
        + applyDate + ", appBaseId=" + appBaseId + ", mateInfo=" + mateInfo + ", garantyType="
        + garantyType + ", city=" + city + ", repayMethod=" + repayMethod + ", applyAmount="
        + applyAmount + ", loanRate=" + loanRate + ", bankNumber=" + bankNumber + ", bankName="
        + bankName + ", bankBranch=" + bankBranch + ", bankUser=" + bankUser + ", repayCardNo="
        + repayCardNo + ", repayCardBank=" + repayCardBank + ", repayCardBranck=" + repayCardBranck
        + ", repayCardUser=" + repayCardUser + ", loanLimit=" + loanLimit + ", loanUse=" + loanUse
        + ", channelCode=" + channelCode + ", garantyObject=" + garantyObject + ", guaranties="
        + guaranties + ", otherBorrower=" + otherBorrower + "]";
  }

}
