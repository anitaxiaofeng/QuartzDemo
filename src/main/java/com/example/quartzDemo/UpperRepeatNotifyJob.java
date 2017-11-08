package com.example.quartzDemo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @Author: Anita
 * @Date: Created in 19:19 2017/11/8
 */
public class UpperRepeatNotifyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("executing upperRepeatNotifyJob");
    }
}
