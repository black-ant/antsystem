package com.antsystem.serverbus.controller;

import com.antsystem.serverbus.config.MyMsgEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 11:50
 * @Version 1.0
 **/

@RefreshScope //允许动态刷新配置
@RestController
public class MyMsgController {
    //注入ApplicationContext,通过ApplicationContext来publish remote event
    private ApplicationContext context;

    @Autowired
    public MyMsgController(ApplicationContext context) {
        this.context = context;
    }

    @Autowired
    private Environment env;

    @RequestMapping(value = "/publish", method = RequestMethod.GET)
    public String publish(@RequestParam(value = "destination", required = false, defaultValue = "**") String destination) {
        // each service instance must have a unique context ID

        final String myUniqueId = context.getId();

        final MyMsgEvent event =
                new MyMsgEvent(this, myUniqueId, destination, "hello world");
        //Since we extended RemoteApplicationEvent and we've configured the scanning of remote events using @RemoteApplicationEventScan, it will be treated as a bus event rather than just a regular ApplicationEvent published in the context.
        //因为我们在启动类上设置了@RemoteApplicationEventScan注解，所以通过context发送的时间将变成一个bus event总线事件，而不是在自身context中发布的一个ApplicationEvent
        context.publishEvent(event);

        return "event published";
    }

}
