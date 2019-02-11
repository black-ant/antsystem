package com.msclient.eshop.clienteshop.controller;

import com.msclient.eshop.clienteshop.entity.ShopVO;
import com.msclient.eshop.clienteshop.entity.UserVO;
import com.msclient.eshop.clienteshop.service.ShopUserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/11 19:41
 * @Version 1.0
 **/
@RestController
public class ShopUserController {

    @Autowired
    ShopUserService shopUserService;

    @GetMapping("addUser")
    public String addUser(){
        return shopUserService.addUser(new UserVO());
    }
}
