package com.huc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Created by huc on 2017/3/1.
 */
@Controller
public class SseController {

    @ResponseBody
    @RequestMapping(value = "/push",produces = "text/event-stream")//1服务端SSE的支持
    public String push(){
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3"+r.nextInt()+"\n\n";
    }
}
