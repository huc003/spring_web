package com.huc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * Created by huc on 2017/2/28.
 */
//入口
public class WebInintializer implements WebApplicationInitializer{//是spring提供用来配置Servlet3.0+配置的借口，从而代替的web.xml的位置

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(MyMvcConfig.class);
        context.setServletContext(servletContext);//注册配置类，并将其和当前servletContext关联
        Dynamic servlet = servletContext.addServlet("dispatcher",new DispatcherServlet(context));//注册Springmvc的DispatcherServlet
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        servlet.setAsyncSupported(true);//开始起步方法的支持
    }
}
