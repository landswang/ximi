package com.ejie.nbrs.ejieinterface.dto;

import com.ejie.nbrs.ejieinterface.entity.RepaymentSchedule;

/**
 * 
 * ClassName:EjieLoanResult
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月10日 下午5:46:21
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class EjieReSchRS {

  private int code;

  private String msg;

  private RepaymentSchedule result;



  public RepaymentSchedule getResult() {
    return result;
  }

  public void setResult(RepaymentSchedule result) {
    this.result = result;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  @Override
  public String toString() {
    return "EjieNewOrderRS [code=" + code + ", msg=" + msg + ", result=" + result + "]";
  }



}
