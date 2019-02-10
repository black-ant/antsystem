package com.dataserver.eshop.serverdataeshop.service;

import com.dataserver.eshop.serverdataeshop.entity.ShopGoods;
import com.dataserver.eshop.serverdataeshop.exception.SaveException;
import com.dataserver.eshop.serverdataeshop.repository.ShopGoodsRepository;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Iterator;
import java.util.List;

/**
 * @author 10169
 * @Description 对商品进行编辑
 * @Date 2019/1/29 23:10
 * @Version 1.0
 **/
@Service
public class GoodsService {

    @Autowired
    ShopGoodsRepository shopGoodsRepository;


    /**
     * 批量保存List列表
     * @param goodsList
     * @return
     */
    @Transactional
    @ExceptionHandler(SaveException.class)
    public boolean saveGoods(List<ShopGoods> goodsList){
        Iterator<ShopGoods> iterator = goodsList.iterator();

        while(iterator.hasNext()){
            ShopGoods shopGood = iterator.next();
            shopGood=editGoods(shopGood,null,null,null);
            shopGoodsRepository.save(shopGood);
        }
        return true;
    }

    /**
     * 保存单个货品
     * @param saveGood
     * @return
     */
    @Transactional
    @ExceptionHandler(SaveException.class)
    public boolean saveGoods(ShopGoods saveGood){
        saveGood=editGoods(saveGood,null,null,null);
        shopGoodsRepository.save(saveGood);
        return true;
    }


    /**
     * 保存前编辑货品资料
     * @param saveGoods
     * @return
     */
    public ShopGoods editGoods(ShopGoods saveGoods,String param1,String param2,String param3){
        saveGoods.setId(1);
        return saveGoods;
    }

}
