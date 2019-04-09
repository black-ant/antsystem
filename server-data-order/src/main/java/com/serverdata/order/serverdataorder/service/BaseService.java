package com.serverdata.order.serverdataorder.service;

import com.serverdata.order.serverdataorder.mapper.CacheServerMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 21:02
 * @Version 1.0
 **/
public abstract  class BaseService {

    @Autowired
    CacheServerMapper cacheMapper;

}

