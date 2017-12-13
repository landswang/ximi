package com.ejie.nbrs.service;

import java.util.List;

import com.ejie.nbrs.entity.User;

/**
 * 
 * ClassName:UserService
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017 2017年10月16日 下午12:22:31
 * @see
 */
public interface UserService {

  List<User> getUserList(int offset, int limit);

}
