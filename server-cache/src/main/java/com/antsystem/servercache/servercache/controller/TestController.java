package com.antsystem.servercache.servercache.controller;

import com.alibaba.fastjson.JSONObject;
import com.antsystem.servercache.servercache.service.OrderCacheService;
import com.antsystem.servercache.servercache.service.UserCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/6 19:08
 * @Version 1.0
 **/
@RestController
public class TestController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserCacheService userCacheService;
    @Autowired
    OrderCacheService orderCacheService;


    @GetMapping("testCreate")
    public String test(@RequestParam("table") String table) {
        JSONObject json = new JSONObject();
        json.put("id", "0001");
        json.put("name", "test");
        json.put("desc", "descis");
        json.put("date", new Date());
        logger.info("data iss:{}", json.toJSONString());
        userCacheService.createOneTest(table,json.toJSONString());
        return "ok";
    }



    @GetMapping("testEntity")
    public String testEditEntity() {
        return userCacheService.createOneTestEntity();
    }

    @GetMapping("getCache")
    public List<String> getCachebByTest(@RequestParam("key") String param) {
        return userCacheService.getCacheTest(param);
    }

    @GetMapping("getCacheList")
    public List<String> getCachebList(@RequestParam("table") String table) {
        return orderCacheService.getOrderList(table);
    }
    @GetMapping("getCacheByType")
    public List<String> getCacheByType(@RequestParam("type") String type) {
        return orderCacheService.findLogisticsOrderList(type);
    }

}
