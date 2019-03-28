package com.serverdata.order.serverdataorder.controller;

import com.serverdata.order.serverdataorder.Entity.ShopOrder;
import com.serverdata.order.serverdataorder.common.response.Wrapper;
import com.serverdata.order.serverdataorder.service.ShopOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/27 13:02
 * @Version 1.0
 **/
@RestController
@RequestMapping("shoporder")
public class ShopOrderController extends BaseController {

    @Autowired
    ShopOrderService shopOrderService;

    @PostMapping("getshoporder")
    public Wrapper findShopOrder(@RequestParam("type") String type){
        List<ShopOrder> shopOrders = new LinkedList<>();
        switch (type){
            case "all":
                shopOrders = shopOrderService.findAll();
                break;
             default:
                 break;
        }
        return apiResponse(shopOrders);
    }


}
