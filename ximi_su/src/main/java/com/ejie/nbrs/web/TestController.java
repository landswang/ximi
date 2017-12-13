package com.ejie.nbrs.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejie.nbrs.cache.RedisCache;
import com.ejie.nbrs.dao.ApplicantDao;
import com.ejie.nbrs.dto.Emessage;
import com.ejie.nbrs.ejieinterface.service.EjieDataService;
import com.ejie.nbrs.entity.Account;
import com.ejie.nbrs.service.AccountService;
import com.ejie.nbrs.service.DownImageService;
import com.ejie.nbrs.service.PackDownFileService;
import com.ejie.nbrs.service.RoleInfoService;
import com.ejie.nbrs.service.UserService;

@Controller
@RequestMapping("/test")
public class TestController {

  private final Logger LOG = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private UserService userService;
  @Autowired
  private AccountService accountService;
  @Autowired
  private RoleInfoService roleInfoService;
  @Autowired
  private RedisCache rc;
  @Autowired
  private ApplicantDao appDao;
  @Autowired
  private DownImageService downImageService;
  @Autowired
  private EjieDataService ejieDataService;
  @Autowired
  private PackDownFileService pdFileService;

  @RequestMapping("/myjsp")
  public String test01(Account models, HttpServletRequest request) {
    System.out.println("test01 " + request.getSession().toString());
    /*
     * Emessage msg = new Emessage("test title", "content", 1000, 1000); msg.setLoanId(10000);
     * 
     * HashMap<String,Emessage> hm= new HashMap<>(); hm.put("10000", msg); hm.put("10001", msg);
     * hm.put("10002", msg); hm.put("10003", msg); hm.put("10004", msg);
     * 
     * redis.putHashCache("role_10000", hm); redis.putHashCache("user_10000", hm);
     * redis.putHashCache("all_10000", hm); Account account =new Account();
     * account.setRoleId(10000); account.setUserId(10000);
     * 
     * MessageUtil.loginSend(account,redis);
     */
    Account account = new Account();
    account.setRoleId(1062);
    rc.getHashCache("role_" + account.getRoleId(), Emessage.class);
    // redis.deleteHashCache("role_10000", "10000");

    // rc.changeHashCache("role_"+account.getRoleId(), "10002");
    return "MyJsp";
  }

  @RequestMapping("/websocket")
  public String websocket(Account models, HttpServletRequest request) {
    System.out.println("login " + request.getSession().toString());
    return "websocket";
  }

  @RequestMapping("/lo")
  public String lo(Account models, HttpServletRequest request) {
    System.out.println("login " + request.getSession().toString());
    return "login";
  }

  @RequestMapping("/userindex")
  public String userindex(@RequestBody Account models, HttpServletRequest request,
      HttpSession session) {
    System.out.println("userindex  request.getSession().toString() is "
        + request.getSession().toString());
    System.out.println("userindex  session.toString() is " + session.toString());
    return "userindex";
  }

  @RequestMapping("/ii")
  public String index(HttpSession session) {
    System.out.println("UserController CURRENT_USER is   " + session.getAttribute("CURRENT_USER"));
    System.out.println(" UserController userindex  session.toString() is " + session.toString());
    return "userindex";
  }

  @RequestMapping("/ws")
  public String websoket() {
    return "websocket";
  }

  @RequestMapping("/11")
  public String getNewOrder() {
    ejieDataService.getNewOrder("YJCD2017081600003", null);
    return "";
  }

}
