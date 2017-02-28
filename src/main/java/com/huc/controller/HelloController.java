package com.huc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huc on 2017/2/28.
 */
@Controller//利用@Controller注解声明时一个控制器
public class HelloController {
    @RequestMapping("/")//配置URL和方法之间的映射
    public String hello(){
        return "index";//通过上面ViewResolver的Bean配置，返回值为index，说明我们的页面放置位置的路径为/WEB-INF/classes/views/index.jsp
    }
}
