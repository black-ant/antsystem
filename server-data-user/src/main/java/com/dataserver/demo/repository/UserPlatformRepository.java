package com.dataserver.demo.repository;

import com.dataserver.demo.entity.UserPlatformEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserPlatformRepository extends JpaRepository<UserPlatformEntity,Long> {

    List<UserPlatformEntity> findByStatusNot(String status);

    UserPlatformEntity findByUserid(Long userid);

    @Query("select u from UserPlatformEntity u where u.username=:username and u.useraccount =:useraccount")
    UserPlatformEntity findByFilter(@Param("username") String username,@Param("useraccount") String useraccount);

}
