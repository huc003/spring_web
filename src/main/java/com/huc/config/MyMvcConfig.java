package com.huc.config;

import com.huc.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by huc on 2017/2/28.
 */
@Configuration
@EnableWebMvc//1 开启Spring Mvc的支持，若无此句，重写WebMvcConfigurerAdapter 方法是无效的
@ComponentScan("com.huc.*")
public class MyMvcConfig extends WebMvcConfigurerAdapter{//2 继承WebMvcConfigurerAdapter类，重写其方法可对Spring Mvc进行配置

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");//设置前缀view的访问路径
        viewResolver.setSuffix(".jsp");//设置文件的访问后缀
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxInMemorySize(1000000);
        return multipartResolver;
    }

    @Bean//配置拦截器的bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");//3 addResourceLocations指的是文件放置的目录，addResourceHandler指的是对外暴露的访问路径
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {//重写addInterceptor方法，注册拦截器
        registry.addInterceptor(demoInterceptor());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toUpload").setViewName("/upload");//返回的显示层
        registry.addViewController("/sse").setViewName("/sse");//返回的显示层
    }


}
