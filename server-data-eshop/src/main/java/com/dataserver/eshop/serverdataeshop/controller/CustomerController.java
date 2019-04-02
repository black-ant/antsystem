package com.dataserver.eshop.serverdataeshop.controller;

import com.alibaba.fastjson.JSONObject;
import com.dataserver.eshop.serverdataeshop.common.response.Wrapper;
import com.dataserver.eshop.serverdataeshop.entity.CustomerAddress;
import com.dataserver.eshop.serverdataeshop.entity.VO.CustomerAddressVO;
import com.dataserver.eshop.serverdataeshop.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/2 21:23
 * @Version 1.0
 **/
@RestController
public class CustomerController extends BaseController{

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    CustomerService cusservice;


    @PostMapping("addcusaddress")
    public Wrapper addCustomerAddress(CustomerAddressVO coutomerAddress){
        logger.info(JSONObject.toJSONString(coutomerAddress.getDelName()));
        logger.info(JSONObject.toJSONString(coutomerAddress));
        return apiResponse( cusservice.addCustomerAddress(coutomerAddress));
    }
}
