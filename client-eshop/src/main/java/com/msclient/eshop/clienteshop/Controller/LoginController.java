package com.msclient.eshop.clienteshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/28 15:26
 * @Version 1.0
 **/
@Controller
public class LoginController {

    @GetMapping("index")
    public String indexStorage(HttpSession session){
        session.setAttribute("shopid","100001");
        return "index";
    }
}
