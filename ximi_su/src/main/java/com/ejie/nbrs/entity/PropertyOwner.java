package com.ejie.nbrs.entity;

/**
 * 
 * ClassName:PropertyOwner 产权人
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月17日 下午3:34:17
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 * 
 */
public class PropertyOwner {

  /**
   * 姓名
   */
  private String pName;
  /**
   * 身份证号
   */
  private String pCardNum;
  /**
   * 电话号码
   */
  private String pTelNum;
  /**
   * 居住地址
   */
  private String pAddress;

  /**
   * 构造函数
   * 
   * @param pName
   * @param pCardNum
   * @param pTelNum
   * @param pAddress
   */
  public PropertyOwner() {}

  /**
   * 构造函数
   * 
   * @param pName
   * @param pCardNum
   * @param pTelNum
   * @param pAddress
   */
  public PropertyOwner(String pName, String pCardNum, String pTelNum, String pAddress) {
    this.pName = pName;
    this.pCardNum = pCardNum;
    this.pTelNum = pTelNum;
    this.pAddress = pAddress;
  }

  public String getpName() {
    return pName;
  }

  public void setpName(String pName) {
    this.pName = pName;
  }

  public String getpCardNum() {
    return pCardNum;
  }

  public void setpCardNum(String pCardNum) {
    this.pCardNum = pCardNum;
  }

  public String getpTelNum() {
    return pTelNum;
  }

  public void setpTelNum(String pTelNum) {
    this.pTelNum = pTelNum;
  }

  public String getpAddress() {
    return pAddress;
  }

  public void setpAddress(String pAddress) {
    this.pAddress = pAddress;
  }

  @Override
  public String toString() {
    return "PropertyOwner [pName=" + pName + ", pCardNum=" + pCardNum + ", pTelNum=" + pTelNum
        + ", pAddress=" + pAddress + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((pAddress == null) ? 0 : pAddress.hashCode());
    result = prime * result + ((pCardNum == null) ? 0 : pCardNum.hashCode());
    result = prime * result + ((pName == null) ? 0 : pName.hashCode());
    result = prime * result + ((pTelNum == null) ? 0 : pTelNum.hashCode());
    return result;
  }

}
