/**
 * 
 */
package com.ejie.nbrs.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
/**
 * @author 手工配置spring 获取实体的工具类
 * @create hisahe
 **/
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
         this.applicationContext = applicationContext;
    }

    public static ApplicationContext  getApplicationContext(){
        return applicationContext;
    }

    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }

    public static Object getBean(Class c){
        return applicationContext.getBean(c);
    }
    
    // 事务工具类 start
    // 获取DataSourceTransactionManager
    public static DataSourceTransactionManager getTransactionManager() {
      ApplicationContext appCtx = getApplicationContext();
      DataSourceTransactionManager transactionManager =
          appCtx.getBean("transactionManager", DataSourceTransactionManager.class);
      return transactionManager;
    }

    // 获取TransactionStatus
    public static TransactionStatus getStatus(DataSourceTransactionManager transactionManager) {
      DefaultTransactionDefinition def = new DefaultTransactionDefinition();
      def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
      TransactionStatus status = transactionManager.getTransaction(def);
      return status;
    }
    // 事务工具类 end
}