package com.platform.platformclient.controller;


import com.platform.platformclient.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DepartmentController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/userall")
    public String dc() {
        return restTemplate.getForObject("http://datauser/platform/getUserAll", String.class);
    }

    @GetMapping("depidfind")
    public String findDepid(@RequestParam("id") Long depid){
        return departmentService.findByDepid(Long.valueOf(100001));
    }
}
