package com.ejie.nbrs.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ejie.nbrs.entity.CommonApplicant;
import com.ejie.nbrs.entity.FileRPath;
import com.ejie.nbrs.entity.GrantMoney;
import com.ejie.nbrs.entity.GuaranteeValue;
import com.ejie.nbrs.entity.MateInfo;
import com.ejie.nbrs.entity.MortgageCar;
import com.ejie.nbrs.entity.MortgageHouse;
import com.ejie.nbrs.entity.PropertyOwner;
import com.ejie.nbrs.entity.ScratchFile;

/**
 * 
 * ClassName:NewLoanView 新的贷款详细信息
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月17日 下午9:03:04
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class NewLoanView {

  private String city;

  private Date finalTransferDate;

  private String guaranteeId;

  private Integer loanId;

  private String name;

  private String idNumber;

  private String sex;
  private Integer age;

  private String nationality;

  private String birthday;

  private String phoneNumber;

  private String educationBackground;

  private String maritalStatus;

  private String career;

  private String permanentAddress;

  private String residenceAddress;

  private String companyAddress;

  private String companyName;

  private String companyDept;

  private String companyProperty;

  private String companyNumber;

  private String yearsWorking;

  private String monthlyIncome;

  private String jobTitle;

  private Date appDate;

  private String eProduct;

  private String repayWay;

  private BigDecimal appMoney;// 送审放款金额

  private String rate;

  private Integer periods;

  private String loanPurpose;

  private String cCardNumber;

  private String cCardName;

  private String cCardBank;

  private String branchbank;
  private String repayCardNo;// 还款银行账号
  private String repayCardBank;// 还款银行名称
  private String repayCardBranck;// 还款支行
  private String repayCardUser; // 还款持卡人
  private String mateName;

  private String mateIdNumber;

  private String matePhoneNumber;

  private String mateEducationBackground;

  private String mateResidenceAddress;

  private String matePermanentAddress;

  private Integer aBaseId;

  private String mhouseId;

  private String mcarId;

  private String serialNo;

  private Integer mateInfoId;
  /**
   * 抵押对象 单位or个人
   */

  private Integer channelCode;
  private String guaranteeObject;

  private MateInfo mateInfo;

  private GrantMoney grantMoney;// 抵押物价值

  /**
   * 人名币大写金额
   */
  private String capitalization;
  /**
   * 附件上传和资料补充地址
   */
  private FileRPath fileRPath;

  private GuaranteeValue guaranteeValue;

  private List<Integer> houseWarrantId;

  private List<Integer> carWarrantId;

  private List<CommonApplicant> commonApplicant;

  private List<MortgageHouse> mortgageHouse;

  private List<MortgageCar> mortgageCar;

  private List<PropertyOwner> poList;// 抵押人
  /**
   * 关联操作日志记录
   */
  private List<LogView> logViewList;
  /**
   * 临时文件表中关联图片名集合
   */
  private List<ScratchFile> scratchFileList;

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  public String getBranchbank() {
    return branchbank;
  }

  public void setBranchbank(String branchbank) {
    this.branchbank = branchbank;
  }

  public String getIdNumber() {
    return idNumber;
  }

  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber == null ? null : idNumber.trim();
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex == null ? null : sex.trim();
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality == null ? null : nationality.trim();
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
  }

  public String getEducationBackground() {
    return educationBackground;
  }

  public void setEducationBackground(String educationBackground) {
    this.educationBackground = educationBackground == null ? null : educationBackground.trim();
  }

  public String getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(String maritalStatus) {
    this.maritalStatus = maritalStatus == null ? null : maritalStatus.trim();
  }

  public String getCareer() {
    return career;
  }

  public void setCareer(String career) {
    this.career = career == null ? null : career.trim();
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

  public String getCompanyProperty() {
    return companyProperty;
  }

  public void setCompanyProperty(String companyProperty) {
    this.companyProperty = companyProperty == null ? null : companyProperty.trim();
  }

  public String getCompanyNumber() {
    return companyNumber;
  }

  public void setCompanyNumber(String companyNumber) {
    this.companyNumber = companyNumber == null ? null : companyNumber.trim();
  }

  public String getYearsWorking() {
    return yearsWorking;
  }

  public void setYearsWorking(String yearsWorking) {
    this.yearsWorking = yearsWorking == null ? null : yearsWorking.trim();
  }

  public String getMonthlyIncome() {
    return monthlyIncome;
  }

  public void setMonthlyIncome(String monthlyIncome) {
    this.monthlyIncome = monthlyIncome == null ? null : monthlyIncome.trim();
  }

  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle == null ? null : jobTitle.trim();
  }

  public Date getAppDate() {
    return appDate;
  }

  public void setAppDate(Date appDate) {
    this.appDate = appDate;
  }

  public String geteProduct() {
    return eProduct;
  }

  public void seteProduct(String eProduct) {
    this.eProduct = eProduct == null ? null : eProduct.trim();
  }

  public String getRepayWay() {
    return repayWay;
  }

  public void setRepayWay(String repayWay) {
    this.repayWay = repayWay == null ? null : repayWay.trim();
  }

  public BigDecimal getAppMoney() {
    return appMoney;
  }

  public void setAppMoney(BigDecimal appMoney) {
    this.appMoney = appMoney;
  }

  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate == null ? null : rate.trim();
  }

  public Integer getPeriods() {
    return periods;
  }

  public void setPeriods(Integer periods) {
    this.periods = periods;
  }

  public String getLoanPurpose() {
    return loanPurpose;
  }

  public void setLoanPurpose(String loanPurpose) {
    this.loanPurpose = loanPurpose == null ? null : loanPurpose.trim();
  }

  public String getcCardNumber() {
    return cCardNumber;
  }

  public void setcCardNumber(String cCardNumber) {
    this.cCardNumber = cCardNumber == null ? null : cCardNumber.trim();
  }

  public String getcCardName() {
    return cCardName;
  }

  public void setcCardName(String cCardName) {
    this.cCardName = cCardName == null ? null : cCardName.trim();
  }

  public String getcCardBank() {
    return cCardBank;
  }

  public void setcCardBank(String cCardBank) {
    this.cCardBank = cCardBank == null ? null : cCardBank.trim();
  }

  public String getMateName() {
    return mateName;
  }

  public void setMateName(String mateName) {
    this.mateName = mateName == null ? null : mateName.trim();
  }

  public String getMateIdNumber() {
    return mateIdNumber;
  }

  public void setMateIdNumber(String mateIdNumber) {
    this.mateIdNumber = mateIdNumber == null ? null : mateIdNumber.trim();
  }

  public String getMatePhoneNumber() {
    return matePhoneNumber;
  }

  public void setMatePhoneNumber(String matePhoneNumber) {
    this.matePhoneNumber = matePhoneNumber == null ? null : matePhoneNumber.trim();
  }

  public String getMateEducationBackground() {
    return mateEducationBackground;
  }

  public void setMateEducationBackground(String mateEducationBackground) {
    this.mateEducationBackground =
        mateEducationBackground == null ? null : mateEducationBackground.trim();
  }

  public String getMateResidenceAddress() {
    return mateResidenceAddress;
  }

  public void setMateResidenceAddress(String mateResidenceAddress) {
    this.mateResidenceAddress = mateResidenceAddress == null ? null : mateResidenceAddress.trim();
  }

  public String getMatePermanentAddress() {
    return matePermanentAddress;
  }

  public void setMatePermanentAddress(String matePermanentAddress) {
    this.matePermanentAddress = matePermanentAddress == null ? null : matePermanentAddress.trim();
  }

  public List<CommonApplicant> getCommonApplicant() {
    return commonApplicant;
  }

  public void setCommonApplicant(List<CommonApplicant> commonApplicant) {
    this.commonApplicant = commonApplicant;
  }

  public List<MortgageHouse> getMortgageHouse() {
    return mortgageHouse;
  }

  public void setMortgageHouse(List<MortgageHouse> mortgageHouse) {
    this.mortgageHouse = mortgageHouse;
  }

  public List<MortgageCar> getMortgageCar() {
    return mortgageCar;
  }

  public void setMortgageCar(List<MortgageCar> mortgageCar) {
    this.mortgageCar = mortgageCar;
  }

  public GrantMoney getGrantMoney() {
    return grantMoney;
  }

  public void setGrantMoney(GrantMoney grantMoney) {
    this.grantMoney = grantMoney;
  }

  public Integer getaBaseId() {
    return aBaseId;
  }

  public void setaBaseId(Integer aBaseId) {
    this.aBaseId = aBaseId;
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

  public Integer getLoanId() {
    return loanId;
  }

  public void setLoanId(Integer loanId) {
    this.loanId = loanId;
  }

  public String getGuaranteeId() {
    return guaranteeId;
  }

  public void setGuaranteeId(String guaranteeId) {
    this.guaranteeId = guaranteeId;
  }

  public Date getFinalTransferDate() {
    return finalTransferDate;
  }

  public void setFinalTransferDate(Date finalTransferDate) {
    this.finalTransferDate = finalTransferDate;
  }

  public List<Integer> getHouseWarrantId() {
    return houseWarrantId;
  }

  public void setHouseWarrantId(List<Integer> houseWarrantId) {
    this.houseWarrantId = houseWarrantId;
  }

  public List<Integer> getCarWarrantId() {
    return carWarrantId;
  }

  public void setCarWarrantId(List<Integer> carWarrantId) {
    this.carWarrantId = carWarrantId;
  }

  public List<PropertyOwner> getPoList() {
    return poList;
  }

  public void setPoList(List<PropertyOwner> poList) {
    this.poList = poList;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  public MateInfo getMateInfo() {
    return mateInfo;
  }

  public void setMateInfo(MateInfo mateInfo) {
    this.mateInfo = mateInfo;
  }

  public Integer getMateInfoId() {
    return mateInfoId;
  }

  public void setMateInfoId(Integer mateInfoId) {
    this.mateInfoId = mateInfoId;
  }

  public String getCapitalization() {
    return capitalization;
  }

  public void setCapitalization(String capitalization) {
    this.capitalization = capitalization;
  }

  public GuaranteeValue getGuaranteeValue() {
    return guaranteeValue;
  }

  public void setGuaranteeValue(GuaranteeValue guaranteeValue) {
    this.guaranteeValue = guaranteeValue;
  }

  public String getGuaranteeObject() {
    return guaranteeObject;
  }

  public void setGuaranteeObject(String guaranteeObject) {
    this.guaranteeObject = guaranteeObject;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
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

  public List<LogView> getLogViewList() {
    return logViewList;
  }

  public void setLogViewList(List<LogView> logViewList) {
    this.logViewList = logViewList;
  }

  public List<ScratchFile> getScratchFileList() {
    return scratchFileList;
  }

  public void setScratchFileList(List<ScratchFile> scratchFileList) {
    this.scratchFileList = scratchFileList;
  }

  public FileRPath getFileRPath() {
    return fileRPath;
  }

  public void setFileRPath(FileRPath fileRPath) {
    this.fileRPath = fileRPath;
  }

  public Integer getChannelCode() {
    return channelCode;
  }

  public void setChannelCode(Integer channelCode) {
    this.channelCode = channelCode;
  }

  @Override
  public String toString() {
    return "NewLoanView [city=" + city + ", finalTransferDate=" + finalTransferDate
        + ", guaranteeId=" + guaranteeId + ", loanId=" + loanId + ", name=" + name + ", idNumber="
        + idNumber + ", sex=" + sex + ", age=" + age + ", nationality=" + nationality
        + ", birthday=" + birthday + ", phoneNumber=" + phoneNumber + ", educationBackground="
        + educationBackground + ", maritalStatus=" + maritalStatus + ", career=" + career
        + ", permanentAddress=" + permanentAddress + ", residenceAddress=" + residenceAddress
        + ", companyAddress=" + companyAddress + ", companyName=" + companyName + ", companyDept="
        + companyDept + ", companyProperty=" + companyProperty + ", companyNumber=" + companyNumber
        + ", yearsWorking=" + yearsWorking + ", monthlyIncome=" + monthlyIncome + ", jobTitle="
        + jobTitle + ", appDate=" + appDate + ", eProduct=" + eProduct + ", repayWay=" + repayWay
        + ", appMoney=" + appMoney + ", rate=" + rate + ", periods=" + periods + ", loanPurpose="
        + loanPurpose + ", cCardNumber=" + cCardNumber + ", cCardName=" + cCardName + repayCardNo
        + ", repayCardBank=" + repayCardBank + ", repayCardBranck=" + repayCardBranck
        + ", repayCardUser=" + repayCardUser + ", mateName=" + mateName + ", mateIdNumber="
        + mateIdNumber + ", matePhoneNumber=" + matePhoneNumber + ", mateEducationBackground="
        + mateEducationBackground + ", mateResidenceAddress=" + mateResidenceAddress
        + ", matePermanentAddress=" + matePermanentAddress + ", aBaseId=" + aBaseId + ", mhouseId="
        + mhouseId + ", mcarId=" + mcarId + ", serialNo=" + serialNo + ", mateInfoId=" + mateInfoId
        + ", channelCode=" + channelCode + ", guaranteeObject=" + guaranteeObject + ", mateInfo="
        + mateInfo + ", grantMoney=" + grantMoney + ", capitalization=" + capitalization
        + ", fileRPath=" + fileRPath + ", guaranteeValue=" + guaranteeValue + ", houseWarrantId="
        + houseWarrantId + ", carWarrantId=" + carWarrantId + ", commonApplicant="
        + commonApplicant + ", mortgageHouse=" + mortgageHouse + ", mortgageCar=" + mortgageCar
        + ", poList=" + poList + ", logViewList=" + logViewList + ", scratchFileList="
        + scratchFileList + "]";
  }

}
