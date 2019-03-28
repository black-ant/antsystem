package com.dataserver.eshop.serverdataeshop.controller;

import com.dataserver.eshop.serverdataeshop.common.response.Wrapper;
import com.dataserver.eshop.serverdataeshop.common.response.WrapperResponse;
import com.dataserver.eshop.serverdataeshop.entity.Shop;
import com.dataserver.eshop.serverdataeshop.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/29 23:02
 * @Version 1.0
 **/
@RestController
public class ShopController extends BaseController{

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ShopService shopService;

    @PostMapping("shopone")
    public Wrapper getOneShop(@RequestParam("shopid") String shopid){
        return  apiResponse(shopService.getShop(shopid));
    }



    @PostMapping("shopedit")
    public Wrapper<Shop> shopEdit(@RequestBody  Shop shop, @RequestParam("shopid") String shopid, @RequestParam("status")String status){
        logger.info("shopedit-----shop:{}--shopid:{}---status:{}",shop,shopid,status);
        perfectShop(shop);
        return WrapperResponse.success(shop);
    }
    @PostMapping("shoppath/{status}")
    public Wrapper<Shop> shopPath(@RequestBody  Shop shop, @RequestParam("shopid") String shopid, @PathVariable("status")String status){
        logger.info("shopedit-----shop:{}--shopid:{}---status:{}",shop,shopid,status);
        return WrapperResponse.success(shop);
    }

    public Shop perfectShop(Shop shop){
        String shopid =redisUtil.get("shopid").toString();
        logger.info("shopid:{}",shopid);
        if(null==shopid){
            redisUtil.set("shopid","1");
        }else{
            Integer id = Integer.valueOf(shopid);
            logger.info("id is :{}",id);

            //要么++id
            redisUtil.set("shopid",++id);
        }
        return shop;
    }

}
