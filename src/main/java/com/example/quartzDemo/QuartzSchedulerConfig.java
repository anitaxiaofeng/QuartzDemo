package com.example.quartzDemo;


import lombok.extern.slf4j.Slf4j;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.quartz.Trigger;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;


/**
 * @Author: Anita
 * @Date: Created in 18:38 2017/11/8
 */
@Configuration
@Slf4j
@ConditionalOnProperty(name = "schedular.quartz.enabled", havingValue = "true")
public class QuartzSchedulerConfig {

    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext){
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource,
                                                     JobFactory jobFactory,
                                                     List<Trigger> triggers,
                                                     SchedulerProperties schedulerProperties){
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setSchedulerName(schedulerProperties.getQuartz().getSchedulerName());
        factory.setOverwriteExistingJobs(schedulerProperties.getQuartz().isOverwriteExistingJobs());
        factory.setDataSource(dataSource);
        factory.setJobFactory(jobFactory);
        factory.setTriggers(triggers.toArray(new Trigger[0]));
        factory.setQuartzProperties(quartzProperties());

        return factory;


    }

    public Properties quartzProperties(){
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        try{
            propertiesFactoryBean.afterPropertiesSet();
            return propertiesFactoryBean.getObject();
        } catch(IOException e){
            e.printStackTrace();
            log.error("read quartz.properties file error:{}", e.getMessage());
        }
        return null;
    }
}
