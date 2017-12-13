package com.ejie.nbrs.entity;

/**
 * 
 * ClassName:Privilege 权限表实体
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017 2017年7月19日 上午10:39:47
 * @see
 */
public class Privilege {
  /*
   * 权限id
   */
  private Integer privilegeId;
  /*
   * 权限名称
   */
  private String privilegeName;
  /*
   * 权限级别
   */
  private String privilegeLevel;

  /*
   * 权限对应的访问菜单
   */
  private String url;

  /*
   * 权限描述
   */
  private String privilegeComment;

  @Override
  public String toString() {
    return "Privilege [privilegeId=" + privilegeId + ", privilegeName=" + privilegeName
        + ", privilegeLevel=" + privilegeLevel + ", url=" + url + ", privilegeComment="
        + privilegeComment + "]";
  }

  /* getter setter */
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

  public String getPrivilegeComment() {
    return privilegeComment;
  }

  public void setPrivilegeComment(String privilegeComment) {
    this.privilegeComment = privilegeComment == null ? null : privilegeComment.trim();
  }
}
