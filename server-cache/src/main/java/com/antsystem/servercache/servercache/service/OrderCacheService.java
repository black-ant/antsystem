package com.antsystem.servercache.servercache.service;

import com.antsystem.servercache.servercache.entity.LTTypeEnum;
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
        HashMap<String,Object> map = new LinkedHashMap<>();
        switch (type) {
                case "ALL":
                return mongodbUtil.getJSONList("LTorder");
            case "RUN":
                map.put("type","1");
                map.put("name","test");
                return mongodbUtil.getJSONListByFilter("LTorder",map);
        }
        return new LinkedList<>();
    }


}
