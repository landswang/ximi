package com.ejie.nbrs.dto;

public class AccountWithRoleInfo {
  private Integer userId;

  private String accountName;

  private String userName;

  private Integer roleId;

  private String password;

  private String status;

  private String statusRemark;

  private String roleName;

  private String roleComment;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName == null ? null : accountName.trim();
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName == null ? null : userName.trim();
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password == null ? null : password.trim();
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status == null ? null : status.trim();
  }

  public String getStatusRemark() {
    return statusRemark;
  }

  public void setStatusRemark(String statusRemark) {
    this.statusRemark = statusRemark == null ? null : statusRemark.trim();
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName == null ? null : roleName.trim();
  }

  public String getRoleComment() {
    return roleComment;
  }

  public void setRoleComment(String roleComment) {
    this.roleComment = roleComment == null ? null : roleComment.trim();
  }

  @Override
  public String toString() {
    return "AccountWithRoleInfo [userId=" + userId + ", accountName=" + accountName + ", userName="
        + userName + ", roleId=" + roleId + ", password=" + password + ", status=" + status
        + ", statusRemark=" + statusRemark + ", roleName=" + roleName + ", roleComment="
        + roleComment + "]";
  }

}
