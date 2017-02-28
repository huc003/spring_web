package com.huc.controller;

import com.huc.bean.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 注解演示控制器
 * Created by huc on 2017/2/28.
 */
@Controller//1 声明此类是一个控制器
@RequestMapping("/anno")//2 映射此类的访问路劲是/anno
public class DemoAnnoController {
    @RequestMapping(produces = "text/plain;chaset=utf-8")//3 此方法未标注路劲，因此使用此类级别的路劲/anno;produces可定制返回response的媒体类型和字符集，或需要返回值是json对象，则设置application/json;chaset=utf-8
    @ResponseBody
    public String index(HttpServletRequest request){//4 演示可接受HttpServletRequest作为参数，当然也可以接受HttpServletReponse
        return "url:"+request.getRequestURL() + "can access";
    }

    @RequestMapping(value = "/pathvar/{str}",produces = "text/plain;chaset=utf-8")//5 演示可以接受路劲参数，并在方法参数前结合@PathVariable
    @ResponseBody
    public String demoPathVar(@PathVariable String str, HttpServletRequest request){
        return "url:"+request.getRequestURL() + "can access,str:"+str;
    }

    @RequestMapping(value = "/requestParam",produces = "text/plain;chaset=utf-8")//6 演示常规的request参数获取，访问路劲为/requestParam?id = 1
    @ResponseBody
    public String passRequestParam(Long id,HttpServletRequest request){
        return "url:"+request.getRequestURL() + "can access,id:"+id;
    }

    @RequestMapping(value = "/obj",produces = "application/json;chaset=utf-8")//7 演示解释参数到对象，访问路劲/obj?id=1&name==xxx
    @ResponseBody//8 也可以用在方法上
    public String passObj(DemoObj obj,HttpServletRequest request){
        return "url:"+request.getRequestURL() + "can access,obj id:"+obj.getId()+" obj name:"+obj.getName();
    }

    @RequestMapping(value = {"/name1","/name2"},produces = "text/plain;chaset=utf-8")//9 演示映射不同的路劲到相同的方法，访问路劲/name1,/name2
    @ResponseBody
    public String remove(HttpServletRequest request){
        return "url:"+request.getRequestURL() + "can access";
    }

}
