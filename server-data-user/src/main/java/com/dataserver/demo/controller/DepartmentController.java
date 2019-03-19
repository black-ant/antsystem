package com.dataserver.demo.controller;


import com.dataserver.demo.common.response.Wrapper;
import com.dataserver.demo.entity.Department;
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
    public Wrapper addOneDepartment(Department department) {
        logger.info("department id :{}---department desc:{}", department.getDepid(), department.getDepdes());
        Department department1 = departmentService.saveOne(department);
        return apiResponse(department1, "添加部门成功");
    }

    @PostMapping("depidfind")
    public Wrapper findByDepid(Long depid) {
        logger.info("查询部门，id:{}", depid);
        Department department1 = departmentService.findDepartment(depid, null, "id");
        return apiResponse(department1);
    }

    @PostMapping("alldep")
    public Wrapper findAllDep() {
        logger.info("查询所有的部门");
        List<Department> departments = departmentService.findAll();
        return apiResponse(departments);
    }

}
