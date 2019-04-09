package com.serverdata.order.serverdataorder.mapper;

import org.springframework.stereotype.Component;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 22:35
 * @Version 1.0
 **/
@Component
public class CacheServiceFailback implements  CacheServerMapper{

    @Override
    public String SaveLogisticsOrder(String type, String orderData) {
        return "no server";
    }
}
