package com.platform.platformclient.repository;

import com.platform.platformclient.entity.UserSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/14 21:51
 * @Version 1.0
 **/
public interface UserSummaryRepository extends JpaRepository<UserSummaryEntity,Long> {

    public UserSummaryEntity findByUserid(String userid);

    public UserSummaryEntity findByUsername(String username);
}
