package com.serverdata.order.serverdataorder.repository;

import com.serverdata.order.serverdataorder.Entity.Inventory;
import com.serverdata.order.serverdataorder.Entity.LogisticsOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/25 23:26
 * @Version 1.0
 **/
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
