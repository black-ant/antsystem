package com.serverdata.order.serverdataorder.service;

import com.serverdata.order.serverdataorder.common.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String getLastOrderID() {
        String orderid =String.valueOf(redisUtils.getByKey("orderid"));
        logger.info("orderid:{}",orderid);
        if (null == orderid) {
            redisUtils.setValue("orderid", "1");
            orderid = "1";
        }else{
            int id = Integer.valueOf(orderid);
            logger.info("orderid before:{}",id++);
            redisUtils.setValue("orderid",String.valueOf(id++));
            logger.info("orderid after:{}",redisUtils.getByKey("orderid"));
        }
        return orderid;
    }

}
