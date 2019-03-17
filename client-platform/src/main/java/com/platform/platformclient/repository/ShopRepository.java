package com.platform.platformclient.repository;

import com.platform.platformclient.entity.ShopEntity;
import com.platform.platformclient.entity.UserSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/17 23:15
 * @Version 1.0
 **/
public interface ShopRepository extends JpaRepository<ShopEntity,Long> {
}
