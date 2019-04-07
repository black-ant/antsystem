package com.antsystem.servercache.servercache.service;

import com.antsystem.servercache.servercache.utils.MongodbUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/6 15:49
 * @Version 1.0
 **/
@Service
public abstract class BaseService {

    @Autowired
    MongodbUtil mongodbUtil;
}
