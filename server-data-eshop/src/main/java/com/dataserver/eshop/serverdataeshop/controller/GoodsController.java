package com.dataserver.eshop.serverdataeshop.controller;

import com.dataserver.eshop.serverdataeshop.common.response.Wrapper;
import com.dataserver.eshop.serverdataeshop.common.response.WrapperResponse;
import com.dataserver.eshop.serverdataeshop.entity.ShopGoods;
import com.dataserver.eshop.serverdataeshop.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/10 19:51
 * @Version 1.0
 **/
@RestController
public class GoodsController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    GoodsService goodsService;

    public List<ShopGoods> getShopGoods(String shopid){
        return new LinkedList<>();
    }

    @PostMapping("savegood")
    public Wrapper saveGood(@RequestBody ShopGoods shopGood){
        Boolean isok = goodsService.saveGoods(shopGood);
        logger.info("code:{}--desc:{}",shopGood.getGoodscode(),shopGood.getGoodsdesc());
        return WrapperResponse.wrap(200, "操作成功", isok);
    }

    @PostMapping("savegoodlist")
    public Wrapper saveGoods(List<ShopGoods> shopGood){
        Boolean isok = goodsService.saveGoods(shopGood);
        return WrapperResponse.wrap(200, "操作成功", isok);
    }



}
