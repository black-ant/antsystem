package com.dataserver.demo.controller;

import com.dataserver.demo.entity.OrderDTO;
import com.dataserver.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("orderList")
    public List<OrderDTO> getOrderList(){
        return orderService.getOrderList();
    }
}
