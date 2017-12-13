package com.ejie.nbrs.entity;

/**
 * 
 * ClassName:角色权限实体
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017 2017年7月19日 下午5:55:21
 * @see
 */
public class RolePrivilege {
  /**
   * 角色id
   */
  private Integer roleId;

  /**
   * 角色名称
   */
  private String roleName;

  /**
   * 角色备注
   */
  private String roleComment;

  /**
   * 权限id
   */
  private Integer privilegeId;

  /**
   * 权限名称
   */
  private String privilegeName;

  /**
   * 权限级别
   */
  private String privilegeLevel;
  /**
   * 父级权限
   */
  private Integer perantLevel;

  /**
   * 可访问url
   */
  private String url;

  @Override
  public String toString() {
    return "RolePrivilege [roleId=" + roleId + ", roleName=" + roleName + ", roleComment="
        + roleComment + ", privilegeId=" + privilegeId + ", privilegeName=" + privilegeName
        + ", privilegeLevel=" + privilegeLevel + ", perantLevel=" + perantLevel + ", url=" + url
        + "]";
  }

  /* getter setter */
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

  public String getRoleComment() {
    return roleComment;
  }

  public void setRoleComment(String roleComment) {
    this.roleComment = roleComment == null ? null : roleComment.trim();
  }

  public Integer getPrivilegeId() {
    return privilegeId;
  }

  public void setPrivilegeId(Integer privilegeId) {
    this.privilegeId = privilegeId;
  }

  public String getPrivilegeName() {
    return privilegeName;
  }

  public void setPrivilegeName(String privilegeName) {
    this.privilegeName = privilegeName == null ? null : privilegeName.trim();
  }

  public String getPrivilegeLevel() {
    return privilegeLevel;
  }

  public void setPrivilegeLevel(String privilegeLevel) {
    this.privilegeLevel = privilegeLevel == null ? null : privilegeLevel.trim();
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url == null ? null : url.trim();
  }

  public Integer getPerantLevel() {
    return perantLevel;
  }

  public void setPerantLevel(Integer perantLevel) {
    this.perantLevel = perantLevel;
  }
}
