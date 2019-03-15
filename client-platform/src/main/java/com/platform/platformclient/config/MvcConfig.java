package com.platform.platformclient.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/13 21:16
 * @Version 1.0
 **/
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/test").setViewName("test");
        registry.addViewController("/tologin").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/01home").setViewName("pages/01home");
    }
}
