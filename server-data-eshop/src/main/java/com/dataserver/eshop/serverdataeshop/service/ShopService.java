package com.dataserver.eshop.serverdataeshop.service;

import com.dataserver.eshop.serverdataeshop.entity.Shop;
import com.dataserver.eshop.serverdataeshop.entity.ShopGoods;
import com.dataserver.eshop.serverdataeshop.repository.ShopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/29 22:57
 * @Version 1.0
 **/
@Service
public class ShopService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ShopRepository shopRepository;

    public boolean createShop() {
        return true;
    }

    /**
     * 通过大类型查询货品
     *
     * @param type
     * @return
     */
    public List<ShopGoods> findGoods(String type) {
        if ("OK".equals(type)) {

        } else if (true) {

        }
        return new LinkedList<>();
    }

    public Shop getShop(String shopid) {
        Shop shop = shopRepository.findShopByShopid(shopid);
        logger.info("查找shop :{}---return shop:{}--{}", shopid, shop.getShopname(), shop.getShopid());
        return shopRepository.findShopByShopid(shopid);
    }
}
