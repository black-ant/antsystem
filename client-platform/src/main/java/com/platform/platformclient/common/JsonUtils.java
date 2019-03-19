package com.platform.platformclient.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class JSONUtils {

    public static JSONObject toJsonObject(String jsons){
        return JSONObject.parseObject(jsons);
    }

    public static <T> T toBean(String json, Class<T> beanClass) {
        return JSON.parseObject(json, beanClass);
    }

    public static <T> List<T> toList(String json, Class<T> beanClass) {
        return JSON.parseArray(json, beanClass);
    }

    public static <T> List<T> wrapperToList(String json, Class<T> beanClass) {
        JSONObject obj =toJsonObject(json);
        return obj.getJSONArray("result").toJavaList(beanClass);
    }
}
