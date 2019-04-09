package com.dataserver.eshop.serverdataeshop.service;

import com.dataserver.eshop.serverdataeshop.mapper.ServerOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 17:44
 * @Version 1.0
 **/
public abstract  class BaseService {

    @Autowired
    ServerOrderMapper serverOrderMapper;

}

