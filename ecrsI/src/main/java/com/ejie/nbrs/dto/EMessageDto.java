/**
 * WsMessage.java com.ejie.nbrs.dto
 * 
 * Function： TODO
 * 
 * ver date author ────────────────────────────────── ver1.1 2017年7月28日 torreswang
 * 
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.dto;

import javax.websocket.Session;

/**
 * ClassName:WsMessage
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017年7月28日 下午2:52:52
 * @see
 */
public class EMessageDto {

  private String key;
  private Session session;

  public EMessageDto(String key, Session session) {
    this.key = key;
    this.session = session;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public Session getSession() {
    return session;
  }

  public void setSession(Session session) {
    this.session = session;
  }


  @Override
  public String toString() {
    return "WsMessage [key=" + key + ", session=" + session + "]";
  }
}
