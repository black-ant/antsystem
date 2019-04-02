package com.dataserver.eshop.serverdataeshop.repository;

import com.dataserver.eshop.serverdataeshop.entity.CustomerAddress;
import com.dataserver.eshop.serverdataeshop.entity.ShopGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/2 22:30
 * @Version 1.0
 **/
@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Long> {

}
