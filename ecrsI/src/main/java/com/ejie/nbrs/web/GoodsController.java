package com.ejie.nbrs.web;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejie.nbrs.dto.BaseResult;
import com.ejie.nbrs.entity.Goods;
import com.ejie.nbrs.enums.ResultEnum;
import com.ejie.nbrs.exception.BizException;
import com.ejie.nbrs.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {

  private final Logger LOG = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private GoodsService goodsService;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String list(Model model, Integer offset, Integer limit) {
    LOG.info("invoke----------/goods/list");
    offset = offset == null ? 0 : offset;// 默认便宜0
    limit = limit == null ? 50 : limit;// 默认展示50条
    List<Goods> list = goodsService.getGoodsList(offset, limit);
    model.addAttribute("goodslist", list);
    return "goodslist";
  }


  @RequestMapping(value = "/{goodsId}/buy", method = RequestMethod.GET,
      produces = {"application/json;charset=UTF-8"})
  @ResponseBody
  public BaseResult<Object> buy(@CookieValue(value = "userPhone", required = false) Long userPhone,
  /* @PathVariable("goodsId") Long goodsId */@Valid Goods goods, BindingResult result) {
    LOG.info("invoke----------/" + goods.getGoodsId() + "/buy userPhone:" + userPhone);
    if (userPhone == null) {
      return new BaseResult<Object>(1, ResultEnum.INVALID_USER.getMsg());
    }
    // Valid 参数验证(这里注释掉，采用AOP的方式验证,见BindingResultAop.java)
    // if (result.hasErrors()) {
    // String errorInfo = "[" + result.getFieldError().getField() + "]" +
    // result.getFieldError().getDefaultMessage();
    // return new BaseResult<Object>(false, errorInfo);
    // }
    try {
      goodsService.buyGoods(userPhone, goods.getGoodsId(), false);
    } catch (BizException e) {
      return new BaseResult<Object>(1, e.getMessage());
    } catch (Exception e) {
      return new BaseResult<Object>(1, ResultEnum.INNER_ERROR.getMsg());
    }
    return new BaseResult<Object>(0, null);
  }
}
