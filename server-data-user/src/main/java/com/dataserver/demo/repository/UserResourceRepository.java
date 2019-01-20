package com.dataserver.demo.repository;

import com.dataserver.demo.entity.UserPlatformEntity;
import com.dataserver.demo.entity.UserSourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/16 22:50
 * @Version 1.0
 **/
@Repository
public interface UserResourceRepository extends JpaRepository<UserSourceEntity,Long> {
}
