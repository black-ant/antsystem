package com.antsystem.servercache.servercache.common;

import com.alibaba.fastjson.JSONObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/10 11:42
 * @Version 1.0
 **/
public abstract class CacheResponse {

    Logger logger = LoggerFactory.getLogger(getClass());

    public List<Object> cacheBack(List<DBObject> list) {
        List<Object> backList = new LinkedList<>();
        for (Object db : list) {
            logger.info("db is :{}", JSONObject.toJSONString(db));
            backList.add(JSONObject.toJSON(db));
        }
        return backList;
    }
}
