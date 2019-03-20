package com.platform.platformclient.controller;


import com.platform.platformclient.entity.vo.DepartmentVO;
import com.platform.platformclient.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    @GetMapping("depidfind/{id}")
    public String findDepid(@PathVariable("id") Long depid) {
        return departmentService.findByDepid(Long.valueOf(100001));
    }

    @GetMapping("dep/departement")
    public ModelAndView repage() {
        ModelAndView modelAndView = new ModelAndView();
        List<DepartmentVO> deplist = departmentService.findAllDep();
        modelAndView.addObject("list",deplist);
        modelAndView.setViewName("pages/department/depmanage");
        return modelAndView;
    }
}
