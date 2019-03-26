package com.msclient.logistics.clientlogistics.service;

import com.msclient.logistics.clientlogistics.entity.InventoryVO;
import com.msclient.logistics.clientlogistics.entity.StorehouseVO;
import com.msclient.logistics.clientlogistics.utils.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/25 23:14
 * @Version 1.0
 **/
@Service
public class InventoryService extends  BaseService{

    Logger logger = LoggerFactory.getLogger(getClass());

    public List<InventoryVO> findAll() {
        String wrapper = serverOrderMapper.findInventoryAll();
        logger.info("wrapper is :{}", wrapper);
        List<InventoryVO> list = JSONUtils.wrapperToList(wrapper, InventoryVO.class);
        return list;
    }
}
