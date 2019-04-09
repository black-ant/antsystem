package com.serverdata.order.serverdataorder.controller;

import com.alibaba.fastjson.JSONObject;
import com.serverdata.order.serverdataorder.Entity.LogisticsOrder;
import com.serverdata.order.serverdataorder.Entity.vo.TradeVO;
import com.serverdata.order.serverdataorder.common.response.Wrapper;
import com.serverdata.order.serverdataorder.service.LogisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/13 20:44
 * @Version 1.0
 **/
@RestController
@RequestMapping("logistics")
public class LogisticsController extends BaseController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    LogisticsService logisticsService;

    @PostMapping("create")
    public String createOrder(LogisticsOrder logisticsOrder) {
        logger.info("LOGIS :{}", JSONObject.toJSONString(logisticsOrder));
        LogisticsOrder savelogis = logisticsService.saveOrder(logisticsOrder);
        return "";
    }

    @PostMapping("createtrade")
    public String createOrder(@RequestBody TradeVO tradeVO) {
        logger.info("tradeVO :{}", JSONObject.toJSONString(tradeVO));
        LogisticsOrder savelogis = logisticsService.createByTrade(tradeVO);
        return "ok";
    }


    @PostMapping("findallorder")
    public Wrapper findallLogisticsOrder(@RequestParam("type") String type) {
        logger.info("findAlll Type is  :{}", JSONObject.toJSONString(type));
        return apiResponse(logisticsService.findAll());
    }

    @GetMapping("cache")
    public Wrapper cacheOneOrder(@RequestParam("orderid") String orderid) {
        return apiResponse(logisticsService.cacheOne(orderid));
    }
}
