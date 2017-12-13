/**
 * Test.java com.ts.ftp.test
 * 
 * Function： TODO
 * 
 * ver date author ────────────────────────────────── ver1.1 2017年8月10日 torreswang
 * 
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ejie.nbrs.dao.IBeanMapperDao;
import com.ejie.nbrs.entity.DeleteFile;
import com.ejie.nbrs.entity.FtpDoc;
import com.ejie.nbrs.entity.Images;
import com.ejie.nbrs.ftp.ContinueFTP;
import com.ejie.nbrs.service.DownImageService;
import com.ejie.nbrs.util.ConfigConst;



/**
 * ClassName:Test
 * 
 * @author hisahe
 * @version
 * @since Ver 1.1
 * @Date 2017年8月10日 下午7:13:43
 * @see
 */
@Service
public class DownImageServiceImple implements DownImageService {
	private static final Logger logger = Logger
			.getLogger(DownImageServiceImple.class);
	
	  @Autowired
	  private  IBeanMapperDao imDao;
	  
	/**
	 * @param args
	 * @throws Exception
	 */
	
	public static void main(String[] args) throws Exception {
		// mybits
		/*String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		ConfigConst.getConfigConst();
		ContinueFTP myFtp = new ContinueFTP();
		myFtp.connect(ConfigConst.ftpserver,
				Integer.parseInt(ConfigConst.ftpport), ConfigConst.ftpuser,
				ConfigConst.ftppwd);
		String[] files = myFtp.getFileList(ConfigConst.ftpgetdir);
		String[] filenames = ConfigConst.ftpfileend.split(",");*/
		//TestServiceImple.downLoadXml(files, myFtp, filenames);
		// Test.insertBean(ConfigConst.ftptodir+ConfigConst.relativepath,
		// sqlSessionFactory,myFtp);
		// myFtp.ftpClient.deleteFile(ConfigConst.ftpgetdir);

	}

