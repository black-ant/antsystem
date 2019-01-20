package com.dataserver.demo.controller;

import com.dataserver.demo.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/19 22:32
 * @Version 1.0
 **/
@RestController
public class UserController {


    @Autowired
    UserManageService userManageService;

    @RequestMapping("create")
    public String createUser(){
        userManageService.createUser("gang");
        return "isok";
    }
}
