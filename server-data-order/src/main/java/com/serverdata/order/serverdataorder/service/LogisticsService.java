package com.serverdata.order.serverdataorder.service;

import com.alibaba.fastjson.JSONObject;
import com.serverdata.order.serverdataorder.Entity.LogisticsOrder;
import com.serverdata.order.serverdataorder.Entity.LogisticsOrderItem;
import com.serverdata.order.serverdataorder.Entity.vo.TradeVO;
import com.serverdata.order.serverdataorder.common.ApplicationCache;
import com.serverdata.order.serverdataorder.controller.BaseController;
import com.serverdata.order.serverdataorder.repository.LogisticsOrderItemRepository;
import com.serverdata.order.serverdataorder.repository.LogisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/13 20:46
 * @Version 1.0
 **/
@Service
public class LogisticsService extends BaseService {

    @Autowired
    LogisticsRepository logisticsRepository;
    @Autowired
    LogisticsOrderItemRepository logisitemRepo;
    @Autowired
    ApplicationCache applicationCache;

    @Transient
    public LogisticsOrder createByTrade(TradeVO tradeVO) {
        LogisticsOrder logisticsOrder = new LogisticsOrder(tradeVO);
        logisticsOrder.setId(String.valueOf(new Random().nextInt(1001)));
        logisticsOrder.setTransfee(BigDecimal.ZERO);
        for (LogisticsOrderItem item : logisticsOrder.getItems()) {
            item.setLid(logisticsOrder.getId());
            item.setTransfee(BigDecimal.ZERO);
            this.saveOrderItem(item);
        }
        logisticsOrder = this.saveOrder(logisticsOrder);
        cacheMapper.SaveLogisticsOrder("logistic", JSONObject.toJSONString(logisticsOrder));
        return logisticsRepository.save(logisticsOrder);
    }

    public LogisticsOrder cacheOne(String orderid) {
        LogisticsOrder order = logisticsRepository.findById(orderid).get();
        cacheMapper.SaveLogisticsOrder("logistic", JSONObject.toJSONString(order));
        return order;
    }

    public LogisticsOrder saveOrder(LogisticsOrder logisticsOrder) {
        return logisticsRepository.save(logisticsOrder);
    }

    public LogisticsOrderItem saveOrderItem(LogisticsOrderItem logisticsItem) {
        return logisitemRepo.save(logisticsItem);
    }


    public LogisticsOrder editLogisticsOrder(LogisticsOrder logisticsOrder) {
        List<LogisticsOrderItem> items = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            LogisticsOrderItem item = new LogisticsOrderItem();
//            item.setOrderid();
        }
        return logisticsOrder;
    }

    public List<LogisticsOrder> findAll() {
        List<LogisticsOrder> list = logisticsRepository.findAll();
        return list;
    }


}
