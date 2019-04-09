package com.msclient.logistics.clientlogistics.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 12:09
 * @Version 1.0
 **/
@Component
//public class MyMsgEventListener implements ApplicationListener<MyMsgEvent> {
public class MyMsgEventListener {
private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //处理自定义事件
//    @Override
    public void onApplicationEvent(MyMsgEvent myCustomRemoteEvent) {
        logger.info("Received MyCustomRemoteEvent - message: " + myCustomRemoteEvent.getMsg());
    }
}
