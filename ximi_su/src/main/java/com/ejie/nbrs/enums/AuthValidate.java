package com.ejie.nbrs.enums;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 项目名称：--- 模块名称：接入层 功能描述：权限定义 创建人： torreswang 创建时间：2017年5月9日 下午8:41:05 修改人： torreswang
 * 修改时间：2017年5月9日 下午8:41:05
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface AuthValidate {

  /**
   * 
   * 描述：权限定义
   * 
   * @author torreswang
   * @created 2017年5月8日 上午11:36:41
   * @since
   * @return 权限代码
   */
  AuthCode value() default AuthCode.Allow;

}
