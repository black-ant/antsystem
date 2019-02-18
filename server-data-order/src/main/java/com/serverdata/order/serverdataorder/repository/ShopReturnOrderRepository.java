package com.serverdata.order.serverdataorder.repository;

import com.serverdata.order.serverdataorder.Entity.ShopOrder;
import com.serverdata.order.serverdataorder.Entity.ShopReturnOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/18 23:02
 * @Version 1.0
 **/
@Repository
public interface ShopReturnOrderRepository extends JpaRepository<ShopReturnOrder,Long> {

}
