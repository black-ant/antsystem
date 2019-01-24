package com.serverauthcenter.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/19 22:31
 * @Version 1.0
 **/
@RestController
public class UserController {

    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }
}
