package com.platform.platformclient.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DepartmentController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/userall")
    public String dc() {
        return restTemplate.getForObject("http://datauser/platform/getUserAll", String.class);
    }
}
