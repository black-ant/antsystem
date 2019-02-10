package com.dataserver.eshop.serverdataeshop.repository;

import com.dataserver.eshop.serverdataeshop.entity.ShopGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/10 20:07
 * @Version 1.0
 **/
@Repository
public interface ShopGoodsRepository  extends JpaRepository<ShopGoods,Long> {


}
