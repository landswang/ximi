package com.ejie.nbrs.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ejie.nbrs.entity.CommonApplicant;
import com.ejie.nbrs.entity.MortgageCar;
import com.ejie.nbrs.entity.MortgageHouse;

public class LoanView {
  private Integer aBaseId;

  private String idNumber;

  private String sex;

  private String nationality;

  private Date birthday;

  private String phoneNumber;

  private String educationBackground;

  private String maritalStatus;

  private String career;

  private String permanentAddress;

  private String residenceAddress;

  private String name;

  private String city;

  private Date appDate;

  private String eProduct;

  private String repayWay;

  private BigDecimal appMoney;

  private String rate;

  private String repaymentLimit;

  private String loanPurpose;

  private BigDecimal comfirmValue;

  private String companyName;

  private String companyAddress;

  private String companyProperty;

  private String companyDept;

  private String companyNumber;

  private String yearsWorking;

  private String monthlyIncome;

  private String jobTitle;

  private String mateName;

  private String mateIdNumber;

  private String matePhoneNumber;

  private String mateEducationBackground;

  private String mateResidenceAddress;

  private String matePermanentAddress;

  private String cCardNumber;

  private String cCardName;

  private String cCardBank;

  private Integer id;

  private BigDecimal realLoanMoney;

  private String loanMethod;

  private Date loanDate;

  private String repaymentCardNumber;

  private String cardholder;

  private String repaymentBank;

  private String remark;

  private Float gRate;

  private Integer status;

  private Integer guaranteeId;

  private Integer cAInfoId;

  private String mhouseId;

  private String mcarId;

  private String loanImage;

  private List<CommonApplicant> commonApplicant;

  private List<MortgageHouse> mortgageHouse;

  private List<MortgageCar> mortgageCar;

  private String serialNo;

  public Integer getaBaseId() {
    return aBaseId;
  }

