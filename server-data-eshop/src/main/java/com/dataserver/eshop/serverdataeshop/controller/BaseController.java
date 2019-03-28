package com.dataserver.eshop.serverdataeshop.controller;

import com.dataserver.eshop.serverdataeshop.common.response.Wrapper;
import com.dataserver.eshop.serverdataeshop.common.response.WrapperResponse;
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

    protected <T> Wrapper<T> apiResponse(T result) {
        boolean isok = isok(result);
        if (isok) {
            return WrapperResponse.wrap(200, "操作成功", result);
        } else {
            return WrapperResponse.wrap(500, "操作失败", result);
        }
    }

    protected <T> Wrapper<T> apiResponse(T result,String msg) {
        boolean isok = isok(result);
        if (isok) {
            return WrapperResponse.wrap(200, msg, result);
        } else {
            return WrapperResponse.wrap(500, msg, result);
        }
    }

    protected boolean isok(Object result) {
        return true;
    }
}
