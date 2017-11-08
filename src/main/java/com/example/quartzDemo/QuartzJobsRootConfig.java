package com.example.quartzDemo;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

/**
 * @Author: Anita
 * @Date: Created in 19:08 2017/11/8
 */
public abstract class QuartzJobsRootConfig {

    protected static JobDetailFactoryBean createJobDetail(Class jobClass){
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(jobClass);
        jobDetailFactoryBean.setDurability(true);
        return jobDetailFactoryBean;
    }


    protected static CronTriggerFactoryBean createTrigger(JobDetail jobDetail,String cronExpression){
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setCronExpression(cronExpression);
        cronTriggerFactoryBean.setJobDetail(jobDetail);
        cronTriggerFactoryBean.setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY);
        return cronTriggerFactoryBean;
    }
}
