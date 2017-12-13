/**
 * MessageUtil.java com.ejie.nbrs.util
 * 
 * Function： TODO
 * 
 * ver date author ────────────────────────────────── ver1.1 2017年8月3日 torreswang
 * 
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.util;

import java.util.HashMap;
import java.util.Map.Entry;

import com.ejie.nbrs.cache.RedisCache;
import com.ejie.nbrs.cache.SocketClientCache;
import com.ejie.nbrs.dto.Emessage;
import com.ejie.nbrs.entity.Account;
import com.google.common.collect.Maps;

/**
 * ClassName:消息工具类 定义消息的封装
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017年8月3日 下午5:57:40
 * @see
 */
public class MessageUtil {
	// 发送给单个用户
	public static void sendToTargetUserById(Emessage em, RedisCache redis) {
		SocketClientCache.sendMessage(em, false, redis);
	}

	// 按角色组发送
	public static void sendToTargetRole(Emessage em, RedisCache redis) {
		
		SocketClientCache.sendMessage(em, true, redis);
	}

	// 发送给所有用户
	public static void sendToAllUser(Emessage em, RedisCache redis) {
		SocketClientCache.sendMessageToAll(em, redis);
	}

	// 用户登录的时候根据角色发送消息列表
	public static void loginSend(Account account, RedisCache rc) {
		HashMap<String, Emessage> ham = rc.getHashCache(
				//目前满足向角色组发送
				SocketClientCache.ROLE_PREFIX + account.getRoleId(),
				Emessage.class);
			/*向个人或者全部备用代码
			  HashMap<String, Emessage> ham1 = rc.getHashCache(
					SocketClientCache.USER_PREFIX + account.getUserId(),
					Emessage.class);
			HashMap<String, Emessage> ham2 = rc.getHashCache(SocketClientCache.ALL
					+ account.getUserId(), Emessage.class);
			HashMap<String, Emessage> ham3 = Maps.newHashMap();
			if (ham.size() >= 1) {
				ham3.putAll(ham);
			}
			if (ham1.size() >= 1) {
				ham3.putAll(ham1);
			}
			if (ham2.size() >= 1) {
				ham3.putAll(ham2);
			}
				/*if (ham3 != null && !ham3.isEmpty()) {
			for (Entry<String, Emessage> entry : ham3.entrySet()) {
				if (entry.getValue().getStatus() == 0) {
					reMap.put(entry.getKey(), entry.getValue());
				}
			}
		}*/

		HashMap<String, Emessage> reMap = Maps.newHashMap();
		  if (ham != null && !ham.isEmpty()) { for (Entry<String, Emessage>
		  entry : ham.entrySet()) { if (entry.getValue().getStatus() == 0) {
		  reMap.put(entry.getKey(), entry.getValue()); } } }
		

	
		if (!reMap.isEmpty()) {
			SocketClientCache.sendMessage(reMap.values(), account);
		}

	}

	/*
	 * 处理业务 用户 和 消息 str 按角色 按个人 所有   key可以为  "role_"+roleId   "_"+roleId   "all_"+roleId   
	 * Account 用户
	 * Emessage 消息体
	 * RedisCache redis实体
	 */
	public static void alter(Account account, Emessage em, String key,
			RedisCache rc) {
		rc.deleteHashCache(key, String.valueOf(em.getLoanId()));
		SocketClientCache.sendMessage(em, true, rc);
	}
}
