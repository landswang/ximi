/**
 * FileRPath.java
 * com.ejie.nbrs.entity
 *
 * Function： TODO 附件上传和资料补充地址
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   ver1.1  2017年9月20日 		zlg
 *
 * Copyright (c) 2017, EJie All Rights Reserved.
*/

package com.ejie.nbrs.entity;
/**
 * ClassName:FileRPath 附件上传和资料补充地址
 * @author   zlg
 * @version  
 * @since    Ver 1.1
 * @Date	 2017年9月20日		下午2:26:09
 * @see 	 
 */
public class FileRPath {
	/**
	 * 贷款审批--附件上传
	 */
	private String loan;
	/**
	 * 贷款审批--资料补充
	 */
	private String xw;
	/**
	 * 押品管理--附件上传
	 */
	private String storage;
	/**
	 * 其他路径地址
	 */
	private String other;
	public String getLoan() {
		return loan;
	}
	public void setLoan(String loan) {
		this.loan = loan;
	}
	public String getXw() {
		return xw;
	}
	public void setXw(String xw) {
		this.xw = xw;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	@Override
	public String toString() {
		return "FileRPath [loan=" + loan + ", xw=" + xw + ", storage="
				+ storage + ", other=" + other + "]";
	}
	

	
}

