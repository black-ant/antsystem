package com.msclient.eshop.clienteshop.service;

import com.msclient.eshop.clienteshop.serverMapper.EshopMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/2 23:21
 * @Version 1.0
 **/
@Service
public class ShopService {

    @Autowired
    EshopMapper eshopMapper;

    @HystrixCommand(fallbackMethod = "geterror")
    public String getShop(){
        return eshopMapper.shopone();
    }

    public String geterror(){
        return "查找错误";
    }
}
