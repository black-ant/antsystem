package com.dataserver.eshop.serverdataeshop.controller;

import com.dataserver.eshop.serverdataeshop.common.response.Wrapper;
import com.dataserver.eshop.serverdataeshop.common.response.WrapperResponse;
import com.dataserver.eshop.serverdataeshop.entity.ShopUser;
import com.dataserver.eshop.serverdataeshop.service.ShopUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 10169
 * @Description 用于处理店铺人员及会员信息
 * @Date 2019/2/11 16:05
 * @Version 1.0
 **/
@RestController
@RequestMapping("user")
public class ShopUserController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ShopUserService shopUserService;

    @PostMapping("adduser")
    public Wrapper addUser(@RequestBody ShopUser shopUser){
        logger.info("进入添加员工部分：{}---username:{}--userdesc:{}",shopUser,shopUser.getRemarks(),shopUser.getUsername());
        shopUserService.addUser(shopUser);
        return WrapperResponse.wrap(200);
    }

    @PostMapping("adduserno")
    public Wrapper addUserNoAnnBody(ShopUser shopUser){
        logger.info("进入添加员工部分,未使用RequestBody：{}---username:{}--userdesc:{}",shopUser,shopUser.getRemarks(),shopUser.getUsername());
        return WrapperResponse.wrap(200);
    }

}
