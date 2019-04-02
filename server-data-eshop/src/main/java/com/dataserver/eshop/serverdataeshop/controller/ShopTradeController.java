package com.dataserver.eshop.serverdataeshop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dataserver.eshop.serverdataeshop.common.response.Wrapper;
import com.dataserver.eshop.serverdataeshop.entity.VO.TradeVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/2 17:38
 * @Version 1.0
 **/
@RestController
public class ShopTradeController extends BaseController{

    Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("trade")
    public Wrapper tradeGoods(TradeVO tradeVO){
        logger.info(JSONObject.toJSONString(tradeVO));
        return apiResponse("OK");
    }
}
