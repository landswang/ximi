package com.ejie.nbrs.entity;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import com.ejie.nbrs.dto.Emessage;
import com.ejie.nbrs.exception.BusinessException;
import com.ejie.nbrs.util.JsonUtil;

/**
 * 
 * @author hisahe SessionWrapper 用来封装account 和 session
 * 
 */
public class SessionWrapper {

	private Account account;

	private Session session;

	public SessionWrapper(Account _account,Session _session){
		
		this.account=_account;
	
		this.session=_session;
		
	}
	public Account getAccount(){
		return account;
	}
	//发送消息
	public boolean sendObj(Object emg) {
		boolean flag = true;

			if (session != null&&emg!=null) {
				try {
					session.getBasicRemote().sendText(JsonUtil.toJson(emg));
					flag = true;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					flag = false;
					
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					flag = false;
				}

				
			}
		
		return flag;
	}
	
}
