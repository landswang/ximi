package com.ejie.nbrs.dao;

import java.util.List;
import java.util.Map;

import com.ejie.nbrs.entity.DeleteFile;
import com.ejie.nbrs.entity.FtpDoc;
import com.ejie.nbrs.entity.Images;




public interface IBeanMapperDao {
	//保存xml文件名中的流水号以及服务类型
	public int insert1(FtpDoc bean);
	//保存文件路径
	public int insert2(Images bean);
	//保存服务器应该删除的文件结合quartz
	public int insert3(DeleteFile bean);
	//查询有效状态下要删除的服务端文件
	public List<DeleteFile> selectByStuts(int stuts);
	//修改要删除服务端文件的有效状态
	public int updateByStuts(DeleteFile bean);
	//新覆盖时候删除原有数据库数据
	public int  deleteImages(Map paramMap);
	//新覆盖时候删除原有
	public int 	deleteFtpDoc(Map paramMap);
	
}
