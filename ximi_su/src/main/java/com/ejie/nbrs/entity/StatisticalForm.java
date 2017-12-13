package com.ejie.nbrs.entity;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * ClassName:StatisticalForm
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年8月11日 上午11:01:35
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public class StatisticalForm {

	private Date starttime;
	
	private Date endtime;
	
	private String type1;
	
	private int lCount;
	
	private int lPassCount;
	
	private BigDecimal lPay;
	
	private BigDecimal lPassPay;
	
	private Integer lCountRate;
	
	private Integer lPayRate;
	
	private int cCount;
	
	private int cPassCount;
	
	private BigDecimal cPay;
	
	private BigDecimal cPassPay;
	
	private BigDecimal cCountRate;
	
	private BigDecimal cPayRate;
	
	
	
	public BigDecimal getlPay() {
		return lPay;
	}
	public void setlPay(BigDecimal lPay) {
		this.lPay = lPay;
	}
	public BigDecimal getlPassPay() {
		return lPassPay;
	}
	public void setlPassPay(BigDecimal lPassPay) {
		this.lPassPay = lPassPay;
	}
	
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getType() {
		return type1;
	}
	public void setType(String type1) {
		this.type1 = type1;
	}
	public int getlCount() {
		return lCount;
	}
	public void setlCount(int lCount) {
		this.lCount = lCount;
	}
	public int getlPassCount() {
		return lPassCount;
	}
	public void setlPassCount(int lPassCount) {
		this.lPassCount = lPassCount;
	}
	
	
	public Integer getlCountRate() {
		return lCountRate;
	}
	public void setlCountRate(Integer lCountRate) {
		this.lCountRate = lCountRate;
	}
	public Integer getlPayRate() {
		return lPayRate;
	}
	public void setlPayRate(Integer lPayRate) {
		this.lPayRate = lPayRate;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public int getcCount() {
		return cCount;
	}
	public void setcCount(int cCount) {
		this.cCount = cCount;
	}
	public int getcPassCount() {
		return cPassCount;
	}
	public void setcPassCount(int cPassCount) {
		this.cPassCount = cPassCount;
	}
	public BigDecimal getcPay() {
		return cPay;
	}
	public void setcPay(BigDecimal cPay) {
		this.cPay = cPay;
	}
	public BigDecimal getcPassPay() {
		return cPassPay;
	}
	public void setcPassPay(BigDecimal cPassPay) {
		this.cPassPay = cPassPay;
	}
	public BigDecimal getcCountRate() {
		return cCountRate;
	}
	public void setcCountRate(BigDecimal cCountRate) {
		this.cCountRate = cCountRate;
	}
	public BigDecimal getcPayRate() {
		return cPayRate;
	}
	public void setcPayRate(BigDecimal cPayRate) {
		this.cPayRate = cPayRate;
	}
	@Override
	public String toString() {
		return "StatisticalForm [starttime=" + starttime + ", endtime="
				+ endtime + ", type1=" + type1 + ", lCount=" + lCount
				+ ", lPassCount=" + lPassCount + ", lPay=" + lPay
				+ ", lPassPay=" + lPassPay + ", lCountRate=" + lCountRate
				+ ", lPayRate=" + lPayRate + ", cCount=" + cCount
				+ ", cPassCount=" + cPassCount + ", cPay=" + cPay
				+ ", cPassPay=" + cPassPay + ", cCountRate=" + cCountRate
				+ ", cPayRate=" + cPayRate + "]";
	}

	
	
}
