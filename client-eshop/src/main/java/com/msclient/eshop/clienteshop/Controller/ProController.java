package com.msclient.eshop.clienteshop.controller;

import com.msclient.eshop.clienteshop.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/9 23:09
 * @Version 1.0
 **/
@RestController
public class ProController {

    @Autowired
    GoodService goodService;

    @GetMapping("/savegood")
    public String dc() {
        return goodService.saveGoods();
    }

    @PostMapping("/findcart")
    public String findCart(){
        return "";
    }
}
