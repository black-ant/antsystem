package com.platform.platformclient.controller;

import com.platform.platformclient.entity.ShopEntity;
import com.platform.platformclient.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/17 23:16
 * @Version 1.0
 **/
@RestController
public class ShopController {

    @Autowired
    ShopService shopService;

    @PostMapping("findshop")
    public List<ShopEntity> findShop(){
        return shopService.findShopList();
    }
}
