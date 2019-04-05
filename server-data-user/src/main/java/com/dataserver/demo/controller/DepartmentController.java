package com.dataserver.demo.controller;


import com.dataserver.demo.common.response.Wrapper;
import com.dataserver.demo.entity.CompanyDepartment;
import com.dataserver.demo.entity.CompanyGroup;
import com.dataserver.demo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
        @RequestMapping("dep")
public class DepartmentController extends BaseController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    DepartmentService departmentService;

    @PostMapping("deplist")
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public Object getDepartmentList(@RequestParam("departmentid") String did) {
        LinkedList<Object> departmentList = new LinkedList<>();
        return "okok";
    }

    @PostMapping("addDep")
    public Wrapper addOneDepartment(CompanyDepartment department) {
        logger.info("department id :{}---department desc:{}", department.getDepid(), department.getDepdes());
        CompanyDepartment department1 = departmentService.saveOne(department);
        return apiResponse(department1, "添加部门成功");
    }

    @PostMapping("depidfind")
    public Wrapper findByDepid(Long depid) {
        logger.info("查询部门，id:{}", depid);
        CompanyDepartment department1 = departmentService.findDepartment(depid, null, "id");
        return apiResponse(department1);
    }

    @PostMapping("alldep")
    public Wrapper findAllDep() {
        logger.info("查询所有的部门");
        List<CompanyDepartment> departments = departmentService.findAll();
        return apiResponse(departments);
    }

    @PostMapping("findgroup")
    public Wrapper findDepGroupd(@RequestParam("depid") Integer depid) {
        logger.info("查询指定部门底下的小组");
        List<CompanyGroup> groups = departmentService.findCompanyGroup(depid);
        return apiResponse(groups);
    }

}
