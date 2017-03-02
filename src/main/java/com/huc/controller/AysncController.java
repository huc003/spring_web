package com.huc.controller;

import com.huc.aysnc.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by huc on 2017/3/2.
 */
@Controller
public class AysncController {
    @Autowired
    public PushService pushService;//1定时任务，定时更新DeferredResult

    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredCall(){//2返回给客户端DeferredResult
        return pushService.getAsyncUpdate();
    }

}
