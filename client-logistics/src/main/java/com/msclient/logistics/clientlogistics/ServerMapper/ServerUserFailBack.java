package com.msclient.logistics.clientlogistics.ServerMapper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 22:40
 * @Version 1.0
 **/
@Component
public class ServerUserFailBack extends BaseErrorFailBack implements ServerUserMapper {

    Logger logger = LoggerFactory.getLogger(getClass());



    @Override
    public String findWarehouseUser(Integer houseid) {
        logger.info("NO findWarehouseUser Server");
        return ErrorTemplate();
    }
}
