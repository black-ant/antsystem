package com.serverdata.order.serverdataorder.repository;

import com.serverdata.order.serverdataorder.Entity.ShopReturnOrder;
import com.serverdata.order.serverdataorder.Entity.Storehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/22 23:23
 * @Version 1.0
 **/
@Repository
public interface StorehouseRepository extends JpaRepository<Storehouse,Integer> {
}
