package com.msclient.eshop.clienteshop.controller;

import com.msclient.eshop.clienteshop.entity.GoodVO;
import com.msclient.eshop.clienteshop.service.GoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Wrapper;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/9 23:09
 * @Version 1.0
 **/
@RestController
public class ProController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    GoodService goodService;

    @PostMapping("/editgood")
    public String editgood(GoodVO goodVO) {
        logger.info("goodsvo code:{}",goodVO.getGoodscode());
        logger.info("goodsvo code:{}",goodVO.getId());
        logger.info("goodsvo desc:{}",goodVO.getGoodsdesc());
        logger.info("goodsvo title:{}",goodVO.getGoodstitle());
        goodService.saveGoods(goodVO);
        return "pages/pro/prolist";
    }

    @PostMapping("/findcart")
    public String findCart(){
        return "";
    }

    @PostMapping("/findgood")
    public String findGoods(@RequestParam("code") String code, ModelMap modelMap){
        GoodVO goodVO = goodService.findGoodByCode(code);
        modelMap.addAttribute("goodone",goodVO);
        return "pages/pro/prolist::pop-edit";
    }

    @GetMapping("/prolist")
    public ModelAndView prolist(HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        String gsid = (String)session.getAttribute("shopid");
        logger.info("进入方法getShop()==:gsid{}",gsid);
        modelAndView.setViewName("pages/pro/prolist");
        modelAndView.addObject("goodone",new GoodVO());
        modelAndView.addObject("goods",goodService.findGoodByShopid(gsid));
        return modelAndView;
    }

}
