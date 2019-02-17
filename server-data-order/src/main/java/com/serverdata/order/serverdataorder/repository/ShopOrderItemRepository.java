package com.serverdata.order.serverdataorder.repository;

import com.serverdata.order.serverdataorder.Entity.ShopOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/17 22:54
 * @Version 1.0
 **/
@Repository
public interface ShopOrderItemRepository extends JpaRepository<ShopOrderItem, Long> {
}
