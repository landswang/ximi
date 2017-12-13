package com.ejie.nbrs.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ejie.nbrs.cache.RedisCache;
import com.ejie.nbrs.dto.AccountWithRoleInfo;
import com.ejie.nbrs.dto.BaseResult;
import com.ejie.nbrs.entity.Account;
import com.ejie.nbrs.entity.LoginAccount;
import com.ejie.nbrs.service.AccountService;
import com.ejie.nbrs.service.DownImageService;
import com.ejie.nbrs.service.UserService;
import com.ejie.nbrs.util.SessionUtils;

@Controller
@RequestMapping("/user")
@SessionAttributes("CURRENT_USER")
public class UserController {

  private final Logger LOG = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private UserService userService;
  @Autowired
  private AccountService accountService;
  @Autowired
  private DownImageService downImageService;
  @Autowired
  private RedisCache cache;

  /**
   * 
   * login:用户登录
   * 
   * @param @param request
   * @param @param model
   * @param @param la
   * @param @return 设定文件
   * @return BaseResult<Account> DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  @CrossOrigin
  public BaseResult<Account> login(HttpSession session, HttpServletRequest request, Model model,
      @RequestBody LoginAccount la) {
    // String ip=request.getRemoteAddr();
    // System.out.println("用户ip地址为："+request.getSession().getAttribute("ip"));

    String operateIp = SessionUtils.getLocalIp(request);
    // System.out.println("。。。。。。。。。用户ip地址为："+operateIp);
    session.setAttribute("operateIp", operateIp);

    String cache_key = RedisCache.CAHCENAME + "|" + request.getSession() + "| ";
    String _sRand = cache.getCache(cache_key, String.class);
    if (_sRand != null) {
      if (_sRand.equalsIgnoreCase(la.getVerificationCode())) {// 验证码通过校验
        return accountService.login(la);
      } else {
        return new BaseResult<Account>(0, "验证码输入有误", null);
      }
    } else {
      return new BaseResult<Account>(0, "验证码过期", null);
    }
    // return accountService.login(la);
  }

  /**
   * 
   * resetpwd:修改密码
   * 
   * @param @param request
   * @param @param model
   * @param @param la
   * @param @return 设定文件
   * @return BaseResult<Account> DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  @RequestMapping(value = "/resetpwd", method = RequestMethod.POST)
  @ResponseBody
  @CrossOrigin
  public BaseResult<Account> resetpwd(HttpServletRequest request, @RequestBody LoginAccount la) {
    return accountService.resetpwd(la);
  }



  @RequestMapping("/ftp")
  public String ftp(Account models, HttpServletRequest request) throws Exception {
    downImageService.saveImage();
    return "ftp";
  }

  @RequestMapping(value = "/creatUser", method = RequestMethod.POST)
  @ResponseBody
  @CrossOrigin
  public BaseResult<Account> creatUser(@RequestBody Account models, HttpServletRequest request) {
    System.out.println("creatUser " + request.getSession().toString());
    String urs = "fail";
    int code = 0;
    try {
      Account existsUser = accountService.queryByUName(models.getAccountName());
      if (existsUser != null && existsUser.getAccountName().equals(models.getAccountName())) {
        urs = "账户名已存在";
      } else {
        int rs = accountService.insertUser(models);
        if (rs == 1) {
          urs = "创建用户 " + models.getAccountName() + " 成功";
          code = 1;
        }
      }
    } catch (Exception e) {
      code = 0;
      urs = "创建用户失败：数据原因";
      e.printStackTrace();
      return new BaseResult<Account>(code, urs, models);
    }
    return new BaseResult<Account>(code, urs, models);
  }

  @RequestMapping(value = "/userList", method = RequestMethod.POST)
  @ResponseBody
  @CrossOrigin
  public List<AccountWithRoleInfo> userLsit(@Param(value = "userId") Integer userId,
      HttpServletRequest request) {
    System.out.println("userList " + request.getSession().toString());
    List<AccountWithRoleInfo> accs = accountService.selectAll();
    for (AccountWithRoleInfo goods : accs) {
      System.out.println(goods);
    }
    return accs;
  }

  @RequestMapping(value = "/modifyAccount", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<String> modifyUser(@RequestBody AccountWithRoleInfo awri) {
    String msg = "修改失败";
    /* 装在要要操作的account */
    System.out.println("----------------------------------------------------------");
    System.out.println("--------------------------------------awri is " + awri);
    Account acc = new Account();
    acc.setUserId(awri.getUserId());
    acc.setStatus(awri.getStatus());
    acc.setRoleId(awri.getRoleId());
    acc.setStatusRemark(awri.getStatusRemark());
    acc.setUserName(awri.getUserName());
    System.out.println("AccountWithRoleInfo is " + acc);
    /* 装在要要操作的account */
    int code = accountService.modifyAccount(acc);
    System.out.println("AccountWithRoleInfo d is " + code);
    if (code == 1) {
      code = 1;
      msg = "修改成功";
    }
    return new BaseResult<String>(code, msg, "");
  }

}
