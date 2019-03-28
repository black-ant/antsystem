package com.dataserver.eshop.serverdataeshop.repository;

import com.dataserver.eshop.serverdataeshop.entity.Shop;
import com.dataserver.eshop.serverdataeshop.entity.ShopGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/28 15:12
 * @Version 1.0
 **/
@Repository
public interface ShopRepository  extends JpaRepository<Shop,Long> {

    Shop findShopByShopid(String shopid);
}
