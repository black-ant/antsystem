package com.msclient.logistics.clientlogistics.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/22 23:36
 * @Version 1.0
 **/

public class JSONUtils {

    final static Logger logger = LoggerFactory.getLogger(JSONUtils.class);

    public static JSONObject toJsonObject(String jsons) {
        return JSONObject.parseObject(jsons);
    }

    public static <T> T toBean(String json, Class<T> beanClass) {
        return JSON.parseObject(json, beanClass);
    }

    public static <T> List<T> toList(String json, Class<T> beanClass) {
        return JSON.parseArray(json, beanClass);
    }

    public static <T> List<T> wrapperToList(String json, Class<T> beanClass) {
        logger.info("json :{}", json);
        JSONObject obj = toJsonObject(json);
        JSONArray jsonArray = null == obj.getJSONArray("result") ? new JSONArray() : obj.getJSONArray("result");
        logger.info("obj :{}", obj.getJSONArray("result"));
        return jsonArray.toJavaList(beanClass);
    }

    public static <T> T wrapperToBean(String json, Class<T> beanClass) {
        JSONObject obj = toJsonObject(json);
        return obj.getJSONObject("result").toJavaObject(beanClass);
    }

    public static <T> List<T> wrapperPKToList(String json, Class<T> beanClass) {
        JSONObject obj = toJsonObject(json);
        return obj.getJSONArray("result").toJavaList(beanClass);
    }
}
