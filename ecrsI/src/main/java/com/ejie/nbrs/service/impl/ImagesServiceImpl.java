package com.ejie.nbrs.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ejie.nbrs.dao.IBeanMapperDao;
import com.ejie.nbrs.dao.ImagesDao;
import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.entity.ScratchFile;
import com.ejie.nbrs.service.ImagesService;
import com.ejie.nbrs.util.ConfigConst;

/**
 * 
 * @author Administrator
 * 
 */
@Service
public class ImagesServiceImpl implements ImagesService {

  @Autowired
  private ImagesDao imagesDao;
  @Autowired
  private IBeanMapperDao ibdao;

  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public String uploadImages(MultipartFile file, HttpServletRequest request, SearchCondition sc)
      throws IOException {
    try {
      ConfigConst.getConfigConst();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // ResultData<Object> resultData = new ResultData<>();
    String path = null;// 文件路径
    String type = null;// 文件类型
    String trueFileName = null;// 自定义的文件名
    if (file != null) {// 判断上传的文件是否为空

      String fileName2 = file.getOriginalFilename();// 测试
      fileName2 = fileName2.replace(",", "，");
      String fileCatalog = sc.getaBaseName() + sc.getSerialNo() + "/";// 文件目录串
      if (sc.getaBaseName() == null) {
        fileCatalog = "";
      }
      String fileName = fileCatalog + fileName2; // 传入文件全名称

      String trueName = fileName.substring(fileName.lastIndexOf("//") + 1, fileName.length());// 实际文件原名

      System.out.println("上传的文件原名称:" + trueName);

      // 判断文件类型
      type =
          fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1,
              fileName.length()) : null;
      if (type != null) {// 判断文件类型是否为空
        if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase())
            || "JPG".equals(type.toUpperCase())) {

          String realPath2 = ConfigConst.zipdir;

          File zipdir = new File(realPath2);

          // 如果文件夹不存在则创建
          if (!zipdir.exists() && !zipdir.isDirectory()) {
            System.out.println("//根目录不存在");
            zipdir.mkdir();
          } else {
            System.out.println("//根目录存在");
          }

          String[] fPath = fileCatalog.split("/");
          String realPath = "";
          File zipdir2 = null;// 二级文件
          for (int i = 0; i < fPath.length; i++) {
            realPath = realPath2 + fPath[i];
            zipdir2 = new File(realPath);
            // 如果文件夹不存在则创建
            if (!zipdir2.exists() && !zipdir2.isDirectory()) {
              System.out.println("//二级目录不存在");
              zipdir2.mkdir();
            } else {
              System.out.println("//二级目录存在");
            }
            realPath2 += fPath[i] + "/";
          }

          // F:\zlgtools\apache-tomcat-8.0.33\webapps\staticresource
          SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
          Date date = new Date();
          String num1 = fileName.substring(0, fileName.lastIndexOf("."));
          String num2 = sdf.format(date);
          // 自定义的文件名称
          trueFileName = num1 + num2 + "." + type;

          // 设置存放图片文件的路径
          path = ConfigConst.zipdir + trueFileName;

          // 转存文件到指定的路径
          file.transferTo(new File(path));
          System.out.println("文件成功上传到指定目录下:" + path);
        } else {
          System.out.println("不是我们想要的文件类型,请按要求重新上传");
          return null;
        }
      } else {
        System.out.println("文件类型为空");
        return null;
      }
    } else {
      System.out.println("没有找到相对应的文件");
      return null;
    }
    return trueFileName;
  }

  /**
   * 
   * @Title: selectScratchFile
   * @Description: TODO 通过流水号查询临时文件信息集合
   * @param @param sc
   * @param @return 参数
   * @return List<ScratchFile> 返回类型
   * @throws
   */
  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public List<ScratchFile> selectScratchFile(SearchCondition sc) {
    Map<String, String> map = new HashMap<String, String>();
    map.put("serialNo", sc.getSerialNo());
    map.put("type", sc.geteProduct());
    return imagesDao.selectScratchFile(map);
  }

  /**
   * 
   * @Title: insertScratchFile
   * @Description: TODO 添加临时文件
   * @param @param sf
   * @param @return 参数
   * @return int 返回类型
   * @throws
   */
  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public int insertScratchFile(SearchCondition sc) {
    ScratchFile sf =
        new ScratchFile(sc.getSerialNo(), sc.geteProduct(), sc.getLoanVoucher(), new Date());// 临时文件
    return imagesDao.insertScratchFile(sf);
  }

  /**
   * 
   * @Title: deleteScratchFile
   * @Description: TODO 删除所有该流水号关联临时文件信息
   * @param @param sc
   * @param @return 参数
   * @return boolean 返回类型
   * @throws
   */
  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public boolean deleteScratchFile(SearchCondition sc) {
    Map<String, String> map = new HashMap<String, String>();
    String fileName = sc.getLoanVoucher();// 文件名称
    String realPath2 = ConfigConst.zipdir;

    if (fileName != null && !fileName.equals("")) {
      // 存放图片文件的路径
      String path = realPath2 + fileName;
      File file = new File(path);
      if (file.exists()) {// 删除临时文件/图片
        file.delete();
      }
    }

    map.put("serialNo", sc.getSerialNo());
    map.put("fileName", fileName);
    map.put("type", sc.geteProduct());
    return imagesDao.deleteScratchFile(map);
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public int insert2(SearchCondition sc) {
    // SearchCondition sc2 = new SearchCondition();
    // sc2.setLoanId(sc.getLoanId());
    // sc2.setSerialNo(sc.getSerialNo());
    // sc2.seteProduct(sc.geteProduct());
    // boolean bool =deleteScratchFile(sc2);
    // System.out.println("是否已经删除临时表中的图片记录？————" + bool);

    // ["image/xwImage/timg420171010151534302.jpg","image/xwImage/QQ截图20171010151534304.png","image/xwImage/timg20171010151534300.jpg"]
    String loanVoucher = sc.getLoanVoucher();
    // 去掉[]括号
    String names = loanVoucher.substring(1, loanVoucher.length() - 1);
    String[] name = names.split(",");

    int k = 0;

    for (int i = 0; i < name.length; i++) {
      // 去掉""双引号
      String b = name[i].substring(1, name[i].length() - 1).trim();
      // Images images=new Images();
      // images.setBusNo(sc.getSerialNo());
      // images.setSource("");
      // images.setSubType(sc.geteProduct());
      // images.setName(b);
      //
      // ibdao.insert2(images);
      k++;
    }

    return k;

  }

}
