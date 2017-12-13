package com.ejie.nbrs.web;

import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ejie.nbrs.util.SessionUtils;

/**
 * 功能说明：websocket处理类
 */
// relationId和userCode是我的业务标识参数,websocket.ws是连接的路径，可以自行定义
@ServerEndpoint("/wmessage.wss/{relationId}/{userCode}")
public class WsMessage {

  // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
  private static int onlineCount = 0;
  // 与某个客户端的连接会话，需要通过它来给客户端发送数据
  private Session session;

  private static Logger log = LoggerFactory.getLogger(WsMessage.class);
  // concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
  private static CopyOnWriteArraySet<WsMessage> webSocketSet = new CopyOnWriteArraySet<WsMessage>();

  /**
   * 打开连接时触发
   * 
   * @param relationId
   * @param userCode
   * @param session
   */
  @OnOpen
  public void onOpen(@PathParam("relationId") String relationId,
      @PathParam("userCode") int userCode, Session session) {
    System.out.println("Websocket Start Connecting:" + SessionUtils.getKey(relationId, userCode));
    log.info("Websocket Start Connecting:" + SessionUtils.getKey(relationId, userCode));
    SessionUtils.put(relationId, userCode, session);
    this.session = session;
    webSocketSet.add(this); // 加入set中
  }

  /**
   * 收到客户端消息时触发
   * 
   * @param relationId
   * @param userCode
   * @param message
   * @return
   */
  @OnMessage
  public String onMessage(@PathParam("relationId") String relationId,
      @PathParam("userCode") int userCode, String message) {
    System.out.println("Got your message (" + message + ").Thanks !");
    return "Got your message (" + message + ").Thanks !";
  }

  /**
   * 异常时触发
   * 
   * @param relationId
   * @param userCode
   * @param session
   */
  @OnError
  public void onError(@PathParam("relationId") String relationId,
      @PathParam("userCode") int userCode, Throwable throwable, Session session) {
    log.info("Websocket Connection Exception:" + SessionUtils.getKey(relationId, userCode));
    log.info(throwable.getMessage(), throwable);
    SessionUtils.remove(relationId, userCode);
  }

  /**
   * 关闭连接时触发
   * 
   * @param relationId
   * @param userCode
   * @param session
   */
  @OnClose
  public void onClose(@PathParam("relationId") String relationId,
      @PathParam("userCode") int userCode, Session session) {
    log.info("Websocket Close Connection:" + SessionUtils.getKey(relationId, userCode));
    SessionUtils.remove(relationId, userCode);
  }

}
