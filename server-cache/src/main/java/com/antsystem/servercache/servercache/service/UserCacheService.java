package com.antsystem.servercache.servercache.service;

import com.antsystem.servercache.servercache.entity.TestEntity;
import com.antsystem.servercache.servercache.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/6 13:25
 * @Version 1.0
 **/
@Service
public class UserCacheService extends BaseService {

    @Autowired
    TestRepository testRepo;

    public String createOneTest(String table,String json) {
        mongodbUtil.InsertJSON(table, json);
        return "ok";
    }

    public String createOneTestEntity() {
        TestEntity testEntity = new TestEntity("is msg","name",new Date());
        testEntity.setId(new Random().nextInt(1001));
        testRepo.save(testEntity);
        return "ok";
    }

    public List<String> getCacheTest(String key) {
        return mongodbUtil.getJSONById("test", key);
    }

    public List<String> getCacheByType(String type) {
        return mongodbUtil.getJSONById("test", type);
    }





}
