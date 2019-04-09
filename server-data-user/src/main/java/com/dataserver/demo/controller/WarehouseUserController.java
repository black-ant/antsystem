package com.dataserver.demo.controller;

import com.dataserver.demo.common.response.Wrapper;
import com.dataserver.demo.service.UserWagesService;
import com.dataserver.demo.service.UserWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 16:01
 * @Version 1.0
 **/
@RestController
public class WarehouseUserController extends BaseController{


    @Autowired
    UserWarehouseService warehouseService;

    @RequestMapping("user/warehouse")
    public Wrapper findWarehouseUser(@RequestParam("warehouseid") Integer houseid){
        return apiResponse(warehouseService.findAllWarehouseUser(houseid));
    }
}
