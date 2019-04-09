package com.dataserver.demo.repository;

import com.dataserver.demo.entity.UserWarehouseMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 15:40
 * @Version 1.0
 **/
@Repository
public interface UserWarehouseMapperReposiroty extends JpaRepository<UserWarehouseMapper,Integer> {


    List<UserWarehouseMapper> findByWarehouseid(Integer wareid);
}
