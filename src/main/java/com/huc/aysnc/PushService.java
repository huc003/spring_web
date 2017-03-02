package com.huc.aysnc;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by huc on 2017/3/2.
 */
@Service
public class PushService {
    private DeferredResult<String> deferredResult;//1在PushService里产生DeferredResult给控制器使用，通过@Scheduled注解方法定时更新DeferredResult

    public DeferredResult<String> getAsyncUpdate(){//1
        deferredResult = new DeferredResult<String>();
        return deferredResult;
    }
    @Scheduled(fixedDelay = 5000)
    public void refresh(){//1
        if(deferredResult!=null){
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
        }
    }
}
