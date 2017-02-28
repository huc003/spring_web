package com.huc.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by huc on 2017/2/28.
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent>{

    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("我bean-demoListener-接收到了bean-demoPublisher发布的消息:"+msg);
        if(!msg.equals("")){
            System.out.println("执行定时任务......");
        }
    }
}
