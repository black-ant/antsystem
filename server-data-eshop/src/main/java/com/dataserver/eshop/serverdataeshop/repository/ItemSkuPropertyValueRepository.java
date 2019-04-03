package com.dataserver.eshop.serverdataeshop.repository;

import com.dataserver.eshop.serverdataeshop.entity.ItemSkuPropertyKey;
import com.dataserver.eshop.serverdataeshop.entity.ItemSkuPropertyValue;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/3 20:05
 * @Version 1.0
 **/
public interface ItemSkuPropertyValueRepository extends JpaRepository<ItemSkuPropertyValue,Long> {
}
