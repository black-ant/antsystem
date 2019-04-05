package com.dataserver.demo.repository;

import com.dataserver.demo.entity.UserWages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/5 11:50
 * @Version 1.0
 **/
@Repository
public interface UserWagesRepository extends JpaRepository<UserWages,Integer> {

    UserWages findByUserid(Integer userid);
}
