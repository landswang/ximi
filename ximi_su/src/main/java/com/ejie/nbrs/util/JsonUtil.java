/**
 * jsonXML.java com.ejie.nbrs.util
 * 
 * Function： TODO
 * 
 * ver date author ────────────────────────────────── ver1.1 2017年7月17日 torreswang
 * 
 * Copyright (c) 2017, EJie All Rights Reserved.
 */

package com.ejie.nbrs.util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ejie.nbrs.exception.BusinessException;

/**
 * 
 * 项目名称：--- 模块名称：常用工具类 功能描述：json工具类 创建人： torreswang 创建时间：2017年3月28日 上午11:56:15 修改人： torreswang
 * 修改时间：2017年3月28日 上午11:56:15
 */
public class JsonUtil {

  /**
   * 
   * 描述：将对象格式化成json字符串
   * 
   * @author torreswang
   * @created 2017年4月1日 下午4:38:18
   * @since
   * @param object 对象
   * @return json字符串
   * @throws BusinessException
   */
  public static String toJson(Object object) throws BusinessException {
    try {
      return JSON.toJSONString(object, new SerializerFeature[] {
          SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect,
          SerializerFeature.WriteNonStringKeyAsString});
    } catch (Exception e) {
      throw new BusinessException();
    }
  }

  /**
   * 
   * 描述：将对象格式化成json字符串（PrettyFormat格式）
   * 
   * @author torreswang
   * @created 2017年4月1日 下午4:38:18
   * @since
   * @param object 对象
   * @return json字符串
   * @throws BusinessException
   */
  public static String toJsonFormat(Object object) throws BusinessException {
    try {
      return JSON.toJSONString(object, new SerializerFeature[] {
          SerializerFeature.WriteMapNullValue, SerializerFeature.PrettyFormat,
          SerializerFeature.DisableCircularReferenceDetect,
          SerializerFeature.WriteNonStringKeyAsString});
    } catch (Exception e) {
      throw new BusinessException();
    }
  }

  /**
   * 
   * 描述：转Map
   * 
   * @author torreswang
   * @created 2017年4月1日 下午5:00:20
   * @since
   * @param obj 对象
   * @return object
   * @throws BusinessException
   */
  public static Object toJsonObject(Object obj) throws BusinessException {
    try {
      return JSON.toJSON(obj);
    } catch (Exception e) {
      throw new BusinessException();
    }
  }

  /**
   * 
   * 描述：将json串转为对象
   * 
   * @author torreswang
   * @created 2017年4月1日 下午5:01:23
   * @since
   * @param jsonString json串
   * @param clazz 对象
   * @return
   * @throws BusinessException
   */
  public static <T> T fromJson(String jsonString, Class<T> clazz) throws BusinessException {
    try {
      if (com.alibaba.druid.util.StringUtils.isEmpty(jsonString)) {
        return null;
      }
      return (T) JSON.parseObject(jsonString, clazz);
    } catch (Exception e) {
      throw new BusinessException();
    }
  }

  /**
   * 
   * toList:将json 装换成 List<T>对象
   * 
   * @param @param jsonString
   * @param @param clazz
   * @param @return
   * @param @throws BusinessException 设定文件
   * @return List<T> DOM对象
   * @throws
   * @since CodingExample　Ver 1.1
   */
  public static <T> List<T> toList(String jsonString, Class<T> clazz) throws BusinessException {
    try {
      if (!com.alibaba.druid.util.StringUtils.isEmpty(jsonString)) {
        return JSON.parseArray(jsonString, clazz);
      }
      return null;
    } catch (Exception e) {
      throw new BusinessException();
    }

  }

  /**
   * 
   * 描述：暂时不开通
   * 
   * @author torreswang
   * @created 2017年4月1日 下午5:08:12
   * @since
   * @param jsonString
   * @return
   * @throws Exception
   */
  @SuppressWarnings("unused")
  private static <T> T fromJson(String jsonString) throws Exception {
    return JSON.parseObject(jsonString, new TypeReference<T>() {}, new Feature[0]);
  }

}
