package com.ejie.nbrs.cache;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.ejie.nbrs.dto.Emessage;
import com.ejie.nbrs.entity.Account;
import com.ejie.nbrs.entity.SessionWrapper;
import com.google.common.collect.Maps;

/**
 * 
 * @author hisahe 2017-08-03
 * 
 *         SocketClientCache 根据角色创建websocket集合 实现群发角色组用户 根据用户ID创建websocket集合 实现群发单用户
 */

@Component
public class SocketClientCache {
  public static final String USER_PREFIX = "user_";
  public static final String ROLE_PREFIX = "role_";
  public static final String ALL = "all";
  private static final String DEFAULT_GROUP = "defaultGroup";// 角色为空默认值

  /*
   * 
   * private static ConcurrentHashMap<String, ArrayList<Session>> cmp = new
   * ConcurrentHashMap<String, ArrayList<Session>>();//根据角色创建websocket集合
   * 
   * private static ConcurrentHashMap<String, Session> cmpTone = new ConcurrentHashMap<String,
   * Session>();//根据用户ID创建websocket集合
   * 
   * 
   * 
   * public static void saveCmpUser(String string, Session session) {
   * 
   * if (string != null && !string.isEmpty()) { cmpTone.put(string, session); }
   * 
   * }
   * 
   * // 根据用户删除用户session链接 public static void removeCmpTone(Session session) { if (session != null) {
   * cmpTone.remove(session); } }
   * 
   * // 根绝用户角色保存session链接 public static void saveCmp(String string, Session session) { if
   * (cmp.containsKey(string)) {
   * 
   * cmp.get(string).add(session);
   * 
   * } else {
   * 
   * ArrayList<Session> listSession = new ArrayList<Session>();
   * 
   * listSession.add(session);
   * 
   * cmp.put(string, listSession); }
   * 
   * }
   * 
   * // 根据用户角色删除用户session链接 public static void removeCmp(Session session) {
   * Collection<ArrayList<Session>> cmps = cmp.values();
   * 
   * for (ArrayList<Session> sessions : cmps) {
   * 
   * for (Session sessio : sessions) {
   * 
   * if (session.equals(sessio)) {
   * 
   * cmp.get(sessions).remove(session); }
   * 
   * } }
   * 
   * }
   * 
   * // 发送给所有对象 public static void sendToAllUser(String message) { Collection<ArrayList<Session>>
   * cmps = cmp.values();
   * 
   * for (ArrayList<Session> sessions : cmps) {
   * 
   * for (Session session : sessions) {
   * 
   * sendMsg(session, message); } }
   * 
   * }
   * 
   * // 根据用户ID发送给指定单个对象 public static void sendToUser(String string, String message) { Session
   * session = cmpTone.get(string); if (session != null) { sendMsg(session, message); }
   * 
   * }
   * 
   * // 根据角色发送给指定用户 public static void sendToListUser(String string, String message) {
   * ArrayList<Session> cmps = cmp.get(string); if (cmps.size() > 0) { for (Session session : cmps)
   * { sendMsg(session, message); } }
   * 
   * } //发送消息 private static void sendMsg(Session session, String msg) { try { if (session != null)
   * { session.getBasicRemote().sendText(msg); } } catch (IOException e) { e.printStackTrace(); } }
   */

  // <groupKey, <userKey, session>> 根据角色来存放 userID和session
  private static ConcurrentHashMap<String, ConcurrentHashMap<String, SessionWrapper>> groupCache =
      new ConcurrentHashMap<String, ConcurrentHashMap<String, SessionWrapper>>();

  // 保存websocket链接的session
  public static void saveCmpUser(SessionWrapper wrapper) {
    if (wrapper != null && wrapper.getAccount() != null) {
      Account account = wrapper.getAccount();
      String groupKey = genRoleGroup(account);
      String userKey = genUserKey(account);
      if (groupCache.containsKey(groupKey)) {
        groupCache.get(groupKey).put(userKey, wrapper);
      } else {
        ConcurrentHashMap<String, SessionWrapper> clientConn = new ConcurrentHashMap<>();
        clientConn.put(userKey, wrapper);
        groupCache.put(groupKey, clientConn);
      }
    }
  }

