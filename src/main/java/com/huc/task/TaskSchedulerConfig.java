package com.huc.task;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by huc on 2017/2/28.
 */
@Configuration
@ComponentScan("com.huc.task")
@EnableScheduling//开启对计划任务的支持
public class TaskSchedulerConfig {

}
