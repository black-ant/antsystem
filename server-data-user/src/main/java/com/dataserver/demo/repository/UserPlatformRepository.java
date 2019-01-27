package com.dataserver.demo.repository;

import com.dataserver.demo.entity.UserPlatformEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserPlatformRepository extends JpaRepository<UserPlatformEntity,Long> {

    List<UserPlatformEntity> findByStatusNot(String status);

}
