package com.ejie.nbrs.dto;

import java.util.Arrays;

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
public class RandP {
  /**
   * 角色id
   */
  private Integer roleId;


  /**
   * 权限id
   */
  private Integer[] privilegeId;



  /* getter setter */
  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public Integer[] getPrivilegeId() {
    return privilegeId;
  }

  public void setPrivilegeId(Integer[] privilegeId) {
    this.privilegeId = privilegeId;
  }

  @Override
  public String toString() {
    return "RandP [roleId=" + roleId + ", privilegeId=" + Arrays.toString(privilegeId) + "]";
  }


}