	/**
	 * filePath=本地image文件目录 xmlPath=本地xml文件路径
	 */
	public  void insertBean(String filePath,ContinueFTP myFtp,String xmlPath) {
		File fileXml = new File(xmlPath);

		FtpDoc bean = null;

		if (xmlPath.endsWith(".xml")) {
			bean = parseXml(xmlPath, myFtp);
			if (bean != null) {

				int Index = xmlPath.lastIndexOf("\\");
				String xmlName = xmlPath.substring(Index + 1, xmlPath.length());

				int size = 0;
				size = saveBean(bean, myFtp, xmlName);
				List<Images> images = bean.getImage();
				if (size == 1) {// 数据持久化成功
					fileXml.renameTo(new File(filePath + "/" + bean.getSource()
							+ "/" + bean.getBusNo() + "/" + fileXml.getName()));
					try {
						myFtp.ftpClient.dele(ConfigConst.ftpgetdir
								+ fileXml.getName());
						for (Images im : images) {
							int lastIndex = im.getName().lastIndexOf("/");
							String ftpFileName = im.getName().substring(
									lastIndex + 1, im.getName().length());
							// 删除ftp服务器xml和图片文件 移动本地xml 移除服务器文件
							myFtp.ftpClient.dele(ConfigConst.ftpgetdir
									+ ftpFileName);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (size == 2) {
					// 服务器文件和xml不能完整对应，也就是下载文件出现异常
					// 移除本地文件xml和下载文件 保留服务器文件

					for (Images im : images) {

						int lastIndex = im.getName().lastIndexOf("/");
						String ftpFileName = im.getName().substring(
								lastIndex + 1, im.getName().length());
						File fileloacal = new File(filePath + "/"+bean.getSource()+"/"
								+ bean.getBusNo() + "/" + ftpFileName);
						fileloacal.delete();
						fileXml.delete();

					}

				} else {// 数据重复删除本地xml
					fileXml.delete();
				}
			}
		}

	}

	// 删除目录下面的所有文件
	private static void deleteFile(File file) {
		if (file.isFile() || file.list().length == 0) {
			file.delete();
		} else {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				deleteFile(files[i]);
				files[i].delete();
			}
		}
	}

	public  int saveBean(FtpDoc bean, ContinueFTP myFtp,
			String xmlName) {
		int re = 0;
		
		StringBuffer delFile = new StringBuffer(xmlName + ",");

		List<Images> images = bean.getImage();
		int delDataStuts = 0;// 删除数据库记录状态 0成功1失败 如果失败回滚
		// 查询流水号和业务类型 如果存在直接删掉全部图片
		// 再删除数据库中的表数据
		if (images != null) {
			String busNo = images.get(0).getBusNo();
			String source = images.get(0).getSource();
			Map<String, String> map = new HashMap<String, String>();
			map.put("busNo", busNo);
			map.put("source", source);
			try {// 先查看是否有删除记录如果没有直接保存 如果有就先删除记录和文件
				int doc = imDao.deleteFtpDoc(map);
				int image = imDao.deleteImages(map);
				if (doc == 0 && image == 0) {
					System.out.println("不删除只保存");
				} else {
					// 如果有记录先删除再保存
					try {
						File file = new File(ConfigConst.ftptodir + "/"
								+ ConfigConst.relativepath + "/" + source + "/"
								+ busNo);
						if (file.exists()) {
							deleteFile(file);
							file.mkdirs();
						}
					// 删除文件成功就直接提交删除记录
					} catch (Exception e) {
						delDataStuts = 1;
						e.printStackTrace();
					}
				}

			} catch (Exception e) {
				// 如果删除数据异常就回滚
				delDataStuts = 1;
				e.printStackTrace();
			}
			if (delDataStuts == 0) {

				for (Images im : images) {
					imDao.insert2(im);
				}
				try {
					re = imDao.insert1(bean);
				} catch (Exception e) {
					re = 0;
					e.printStackTrace();
					logger.info("重复数据不能插入");
				}

				if (re == 1) {
					for (Images im : images) {
						try {
							int lastIndex = im.getName().lastIndexOf("/");
							String ftpFileName = im.getName().substring(
									lastIndex + 1, im.getName().length());
							delFile.append(ftpFileName + ",");
							String result = myFtp.download(
									ConfigConst.ftpgetdir + ftpFileName,
									ConfigConst.ftptodir + im.getName())
									.toString();
							if (result.equals("Remote_File_Noexist")
									|| result
											.equals("Download_From_Break_Failed")
									|| result.equals("Download_New_Failed")) {
								logger.info("下载xml文件中的" + im.getName()
										+ "在ftp服务器不存在或者下载失败");
								re = 2;
								break;
							}

						} catch (IOException e) {
							logger.info("下载文件出现异常");
							re = 2;
							e.printStackTrace();
							break;
							// TODO Auto-generated catch block

						}

					}
                 if(re!=2){
						try {// 解决服务器端文件删除异常问题
							String path = images.get(0).getSource()+"/"+images.get(0).getBusNo();
							DeleteFile df = new DeleteFile();
							delFile.deleteCharAt(delFile.length() - 1);
							df.setFileName(delFile.toString());
							df.setStuts(1);
							df.setPath(path);
							imDao.insert3(df);
						} catch (Exception e) {
							e.printStackTrace();
							logger.info("轮询删除服务器状态保存失败");
						}
                 }
				}
			}
		}
		return re;

	}

	/**
	 * @param rfiles
	 * @param myFtp
	 * @param files
	 * @throws IOException
	 */
	public  void downLoadXml(String[] rfiles, ContinueFTP myFtp,
			String[] files)
			throws IOException {
		String filePath = ConfigConst.ftptodir + ConfigConst.relativepath;
		if (rfiles == null) {
			logger.info("远程文件列表为空");
			return;
		}

		for (int i = 0; i < rfiles.length; i++) {
			if (rfiles[i].endsWith(files[0])) {
				File file = new File(filePath);
				if (!file.isDirectory()) {
					file.mkdir();
				}
				String filepath = file + "\\" + rfiles[i];
				String result = myFtp.download(
						ConfigConst.ftpgetdir + rfiles[i], filepath).toString();
				if (result.equals("Download_New_Success")
						|| result.equals("Download_From_Break_Success")) {
					insertBean(filePath, myFtp, filepath);
					logger.info("xml下载成功.....");
				} else if (result.equals("Local_Bigger_Remote")) {
					// 如果xml本地存在删除本地文件
					File delFile = new File(filepath);
					delFile.delete();
					continue;
				} else {
					logger.info("下载不成功继续下一个xml下载.....");
					continue;
				}

				logger.info("下载资源" + rfiles[i] + "文件结果：" + result);
			}

		}

	}

	// 获取本地文件路径下的所有文件名

	public static String[] getFileName(String path) {
		File file = new File(path);
		String[] fileNames = file.list();
		return fileNames;
	}

	// 解析xml

	public static FtpDoc parseXml(String xmlPath, ContinueFTP myFtp
		) {

		SAXReader reader = new SAXReader();
		// 读取文件 转换成Document
		Document document;
		FtpDoc bean = null;
		try {
			document = reader.read(new File(xmlPath));
			// 获取根节点元素对象
			Element root = document.getRootElement();
			Element taskEle = root.element("Task");

			bean = initBean(taskEle, myFtp);

		} catch (DocumentException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		return bean;

	}

	// 解析xml然后返回FtpDoc FtpDoc 用来标识读取文件的唯一性
	public static FtpDoc initBean(Element beanDoc, ContinueFTP myFtp) {
		String filePath = ConfigConst.ftptodir + ConfigConst.relativepath;
		FtpDoc bean = new FtpDoc();
		bean.setId(beanDoc.elementText("SequenceId"));
		bean.setBranchCode(beanDoc.elementText("BranchCode"));
		String source = beanDoc.elementText("Source");
		// 如果source 不统一 再做下一步判断 目前只是参考xml文件
		if (source.equals("001")) {
			source = "SXL";
		} else if (source.equals("002")) {
			source = "DYJFKL";
		} else if (source.equals("003")) {
			source = "DHL";
		}
		bean.setSource(source);
		bean.setBusNo(beanDoc.elementText("BussNo"));
		// 本地路径+相对路径+业务类别+订单号
		File file = new File(filePath + "/" + source + "/"
				+ beanDoc.elementText("BussNo"));
		if (!file.exists()) {
			file.mkdirs();
		}

		List<Images> names = new ArrayList<>();
		Element document = beanDoc.element("Documents");
		if (document != null) {

			List<Element> docs = document.elements("Document");
			for (Element doc : docs) {

				Element filesEl = doc.element("Files");
				List<Element> files = filesEl.elements("File");

				if (files != null) {
					for (Element f : files) {

						Images image = new Images();
						image.setName(ConfigConst.relativepath + source + "/"
								+ beanDoc.elementText("BussNo") + "/"
								+ f.elementText("Name"));
						image.setSource(source);
						image.setBusNo(beanDoc.elementText("BussNo"));
						image.setSubType(doc.elementText("Subtype")
								.toUpperCase());

						System.out.println("name=" + f.elementText("Name"));
						names.add(image);

					}
				}

				if (!names.isEmpty()) {
					String subType = doc.elementText("Subtype");
					bean.setImage(names);
				}
			}
		}
		return bean;
	}

	/* (non-Javadoc)
	 * @see com.ejie.nbrs.service.TestService#saveImage()
	 */
	@Override
	public void saveImage() throws Exception {
		ConfigConst.getConfigConst();
		ContinueFTP myFtp = new ContinueFTP();
		myFtp.connect(ConfigConst.ftpserver,
				Integer.parseInt(ConfigConst.ftpport), ConfigConst.ftpuser,
				ConfigConst.ftppwd);
		String[] files = myFtp.getFileList(ConfigConst.ftpgetdir);
		String[] filenames = ConfigConst.ftpfileend.split(",");
		try{
			downLoadXml(files, myFtp, filenames);
			delFile(myFtp);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			myFtp.disconnect();
		}
	}
	
	
	
	public synchronized  void   delFile(ContinueFTP myFtp){
		try {
			List<DeleteFile> list = imDao.selectByStuts(1);

			if (list.size() > 0) {
				for (DeleteFile df : list) {
					String str = df.getFileName();
					String path = df.getPath();
					String[] strArray = null;
					strArray = str.split(",");
					boolean result = false;
					File file = new File(ConfigConst.ftptodir + "/"
							 + strArray[0]);
					if (file.exists()) {
						file.renameTo(new File(ConfigConst.ftptodir + "/"
								+ ConfigConst.relativepath + "/" + path + "/"
								+ strArray[0]));
					}

					for (int i = 0; i < strArray.length; i++) {
						boolean bl = myFtp.ftpClient
								.deleteFile(ConfigConst.ftpgetdir + strArray[i]);

						if (bl) {
							result = true;
						}
					}
					if (!result) {
						df.getId();
						df.setStuts(0);
						imDao.updateByStuts(df);
					}
				}

			}

		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	
	}
}
