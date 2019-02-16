package com.serverdata.order.serverdataorder.repository;

import com.serverdata.order.serverdataorder.Entity.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/28 23:09
 * @Version 1.0
 **/
@Repository
public interface ShopOrderRepository extends JpaRepository<ShopOrder,Long> {

    ShopOrderRepository findByOrderid(String orderid);
}
