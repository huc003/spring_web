package com.huc.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by huc on 2017/3/1.
 */
@ControllerAdvice//1声明是一个控制器建言，@ControllerAdvice组合了@Controller注解，所以自动注册为spring的bean
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = Exception.class)//2@ExceptionHandler 在此处定义全局处理，通过value属性可过滤拦截的条件，在此我们拦截所有的异常
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error");//error页面
        modelAndView.addObject("errorMessage",exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute//3将键值对添加到全局，所有注解的@RequestMapping的方法可获得次键值对
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");//3
    }

    @InitBinder//4通过InitBinder注解定制WebDataBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");//5此处忽略request参数的id
    }
}
