package com.serverdata.order.serverdataorder.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/25 23:12
 * @Version 1.0
 **/
@Component
public class RedisUtils {

    @Autowired
    RedisTemplate redisTemplate;

    public Object getByKey(String key){
        return key==null?null:redisTemplate.opsForValue().get(key);
    }

    public Object setValue(String key,Object value){
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Set<String> getSetByKey(String key){
        return redisTemplate.opsForSet().members(key);
    }
}
