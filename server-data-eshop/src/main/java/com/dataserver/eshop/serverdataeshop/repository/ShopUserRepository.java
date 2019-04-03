package com.dataserver.eshop.serverdataeshop.repository;

import com.dataserver.eshop.serverdataeshop.entity.UserShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/11 16:11
 * @Version 1.0
 **/
@Repository
public interface ShopUserRepository  extends JpaRepository<UserShop,Long> {


}
