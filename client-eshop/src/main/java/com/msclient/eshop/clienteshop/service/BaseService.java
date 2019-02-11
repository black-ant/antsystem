package com.msclient.eshop.clienteshop.service;

import com.msclient.eshop.clienteshop.serverMapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/10 21:48
 * @Version 1.0
 **/
public abstract  class BaseService {

    @Autowired
    ShopMapper eshopMapper;

}
