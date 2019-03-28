package com.msclient.eshop.clienteshop.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/28 16:45
 * @Version 1.0
 **/
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

    public static <T> T wrapperToBean(String json, Class<T> beanClass) {
        JSONObject obj =toJsonObject(json);
        return obj.getJSONObject("result").toJavaObject(beanClass);
    }
    public static <T> List<T> wrapperToList(String json, Class<T> beanClass) {
        JSONObject obj =toJsonObject(json);
        return obj.getJSONArray("result").toJavaList(beanClass);
    }

    public static <T> List<T> wrapperPKToList(String json, Class<T> beanClass) {
        JSONObject obj =toJsonObject(json);
        return obj.getJSONArray("result").toJavaList(beanClass);
    }
}
