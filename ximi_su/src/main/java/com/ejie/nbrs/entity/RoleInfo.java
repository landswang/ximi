package com.ejie.nbrs.entity;

/**
 * 
 * ClassName:RoleInfo
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017 2017年7月17日 下午4:05:25
 * @see
 */
public class RoleInfo {
  /**
   * 角色id
   */
  private Integer roleId;
  /**
   * 角色名
   */
  private String roleName;
  /**
   * 角色描述
   */
  private String roleComment;

  public String getRoleComment() {
    return roleComment;
  }

  public void setRoleComment(String roleComment) {
    this.roleComment = roleComment;
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName == null ? null : roleName.trim();
  }

  @Override
  public String toString() {
    return "RoleInfo [roleId=" + roleId + ", roleName=" + roleName + ", roleComment=" + roleComment
        + "]";
  }


}