  public void setaBaseId(Integer aBaseId) {
    this.aBaseId = aBaseId;
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

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city == null ? null : city.trim();
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

  public String getRepaymentLimit() {
    return repaymentLimit;
  }

  public void setRepaymentLimit(String repaymentLimit) {
    this.repaymentLimit = repaymentLimit == null ? null : repaymentLimit.trim();
  }

  public String getLoanPurpose() {
    return loanPurpose;
  }

  public void setLoanPurpose(String loanPurpose) {
    this.loanPurpose = loanPurpose == null ? null : loanPurpose.trim();
  }

  public BigDecimal getComfirmValue() {
    return comfirmValue;
  }

  public void setComfirmValue(BigDecimal comfirmValue) {
    this.comfirmValue = comfirmValue;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName == null ? null : companyName.trim();
  }

  public String getCompanyAddress() {
    return companyAddress;
  }

  public void setCompanyAddress(String companyAddress) {
    this.companyAddress = companyAddress == null ? null : companyAddress.trim();
  }

  public String getCompanyProperty() {
    return companyProperty;
  }

  public void setCompanyProperty(String companyProperty) {
    this.companyProperty = companyProperty == null ? null : companyProperty.trim();
  }

  public String getCompanyDept() {
    return companyDept;
  }

  public void setCompanyDept(String companyDept) {
    this.companyDept = companyDept == null ? null : companyDept.trim();
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public BigDecimal getRealLoanMoney() {
    return realLoanMoney;
  }

  public void setRealLoanMoney(BigDecimal realLoanMoney) {
    this.realLoanMoney = realLoanMoney;
  }

  public String getLoanMethod() {
    return loanMethod;
  }

  public void setLoanMethod(String loanMethod) {
    this.loanMethod = loanMethod == null ? null : loanMethod.trim();
  }

  public Date getLoanDate() {
    return loanDate;
  }

  public void setLoanDate(Date loanDate) {
    this.loanDate = loanDate;
  }

  public String getRepaymentCardNumber() {
    return repaymentCardNumber;
  }

  public void setRepaymentCardNumber(String repaymentCardNumber) {
    this.repaymentCardNumber = repaymentCardNumber == null ? null : repaymentCardNumber.trim();
  }

  public String getCardholder() {
    return cardholder;
  }

  public void setCardholder(String cardholder) {
    this.cardholder = cardholder == null ? null : cardholder.trim();
  }

  public String getRepaymentBank() {
    return repaymentBank;
  }

  public void setRepaymentBank(String repaymentBank) {
    this.repaymentBank = repaymentBank == null ? null : repaymentBank.trim();
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  public Float getgRate() {
    return gRate;
  }

  public void setgRate(Float gRate) {
    this.gRate = gRate;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getGuaranteeId() {
    return guaranteeId;
  }

  public void setGuaranteeId(Integer guaranteeId) {
    this.guaranteeId = guaranteeId;
  }

  public Integer getcAInfoId() {
    return cAInfoId;
  }

  public void setcAInfoId(Integer cAInfoId) {
    this.cAInfoId = cAInfoId;
  }

  public String getMhouseId() {
    return mhouseId;
  }

  public void setMhouseId(String mhouseId) {
    this.mhouseId = mhouseId == null ? null : mhouseId.trim();
  }

  public String getMcarId() {
    return mcarId;
  }

  public void setMcarId(String mcarId) {
    this.mcarId = mcarId == null ? null : mcarId.trim();
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

  public String getLoanImage() {
    return loanImage;
  }

  public void setLoanImage(String loanImage) {
    this.loanImage = loanImage;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  @Override
  public String toString() {
    return "LoanView [aBaseId=" + aBaseId + ", idNumber=" + idNumber + ", sex=" + sex
        + ", nationality=" + nationality + ", birthday=" + birthday + ", phoneNumber="
        + phoneNumber + ", educationBackground=" + educationBackground + ", maritalStatus="
        + maritalStatus + ", career=" + career + ", permanentAddress=" + permanentAddress
        + ", residenceAddress=" + residenceAddress + ", name=" + name + ", city=" + city
        + ", appDate=" + appDate + ", eProduct=" + eProduct + ", repayWay=" + repayWay
        + ", appMoney=" + appMoney + ", rate=" + rate + ", repaymentLimit=" + repaymentLimit
        + ", loanPurpose=" + loanPurpose + ", comfirmValue=" + comfirmValue + ", companyName="
        + companyName + ", companyAddress=" + companyAddress + ", companyProperty="
        + companyProperty + ", companyDept=" + companyDept + ", companyNumber=" + companyNumber
        + ", yearsWorking=" + yearsWorking + ", monthlyIncome=" + monthlyIncome + ", jobTitle="
        + jobTitle + ", mateName=" + mateName + ", mateIdNumber=" + mateIdNumber
        + ", matePhoneNumber=" + matePhoneNumber + ", mateEducationBackground="
        + mateEducationBackground + ", mateResidenceAddress=" + mateResidenceAddress
        + ", matePermanentAddress=" + matePermanentAddress + ", cCardNumber=" + cCardNumber
        + ", cCardName=" + cCardName + ", cCardBank=" + cCardBank + ", id=" + id
        + ", realLoanMoney=" + realLoanMoney + ", loanMethod=" + loanMethod + ", loanDate="
        + loanDate + ", repaymentCardNumber=" + repaymentCardNumber + ", cardholder=" + cardholder
        + ", repaymentBank=" + repaymentBank + ", remark=" + remark + ", gRate=" + gRate
        + ", status=" + status + ", guaranteeId=" + guaranteeId + ", cAInfoId=" + cAInfoId
        + ", mhouseId=" + mhouseId + ", mcarId=" + mcarId + ", loanImage=" + loanImage
        + ", commonApplicant=" + commonApplicant + ", mortgageHouse=" + mortgageHouse
        + ", mortgageCar=" + mortgageCar + ", serialNo=" + serialNo + "]";
  }



}
