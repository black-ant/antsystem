package com.msclient.eshop.clienteshop.controller;

import com.msclient.eshop.clienteshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/31 23:28
 * @Version 1.0
 **/
@RestController
public class ShopController {


    @Autowired
    ShopService shopService;

    @GetMapping("/consumer")
    public String dc() {
        return shopService.getShop();
    }


    @GetMapping("/shopedit")
    public String shopEdit(){
       return  shopService.shopedit();
    }
    @GetMapping("/shoppath")
    public String shopPath(){
       return  shopService.shoppath();
    }



}
