package com.antsystem.servercache.servercache.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/6 13:15
 * @Version 1.0
 **/
@Component
public class RedisUtil {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 通过key获取对象
     * @param  key
     */
    public Object get(String key){
        return key==null?null:redisTemplate.opsForValue().get(key);
    }
    /**
     * 设置redis键值对
     * @param  key
     * @param  value
     */
    public Object set(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
