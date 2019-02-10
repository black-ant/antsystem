package com.dataserver.eshop.serverdataeshop.service;

import com.dataserver.eshop.serverdataeshop.entity.ShopGoods;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/10 21:34
 * @Version 1.0
 **/
@Service
public class FindGoodsService {



    public List<ShopGoods> findGoodsByFilter(String id,String param2){
        return new LinkedList<>();
    }
}
