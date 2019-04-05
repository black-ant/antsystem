package com.dataserver.eshop.serverdataeshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataserver.eshop.serverdataeshop.common.response.Wrapper;
import com.dataserver.eshop.serverdataeshop.common.response.WrapperResponse;
import com.dataserver.eshop.serverdataeshop.entity.ShopGoods;
import com.dataserver.eshop.serverdataeshop.entity.VO.CustomerCartVO;
import com.dataserver.eshop.serverdataeshop.service.GoodsService;
import com.dataserver.eshop.serverdataeshop.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/28 17:17
 * @Version 1.0
 **/
@RestController
public class ShopGoodsController extends BaseController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    GoodsService goodsService;


    @PostMapping("findGoods")
    public Wrapper findGoodsByShopid(@RequestParam("shopid") String shopid) {
        return apiResponse(goodsService.findShopGoods(shopid));
    }

    @PostMapping("findGoodsOne")
    public Wrapper findOneGoods(@RequestParam("gid") String gid) {
        logger.info("gid is :{}", gid);
//        goodsService.
        return apiResponse("ok");
    }

    @PostMapping("findOneGoodsByid")
    public Wrapper findOneGoodsByID(@RequestParam("gid") Integer gid) {
        return apiResponse(goodsService.findShopGoodsOne(gid));
    }


    @PostMapping("savegood")
    public Wrapper saveGood(@RequestBody ShopGoods shopGood) {
        Boolean isok = goodsService.saveGoods(shopGood);
        logger.info("code:{}--desc:{}", shopGood.getGoodscode(), shopGood.getGoodsdesc());
        return WrapperResponse.wrap(200, "操作成功", isok);
    }

    @PostMapping("savegoodlist")
    public Wrapper saveGoods(List<ShopGoods> shopGood) {
        Boolean isok = goodsService.saveGoods(shopGood);
        return WrapperResponse.wrap(200, "操作成功", isok);
    }

    @PostMapping("addcart")
    public Wrapper addCart(CustomerCartVO cartVO) {
        logger.info("objs :{}", JSONObject.toJSONString(cartVO));
        goodsService.addToCart(cartVO);
        return WrapperResponse.wrap(200, "操作成功");
    }

    @PostMapping("findcart")
    public Wrapper findUserCart(@RequestParam("userid") Integer userid, @RequestParam("key") String nobody_key) {
        List<CustomerCartVO> cartVOS = goodsService.findCartList(userid, nobody_key);
        return apiResponse(cartVOS);
    }
}
