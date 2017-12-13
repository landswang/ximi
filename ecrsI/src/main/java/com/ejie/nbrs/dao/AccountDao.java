package com.ejie.nbrs.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ejie.nbrs.entity.Account;

/**
 * 
 * ClassName:AccountDao 账户操作类
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017 2017年7月14日 下午4:40:25
 * @see
 */
public interface AccountDao {
  /**
   * 
   * queryByUName:(通过用户名查询用户信息)
   * 
   * @param @param userName 用户名
   * @param @return 设定文件
   * @return Account DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  Account queryByUName(String userName);

  int deleteByPrimaryKey(Integer userId);

  int insertSelective(Account record);

  /**
   * 通过主键查询account
   * 
   * @param userId
   * @return
   */
  Account selectByUId(@Param("userId") Integer userId);


  int updateByPrimaryKeySelective(Account record);

  int updateByPrimaryKey(Account record);
  
  int insert(Account record);

  /**
   * 添加用户信息进入account表
   * 
   * @param accountName 用户帐号
   * @param password 密码
   * @param userName 用户姓名
   * @return
   */
  int insertUser(Account user);

  /**
   * 查询所有account
   * 
   * @return
   */
  List<Account> selectAll();

  // /////////////
  /**
   * 
   * modifyAccount:通过用户id 更改账号状态
   * 
   * @param userid
   * @return 设定文件
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  int modifyAccount(Account acc);

  int resetpwd(Account acc);

}
