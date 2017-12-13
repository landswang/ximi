/**
 * 
 */
package com.ejie.nbrs.entity;

/*** 
 * @Title:       ScratchFile 
 * @Description: ecrs191
 * @packageName  com.ejie.nbrs.entity
 * @fileName     ScratchFile.java
 * @Company:      ejie  
 * @version      1.1
 * @author       hisahe
 * @date         2017年9月14日 下午2:10:15
 */
import java.util.Date;

public class ScratchFile {
	//ID
    private Integer id;
    //流水号
    private String serialno;
	//类型
    private String type;
	//文件名
    private String fileName;
	//时间
    private Date date;

    
    public ScratchFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScratchFile(String serialno,String type,
			String fileName, Date date) {
		super();
		this.serialno = serialno;
		this.type = type;
		this.fileName = fileName;
		this.date = date;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerialno() {
        return serialno;
    }

    public void setSerialno(String serialno) {
        this.serialno = serialno == null ? null : serialno.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ScratchFile [id=" + id + ", serialno=" + serialno 
				+ ", type=" + type + ", fileName=" + fileName
				+ ", date=" + date + "]";
	}
    
}
