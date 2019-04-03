package com.dataserver.eshop.serverdataeshop.service;

import com.dataserver.eshop.serverdataeshop.entity.ItemSkuPropertyReference;
import com.dataserver.eshop.serverdataeshop.entity.ShopGoods;
import com.dataserver.eshop.serverdataeshop.exception.SaveException;
import com.dataserver.eshop.serverdataeshop.repository.ItemSkuPropertyReferenceRepository;
import com.dataserver.eshop.serverdataeshop.repository.ShopGoodsRepository;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 10169
 * @Description 对商品进行编辑
 * @Date 2019/1/29 23:10
 * @Version 1.0
 **/
@Service
public class GoodsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ItemSkuPropertyReferenceRepository skuRefreop;
    @Autowired
    ShopGoodsRepository shopGoodsRepository;
    @Autowired
    ApplicationService application;

    /**
     * 批量保存List列表
     *
     * @param goodsList
     * @return
     */
    @Transactional
    @ExceptionHandler(SaveException.class)
    public boolean saveGoods(List<ShopGoods> goodsList) {
        Iterator<ShopGoods> iterator = goodsList.iterator();

        while (iterator.hasNext()) {
            ShopGoods shopGood = iterator.next();
            shopGood = editGoods(shopGood, null, null, null);
            shopGoodsRepository.save(shopGood);
        }
        return true;
    }

    /**
     * 保存单个货品
     *
     * @param saveGood
     * @return
     */
    @Transactional
    @ExceptionHandler(SaveException.class)
    public boolean saveGoods(ShopGoods saveGood) {
        saveGood = editGoods(saveGood, null, null, null);
        shopGoodsRepository.save(saveGood);
        return true;
    }


    /**
     * 保存前编辑货品资料
     *
     * @param saveGoods
     * @return
     */
    public ShopGoods editGoods(ShopGoods saveGoods, String param1, String param2, String param3) {
        saveGoods.setId(1);
        return saveGoods;
    }

    /**
     * 查找店铺所有的货品
     *
     * @return
     */
    public List<ShopGoods> findShopGoods(String shopid) {
        List<ShopGoods> shopGoods = shopGoodsRepository.findByShopid(shopid);
        return shopGoods;
    }

    /**
     * 根据Code 查询单个货品
     *
     * @return
     */
    public Map<Integer,Map<String, Object>> findShopGoodsOne(Integer goodsid) {
        List<ItemSkuPropertyReference> reflist = skuRefreop.findByGoodsid(goodsid);
        Map<Integer,Map<String, Object>> map = new LinkedHashMap<>();
        Map<String, Object> itemMap;
        for(ItemSkuPropertyReference item : reflist){
            if(map.containsKey(item.getSkuid())){
                itemMap =  map.get(item.getSkuid());
                itemMap.put(application.getItemkeyMap().get(item.getSkukeyid()).getName(), application.getItemvalueMap().get(item.getSkuvalueid()).getValue());
                itemMap.put("skuid",item.getSkuid());
            }else{
                itemMap= new HashMap<String, Object>();
                itemMap.put(application.getItemkeyMap().get(item.getSkukeyid()).getName(), application.getItemvalueMap().get(item.getSkuvalueid()).getValue());
                map.put(item.getSkuid(),itemMap);
            }
            logger.info("skukey:{}--skuvalue:{}",item.getSkukeyid(),item.getSkuvalueid());

        }
        return map;
    }

}
