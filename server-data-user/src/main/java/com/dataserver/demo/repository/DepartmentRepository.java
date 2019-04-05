package com.dataserver.demo.repository;

import com.dataserver.demo.entity.CompanyDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/18 22:59
 * @Version 1.0
 **/
public interface DepartmentRepository extends JpaRepository<CompanyDepartment,Long> {

    CompanyDepartment findByDepname(String depname);
    CompanyDepartment findByDepid(Long depid);
}
