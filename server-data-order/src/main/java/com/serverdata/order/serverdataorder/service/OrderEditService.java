package com.serverdata.order.serverdataorder.service;

import com.serverdata.order.serverdataorder.Entity.ShopOrder;
import com.serverdata.order.serverdataorder.Entity.ShopOrderItem;
import com.serverdata.order.serverdataorder.Entity.ShopReturnOrder;
import com.serverdata.order.serverdataorder.Entity.ShopReturnOrderItem;
import com.serverdata.order.serverdataorder.common.utils.RedisUtils;
import com.serverdata.order.serverdataorder.repository.ShopOrderItemRepository;
import com.serverdata.order.serverdataorder.repository.ShopOrderRepository;
import com.serverdata.order.serverdataorder.repository.ShopReturnOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/26 21:19
 * @Version 1.0
 **/
@Service
public class OrderEditService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    ShopOrderRepository shopOrderRepository;
    @Autowired
    ShopOrderItemRepository shopOrderItemRepository;
    @Autowired
    ShopReturnOrderRepository shopReturnOrderRepository;

    public String getLastOrderID() {
        String orderid = String.valueOf(redisUtils.getByKey("orderid"));
        logger.info("orderid:{}", orderid);
        if (null == orderid) {
            redisUtils.setValue("orderid", "1");
            orderid = "1";
        } else {
            int id = Integer.valueOf(orderid);
            logger.info("orderid before:{}", id++);
            redisUtils.setValue("orderid", String.valueOf(id++));
            logger.info("orderid after:{}", redisUtils.getByKey("orderid"));
        }
        return orderid;
    }

    @Transactional
    public ShopOrder createShopOrder() {
        ShopOrder shopOrder = new ShopOrder();
        editShopOrder(shopOrder);
        return shopOrderRepository.save(shopOrder);
    }

    public void editShopOrder(ShopOrder shopOrder) {
        List<ShopOrderItem> shopOrderItems = new LinkedList<>();
        ShopOrderItem shopOrderItem = new ShopOrderItem("S1102231", "1");
        shopOrderItems.add(shopOrderItem);
        shopOrderItemRepository.save(shopOrderItem);
        ShopOrderItem shopOrderItem2 = new ShopOrderItem("S1102231", "2");
        shopOrderItems.add(shopOrderItem2);
        shopOrderItemRepository.save(shopOrderItem2);
        shopOrder.setShopOrderItems(shopOrderItems);
        shopOrder.setOrderid("S1102231");
    }

    @Transactional
    public ShopReturnOrder createReturnOrder() {
        ShopReturnOrder shopOrder = new ShopReturnOrder();
        editReturnOrder(shopOrder);
        return shopReturnOrderRepository.save(shopOrder);
    }

    public void editReturnOrder(ShopReturnOrder shopReturnOrder) {
        List<ShopReturnOrderItem> shopOrderItems = new LinkedList<>();
        ShopReturnOrderItem shopOrderItem = new ShopReturnOrderItem("S1102231", "1");
        shopOrderItems.add(shopOrderItem);
        ShopReturnOrderItem shopOrderItem2 = new ShopReturnOrderItem("S1102231", "2");
        shopOrderItems.add(shopOrderItem2);
        shopReturnOrder.setShopReturnOrderItems(shopOrderItems);
        shopReturnOrder.setOrderid("S1102231");
    }

}
