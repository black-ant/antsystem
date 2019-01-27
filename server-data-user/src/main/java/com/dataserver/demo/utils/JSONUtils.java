package com.dataserver.demo.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/27 14:37
 * @Version 1.0
 **/
public class JSONUtils {

    private JSONObject json;
    public static String objectToJSON(Object obj){
        return JSONObject.toJSONString(obj);
    }
}
