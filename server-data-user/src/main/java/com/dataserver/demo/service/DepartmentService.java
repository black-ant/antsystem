package com.dataserver.demo.service;

import com.dataserver.demo.entity.CompanyDepartment;
import com.dataserver.demo.entity.CompanyGroup;
import com.dataserver.demo.repository.CompanyGroupRepository;
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
    @Autowired
    CompanyGroupRepository cgRepo;

    public CompanyDepartment findDepartment(Long depid, String depname, String type){
        return "id".equals(type)?departmentRepository.findByDepid(depid):departmentRepository.findByDepname(depname);
    }
    public List<CompanyDepartment> findAll(){
        return departmentRepository.findAll();
    }

    public CompanyDepartment saveOne(CompanyDepartment department){
        return departmentRepository.save(department);
    }


    /**
     * 以下系列方法用于查询小猪
     * @return
     */
    public List<CompanyGroup> findAllGroup(){
        return  cgRepo.findAll();
    }
    public List<CompanyGroup> findCompanyGroup(Integer depid){
        return  cgRepo.findByDid(depid);
    }
    public CompanyGroup findOneGroup(Integer gid){
        CompanyGroup groud = cgRepo.findById(gid).get();
        return groud;
    }


}
