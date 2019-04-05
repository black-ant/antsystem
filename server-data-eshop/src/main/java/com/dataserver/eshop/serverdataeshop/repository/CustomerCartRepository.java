package com.dataserver.eshop.serverdataeshop.repository;

import com.dataserver.eshop.serverdataeshop.entity.CustomerCart;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/4 15:04
 * @Version 1.0
 **/
@Repository
public interface CustomerCartRepository extends JpaRepository<CustomerCart, Integer> {

    CustomerCart findByGoodsidAndSkuidAndShopId(Integer goodsid, Integer skuid, Integer shopid);

    @Query("Select c from CustomerCart c where (c.buyerId = :buyerid or :buyerid is null) and  (c.nobodyKey = :keyid or :keyid is null) ")
    List<CustomerCart> findByUserid(@Param("buyerid") Integer buyerid, @Param("keyid") String keyid);
}
