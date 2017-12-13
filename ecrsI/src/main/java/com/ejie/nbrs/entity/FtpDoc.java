package com.ejie.nbrs.entity;
import java.util.List;
/**
 * 
 * @author hisahe
 * 本类的目的在于确保文件读取唯一 保存订单号 服务类别  但是不保存资料名称
 * 资料名称需要在image中获取  如果获取资料类别需要结合image 查询字典表
 *
 */
public class FtpDoc {
	private String id;//ID 文件名
	private String branchCode;//机构代码
	private String source;//服务类别
	private String busNo;//订单号
	private List<Images> image;
	public List<Images> getImage() {
		return image;
	}
	public void setImage(List<Images> image) {
		this.image = image;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}
	
}
