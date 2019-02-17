package com.msclient.eshop.clienteshop.controller;

import com.msclient.eshop.clienteshop.entity.GoodVO;
import com.msclient.eshop.clienteshop.response.WrapperResponse;
import com.msclient.eshop.clienteshop.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/13 20:40
 * @Version 1.0
 **/
@RestController
public class AppCartController {

    @Autowired
    GoodService goodService;

    @PostMapping("mycart")
    public String getCart(@RequestParam("userid") String userid){
        List<GoodVO> goods= goodService.getCart(userid);
        return "";
    }


}
