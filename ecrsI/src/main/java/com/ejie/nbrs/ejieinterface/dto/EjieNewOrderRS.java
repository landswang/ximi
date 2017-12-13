package com.ejie.nbrs.ejieinterface.dto;

import java.util.List;

import com.ejie.nbrs.ejieinterface.entity.NewOrder;

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
public class EjieNewOrderRS {

  private int count;
  private List<NewOrder> data;

  public List<NewOrder> getData() {
    return data;
  }

  public void setData(List<NewOrder> data) {
    this.data = data;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }



  @Override
  public String toString() {
    return "EjieLoanResult [count=" + count + ", data=" + data + "]";
  }


}
