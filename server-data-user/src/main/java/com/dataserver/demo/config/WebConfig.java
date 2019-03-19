package com.dataserver.demo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/27 21:58
 * @Version 1.0
 **/
@Configuration
@EnableWebMvc // 1开启默认配置
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //1.构建了一个HttpMessageConverter  FastJson   消息转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //2.定义一个配置，设置编码方式，和格式化的形式
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //3.设置成了PrettyFormat格式
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //4.处理中文乱码问题
        List<MediaType> fastMediaTypes =  new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        //5.将fastJsonConfig加到消息转换器中
        fastConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastConverter);
    }
}
