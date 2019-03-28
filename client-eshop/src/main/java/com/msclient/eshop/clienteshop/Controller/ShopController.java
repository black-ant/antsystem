package com.msclient.eshop.clienteshop.controller;

import com.msclient.eshop.clienteshop.entity.ShopVO;
import com.msclient.eshop.clienteshop.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/31 23:28
 * @Version 1.0
 **/
@RestController
public class ShopController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    ShopService shopService;

    @GetMapping("/consumer")
    public ShopVO dc() {
        return shopService.getShop("10001");
    }

    @GetMapping("/getshop")
    public ModelAndView getShop(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        String gsid = (String)session.getAttribute("shopid");
        logger.info("进入方法getShop()==:gsid{}",gsid);
        modelAndView.setViewName("pages/shopedit");
        modelAndView.addObject("shopModel",shopService.getShop(gsid));
        return modelAndView;
    }

    @GetMapping("/shopedit")
    public String shopEdit(){
       return  shopService.shopedit();
    }


    @GetMapping("/shoppath")
    public String shopPath(){
       return  shopService.shoppath();
    }



}
