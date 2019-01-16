package com.dataserver.demo.repository;

import com.dataserver.demo.entity.UserSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/16 22:55
 * @Version 1.0
 **/
public interface UserSummaryRepository extends JpaRepository<UserSummaryEntity,Long> {

    public UserSummaryEntity findByUserid(String userid);
}
