package com.ejie.nbrs.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejie.nbrs.service.WordService;

/**
 * word导出
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping("/wordOp")
public class WordOp {


	/**
	 * 跳转到word页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/doc2")
	public String uploadPage() {
		return "doc2";
	}

	@Autowired
	private WordService wservice;

	/**
	 * word导出方法
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/wordService")
	protected void wordService(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		wservice.wordPo(req, resp);
	}


}
