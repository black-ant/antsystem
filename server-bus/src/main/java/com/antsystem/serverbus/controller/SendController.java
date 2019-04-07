package com.antsystem.serverbus.controller;

import com.antsystem.serverbus.config.RabbitConfig;
import com.antsystem.serverbus.entity.Book;
import com.antsystem.serverbus.service.MsgProducer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/6 21:48
 * @Version 1.0
 **/
@RestController
public class SendController {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public SendController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @Autowired
    MsgProducer msgProducer;


    @GetMapping("sendbook")
    public void defaultMessage() {
        Book book = new Book();
        book.setId("1");
        book.setName("一起来学Spring Boot");
        this.rabbitTemplate.convertAndSend(RabbitConfig.DEFAULT_BOOK_QUEUE, book);
        this.rabbitTemplate.convertAndSend(RabbitConfig.MANUAL_BOOK_QUEUE, book);
    }


    @GetMapping("sendQueen")
    public void sendQueen() {
        msgProducer.sendMsg("测试queen");
    }
}
