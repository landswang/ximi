package com.ejie.nbrs.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.ejie.nbrs.dto.SearchCondition;
import com.ejie.nbrs.entity.ScratchFile;

/**
 * 图片服务层
 * @author zlg
 *
 */
public interface ImagesService {
	
	//保存文件路径
	int insert2(SearchCondition sc);
	/**
	 * 上传图片
	 * 
	 * @return 成功否
	 * @throws IOException
	 */
	String uploadImages(MultipartFile file,HttpServletRequest request,SearchCondition sc) throws IOException;
	/**
	 * 
	* @Title: selectScratchFile
	* @Description: TODO 通过流水号查询临时文件信息集合
	* @param @param sc
	* @param @return    参数
	* @return List<ScratchFile>    返回类型
	* @throws
	 */
	List<ScratchFile> selectScratchFile(SearchCondition sc);
	/**
	 * 
	* @Title: insertScratchFile
	* @Description: TODO 添加临时文件
	* @param @param sf
	* @param @return    参数
	* @return int    返回类型
	* @throws
	 */
	int insertScratchFile(SearchCondition sc);
	/**
	 * 
	* @Title: deleteScratchFile
	* @Description: TODO 删除所有该流水号关联临时文件信息
	* @param @param sc
	* @param @return    参数
	* @return boolean    返回类型
	* @throws
	 */
	boolean deleteScratchFile(SearchCondition sc);
}
