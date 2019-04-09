package com.dataserver.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.dataserver.demo.common.ApplicationCache;
import com.dataserver.demo.entity.UserPlatformEntity;
import com.dataserver.demo.entity.UserSourceEntity;
import com.dataserver.demo.entity.UserWarehouseMapper;
import com.dataserver.demo.entity.dto.WarehouseUserDTO;
import com.dataserver.demo.repository.UserWarehouseMapperReposiroty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 15:38
 * @Version 1.0
 **/
@Service
public class UserWarehouseService {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserWarehouseMapperReposiroty mapperRepo;
    @Autowired
    ApplicationCache appCache;

    public List<WarehouseUserDTO> findAllWarehouseUser(Integer warehouseid) {
        List<UserWarehouseMapper> list = mapperRepo.findByWarehouseid(warehouseid);
        List<WarehouseUserDTO> dto = list.stream().map(p -> {
            WarehouseUserDTO dtoitem;
            logger.info("dto is :{}", JSONObject.toJSONString(p));
            Object userItem = appCache.getUserInfo(p.getUsertype(), p.getUserid());
            if (1 == p.getUsertype()) {
                dtoitem = new WarehouseUserDTO((UserPlatformEntity) userItem, p);
            } else {
                dtoitem = new WarehouseUserDTO((UserSourceEntity) userItem, p);
            }
            logger.info("dtoitem is :{}", JSONObject.toJSONString(dtoitem));
            return dtoitem;
        }).collect(Collectors.toList());
        logger.info("UserWarehouseMapper is :{}", JSONObject.toJSONString(dto));
        return dto;
    }
}
