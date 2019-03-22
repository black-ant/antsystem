package com.serverdata.order.serverdataorder.service;

import com.serverdata.order.serverdataorder.Entity.Storehouse;
import com.serverdata.order.serverdataorder.repository.StorehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/22 23:23
 * @Version 1.0
 **/
@Service
public class StorehouseService {

    @Autowired
    StorehouseRepository storehouseRepository;

    public List<Storehouse> findAll(){
        return storehouseRepository.findAll();
    }
}
