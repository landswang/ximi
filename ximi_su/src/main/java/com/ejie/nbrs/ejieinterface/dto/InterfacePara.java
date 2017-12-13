/**
 * InterfacePara.java com.ejie.nbrs.ejieinterface.dto
 * 
 * Function： TODO
 * 
 * ver date author ────────────────────────────────── ver1.1 2017年8月14日 torreswang
 * 
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.ejieinterface.dto;

/**
 * ClassName:InterfacePara
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017年8月14日 上午9:55:00
 * @see
 */
public class InterfacePara {

  private String username;
  private String password;
  private String token;
  private String apikey;
  /* 业务流水号 */
  private String serialNo;

  public InterfacePara() {}


  public InterfacePara(String serialNo) {
    this.serialNo = serialNo;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getApikey() {
    return apikey;
  }

  public void setApikey(String apikey) {
    this.apikey = apikey;
  }

  public String getSerialNo() {
    return serialNo;
  }

  public void setSerialNo(String serialNo) {
    this.serialNo = serialNo;
  }

  @Override
  public String toString() {
    return "InterfacePara [username=" + username + ", password=" + password + ", token=" + token
        + ", apikey=" + apikey + ", serialNo=" + serialNo + "]";
  }

}
