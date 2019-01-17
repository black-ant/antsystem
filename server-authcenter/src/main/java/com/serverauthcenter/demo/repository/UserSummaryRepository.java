package com.serverauthcenter.demo.repository;

import com.serverauthcenter.demo.entity.UserSummaryEntity;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/17 22:25
 * @Version 1.0
 **/
public interface UserSummaryRepository extends JpaRepository<UserSummaryEntity,Long> {

    public UserSummaryEntity findByUserid(String userid);
}
