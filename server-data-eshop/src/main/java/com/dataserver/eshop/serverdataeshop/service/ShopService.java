package com.dataserver.eshop.serverdataeshop.service;

import com.dataserver.eshop.serverdataeshop.entity.Shop;
import com.dataserver.eshop.serverdataeshop.entity.ShopGoods;
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

    public boolean createShop(){
        return true;
    }

    /**
     * 通过大类型查询货品
     * @param type
     * @return
     */
    public List<ShopGoods> findGoods(String type){
        if("OK".equals(type)){

        }else if(true){

        }
        return new LinkedList<>();
    }

    public Shop getShop(String shopid){
        return new Shop();
    }
}
