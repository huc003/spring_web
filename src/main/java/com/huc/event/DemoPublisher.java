package com.huc.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Created by huc on 2017/2/28.
 */
@Component
public class DemoPublisher {
    @Autowired
    public ApplicationContext applicationContext;//用来发布事件

    public void punlish(String msg){
        applicationContext.publishEvent(new DemoEvent(this,msg));//使用ApplicationContext的publishEvent 方法来发布
    }
}
