/**
 * SessionUtils.java com.ejie.nbrs.util
 * 
 * Function： TODO
 * 
 * ver date author ────────────────────────────────── ver1.1 2017年7月28日 torreswang
 * 
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.util;

/**
 * ClassName:SessionUtils
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017年7月28日 上午10:08:51
 * @see
 */
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import com.ejie.nbrs.dto.EMessageDto;

/**
 * 功能说明：用来存储业务定义的sessionId和连接的对应关系 利用业务逻辑中组装的sessionId获取有效连接后进行后续操作
 */
public class SessionUtils {
  // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
  private static int onlineCount = 0;

  public static Map<String, Session> clients = new ConcurrentHashMap<>();
  private static CopyOnWriteArraySet<EMessageDto> webSocketSet =
      new CopyOnWriteArraySet<EMessageDto>();

  public static void put(String relationId, int userCode, Session session) {
    // clients.put(getKey(relationId, userCode), session);
    webSocketSet.add(new EMessageDto(getKey(relationId, userCode), session));
    addOnlineCount();
  }

  public static void broadcast(String message) {
    for (EMessageDto se : webSocketSet) {
      se.getSession().getAsyncRemote().sendText(message);
    }

  }

  public static Session get(String relationId, int userCode) {
    Session ses = null;
    for (EMessageDto se : webSocketSet) {
      if (getKey(relationId, userCode).equals(se.getKey())) {
        ses = se.getSession();
      }
    }
    return ses;
  }

  public static void remove(String relationId, int userCode) {
    // clients.remove(getKey(relationId, userCode));
    for (EMessageDto se : webSocketSet) {
      if (getKey(relationId, userCode).equals(se.getKey())) {
        webSocketSet.remove(se);
        subOnlineCount(); // 在线数减1
      }
    }
  }

  /**
   * 判断是否有连接
   * 
   * @param relationId
   * @param userCode
   * @return
   */
  public static boolean hasConnection(String relationId, int userCode) {
    return clients.containsKey(getKey(relationId, userCode));
  }

  /**
   * 组装唯一识别的key
   * 
   * @param relationId
   * @param userCode
   * @return
   */
  public static String getKey(String relationId, int userCode) {
    return relationId + "_" + userCode;
  }

  public static synchronized int getOnlineCount() {
    return onlineCount;
  }

  public static synchronized void addOnlineCount() {
    SessionUtils.onlineCount++;
  }

  public static synchronized void subOnlineCount() {
    SessionUtils.onlineCount--;
  }
  
  /**
  * 从Request对象中获得客户端IP，处理了HTTP代理服务器和Nginx的反向代理截取了ip
  * @param request
  * @return ip
  */
public static String getLocalIp(HttpServletRequest request) {
    String remoteAddr = request.getRemoteAddr();
    String forwarded = request.getHeader("X-Forwarded-For");
    String realIp = request.getHeader("X-Real-IP");

    String ip = null;
    if (realIp == null) {
        if (forwarded == null) {
            ip = remoteAddr;
        } else {
            ip = remoteAddr + "/" + forwarded.split(",")[0];
        }
    } else {
        if (realIp.equals(forwarded)) {
            ip = realIp;
        } else {
            if(forwarded != null){
                forwarded = forwarded.split(",")[0];
            }
            ip = realIp + "/" + forwarded;
        }
    }
    return ip;
}
}
