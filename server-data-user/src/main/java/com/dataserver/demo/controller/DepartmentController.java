package com.dataserver.demo.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class DepartmentController {

    @PostMapping("/deplist")
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Object getDepartmentList(@RequestParam("departmentid") String did){
        LinkedList<Object> departmentList = new LinkedList<>();
        return "okok";
    }

}
