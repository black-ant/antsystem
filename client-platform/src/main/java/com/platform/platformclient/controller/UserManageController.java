package com.platform.platformclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserManageController {

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/userlist")
    public String dc() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("DATAUSER");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/platform/getUserAll";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }
}
