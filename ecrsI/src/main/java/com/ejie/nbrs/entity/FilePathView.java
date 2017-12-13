/**
 * 
 */
package com.ejie.nbrs.entity;

import java.util.Arrays;

/*** 
 * @Title:       FilePath 
 * @Description: ecrs191
 * @packageName  com.ejie.nbrs.entity
 * @fileName     FilePath.java
 * @Company:      ejie  
 * @version      1.1
 * @author       hisahe
 * @date         2017年8月13日 下午3:02:28
 */
public class FilePathView {

	private String  serviceType;//服务类别
	private String  docType;//文档类别一级类目
	private String  doc;//文档二级类目
	private String  loanId;//业务ID
	private String name;//文件路径及名称
	private String sourceFlag;//来源标识
	private String filename;//原文件名
	private String[] docArr;//文档二级分类集合数组
	
	
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the loanId
	 */
	public String getLoanId() {
		return loanId;
	}
	/**
	 * @param loanId the loanId to set
	 */
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	/**
	 * @return the serviceType
	 */
	public String getServiceType() {
		return serviceType;
	}
	/**
	 * @param serviceType the serviceType to set
	 */
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	/**
	 * @return the docType
	 */
	public String getDocType() {
		return docType;
	}
	/**
	 * @param docType the docType to set
	 */
	public void setDocType(String docType) {
		this.docType = docType;
	}
	/**
	 * @return the doc
	 */
	public String getDoc() {
		return doc;
	}
	/**
	 * @param doc the doc to set
	 */
	public void setDoc(String doc) {
		this.doc = doc;
	}

	public String getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(String sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	
	public String[] getDocArr() {
		return docArr;
	}
	public void setDocArr(String[] docArr) {
		this.docArr = docArr;
	}
	@Override
	public String toString() {
		return "FilePathView [serviceType=" + serviceType + ", docType="
				+ docType + ", doc=" + doc + ", loanId=" + loanId + ", name="
				+ name + ", sourceFlag=" + sourceFlag + ", filename="
				+ filename + ", docArr=" + Arrays.toString(docArr) + "]";
	}
	


}
