package com.dataserver.demo.controller;


import com.dataserver.demo.entity.UserPlatform;
import com.dataserver.demo.service.UserPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("platform")
public class PlatformUserController {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    UserPlatformService userService;

    @GetMapping("test")
    public String dc() {
        String services = "Services platform user: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @GetMapping("getUserAll")
    public  List<UserPlatform>  getAllUser() {
        List<UserPlatform> userList = userService.getAllUser();
        return userList;
    }
}
