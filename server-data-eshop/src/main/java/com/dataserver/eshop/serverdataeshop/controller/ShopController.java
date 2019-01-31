package com.dataserver.eshop.serverdataeshop.controller;

import com.dataserver.eshop.serverdataeshop.entity.Shop;
import com.dataserver.eshop.serverdataeshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/29 23:02
 * @Version 1.0
 **/
@RestController
public class ShopController {

    @Autowired
    ShopService shopService;

    @PostMapping("shopone")
    public Shop getOneShop(String shopid){
        return shopService.getShop("001");
    }
}
