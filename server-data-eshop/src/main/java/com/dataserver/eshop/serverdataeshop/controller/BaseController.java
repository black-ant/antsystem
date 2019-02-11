package com.dataserver.eshop.serverdataeshop.controller;

import com.dataserver.eshop.serverdataeshop.common.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/11 21:13
 * @Version 1.0
 **/

public abstract class BaseController {

    @Autowired
    RedisUtil redisUtil;
}
