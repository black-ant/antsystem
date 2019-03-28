package com.msclient.logistics.clientlogistics.service;

import com.msclient.logistics.clientlogistics.entity.CarInfoVO;
import com.msclient.logistics.clientlogistics.entity.InventoryVO;
import com.msclient.logistics.clientlogistics.utils.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/27 14:52
 * @Version 1.0
 **/
@Service
public class CarInfoService extends  BaseService{

    Logger logger = LoggerFactory.getLogger(getClass());

    public List<CarInfoVO> findCarInfoByCarid(Long carid){
        String wrapper = serverOrderMapper.findCarInfoByCarId(carid);
        logger.info("wrapper is :{}", wrapper);
        List<CarInfoVO> list = JSONUtils.wrapperToList(wrapper, CarInfoVO.class);
        return list;
    }
}
