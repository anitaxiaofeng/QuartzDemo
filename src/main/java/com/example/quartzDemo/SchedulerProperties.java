package com.example.quartzDemo;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Anita
 * @Date: Created in 18:46 2017/11/8
 */
@Data
@Slf4j
@Component
@ConfigurationProperties("scheduler")
public class SchedulerProperties implements InitializingBean {

    private QuartzProperties quartz;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("property:{}",quartz);
    }

    @Data
    public static class QuartzProperties{
        @NotNull
        private String schedulerName;
        private boolean enabled;
        private boolean overwriteExistingJobs;
    }
}
