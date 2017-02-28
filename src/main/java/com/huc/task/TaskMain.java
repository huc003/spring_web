package com.huc.task;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by huc on 2017/2/28.
 */
public class TaskMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
        
    }
}
