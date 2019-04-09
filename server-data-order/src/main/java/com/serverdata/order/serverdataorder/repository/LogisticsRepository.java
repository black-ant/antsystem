package com.serverdata.order.serverdataorder.repository;

import com.serverdata.order.serverdataorder.Entity.LogisticsOrder;
import com.serverdata.order.serverdataorder.Entity.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/13 20:49
 * @Version 1.0
 **/
@Repository
public interface LogisticsRepository extends JpaRepository<LogisticsOrder, String> {

}
