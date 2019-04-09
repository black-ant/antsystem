package com.dataserver.demo.common;

import com.alibaba.fastjson.JSONObject;
import com.dataserver.demo.entity.UserPlatformEntity;
import com.dataserver.demo.entity.UserSourceEntity;
import com.dataserver.demo.repository.UserPlatformRepository;
import com.dataserver.demo.repository.UserResourceRepository;
import com.dataserver.demo.service.ApplicationService;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 15:15
 * @Version 1.0
 **/
@Component
@ApplicationScope
@Data
public class ApplicationCache implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger logger = LoggerFactory.getLogger(ApplicationCache.class);
    private static Map<Integer, UserPlatformEntity> user_platform = new ConcurrentHashMap<Integer, UserPlatformEntity>();
    private static Map<Integer, UserSourceEntity> user_source = new ConcurrentHashMap<Integer, UserSourceEntity>();

    @Autowired
    UserPlatformRepository userPlatformRepo;
    @Autowired
    UserResourceRepository userResourceRepo;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initCache();
    }


    public void initCache() {
        //查找平台用户
        cachePlatformUser();
        //查找外包用户
        cacheResourceUser();
    }

    public void refushCache(String cacheID) {
        switch (cacheID) {
            case "ALL":
                initCache();
                break;
            case "P_USER":

        }
    }

    public void cachePlatformUser() {
        List<UserPlatformEntity> plist = userPlatformRepo.findAll();
        user_platform = (ConcurrentHashMap) plist.stream().collect(Collectors.toMap(UserPlatformEntity::getUserid, key -> key, throwingMerger(), ConcurrentHashMap::new));
        logger.info("user platform is :{}", JSONObject.toJSONString(user_platform));
    }

    public void cacheResourceUser() {
        List<UserSourceEntity> plist = userResourceRepo.findAll();
        user_source = (ConcurrentHashMap) plist.stream().collect(Collectors.toMap(UserSourceEntity::getUserid, key -> key, throwingMerger(), ConcurrentHashMap::new));
        logger.info("user source is :{}", JSONObject.toJSONString(user_source));
    }

    public <T> T getUserInfo(Integer type, Integer userid) {
        if (1 == type) {
            return (T)user_platform.get(userid);
        } else {
            return (T)user_source.get(userid);
        }
    }



    private static <T> BinaryOperator<T> throwingMerger() {
        return (u, v) -> {
            throw new IllegalStateException(String.format("Duplicate key %s", u));
        };
    }

}
