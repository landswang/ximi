package com.ejie.nbrs.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ejie.nbrs.cache.RedisCache;
import com.ejie.nbrs.dao.AccWRDao;
import com.ejie.nbrs.dao.AccountDao;
import com.ejie.nbrs.dao.RoleInfoDao;
import com.ejie.nbrs.dao.RolePrivilegeDao;
import com.ejie.nbrs.dto.AccountWithRoleInfo;
import com.ejie.nbrs.dto.BaseResult;
import com.ejie.nbrs.entity.Account;
import com.ejie.nbrs.entity.LoginAccount;
import com.ejie.nbrs.entity.RoleInfo;
import com.ejie.nbrs.entity.RolePrivilege;
import com.ejie.nbrs.service.AccountService;
import com.ejie.nbrs.util.TdesUtil;
import com.ejie.nbrs.util.TimeUtils;
import com.ejie.nbrs.util.TokenGenerator;

@Service
public class AccountServiceImpl implements AccountService {

  private final Logger LOG = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private AccountDao accountDao;
  @Autowired
  private AccWRDao accwrDao;
  @Autowired
  private RoleInfoDao riDao;
  @Autowired
  private RedisCache cache;
  @Autowired
  private RolePrivilegeDao roleRPDao;

  /**
   * @name login ： 用户登录处理 (non-Javadoc)
   * 
   * @param la ：登录信息（用户名、密码验、证码等信息）
   * 
   * @see com.ejie.nbrs.service.AccountService#login(com.ejie.nbrs.entity.LoginAccount)
   */
  @Override
  @Transactional(propagation=Propagation.REQUIRES_NEW)
  public BaseResult<Account> login(LoginAccount la) {
    int code = 0;
    String msg = "验证码过期";
    Account acc = null;
    acc = accountDao.queryByUName(la.getUserName());
    if (acc != null) {
      try {
        if (acc.getPassword() != null && la != null && la.getPassword() != null) {
          if (acc.getPassword().equals(TdesUtil.encrypt(la.getPassword()))) {
            if (acc.getStatus().equals("0")) {
              /* 查询用户权限，并装填到account 中 */
              List<RolePrivilege> rps = roleRPDao.selectRPByRoleId(acc.getRoleId());
              if (rps != null) {// 遍历权限id
                String pls = "";
                for (int r = 0; r < rps.size(); r++) {
                  pls += rps.get(r).getPrivilegeId();
                  if (r + 1 < rps.size()) {
                    pls += ",";
                  }
                }
                System.out.println("pls is " + pls);
                String[] plss = pls.split(",");
                acc.setPrivilegeList(plss);
              }
              LOG.info("this is user login success " + acc);
              code = 1;
              msg = "登录成功";
              /* 添加token */
              String utoken =
                  TokenGenerator.generateValue(acc.getAccountName() + acc.getPassword()
                      + TimeUtils.getCurrentTimeInLong());// 生成token
              acc.setUtoken(utoken);// 用户赋token
              System.out.println("--------------------------------utoken is " + utoken);
              cache.putCacheWithExpireTime(utoken, acc, 1800); // 将登录用户放入缓存中过期时间30分钟
            } else {
              msg = "账号已禁用";
              acc = null;
              LOG.info("this is user login failure : wrong password  " + acc);
            }
          } else {
            msg = "用户名或者密码错误";
            acc = null;
            LOG.info("this is user login failure : wrong password  " + acc);
          }
        }
      } catch (Exception e) {
        code = 0;
        msg = "登录失败";
      }
    } else {
      msg = "用户名或者密码错误";
    }


    return new BaseResult<Account>(code, msg, acc);

  }



  /**
   * 
   * (non-Javadoc)
   * 
   * @see com.ejie.nbrs.service.AccountService#AddAccount(com.ejie.nbrs.entity.Account)
   */
  @Override
  @Transactional(propagation=Propagation.REQUIRES_NEW)
  public int AddAccount(Account acc) {
    try {
      acc.setPassword(com.ejie.nbrs.util.TdesUtil.encrypt(acc.getPassword()));
    } catch (Exception e) {

      // TODO Auto-generated catch block
      e.printStackTrace();

    }
    // TODO Auto-generated method stub
    return accountDao.insert(acc);

  }

  /**
   * 实现添加的方法
   */
  @Override
  @Transactional(propagation=Propagation.REQUIRES_NEW)
  public int insertUser(Account user) {
    System.out.println("-------------------user.getPassword()------------------");
    System.out.println("-------------------user.getPassword() is " + user.getPassword());
    String ss = user.getPassword();
    try {
      ss = TdesUtil.encrypt(ss);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("-------------------after Password is " + ss);

    user.setPassword(ss);
    System.out.println("-------------------user.getPassword() is " + user.getPassword());
    return accountDao.insertUser(user);
  }

  @Override
  public Account selectByUId(Integer userId) {
    return accountDao.selectByUId(userId);
  }

  @Override
  public List<AccountWithRoleInfo> selectAll() {
    List<AccountWithRoleInfo> userlist = accwrDao.selectAll(0, 1000000);
    return userlist;
  }

  @Override
  public int modifyAccount(Account user) {
    return accountDao.modifyAccount(user);
  }

  @Override
  public int modifyRole(RoleInfo r) {

    return riDao.modifyRole(r);


  }

  @Override
  public Account queryByUName(String accountName) {
    return accountDao.queryByUName(accountName);

  }

  @Override
  public Account queryByUId(Integer userId) {
    return accountDao.selectByUId(userId);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.ejie.nbrs.service.AccountService#resetpwd(com.ejie.nbrs.entity.LoginAccount)
   */
  @Override
  @Transactional(propagation=Propagation.REQUIRES_NEW)
  public BaseResult<Account> resetpwd(LoginAccount la) {
    int code = 1;
    String msg = "修改成功";
    Account acc = accountDao.queryByUName(la.getUserName());


    int acc1 = 0;
    try {

      if (acc != null && TdesUtil.encrypt(la.getPassword()).equals(acc.getPassword())) {
        acc.setPassword(TdesUtil.encrypt(la.getRepassword()));

        acc1 = accountDao.resetpwd(acc);
        if (acc1 == 0) {
          code = 0;
          msg = "修改失败";
        }

      } else {
        code = 0;
        msg = "原始密码错误";
      }

    } catch (Exception e) {
      code = 0;
      msg = "修改失败";


    }

    return new BaseResult<Account>(code, msg, acc);
  }



}
