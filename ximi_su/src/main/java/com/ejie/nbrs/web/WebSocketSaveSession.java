package com.ejie.nbrs.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import com.ejie.nbrs.cache.RedisCache;
import com.ejie.nbrs.cache.SocketClientCache;
import com.ejie.nbrs.dto.Emessage;
import com.ejie.nbrs.entity.Account;
import com.ejie.nbrs.entity.SessionWrapper;
import com.ejie.nbrs.service.AccountService;
import com.ejie.nbrs.util.MessageUtil;
import com.ejie.nbrs.util.ServerEncoder;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

// configurator spring 注入 websocket 需要导入spring-websocket jar包 ServerEncoder
// 定义一个消息对象编码器将对象对象转换为json格式
@ServerEndpoint(value = "/wmessage.ws/{relationId}/{userCode}",
    configurator = SpringConfigurator.class, encoders = {ServerEncoder.class})
public class WebSocketSaveSession {
  private Session session;
  private static Logger log = LoggerFactory.getLogger(WebSocketSaveSession.class);
  @Resource
  private AccountService accountService;
  private Account account;
  @Autowired
  private RedisCache redis;

  /**
   * 打开连接时触发
   * 
   * @param relationId
   * @param userCode
   * @param session
   */
  @OnOpen
  public void onOpen(@PathParam("userCode") String accountName, Session session) {
    account = accountService.queryByUId(new Integer(accountName));
   
    SessionWrapper sessionWrapper = new SessionWrapper(account, session);

    if (checkAccount(account)) {
      SocketClientCache.saveCmpUser(sessionWrapper);
      MessageUtil.loginSend(account,redis);
    } else {
      try {
        session.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

   

  }

  // 校验account对象是否存在
  private boolean checkAccount(Account account) {
    if (account != null) {
      return true;
    }
    return false;
  }


  /**
   * 收到客户端消息时触发
   * 
   * @param userCode
   * @param messageState 消息状态
   * @param loanId  业务id  也就好似loanid
   * @return
   */
  @OnMessage
	public void onMessage(@PathParam("userCode") String userCode, String message) {
	  Gson gson = new Gson();
	  try{
	  Emessage ems=  gson.fromJson(message, Emessage.class);
	  
	  if(ems!=null){
	    String  loanId= String.valueOf(ems.getLoanId());
		String  messageState= String.valueOf(ems.getStatus());
		if (!messageState.isEmpty() && !loanId.isEmpty()
				&& account != null) {
			SocketClientCache.changeMessageState(account,"role_",messageState, loanId, redis);
		}
	  }
	  }catch(JsonSyntaxException e){
		  
		  System.out.println("json 格式有误");
		  
	  }

		System.out.println("client: " + userCode + ", msg: " + message);
	}

  /**
   * 异常时触发
   * 
   * @param relationId
   * @param userCode
   * @param session
   */
  @OnError
  public void onError(@PathParam("userCode") String userCode, Throwable throwable, Session session) {
    log.info(throwable.getMessage(), throwable);
  }

  /**
   * 关闭连接时触发
   * 
   * @param relationId
   * @param userCode
   * @param session
   */
  @OnClose
  public void onClose(Session session) {
    this.session = session;
    SocketClientCache.removeClient(account);

  }
}
