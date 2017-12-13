/**
 * AccessoryView.java
 * com.ejie.nbrs.dto
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   ver1.1  2017年9月21日 		zlg
 *
 * Copyright (c) 2017, EJie All Rights Reserved.
*/

package com.ejie.nbrs.dto;
/**
 * ClassName:AccessoryView 上传附件视图
 * @author   zlg
 * @version  
 * @since    Ver 1.1
 * @Date	 2017年9月21日		下午5:09:29
 * @see 	 
 */
public class AccessoryInfo {
	/**
	 * 一级标识
	 */
    private String rootType;
    /**
     * 二级标识
     */
    private String secondType;
    /**
     * 二级标识名称/解释
     */
    private String secondTypeName;
    /**
     * 三级标识
     */
    private String thirdType;
    /**
     * 三级标识名称/解释
     */
    private String thirdTypeName;
    /**
     * 附件上传方标识
     */
    private String typeSource;
	public String getRootType() {
		return rootType;
	}
	public void setRootType(String rootType) {
		this.rootType = rootType;
	}
	public String getSecondType() {
		return secondType;
	}
	public void setSecondType(String secondType) {
		this.secondType = secondType;
	}
	public String getSecondTypeName() {
		return secondTypeName;
	}
	public void setSecondTypeName(String secondTypeName) {
		this.secondTypeName = secondTypeName;
	}
	public String getThirdType() {
		return thirdType;
	}
	public void setThirdType(String thirdType) {
		this.thirdType = thirdType;
	}
	public String getThirdTypeName() {
		return thirdTypeName;
	}
	public void setThirdTypeName(String thirdTypeName) {
		this.thirdTypeName = thirdTypeName;
	}
	public String getTypeSource() {
		return typeSource;
	}
	public void setTypeSource(String typeSource) {
		this.typeSource = typeSource;
	}
	@Override
	public String toString() {
		return "AccessoryInfo [rootType=" + rootType + ", secondType="
				+ secondType + ", secondTypeName=" + secondTypeName
				+ ", thirdType=" + thirdType + ", thirdTypeName="
				+ thirdTypeName + ", typeSource=" + typeSource + "]";
	}
    

    
}

