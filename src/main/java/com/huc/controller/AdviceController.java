package com.huc.controller;

import com.huc.main.bean.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huc on 2017/3/1.
 */
@Controller
public class AdviceController {
    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj){//1
        throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute："+msg);
    }
}
