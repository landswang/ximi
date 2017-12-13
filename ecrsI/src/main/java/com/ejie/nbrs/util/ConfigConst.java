package com.ejie.nbrs.util;

/**
 * 
 * ClassName:ConfigConst
 * 
 * @author torreswang
 * @version
 * @since Ver 1.1
 * @Date 2017 2017年8月10日 下午7:26:34
 * @see
 */
public class ConfigConst {


  public static String rundate;

  public static String ftpserver;

  public static String ftpuser;

  public static String ftppwd;

  public static String ftpport;

  public static String ftpgetdir;

  public static String ftptodir;

  public static String ftpfile;

  public static String ftpfileend;
  
  public static String relativepath;

  public static String deldate;
  public static String zippath;
  public static String zipdir;
  public static String  document;
  public static String  fileRPath;

  public static void getConfigConst() throws Exception {

    rundate = ConfigManager.getInstance().getConfigItem("rundate");
    ftpserver = ConfigManager.getInstance().getConfigItem("ftpserver");
    ftpuser = ConfigManager.getInstance().getConfigItem("ftpuser");
    ftppwd = ConfigManager.getInstance().getConfigItem("ftppwd");
    ftpport = ConfigManager.getInstance().getConfigItem("ftpport");
    ftpgetdir = ConfigManager.getInstance().getConfigItem("ftpgetdir");
    ftptodir = ConfigManager.getInstance().getConfigItem("ftptodir");
    ftpfile = ConfigManager.getInstance().getConfigItem("ftpfile");
    ftpfileend = ConfigManager.getInstance().getConfigItem("ftpfileend");
    relativepath = ConfigManager.getInstance().getConfigItem("relativepath");
    deldate = ConfigManager.getInstance().getConfigItem("deldate");
    zippath = ConfigManager.getInstance().getConfigItem("zippath");
    zipdir = ConfigManager.getInstance().getConfigItem("zipdir");
    document = ConfigManager.getInstance().getConfigItem("document");
    fileRPath = ConfigManager.getInstance().getConfigItem("fileRPath");
  }
}
