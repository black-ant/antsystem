package com.serverdata.order.serverdataorder.service;

import com.serverdata.order.serverdataorder.Entity.CarInfo;
import com.serverdata.order.serverdataorder.repository.CarInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/27 15:13
 * @Version 1.0
 **/
@Service
public class CarInfoService {

    @Autowired
    CarInfoRepository carInfoRepository;

    public List<CarInfo> findByCarid(Long carid){
        return carInfoRepository.findByCarId(carid);
    }
}
