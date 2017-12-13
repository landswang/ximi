package com.ejie.nbrs.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * word服务层
 * @author Administrator
 *
 */
public interface WordService {
	
	/**
	 * word操作方法
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	void wordPo(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;
}
