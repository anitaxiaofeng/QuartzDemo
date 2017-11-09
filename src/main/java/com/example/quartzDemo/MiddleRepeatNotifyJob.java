package com.example.quartzDemo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author: Anita
 * @Date: Created in 20:07 2017/11/8
 */
public class MiddleRepeatNotifyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("executing middleRepeatNotifyJob");
    }
}
