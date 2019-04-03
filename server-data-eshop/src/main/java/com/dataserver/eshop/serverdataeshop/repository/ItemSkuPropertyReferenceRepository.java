package com.dataserver.eshop.serverdataeshop.repository;

import com.dataserver.eshop.serverdataeshop.entity.ItemSkuPropertyKey;
import com.dataserver.eshop.serverdataeshop.entity.ItemSkuPropertyReference;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/3 20:59
 * @Version 1.0
 **/
public interface ItemSkuPropertyReferenceRepository extends JpaRepository<ItemSkuPropertyReference,Long> {

    List<ItemSkuPropertyReference> findBySkuid(Integer skuid);

    List<ItemSkuPropertyReference> findByGoodsid(Integer goodsid);
}
