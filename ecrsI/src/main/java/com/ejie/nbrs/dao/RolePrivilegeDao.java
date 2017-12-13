package com.ejie.nbrs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ejie.nbrs.dto.RandP;
import com.ejie.nbrs.entity.RolePrivilege;

public interface RolePrivilegeDao {
  int insert(RolePrivilege record);

  /**
   * 
   * insertRPbase:为角色赋权
   * 
   * @param @param rps 权限列表
   * @param @return 设定文件
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  int insertRPList(RandP rps);

  /**
   * 
   * deleteRPByRoleId:清空指定角色权限
   * 
   * @param @param roleId 角色id
   * @param @return 设定文件
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  int deleteRPByRoleId(@Param("roleId") Integer roleId);

  /**
   * 
   * insertRPList:批量插入用户权限
   * 
   * @param @param rps 用户权限列表
   * @param @return 设定文件
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  int insertRPList(@Param("rps") List<RolePrivilege> rps);

  /**
   * selectRPByRoleId:返回角色所有权限
   * 
   * @param @param roleId 角色id
   * @param @return 设定文件
   * @return List<RolePrivilege> 所有权限集合
   * @throws
   * @since CodingExample　Ver 1.1
   */
  List<RolePrivilege> selectRPByRoleId(@Param("roleId") Integer roleId);
}
