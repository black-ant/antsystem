package com.antsystem.servercache.servercache.controller;

import com.alibaba.fastjson.JSONObject;
import com.antsystem.servercache.servercache.entity.TestEntity;
import com.antsystem.servercache.servercache.repository.TestRepository;
import com.antsystem.servercache.servercache.service.OrderCacheService;
import com.antsystem.servercache.servercache.service.UserCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/6 13:26
 * @Version 1.0
 **/
@RestController
public class OrderController {

    @Autowired
    OrderCacheService orderCacheService;

    @GetMapping("saveLsOrder")
    public String SaveLogisticsOrder(@RequestParam("type") String type, @RequestParam("data") String orderData) {
        orderCacheService.SaveLogisticsOrder(type, orderData);
        return "ok";
    }

    @GetMapping("getOrderList")
    public List<String> getOrderList(@RequestParam("type") String type) {
        return orderCacheService.findLogisticsOrderList(type);
    }
}
