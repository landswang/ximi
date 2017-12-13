package com.ejie.nbrs.util;
import javax.websocket.EncodeException; 
import javax.websocket.Encoder; 
import javax.websocket.EndpointConfig;
import com.ejie.nbrs.dto.Emessage;
import com.ejie.nbrs.exception.BusinessException;
/***
 * * 
* @Title:       ServerEncoder 
* @Description: ecrs  定义编码器 将websocket 发送的对象转换为json对象
* @packageName  com.ejie.nbrs.util
* @fileName     ServerEncoder.java
* @Company:      ejie  
* @version      1.1
* @author       hisahe
* @date         2017年8月4日 下午3:05:54
 */
public class ServerEncoder implements Encoder.Text<Emessage> { 
	@Override 	public void destroy() { 		
		// TODO Auto-generated method stub  	
		}  
	@Override 	
	public void init(EndpointConfig arg0) { 
		// TODO Auto-generated method stub  
		}  
	@Override 	
	public String encode(Emessage em) throws EncodeException {
		try {
			return JsonUtil.toJson(em);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		} 
	} 
	