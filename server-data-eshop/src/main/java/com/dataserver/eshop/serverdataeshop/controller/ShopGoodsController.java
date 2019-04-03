package com.dataserver.eshop.serverdataeshop.controller;

import com.dataserver.eshop.serverdataeshop.common.response.Wrapper;
import com.dataserver.eshop.serverdataeshop.service.GoodsService;
import com.dataserver.eshop.serverdataeshop.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/28 17:17
 * @Version 1.0
 **/
@RestController
public class ShopGoodsController extends BaseController{

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    GoodsService goodsService;


    @PostMapping("findGoods")
    public Wrapper findGoodsByShopid(@RequestParam("shopid") String shopid){
        return  apiResponse(goodsService.findShopGoods(shopid));
    }

    @PostMapping("findGoodsOne")
    public Wrapper findOneGoods(@RequestParam("gid") String gid){
        logger.info("gid is :{}",gid);
//        goodsService.
        return  apiResponse("ok");
    }
    
    @PostMapping("findOneGoodsByid")
    public Wrapper findOneGoodsByID(@RequestParam("gid") Integer gid){
        return  apiResponse(goodsService.findShopGoodsOne(gid));
    }
}
