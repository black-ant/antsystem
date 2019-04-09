package com.serverdata.order.serverdataorder.common;

import com.serverdata.order.serverdataorder.common.utils.CommonUtils;
import com.serverdata.order.serverdataorder.common.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/13 21:34
 * @Version 1.0
 **/
@Service
public class ApplicationCache {

    @Autowired
    RedisUtils redisUtils;

    public String getOrderids(String ordertype) {
        int id = 0;
        switch (ordertype) {
            case "L":
                id = (int) redisUtils.getByKey("Lorderid");
                break;
            case "S":
                id = (int) redisUtils.getByKey("Sorderid");
                break;
            case "R":
                id = (int) redisUtils.getByKey("Rorderid");
                break;
            default:
                id = 0;
        }
        return editID(id,ordertype);

    }

    public String editID(int id, String type) {
        return CommonUtils.getnextOrder(String.valueOf(id), type, 1);
    }
}
