package com.ejie.nbrs.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejie.nbrs.dto.BaseResult;
import com.ejie.nbrs.dto.RandP;
import com.ejie.nbrs.entity.RoleInfo;
import com.ejie.nbrs.entity.RolePrivilege;
import com.ejie.nbrs.service.RoleInfoService;

/**
 * 
 * ClassName:AdminController 用户登录
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017 2017年7月14日 下午5:15:55
 * @see
 */
@RequestMapping("/auth")
@Controller
public class AuthController {

  @Autowired
  private RoleInfoService roleInfodao;

  @RequestMapping(value = "/creatRole", method = RequestMethod.POST)
  @ResponseBody
  @CrossOrigin(maxAge = 3600)
  public BaseResult<RoleInfo> creatRole(@RequestBody RoleInfo s) {
    String urs = "添加失败";
    int rs = 0;
    roleInfodao.selectByRoleName(s.getRoleName());
    if (roleInfodao.selectByRoleName(s.getRoleName()) == null) {
      // urs = ResponseRSEncaps.encaps2j(0, "成功", s);
      if (roleInfodao.insertUser(s)) {
        urs = "添加成功";
        rs = 1;
      }
    } else {
      urs = "已经存在该角色";
    }
    return new BaseResult<RoleInfo>(rs, urs);

  }

  @RequestMapping(value = "/allRoleName", method = RequestMethod.POST)
  @ResponseBody
  @CrossOrigin(maxAge = 3600)
  public BaseResult<List<RoleInfo>> getAllRoleName(Model model) {
    // public String getAllRoleName(Model model) {
    String urs = "查询失败";
    int rs = 0;
    List<RoleInfo> ls = roleInfodao.queryByAll();
    System.err.println("------ddddd----- " + ls.size());
    if (ls.size() == 0) {

    } else {
      urs = "查询成功";
      rs = 1;
    }
    return new BaseResult<List<RoleInfo>>(rs, urs, ls);
  }

  @RequestMapping(value = "/modifyRole", method = RequestMethod.POST)
  @ResponseBody
  @CrossOrigin(maxAge = 3600)
  public String modifyRole(@RequestBody RoleInfo s) {
    String rs = "fail";
    // s.setUserId(null);
    if (roleInfodao.modifyRole(s) == 1) {
      // urs = ResponseRSEncaps.encaps2j(0, "成功", s);
      rs = "ok";
    } else {
    }
    return rs;
  }

  @RequestMapping(value = "/allRoleInfo", method = RequestMethod.POST)
  @ResponseBody
  @CrossOrigin(maxAge = 3600)
  public BaseResult<List<RoleInfo>> getAllRole(Model model) {
    int code = 0;
    String msg = "";
    List<RoleInfo> ls = roleInfodao.queryByAll();
    if (ls.size() == 0) {
      msg = "";
      code = 1;
    } else {
      msg = "";
    }
    return new BaseResult<List<RoleInfo>>(code, msg, ls);
  }

  @RequestMapping(value = "/privilegeList", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<List<RolePrivilege>> selectRPByRoleId(@RequestBody RoleInfo s) {
    // public List<AccountWithRoleInfo> sbyUserId(@Param(value = "userId") Integer userId) {
    String urs = "查询失败";
    int rs = 0;
    System.out.println("-------------------id is " + s.getRoleId());
    List<RolePrivilege> ls = roleInfodao.selectRPByRoleId(s.getRoleId());
    System.err.println("------selectRPByRoleId----- " + ls.size());
    urs = "查询成功";
    rs = 1;
    return new BaseResult<List<RolePrivilege>>(rs, urs, ls);
  }

  /**
   * 
   * insertRPList:(这里用一句话描述这个方法的作用)
   * 
   * @param @param rps
   * @param @return 设定文件
   * @return BaseResult<List<RolePrivilege>> DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  @RequestMapping(value = "/modifyURolePrivilege", method = RequestMethod.POST)
  @CrossOrigin
  @ResponseBody
  public BaseResult<List<RolePrivilege>> insertRPList(@RequestBody RandP rps) {
    // public List<AccountWithRoleInfo> sbyUserId(@Param(value = "userId") Integer userId) {
    String urs = "赋权失败";
    int rs = 0;
    // 赋权限之前先清空可能有的权限 欲练此功 嘿嘿~
    roleInfodao.deleteRPByRoleId(rps.getRoleId());
    System.out.println("---------insertRPList----------s is " + rps);
    int ls = roleInfodao.insertRPList(rps);
    System.out.println("---------insertRPList----------rs is " + ls);
    if (ls == rps.getPrivilegeId().length) {
      urs = "赋权成功，共 " + ls + " 权限";
      rs = 1;
    } else {
    }
    return new BaseResult<List<RolePrivilege>>(rs, urs);
  }


}
