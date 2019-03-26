package com.msclient.logistics.clientlogistics.service;

import com.msclient.logistics.clientlogistics.entity.StorehouseVO;
import com.msclient.logistics.clientlogistics.utils.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/22 23:17
 * @Version 1.0
 **/
@Service
public class StorehouseService extends BaseService {

    Logger logger = LoggerFactory.getLogger(getClass());

    public List<StorehouseVO> findAll() {
        String wrapper = serverOrderMapper.findStorehouseAll();
        logger.info("wrapper is :{}", wrapper);
        List<StorehouseVO> list = JSONUtils.wrapperToList(wrapper, StorehouseVO.class);
        return list;
    }

}
