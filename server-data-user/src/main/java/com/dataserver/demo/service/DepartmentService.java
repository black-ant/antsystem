package com.dataserver.demo.service;

import com.dataserver.demo.entity.Department;
import com.dataserver.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/18 22:57
 * @Version 1.0
 **/
@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;


    public Department findDepartment(Long depid,String depname,String type){
        return "id".equals(type)?departmentRepository.findByDepid(depid):departmentRepository.findByDepname(depname);
    }

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }
    public Department saveOne(Department department){
        return departmentRepository.save(department);
    }
}
