package com.platform.platformclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/14 21:51
 * @Version 1.0
 **/
@RefreshScope
@RestController
public class ConfigController {


    @Value("${sang}")
    String sang;
    @Autowired
    Environment env;

    @RequestMapping("/sang")
    public String sang() {
        return this.sang;
    }
    @RequestMapping("/sang2")
    public String sang2() {
        return env.getProperty("sang", "未定义");
    }
}
