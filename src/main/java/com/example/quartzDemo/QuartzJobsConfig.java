package com.example.quartzDemo;

import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;




/**
 * @Author: Anita
 * @Date: Created in 19:16 2017/11/8
 */
@Configuration
public class QuartzJobsConfig extends QuartzJobsRootConfig {

    @Bean
    public JobDetailFactoryBean upperRepeatNotifyJobDetail(){
        return createJobDetail(UpperRepeatNotifyJob.class);
    }

    @Bean
    public CronTriggerFactoryBean upperRepeatNotifyJobTrigger(
            @Qualifier("upperRepeatNotifyJobDetail")JobDetail jobDetail,
            @Value("${job.cron.upperRepeatNotifyJob}")String cronExpression){
        return createTrigger(jobDetail,cronExpression);
    }

    @Bean
    public JobDetailFactoryBean middleRepeatNotifyJobDetail() {
        return createJobDetail(MiddleRepeatNotifyJob.class);
    }

    @Bean
    public CronTriggerFactoryBean middleRepeatNotifyJobTrigger(@Qualifier("middleRepeatNotifyJobDetail") JobDetail jobDetail,
                                                               @Value("${job.cron.middleRepeatNotifyJob}") String cronExpression) {
        return createTrigger(jobDetail, cronExpression);
    }



}
