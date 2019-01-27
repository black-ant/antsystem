package com.dataserver.demo.controller;

import com.dataserver.demo.entity.vo.Wrapper;
import com.dataserver.demo.utils.WrapperResponse;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/27 18:50
 * @Version 1.0
 **/
public class BaseController {

    protected <T> Wrapper<T> apiResponse(T result) {
        boolean isok = isok(result);
        if (isok) {
            return WrapperResponse.wrap(200, "操作成功", result);
        } else {
            return WrapperResponse.wrap(500, "操作失败", result);
        }
    }

    protected boolean isok(Object result) {
        return true;
    }


}

