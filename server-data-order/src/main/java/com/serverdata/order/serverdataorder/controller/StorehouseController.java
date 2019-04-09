package com.serverdata.order.serverdataorder.controller;

import com.serverdata.order.serverdataorder.Entity.Storehouse;
import com.serverdata.order.serverdataorder.common.response.Wrapper;
import com.serverdata.order.serverdataorder.service.StorehouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/22 23:24
 * @Version 1.0
 **/
@RestController
@RequestMapping("storehouse")
public class StorehouseController extends BaseController{

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    StorehouseService storehouseService;

    @PostMapping("findall")
    public Wrapper findAll(){
        logger.info("查询所有仓库");
        List<Storehouse> list = storehouseService.findAll();
        return apiResponse(list,"查询成功");
    }

    @PostMapping("saveone")
    public Wrapper saveOneStorehouse(@RequestBody Storehouse storehouse){
        logger.info("查询所有仓库");
        Storehouse item = storehouseService.save(storehouse);
        return apiResponse(item,"保存成功");
    }
}
