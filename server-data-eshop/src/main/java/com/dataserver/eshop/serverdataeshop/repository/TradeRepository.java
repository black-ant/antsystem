package com.dataserver.eshop.serverdataeshop.repository;

import com.dataserver.eshop.serverdataeshop.entity.TradeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/4 20:19
 * @Version 1.0
 **/
public interface TradeRepository extends JpaRepository<TradeOrder ,String> {

}
