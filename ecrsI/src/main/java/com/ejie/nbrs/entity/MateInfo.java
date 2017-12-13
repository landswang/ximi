package com.ejie.nbrs.entity;
/**
 * 
 * ClassName:MateInfo 配偶信息
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月17日 下午8:55:20
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public class MateInfo {
	/**
	 * 配偶主键
	 */
    private Integer mateInfoId;
    /**
     * 配偶姓名
     */
    private String mateName;
/**
 * 证件号
 */
    private String mateIdNumber;
/**
 * 电话
 */
    private String matePhoneNumber;
/**
 * 学历
 */
    private String mateEducationBackground;
/**
 * 户籍地址
 */
    private String matePermanentAddress;
/**
 * 居住地址
 */
    private String mateResidenceAddress;
    /**
     * 配偶年龄
     */
    private String mateAge;
    /**
     * 配偶性别
     */
    private String mateGender;
	public Integer getMateInfoId() {
		return mateInfoId;
	}
	public void setMateInfoId(Integer mateInfoId) {
		this.mateInfoId = mateInfoId;
	}
	public String getMateName() {
		return mateName;
	}
	public void setMateName(String mateName) {
		this.mateName = mateName;
	}
	public String getMateIdNumber() {
		return mateIdNumber;
	}
	public void setMateIdNumber(String mateIdNumber) {
		this.mateIdNumber = mateIdNumber;
	}
	public String getMatePhoneNumber() {
		return matePhoneNumber;
	}
	public void setMatePhoneNumber(String matePhoneNumber) {
		this.matePhoneNumber = matePhoneNumber;
	}
	public String getMateEducationBackground() {
		return mateEducationBackground;
	}
	public void setMateEducationBackground(String mateEducationBackground) {
		this.mateEducationBackground = mateEducationBackground;
	}
	public String getMatePermanentAddress() {
		return matePermanentAddress;
	}
	public void setMatePermanentAddress(String matePermanentAddress) {
		this.matePermanentAddress = matePermanentAddress;
	}
	public String getMateResidenceAddress() {
		return mateResidenceAddress;
	}
	public void setMateResidenceAddress(String mateResidenceAddress) {
		this.mateResidenceAddress = mateResidenceAddress;
	}
	public String getMateAge() {
		return mateAge;
	}
	public void setMateAge(String mateAge) {
		this.mateAge = mateAge;
	}
	public String getMateGender() {
		return mateGender;
	}
	public void setMateGender(String mateGender) {
		this.mateGender = mateGender;
	}
	@Override
	public String toString() {
		return "MateInfo [mateInfoId=" + mateInfoId + ", mateName=" + mateName
				+ ", mateIdNumber=" + mateIdNumber + ", matePhoneNumber="
				+ matePhoneNumber + ", mateEducationBackground="
				+ mateEducationBackground + ", matePermanentAddress="
				+ matePermanentAddress + ", mateResidenceAddress="
				+ mateResidenceAddress + ", mateAge=" + mateAge
				+ ", mateGender=" + mateGender + "]";
	}

  
}