package com.dataserver.eshop.serverdataeshop.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/29 19:45
 * @Version 1.0
 **/
@Configuration
public class MyMVCSuooprt extends WebMvcConfigurationSupport {

    /*
     * 这里主要为了解决跨域问题,所以重写addCorsMappings方法
     */
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("access-control-allow-headers",
                        "access-control-allow-methods",
                        "access-control-allow-origin",
                        "access-control-max-age",
                        "X-Frame-Options")
                .allowCredentials(false).maxAge(3600);
        super.addCorsMappings(registry);
    }

    /**
     * 配置FastJson为方式一
     *
     * @return
     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//        /*
//         * 1、需要先定义一个convert转换消息的对象 2、添加fastJson的配置信息，比如：是否要格式化返回json数据 3、在convert中添加配置信息
//         * 4、将convert添加到converters当中
//         *
//         */
//        // 1、需要先定义一个·convert转换消息的对象；
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        // 2、添加fastjson的配置信息，比如 是否要格式化返回json数据
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//        // 3、在convert中添加配置信息.
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        // 4、将convert添加到converters当中.
//        converters.add(fastConverter);
//    }

}
