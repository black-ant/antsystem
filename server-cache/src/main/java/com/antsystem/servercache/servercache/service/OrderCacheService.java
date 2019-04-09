package com.antsystem.servercache.servercache.service;

import com.alibaba.fastjson.JSONObject;
import com.antsystem.servercache.servercache.entity.LTTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/6 13:25
 * @Version 1.0
 **/
@Service
public class OrderCacheService extends BaseService {

    Logger logger = LoggerFactory.getLogger(getClass());

    //===============系统测试简单代码
    public List<String> getOrderList(String order) {
        return mongodbUtil.getJSONList("antcache");
    }

    public List<String> getOrderListById(String order, String key) {
        return mongodbUtil.getJSONById(order, key);
    }

    //==================项目部分
    public void SaveLogisticsOrder(String type, String json) {
        switch (type) {
            case "logistic":
                mongodbUtil.InsertJSON("LTorder", json);
                break;
        }
    }

    public List<String> findLogisticsOrderList(String type) {
        HashMap<String, Object> map = new LinkedHashMap<>();
        List<String> list = new LinkedList<>();
        switch (type) {
            case "ALL":
                list = mongodbUtil.getJSONList("LTorder");
                break;
            case "RUN":
                map.put("type", "1");
                map.put("name", "test");
                list = mongodbUtil.getJSONListByFilter("LTorder", map);
                break;
            default:
                list = new LinkedList<>();

        }
        logger.info("return cache Logistics :{}", JSONObject.toJSONString(list));
        return list;
    }


}
