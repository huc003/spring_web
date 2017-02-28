package com.huc.thread;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by huc on 2017/2/28.
 */
@Configuration
@ComponentScan("com.huc.thread")
@EnableAsync//利用@EnableAsync注解开启异步任务支持
public class TaskExecutorConfig implements AsyncConfigurer{

    public Executor getAsyncExecutor() {//配置类实现AsyncConfigurer 接口并重写getAsyncExecutor 方法，并返回一个ThreadPoolTaskExecutor，这样我们就可以获得一个线程池TaskExecutor
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        taskExecutor.initialize();
        return taskExecutor;
    }

    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }
}
