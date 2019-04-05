package com.dataserver.demo.repository;

import com.dataserver.demo.entity.CompanyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/5 11:49
 * @Version 1.0
 **/
@Repository
public interface CompanyGroupRepository extends JpaRepository<CompanyGroup,Integer> {

    List<CompanyGroup> findByDid(Integer depid);

//    CompanyGroup findById(Integer id);
}
