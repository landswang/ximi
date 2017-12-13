/**
 * 
 */
package com.ejie.nbrs.entity;

/*** 
 * @Title:       DeleteFile 
 * @Description: FTP-master
 * @packageName  com.ts.ftp.bean
 * @fileName     DeleteFile.java
 * @Company:      ejie  
 * @version      1.1
 * @author       hisahe
 * @date         2017年8月16日 上午10:28:16
 */
public class DeleteFile {
	
	int id;
	String fileName;
	int stuts;
	String path;
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the stuts
	 */
	public int getStuts() {
		return stuts;
	}
	/**
	 * @param stuts the stuts to set
	 */
	public void setStuts(int stuts) {
		this.stuts = stuts;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DeleteFile [id=" + id + ", fileName=" + fileName + ", stuts="
				+ stuts + ", path=" + path + "]";
	}
	

}
