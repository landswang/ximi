package com.ejie.nbrs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ejie.nbrs.dto.AccountWithRoleInfo;

public interface AccWRDao {
  /**
   * 根据偏移量查询可用商品列表
   * 
   * @param offset
   * @param limit
   * @return
   */
  List<AccountWithRoleInfo> selectAll(@Param("offset") int offset, @Param("limit") int limit);



}
