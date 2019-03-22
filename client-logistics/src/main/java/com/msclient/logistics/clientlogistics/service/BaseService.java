package com.msclient.logistics.clientlogistics.service;

import com.msclient.logistics.clientlogistics.ServerMapper.ServerOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/22 23:17
 * @Version 1.0
 **/
public abstract  class BaseService {

    @Autowired
    ServerOrderMapper serverOrderMapper;

}
