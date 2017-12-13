package com.ejie.nbrs.entity;

import java.util.Arrays;

/**
 * 
 * ClassName:Account 账户实体
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017 2017年7月14日 下午5:55:21
 * @see
 */
public class Account {
  /**
   * 用户唯一标示
   */
  private Integer userId;
  /**
   * 角色id
   */
  private Integer roleId;

  /**
   * 用户姓名
   */
  private String userName;

  /**
   * 用户帐号
   */
  private String accountName;
  /**
   * 密码
   */
  private String password;
  /**
   * 邮箱
   */
  private String email;
  /**
   * 手机
   */
  private String phoneNumber;
  /**
   * 用户类型
   */
  private String userType;
  /**
   * 用户状态
   */
  private String status;
  /**
   * 安全密匙
   */
  private String apikey;
  /**
   * 验证码
   */
  private String verificationCode;

  /**
   * 备注
   */
  private String statusRemark;
  /**
   * 权限数组
   */
  private String[] privilegeList;

  /**
   * 角色
   */
  private RoleInfo roleInfo;
  /**
   * 角色
   */
  private String utoken;

  /* 以下是get、set方法 */

  public String getUtoken() {
    return utoken;
  }

  public void setUtoken(String utoken) {
    this.utoken = utoken;
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public RoleInfo getRoleInfo() {
    return roleInfo;
  }

  public void setRoleInfo(RoleInfo roleInfo) {
    this.roleInfo = roleInfo;
  }

  public String getStatusRemark() {
    return statusRemark;
  }

  public void setStatusRemark(String statusRemark) {
    this.statusRemark = statusRemark;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getApikey() {
    return apikey;
  }

  public void setApikey(String apikey) {
    this.apikey = apikey;
  }

  public String getVerificationCode() {
    return verificationCode;
  }

  public void setVerificationCode(String verificationCode) {
    this.verificationCode = verificationCode;
  }


  public String[] getPrivilegeList() {
    return privilegeList;
  }

  public void setPrivilegeList(String[] privilegeList) {
    this.privilegeList = privilegeList;
  }

  @Override
  public String toString() {
    return "Account [userId=" + userId + ", roleId=" + roleId + ", userName=" + userName
        + ", accountName=" + accountName + ", password=" + password + ", email=" + email
        + ", phoneNumber=" + phoneNumber + ", userType=" + userType + ", status=" + status
        + ", apikey=" + apikey + ", verificationCode=" + verificationCode + ", statusRemark="
        + statusRemark + ", privilegeList=" + Arrays.toString(privilegeList) + ", roleInfo="
        + roleInfo + ", utoken=" + utoken + "]";
  }


}
