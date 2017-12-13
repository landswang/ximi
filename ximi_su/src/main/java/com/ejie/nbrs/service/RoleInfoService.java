package com.ejie.nbrs.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ejie.nbrs.dto.RandP;
import com.ejie.nbrs.entity.RoleInfo;
import com.ejie.nbrs.entity.RolePrivilege;

/**
 * 
 * ClassName:AccountService 账户处理Service
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017 2017年7月14日 下午4:56:17
 * @see
 */
public interface RoleInfoService {

  List<RoleInfo> queryByAll();

  /**
   * 
   * insertUser:(这里用一句话描述这个方法的作用)
   * 
   * @param @param role
   * @param @return 设定文件
   * @return boolean DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  boolean insertUser(RoleInfo role);



  /**
   * 通过userId查询RoleInfo
   * 
   * @param roleNAme 角色名
   * @return
   */
  RoleInfo selectByRoleName(String roleName);

  /**
   * 查询所有RoleInfo
   * 
   * @return
   */
  List<RoleInfo> selectAll();

  /**
   * 
   * distincRoleName:(加distinc查询所有角色)
   * 
   * @param @return 设定文件
   * @return List<RoleInfo> DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  List<RoleInfo> distincRoleName();

  /**
   * 
   * modifyRole: 修改当前role
   * 
   * @param @param r 需要修改的role
   * @param @return 修改结果
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  int modifyRole(RoleInfo r);

  /**
   * 
   * selectRPByRoleId:返回角色所有权限
   * 
   * @param @param roleId 角色id
   * @param @return 设定文件
   * @return List<RolePrivilege> 所有权限集合
   * @throws
   * @since CodingExample　Ver 1.1
   */
  List<RolePrivilege> selectRPByRoleId(@Param("roleId") Integer roleId);

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
  int deleteRPByRoleId(Integer roleId);

}
