package com.ejie.nbrs.ejieinterface.dto;



/**
 * 
 * ClassName:EjieLoanParent
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月10日 上午10:30:13
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class EjieResultSet {


  private int code;

  private String msg;

  private EjieNewOrderRS result;

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

  public EjieNewOrderRS getResult() {
    return result;
  }

  public void setResult(EjieNewOrderRS result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return "EjieLoanParent [code=" + code + ", msg=" + msg + ", result=" + result + "]";
  }



}
