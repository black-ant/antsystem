package com.serverdata.order.serverdataorder.controller;

import com.serverdata.order.serverdataorder.Entity.LogisticsOrder;
import com.serverdata.order.serverdataorder.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/13 20:44
 * @Version 1.0
 **/
@RestController
@RequestMapping("logistics")
public class LogisticsController {

    @Autowired
    LogisticsService logisticsService;

    @PostMapping("create")
    public String createOrder(LogisticsOrder logisticsOrder){
        LogisticsOrder savelogis = logisticsService.createOrder(logisticsOrder);
        return "";
    }
}
