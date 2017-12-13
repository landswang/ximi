/**
 * 
 */
package com.ejie.nbrs.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;

import com.ejie.nbrs.dto.BaseResult;


public interface  PackDownFileService {
	 boolean fileToZip(String bussNo);
	 void download(String bussNo,HttpServletResponse response) throws IOException;
	 BaseResult<String> whetherZip(String bussNo) throws IOException;
}
