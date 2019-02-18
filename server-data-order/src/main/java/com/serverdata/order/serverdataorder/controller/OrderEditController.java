package com.serverdata.order.serverdataorder.controller;

import com.serverdata.order.serverdataorder.Entity.ShopOrder;
import com.serverdata.order.serverdataorder.Entity.ShopReturnOrder;
import com.serverdata.order.serverdataorder.service.OrderEditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/26 21:18
 * @Version 1.0
 **/
@RestController
public class OrderEditController {

    @Autowired
    OrderEditService orderEditService;

    @GetMapping("getOrderId")
    public String getOrderId(){
        return orderEditService.getLastOrderID();
    }

    @GetMapping("createorder")
    public ShopOrder createOrder(){
        return orderEditService.createShopOrder();
    }

    @GetMapping("createreturnorder")
    public ShopReturnOrder createReturnOrder(){
        return orderEditService.createReturnOrder();
    }
}
