package com.huc.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by huc on 2017/2/28.
 */
@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat ddateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 5000)//声明这是一个计划任务
//    public void reportCurrentTime(){
//        System.out.println("每隔5秒执行一次"+ddateFormat.format(new Date()));
//    }

    @Scheduled(cron = "0 45 14 ? * *")//在指定的时间内执行计划
    public void fixTimeExecution(){
        System.out.println("在指定的时间 "+ddateFormat.format(new Date())+"执行");
    }

}
