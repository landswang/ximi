package com.ejie.nbrs.dao;

import java.util.List;
import java.util.Map;

import com.ejie.nbrs.entity.ScratchFile;

/**
 * 
 * ClassName:ImagesDao 图片处理dao层
 * 
 * @author zlg
 * @version 版本
 * @since Ver 1.1
 * @Date 2017年9月14日 下午2:32:22
 * @ModifiedBy 修改人
 * @Copyright 公司名称
 *
 */
public interface ImagesDao {
	/**
	 * 
	* @Title: selectScratchFile
	* @Description: TODO 通过流水号查询临时文件信息集合
	* @param @param sc
	* @param @return    参数
	* @return List<ScratchFile>    返回类型
	* @throws
	 */
	List<ScratchFile> selectScratchFile(Map<String,String> map);
	/**
	 * 
	* @Title: insertScratchFile
	* @Description: TODO 添加临时文件
	* @param @param sf
	* @param @return    参数
	* @return int    返回类型
	* @throws
	 */
	int insertScratchFile(ScratchFile sf);
	/**
	 * 
	* @Title: deleteScratchFile
	* @Description: TODO 删除所有该流水号关联临时文件信息
	* @param @param sc
	* @param @return    参数
	* @return boolean    返回类型
	* @throws
	 */
	boolean deleteScratchFile(Map<String,String> map);
}
