package com.ejie.nbrs.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejie.nbrs.cache.RedisCache;
import com.ejie.nbrs.dao.RoleInfoDao;
import com.ejie.nbrs.dao.RolePrivilegeDao;
import com.ejie.nbrs.dto.RandP;
import com.ejie.nbrs.entity.RoleInfo;
import com.ejie.nbrs.entity.RolePrivilege;
import com.ejie.nbrs.service.RoleInfoService;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

  private final Logger LOG = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private RoleInfoDao roleInfoDao;
  @Autowired
  private RolePrivilegeDao roleRPDao;
  @Autowired
  private RedisCache cache;

  @Override
  public List<RoleInfo> queryByAll() {
    String cache_key = RedisCache.CAHCENAME + "|queryRoleInfoDistinctName|" + 0 + "|";
    List<RoleInfo> result_cache = cache.getListCache(cache_key, RoleInfo.class);
    if (result_cache != null) {
      LOG.info("get cache with key:" + cache_key);
    } else {
      // 缓存中没有再去数据库取，并插入缓存（缓存时间为60秒）
      result_cache = roleInfoDao.distincRoleName();
      System.out.println(result_cache.size() + result_cache.get(0).toString());
      // cache.putListCacheWithExpireTime(cache_key, result_cache, RedisCache.CAHCETIME);
      LOG.info("put cache with key:" + cache_key);

    }
    System.out.println("----------------result_cache is " + result_cache);
    return result_cache;
  }

  /**
   * 实现添加
   */
  @Override
  public boolean insertUser(RoleInfo role) {
    return roleInfoDao.insertUser(role);
  }



  @Override
  public List<RoleInfo> selectAll() {
    return roleInfoDao.selectAll();
  }

  @Override
  public List<RoleInfo> distincRoleName() {
    return roleInfoDao.distincRoleName();
  }

  @Override
  public int modifyRole(RoleInfo r) {
    return roleInfoDao.modifyRole(r);
  }

  @Override
  public RoleInfo selectByRoleName(String roleName) {
    return roleInfoDao.selectByRoleName(roleName);
  }

  @Override
  public List<RolePrivilege> selectRPByRoleId(Integer roleId) {
    return roleRPDao.selectRPByRoleId(roleId);
  }

  @Override
  public int insertRPList(RandP rps) {
    return roleRPDao.insertRPList(rps);
  }

  @Override
  public int deleteRPByRoleId(Integer roleId) {
    return roleRPDao.deleteRPByRoleId(roleId);
  }
}
