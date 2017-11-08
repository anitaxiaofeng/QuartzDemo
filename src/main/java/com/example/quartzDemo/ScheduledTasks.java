//package com.example.quartzDemo;
//
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * @Author: Anita
// * @Date: Created in 17:59 2017/11/8
// */
//@Component
//@Configurable
//@EnableScheduling
//public class ScheduledTasks {
//
//    @Scheduled(fixedRate = 1000*30)
//    public void reportCurrentTime(){
//        System.out.println("Scheduling Tasks Examples:The time is now"+ dataFormat().format(new Date()));
//    }
//
//    @Scheduled(cron = "0 */1 * * * *")
//    public void reportCurrentByCron(){
//        System.out.println("Scheduling Tasks Examples:The time is now"+ dataFormat().format(new Date()));
//    }
//
//
//    private SimpleDateFormat dataFormat(){
//        return new SimpleDateFormat("HH:mm:ss");
//    }
//}