  // 删除websocket链接保存的session
  public static void removeClient(Account account) {
    if (account != null) {
      String groupKey =
          account.getRoleId() == null ? DEFAULT_GROUP : String.valueOf(account.getRoleId());
      String userKey = String.valueOf(account.getUserId());

      if (userKey == null) {
        return;
      }

      ConcurrentHashMap<String, SessionWrapper> sessionMap = groupCache.get(groupKey);
      if (sessionMap != null) {
        sessionMap.remove(userKey);
      }
    }
  }

  // 发送消息 isGroup 是否往组发
  public static void sendMessage(Emessage em, boolean isGroup, RedisCache redis) {
    if (isGroup) {

      String groupKey = genRoleGroup(em);
      ConcurrentHashMap<String, SessionWrapper> sessionMap = groupCache.get(groupKey);
      if (sessionMap != null && !sessionMap.isEmpty()) {
        for (SessionWrapper wrapper : sessionMap.values()) {
          wrapper.sendObj(em);
        }


      }
      saveMessToRedis(em, ROLE_PREFIX + em.getReceiveRoleId(), redis);

    } else {
      String groupKey = genRoleGroup(em);
      ConcurrentHashMap<String, SessionWrapper> sessionMap = groupCache.get(groupKey);
      if (sessionMap != null) {
        String userKey = genUserKey(em);
        if (userKey == null) {
          return;
        }

        SessionWrapper wrapper = sessionMap.get(userKey);
        if (wrapper != null) {
          wrapper.sendObj(em);

          saveMessToRedis(em, USER_PREFIX + em.getReceiveUserId(), redis);
        }
      }
    }
  }


  // 发送消息列表
  public static void sendMessage(Collection<Emessage> emg, Account account) {



    String groupKey = genRoleGroup(account);
    ConcurrentHashMap<String, SessionWrapper> sessionMap = groupCache.get(groupKey);
    if (sessionMap != null) {
      String userKey = genUserKey(account);
      if (userKey == null) {
        return;
      }
      SessionWrapper wrapper = sessionMap.get(userKey);
      if (wrapper != null) {
        wrapper.sendObj(emg);
      }
    }


  }



  public static void saveMessToRedis(Emessage em, String key, RedisCache redis) {
    HashMap<String, Emessage> hm = Maps.newHashMap();
    hm.put(String.valueOf(em.getLoanId()), em);
    redis.putHashCache(key, hm);
  }

  private static String genUserKey(Account account) {
    if (account != null && account.getUserId() != 0) {
      return String.valueOf(account.getUserId());
    }

    return null;
  }

  private static String genRoleGroup(Account account) {
    if (account != null && account.getRoleId() != 0) {
      return String.valueOf(account.getRoleId());
    }

    return DEFAULT_GROUP;
  }

  private static String genRoleGroup(Emessage em) {
    if (em != null && em.getReceiveRoleId() != 0) {
      return String.valueOf(em.getReceiveRoleId());
    }

    return DEFAULT_GROUP;
  }

  private static String genUserKey(Emessage em) {
    if (em != null && em.getReceiveUserId() != 0) {
      return String.valueOf(em.getReceiveUserId());
    }

    return null;
  }

  public static void sendMessageToAll(Emessage msg, RedisCache redis) {
    if (groupCache == null || groupCache.isEmpty()) {
      return;
    }
    for (ConcurrentHashMap<String, SessionWrapper> sessionMap : groupCache.values()) {
      for (SessionWrapper wrapper : sessionMap.values()) {
        wrapper.sendObj(msg);
      }
    }

    saveMessToRedis(msg, ALL, redis);
  }

  // 改变消息状态
  /*
   * 前台改变消息状态接口
   */
  public static void changeMessageState(Account acount, String str, String messageState,
      String loanId, RedisCache redis) {

    redis.changeHashCache(str + acount.getRoleId(), messageState, loanId);
  }

}
