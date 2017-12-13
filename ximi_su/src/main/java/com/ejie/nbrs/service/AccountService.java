package com.ejie.nbrs.service;


import java.util.List;

import com.ejie.nbrs.dto.AccountWithRoleInfo;
import com.ejie.nbrs.dto.BaseResult;
import com.ejie.nbrs.entity.Account;
import com.ejie.nbrs.entity.LoginAccount;
import com.ejie.nbrs.entity.RoleInfo;

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
public interface AccountService {

  /**
   * 
   * login:根据用户名、密码完成登录
   * 
   * @param @param name 用户名
   * @param @param pwd 密码
   * @param @return 设定文件
   * @return Account 登录成功的账户
   * @throws
   * @since CodingExample　Ver 1.1
   */
  /**
   * 
   * login:根据用户名、密码、验证码完成登录
   * 
   * @param @param loginAccount 登录信息封装
   * @param @return 设定文件
   * @return BaseResult<Account> DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  BaseResult<Account> login(LoginAccount loginAccount);

  /**
   * 
   * AddAccount:新建用户
   * 
   * @param @param acc
   * @param @return 设定文件
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  int AddAccount(Account acc);

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
   * 通过主键查询account
   * 
   * @param userId
   * @return
   */
  Account selectByUId(Integer userId);

  /**
   * 查询所有account
   * 
   * @return
   */
  List<AccountWithRoleInfo> selectAll();

  /**
   * 
   * modifyUserStatus:通过用户id 更改账号状态
   * 
   * @param userid
   * @return 设定文件
   * @return int DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  int modifyAccount(Account acc);

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
   * modifyRole: 根据用户名查询对象
   * 
   * @param @param accountName
   * @param @return
   * @return
   * @throws
   * @since
   */
  Account queryByUName(String accountName);

  /**
   * 
   * queryByUId:根据用户id 返回用户信息
   * 
   * @param @param userId
   * @param @return 设定文件
   * @return Account DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  Account queryByUId(Integer userId);
  
  /**
   * 
   * queryByUId:根据用户id 返回用户信息
   * 
   * @param @param userId
   * @param @return 设定文件
   * @return Account DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  BaseResult<Account> resetpwd(LoginAccount loginAccount);

}
