package com.msclient.eshop.clienteshop.Controller;

import com.msclient.eshop.clienteshop.ServerMapper.EshopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/31 23:28
 * @Version 1.0
 **/
@RestController
public class ShopController {

    @Autowired
    EshopMapper eshopMapper;

    @GetMapping("/consumer")
    public String dc() {
        return eshopMapper.shopone();
    }


}
