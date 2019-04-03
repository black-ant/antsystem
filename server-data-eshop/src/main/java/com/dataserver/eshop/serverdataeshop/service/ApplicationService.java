package com.dataserver.eshop.serverdataeshop.service;

import com.dataserver.eshop.serverdataeshop.entity.ItemSkuPropertyKey;
import com.dataserver.eshop.serverdataeshop.entity.ItemSkuPropertyValue;
import com.dataserver.eshop.serverdataeshop.entity.VO.CustomerAddressVO;
import com.dataserver.eshop.serverdataeshop.repository.ItemSkuPropertyKeyRepository;
import com.dataserver.eshop.serverdataeshop.repository.ItemSkuPropertyValueRepository;
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
    @Autowired
    ItemSkuPropertyKeyRepository itemkeyrepo;
    @Autowired
    ItemSkuPropertyValueRepository itemvaluerepo;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("=========== 项目启动后，初始化 Redis =============");
        List<ItemSkuPropertyKey> listKey = itemkeyrepo.findAll();
        itemkeyMap = (ConcurrentHashMap)listKey.stream().collect(Collectors.toMap(ItemSkuPropertyKey::getId, key -> key,throwingMerger(),ConcurrentHashMap::new));
        for (Map.Entry<Integer, ItemSkuPropertyKey> entry : itemkeyMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        List<ItemSkuPropertyValue> listValue = itemvaluerepo.findAll();
        itemvalueMap = (ConcurrentHashMap)listValue.stream().collect(Collectors.toMap(ItemSkuPropertyValue::getId, value -> value,throwingMerger(),ConcurrentHashMap::new));
        for (Map.Entry<Integer, ItemSkuPropertyValue> entry : itemvalueMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
    private static <T> BinaryOperator<T> throwingMerger() {
        return (u,v) -> { throw new IllegalStateException(String.format("Duplicate key %s", u)); };
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
}
