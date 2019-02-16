package com.serverdata.order.serverdataorder.service;

import com.serverdata.order.serverdataorder.Entity.LogisticsOrder;
import com.serverdata.order.serverdataorder.Entity.LogisticsOrderItem;
import com.serverdata.order.serverdataorder.repository.LogisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/13 20:46
 * @Version 1.0
 **/
@Service
public class LogisticsService {

    @Autowired
    LogisticsRepository logisticsRepository;
    @Autowired
    ApplicationService applicationService;


    public LogisticsOrder createOrder(LogisticsOrder logisticsOrder) {
        return logisticsRepository.save(logisticsOrder);
    }

    public LogisticsOrder editLogisticsOrder(LogisticsOrder logisticsOrder) {
        logisticsOrder.setOrderid("1111");
        List<LogisticsOrderItem> items = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            LogisticsOrderItem item = new LogisticsOrderItem();
//            item.setOrderid();
        }
        return logisticsOrder;
    }


}
