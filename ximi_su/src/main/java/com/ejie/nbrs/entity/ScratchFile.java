/**
 * 
 */
package com.ejie.nbrs.entity;

/***
 * @Title: ScratchFile
 * @Description: ecrs191
 * @packageName com.ejie.nbrs.entity
 * @fileName ScratchFile.java
 * @Company: ejie
 * @version 1.1
 * @author hisahe
 * @date 2017年9月14日 下午2:10:15
 */
import java.util.Date;

public class ScratchFile {
  // ID
  private Integer id;
  // 流水号
  private String serialno;
  // 类型
  private String type;
  // 文件路劲
  private String fileName;
  // 时间
  private Date date;
  /**
   * 文件原名
   */
  private String trueName;


  public ScratchFile() {
    super();
    // TODO Auto-generated constructor stub
  }

  public ScratchFile(String serialno, String type, String fileName, Date date, String trueName) {
    super();
    this.serialno = serialno;
    this.type = type;
    this.fileName = fileName;
    this.date = date;
    this.trueName = trueName;
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

  public String getTrueName() {
    return trueName;
  }

  public void setTrueName(String trueName) {
    this.trueName = trueName;
  }

  @Override
  public String toString() {
    return "ScratchFile [id=" + id + ", serialno=" + serialno + ", type=" + type + ", fileName="
        + fileName + ", date=" + date + ", trueName=" + trueName + "]";
  }

}
