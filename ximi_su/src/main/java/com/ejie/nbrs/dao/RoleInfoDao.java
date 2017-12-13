package com.ejie.nbrs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ejie.nbrs.entity.RoleInfo;

/**
 * 
 * RoleInfoDao 用户角色
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017 2017年7月14日 下午4:40:25
 * @see
 */
public interface RoleInfoDao {

  /**
   * 添加用户信息进入RoleInfo
   * 
   * @param roleId 角色id
   * @param roleComment 角色描述
   * @return
   */
  boolean insertUser(RoleInfo role);


  /**
   * 通过userId查询RoleInfo
   * 
   * @param roleNAme 角色名
   * @return
   */
  RoleInfo selectByRoleName(@Param("roleNAme") String roleName);

  /**
   * 查询所有RoleInfo
   * 
   * @return
   */
  List<RoleInfo> selectAll();

  // /未实现的接口
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



}
