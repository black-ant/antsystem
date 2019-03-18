package com.dataserver.demo.repository;

import com.dataserver.demo.entity.Department;
import com.dataserver.demo.entity.UserPlatformEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/18 22:59
 * @Version 1.0
 **/
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findByDepname(String depname);
    Department findByDepid(Long depid);
}
