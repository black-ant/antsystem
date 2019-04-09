package com.msclient.logistics.clientlogistics.ServerMapper;

import com.msclient.logistics.clientlogistics.entity.StorehouseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 22:39
 * @Version 1.0
 **/
@Component
public class ServerOrderFailBack extends BaseErrorFailBack implements ServerOrderMapper {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String findStorehouseAll() {
        logger.info("findStorehouseAll server-no");
        return ErrorTemplate();
    }

    @Override
    public String findInventoryAll() {
        logger.info("findInventoryAll server-no");
        return ErrorTemplate();
    }

    @Override
    public String findCarInfoByCarId(Long carid) {
        logger.info("findCarInfoByCarId server-no");
        return ErrorTemplate();
    }

    @Override
    public String findallLogisticsOrder(String type) {
        logger.info("findallLogisticsOrder server-no");
        return ErrorTemplate();
    }

    @Override
    public String saveOneStorehouse(StorehouseVO storehouse) {
        logger.info("saveOneStorehouse server-no");
        return ErrorTemplate();
    }
}
