package com.dataserver.eshop.serverdataeshop.service;

import com.dataserver.eshop.serverdataeshop.entity.ItemSkuPropertyKey;
import com.dataserver.eshop.serverdataeshop.entity.ItemSkuPropertyValue;
import com.dataserver.eshop.serverdataeshop.entity.Shop;
import com.dataserver.eshop.serverdataeshop.entity.ShopGoods;
import com.dataserver.eshop.serverdataeshop.entity.VO.CustomerAddressVO;
import com.dataserver.eshop.serverdataeshop.repository.ItemSkuPropertyKeyRepository;
import com.dataserver.eshop.serverdataeshop.repository.ItemSkuPropertyValueRepository;
import com.dataserver.eshop.serverdataeshop.repository.ShopGoodsRepository;
import com.dataserver.eshop.serverdataeshop.repository.ShopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/3 20:17
 * @Version 1.0
 **/
@Component
@Order(value = 1)
public class ApplicationService implements ApplicationRunner {

    private static Logger logger = LoggerFactory.getLogger(ApplicationService.class);

    private static ConcurrentHashMap<Integer, ItemSkuPropertyKey> itemkeyMap = new ConcurrentHashMap<Integer, ItemSkuPropertyKey>();
    private static ConcurrentHashMap<Integer, ItemSkuPropertyValue> itemvalueMap = new ConcurrentHashMap<Integer, ItemSkuPropertyValue>();
    private static ConcurrentHashMap<Integer, Shop> shopMap = new ConcurrentHashMap<Integer, Shop>();
    private static ConcurrentHashMap<Integer, ShopGoods> goodsMap = new ConcurrentHashMap<Integer, ShopGoods>();
    @Autowired
    ItemSkuPropertyKeyRepository itemkeyRepo;
    @Autowired
    ItemSkuPropertyValueRepository itemValueRepo;
    @Autowired
    ShopRepository shopRepo;
    @Autowired
    ShopGoodsRepository shopGoodsRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        getCache();
    }

    public void getCache() {
        refushFromDB();
    }

    /**
     * 将Cache 设置到缓存
     */
    public void getFromRedis() {

    }

    public void setInRedis() {

    }

    public void refushFromDB() {
        findSKUProperty();
        findShop("ALL", 0);
        findGoods("ALL", 0);
    }

    public static ConcurrentHashMap<Integer, ShopGoods> getGoodsMap() {
        return goodsMap;
    }

    public static void setGoodsMap(ConcurrentHashMap<Integer, ShopGoods> goodsMap) {
        ApplicationService.goodsMap = goodsMap;
    }

    public void findSKUProperty() {
        logger.info("=========== 项目启动后，初始化 Redis =============");
        List<ItemSkuPropertyKey> listKey = itemkeyRepo.findAll();
        itemkeyMap = (ConcurrentHashMap) listKey.stream().collect(Collectors.toMap(ItemSkuPropertyKey::getId, key -> key, throwingMerger(), ConcurrentHashMap::new));
        for (Map.Entry<Integer, ItemSkuPropertyKey> entry : itemkeyMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        List<ItemSkuPropertyValue> listValue = itemValueRepo.findAll();
        itemvalueMap = (ConcurrentHashMap) listValue.stream().collect(Collectors.toMap(ItemSkuPropertyValue::getId, value -> value, throwingMerger(), ConcurrentHashMap::new));
        for (Map.Entry<Integer, ItemSkuPropertyValue> entry : itemvalueMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    public void findShop(String type, Integer shopid) {
        if ("ALL".equals(type)) {
            List<Shop> shops = shopRepo.findAll();
            shopMap = (ConcurrentHashMap) shops.stream()
                    .collect(Collectors.toMap(Shop::getShopid, key -> key, throwingMerger(), ConcurrentHashMap::new));
        } else {

        }
        logger.info("shop key:{}--size:{}",shopMap.keySet(),shopMap.size());
        logger.info("shop 10001 :{}--containkey:{}", shopMap.get(Integer.valueOf("10001")), shopMap.containsKey("10001"));
        logger.info("shop 10001 :{}--containkey:{}", shopMap.containsKey(10002), shopMap.containsKey(10001));
        logger.info("shop 10001 :{}--containkey:{}", shopMap.get(Long.valueOf(10001L)), shopMap.containsKey(10001l));
        for (Map.Entry<Integer, Shop> entry : shopMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    public void findGoods(String type, Integer goodsid) {
        if ("ALL".equals(type)) {
            List<ShopGoods> shopGoods = shopGoodsRepo.findAll();
            goodsMap = (ConcurrentHashMap) shopGoods.stream()
                    .collect(Collectors.toMap(ShopGoods::getId, key -> key, throwingMerger(), ConcurrentHashMap::new));
        } else {

        }
        for (Map.Entry<Integer, ShopGoods> entry : goodsMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    private static <T> BinaryOperator<T> throwingMerger() {
        return (u, v) -> {
            throw new IllegalStateException(String.format("Duplicate key %s", u));
        };
    }


    public static ConcurrentHashMap<Integer, ItemSkuPropertyKey> getItemkeyMap() {
        return itemkeyMap;
    }

    public static void setItemkeyMap(ConcurrentHashMap<Integer, ItemSkuPropertyKey> itemkeyMap) {
        ApplicationService.itemkeyMap = itemkeyMap;
    }

    public static ConcurrentHashMap<Integer, ItemSkuPropertyValue> getItemvalueMap() {
        return itemvalueMap;
    }

    public static void setItemvalueMap(ConcurrentHashMap<Integer, ItemSkuPropertyValue> itemvalueMap) {
        ApplicationService.itemvalueMap = itemvalueMap;
    }

    public static ConcurrentHashMap<Integer, Shop> getShopMap() {
        return shopMap;
    }

    public static void setShopMap(ConcurrentHashMap<Integer, Shop> shopMap) {
        ApplicationService.shopMap = shopMap;
    }
}
