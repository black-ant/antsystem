package com.dataserver.eshop.serverdataeshop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dataserver.eshop.serverdataeshop.common.response.Wrapper;
import com.dataserver.eshop.serverdataeshop.entity.VO.TradeVO;
import com.dataserver.eshop.serverdataeshop.service.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/2 17:38
 * @Version 1.0
 **/
@RestController
public class ShopTradeController extends BaseController{

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TradeService tradeService;

    @PostMapping("trade")
    public Wrapper tradeGoods(@RequestBody TradeVO tradeVO){
        logger.info(JSONObject.toJSONString(tradeVO));
        tradeService.saveTradeOrder(tradeVO);
        return apiResponse("OK");
    }
}
