package com.antsystem.servercache.servercache.repository;

import com.antsystem.servercache.servercache.entity.TestEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author 10169
 * @Description 直接通过继承MongoRepository 实现对MongoDB的快速便捷的操作
 * 如果将MongDB 作为主要的数据存储途径 ，且对数据有细微频繁的操作 ，可以使用该方法
 * @Date 2019/4/6 15:25
 * @Version 1.0
 **/
public interface TestRepository extends MongoRepository<TestEntity,Integer> {

}
