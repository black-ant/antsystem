package com.serverdata.order.serverdataorder.service;

import com.serverdata.order.serverdataorder.Entity.ShopOrder;
import com.serverdata.order.serverdataorder.repository.ShopOrderRepository;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/27 13:08
 * @Version 1.0
 **/
@Service
public class ShopOrderService {

    @Autowired
    ShopOrderRepository shopOrderRepository;

    public List<ShopOrder> findAll(){
        return shopOrderRepository.findAll();
    }
}
