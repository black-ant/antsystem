package com.serverdata.order.serverdataorder.controller;

import com.serverdata.order.serverdataorder.Entity.CarInfo;
import com.serverdata.order.serverdataorder.common.response.Wrapper;
import com.serverdata.order.serverdataorder.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/27 15:14
 * @Version 1.0
 **/
@RestController
@RequestMapping("info")
public class CarInfoController extends BaseController {

    @Autowired
    CarInfoService carInfoService;

    @PostMapping("infocarid")
    public Wrapper findCarInfoByCarId(@RequestParam("carid") Long carid) {
        List<CarInfo> carInfos = carInfoService.findByCarid(carid);
        return apiResponse(carInfos);
    }
}
