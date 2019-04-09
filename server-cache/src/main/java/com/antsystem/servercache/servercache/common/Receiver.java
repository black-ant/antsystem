package com.antsystem.servercache.servercache.common;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 14:53
 * @Version 1.0
 **/
@Component
public class Receiver {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //使用@RabbitListener监听指定队列、指定exchange、指定routingKey的消息
    //同时@RabbitListener有建立队列、exchange、routingKey的功能
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "editCatalog", durable = "true"),
                    exchange = @Exchange(value = "catalogExchange", type = "topic", durable = "true"),
                    key = "editCatalogKey")
    )
    public void receiveMessage(String message) throws Exception {
        logger.info("msg is :{}", message);
    }
}

