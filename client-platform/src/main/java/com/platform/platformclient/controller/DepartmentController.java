package com.platform.platformclient.controller;


import com.platform.platformclient.entity.vo.DepartmentVO;
import com.platform.platformclient.entity.vo.GroupVO;
import com.platform.platformclient.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

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
    public ModelAndView repage(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        List<DepartmentVO> deplist = departmentService.findAllDep();
        modelAndView.addObject("list", deplist);
        session.setAttribute("newDep",new DepartmentVO());
        modelAndView.setViewName("pages/department/depmanage");
        return modelAndView;
    }

    @GetMapping("dep/getgroup")
    public ModelAndView getDepGroup(@RequestParam("depid") Integer depid, HttpSession session) {
        logger.info("depid is :{}", depid);
        ModelAndView modelAndView = new ModelAndView();
        List<GroupVO> list = departmentService.findGroup(depid);
        modelAndView.addObject("grouplist", list);
        modelAndView.setViewName("pages/department/depmanage::group-list");
        return modelAndView;
    }

    @PostMapping("dep/getCart")
    public Map<String, Object> getGroupCart(@RequestParam("depid") Integer depid) {
        logger.info("depid is :{}", depid);
        Map<String, Object> map = new HashMap<>();
        return map;
    }

    @PostMapping("dep/getgroupajax")
    public Map<String, Object> getgroupajax(@RequestParam("depid") Integer depid) {
        logger.info("depid is :{}", depid);
        Map<String, Object> map = new HashMap<>();

        List<GroupVO> list = departmentService.findGroup(depid);
        map.put("list", list);
        return map;
    }

    @PostMapping("createdep")
    public String createDep(DepartmentVO departmentVO) {
        logger.info("depid is :{}", departmentVO);
        ModelAndView modelAndView = new ModelAndView();
        String wrapper = departmentService.createOne(departmentVO);
        logger.info("wrapper ： is {}",wrapper);
        List<DepartmentVO> deplist = departmentService.findAllDep();
        modelAndView.addObject("list", deplist);
//        List<DepartmentVO> list = departmentService.createOne(departmentVO);
//        modelAndView.addObject("grouplist", list);
//        modelAndView.setViewName("pages/department/depmanage");
        return "isok";
    }

    @GetMapping("test")
    public String getDepGroup() {
        logger.info("test is :{}", "ok");
        return "ok";
    }
}
