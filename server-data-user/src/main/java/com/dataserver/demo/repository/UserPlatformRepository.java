package com.dataserver.demo.repository;

import com.dataserver.demo.entity.UserPlatform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPlatformRepository extends JpaRepository<UserPlatform,Long> {


}
