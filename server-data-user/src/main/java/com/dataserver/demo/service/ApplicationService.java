package com.dataserver.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/18 22:52
 * @Version 1.0
 **/
@ApplicationScope
public class ApplicationService {

    Logger logger = LoggerFactory.getLogger(getClass());

    private Long depid;
    private Long userid;


    @InitBinder
    public void init(){
        logger.info("Application Service start");
        findId();
    }

    /**
     * 查询订单初始ID , 每次启动时查询 ，放入缓存
     */
    public void findId(){

    }
}
