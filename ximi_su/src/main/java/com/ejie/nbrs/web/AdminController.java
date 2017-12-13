package com.ejie.nbrs.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejie.nbrs.service.LoanInfoService;
import com.ejie.nbrs.util.TimeUtils;

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
@RequestMapping("/admin/")
@Controller
public class AdminController {

  @Autowired
  private LoanInfoService loanInfodao;

  @RequestMapping(value = "index", method = RequestMethod.GET)
  @ResponseBody
  @CrossOrigin(maxAge = 3600)
  public String getLoanList(Integer offset, Integer limit) {
    offset = offset == null ? 0 : offset;// 默认便宜0
    limit = limit == null ? 70 : limit;// 默认展示50条
    String userJson =
        "{\"verificationCode\" : " + "\"/imagesDo/getImage?" + TimeUtils.getCurrentTimeInString()
            + "\"}";
    return userJson;

  }

  @RequestMapping(value = "1", method = RequestMethod.GET)
  public String goindex(Integer offset, Integer limit) {
    return "index";
  }


}
