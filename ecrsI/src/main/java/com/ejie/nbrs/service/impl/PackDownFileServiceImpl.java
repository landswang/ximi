/**
 * 
 */
package com.ejie.nbrs.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import com.ejie.nbrs.dto.BaseResult;
import com.ejie.nbrs.service.PackDownFileService;
import com.ejie.nbrs.util.ConfigConst;

/***
 * @Title: PackedFileServiceImpl
 * @Description: ecrs191
 * @packageName com.ejie.nbrs.service.impl
 * @fileName PackedFileServiceImpl.java
 * @Company: ejie
 * @version 1.1
 * @author hisahe
 * @date 2017年8月23日 上午9:27:03
 */
@Service
public class PackDownFileServiceImpl implements PackDownFileService {
  public boolean fileToZip(String bussNo) {
    boolean flag = false;
    FileInputStream fis = null;
    BufferedInputStream bis = null;
    FileOutputStream fos = null;
    ZipOutputStream zos = null;


    File sourceFile =
        new File(ConfigConst.ftptodir + ConfigConst.relativepath + "SXL" + "/" + bussNo);
    File sourceFile1 =
        new File(ConfigConst.ftptodir + ConfigConst.relativepath + "DYJFKL" + "/" + bussNo);
    File sourceFile2 =
        new File(ConfigConst.ftptodir + ConfigConst.relativepath + "DHL" + "/" + bussNo);
    File sourceFile3 = new File(ConfigConst.zipdir + "image/xwImage/" + bussNo);
    // new File(ConfigConst.ftptodir + ConfigConst.relativepath + "DHL" + "/" + bussNo);

    List<File> lsf = new ArrayList<File>();


    if (sourceFile.exists()) {
      File[] sourceFiles = sourceFile.listFiles();
      if (null == sourceFiles || sourceFiles.length < 1) {
        System.out.println("待压缩的文件目录：" + ConfigConst.ftptodir + ConfigConst.relativepath
            + "里面不存在文件，无需压缩.");
      } else {
        lsf.add(sourceFile);
      }
    }

    if (sourceFile1.exists()) {
      File[] sourceFiles = sourceFile1.listFiles();
      if (null == sourceFiles || sourceFiles.length < 1) {
        System.out.println("待压缩的文件目录：" + ConfigConst.ftptodir + ConfigConst.relativepath
            + "里面不存在文件，无需压缩.");
      } else {
        lsf.add(sourceFile1);
      }
    }

    if (sourceFile2.exists()) {
      File[] sourceFiles = sourceFile2.listFiles();
      if (null == sourceFiles || sourceFiles.length < 1) {
        System.out.println("待压缩的文件目录：" + ConfigConst.ftptodir + ConfigConst.relativepath
            + "里面不存在文件，无需压缩.");
      } else {
        lsf.add(sourceFile2);
      }
    }

    if (sourceFile3.exists()) {
      File[] sourceFiles = sourceFile3.listFiles();
      if (null == sourceFiles || sourceFiles.length < 1) {
        System.out.println("待压缩的文件目录：" + ConfigConst.ftptodir + ConfigConst.relativepath
            + "里面不存在文件，无需压缩.");
      } else {
        lsf.add(sourceFile3);
      }
    }

    if (lsf.size() == 0 || lsf.isEmpty()) {
      System.out.println("待压缩的文件目录：" + ConfigConst.ftptodir + ConfigConst.relativepath + "SXL"
          + "/" + bussNo + "不存在.");
    } else {
      try {
        File zipContents =
            new File(ConfigConst.zipdir + ConfigConst.relativepath + ConfigConst.zippath);// 压缩到的目录
        File zipFile =
            new File(ConfigConst.zipdir + ConfigConst.relativepath + ConfigConst.zippath + bussNo
                + ".zip");
        if (!zipContents.exists()) {// 如果目录不存在就直接创建
          zipFile.mkdirs();
        }
        if (zipFile.exists()) {// 如果压缩文件存在直接删除
          zipFile.delete();
        }
        fos = new FileOutputStream(zipFile);
        zos = new ZipOutputStream(new BufferedOutputStream(fos));
        for (File file : lsf) {
          File[] sourceFiles = file.listFiles();
          byte[] bufs = new byte[1024 * 10];
          for (int i = 0; i < sourceFiles.length; i++) {
            // 创建ZIP实体，并添加进压缩包
            ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
            try {
              zos.putNextEntry(zipEntry);
            } catch (Exception e) {
              System.out.println(sourceFiles[i].getName() + "文件重复");
              continue;

            }
            // 读取待压缩的文件并写进压缩包里
            fis = new FileInputStream(sourceFiles[i]);
            bis = new BufferedInputStream(fis, 1024 * 10);
            int read = 0;
            while ((read = bis.read(bufs, 0, 1024 * 10)) != -1) {
              zos.write(bufs, 0, read);
            }

            bis.close();
            fis.close();
          }
        }
        flag = true;
      } catch (FileNotFoundException e) {
        flag = false;
        e.printStackTrace();
        throw new RuntimeException(e);
      } catch (IOException e) {
        flag = false;
        e.printStackTrace();
        throw new RuntimeException(e);
      } finally {
        // 关闭流
        try {
          if (null != zos) {
            zos.close();
          }
          if (null != fos) {
            fos.close();
          }
        } catch (IOException e) {
          flag = false;
          e.printStackTrace();
          throw new RuntimeException(e);
        }
      }
    }
    return flag;
  }

  public void download(String bussNo, HttpServletResponse response) throws IOException {
    File file =
        new File(ConfigConst.zipdir + ConfigConst.relativepath + ConfigConst.zippath + bussNo
            + ".zip");
    response.setContentType("application/octet-stream");
    String name = URLEncoder.encode(bussNo + ".zip", "UTF-8");
    response.setHeader("Content-disposition", "attachment;filename=" + name);
    OutputStream os = response.getOutputStream();
    IOUtils.copy(new FileInputStream(file), os);
    os.flush();
    os.close();
    file.delete();
  }

  public BaseResult<String> whetherZip(String bussNo) throws IOException {
    int code = 0;
    String msg = null;
    boolean flag = fileToZip(bussNo);
    if (flag) {
      System.out.println("文件打包成功!");
      code = 1;
      msg = "文件打包成功，准备下载。";
    } else {
      code = 0;
      msg = "文件不存在，无法下载";
      System.out.println("文件打包失败!");
    }
    return new BaseResult<String>(code, msg, null);

  }
}
