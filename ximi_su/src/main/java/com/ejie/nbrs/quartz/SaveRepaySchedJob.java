package com.ejie.nbrs.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.ejie.nbrs.ejieinterface.service.EjieDataService;
import com.ejie.nbrs.util.SpringContextUtil;

/**
 * 任务轮询调用还款计划
 * 
 */

public class SaveRepaySchedJob extends QuartzJobBean {  
    @Override  
    protected void executeInternal(JobExecutionContext arg0)  
            throws JobExecutionException {  
        System.out.println("I am SecondScheduledJob");  
        ApplicationContext appCtx = SpringContextUtil.getApplicationContext();
        EjieDataService ejieDataService = appCtx.getBean(EjieDataService.class);
        ejieDataService.getRepaySched();
    }  
  
}