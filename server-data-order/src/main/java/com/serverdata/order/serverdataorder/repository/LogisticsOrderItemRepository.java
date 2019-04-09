package com.serverdata.order.serverdataorder.repository;

import com.serverdata.order.serverdataorder.Entity.LogisticsOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 17:25
 * @Version 1.0
 **/
@Repository
public interface LogisticsOrderItemRepository extends JpaRepository<LogisticsOrderItem,Integer> {

}
