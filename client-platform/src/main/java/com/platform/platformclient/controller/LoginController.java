package com.platform.platformclient.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/13 21:55
 * @Version 1.0
 **/
@RestController
public class LoginController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("login/token")
    public String loginToken(@RequestParam("token") String token){
        logger.info("token is :{}",token);
        return "redirect:/tologin";
    }

    @PostMapping("login/uplogin")
    public String userLogin(@RequestParam("username") String username,@RequestParam("password") String password){
        logger.info("username is :{}--password is :{}",username,password);
        return "ok";
    }
}
