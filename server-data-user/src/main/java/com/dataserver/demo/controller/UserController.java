package com.dataserver.demo.controller;

import com.dataserver.demo.entity.dto.OutSourceUserDTO;
import com.dataserver.demo.entity.dto.PlatformUserDTO;
import com.dataserver.demo.entity.vo.Wrapper;
import com.dataserver.demo.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/19 22:32
 * @Version 1.0
 **/
@RestController
public class UserController extends  BaseController{


    @Autowired
    UserManageService userManageService;

    @RequestMapping("create")
    public String createUser(){
        userManageService.createUser("gang");
        return "isok";
    }

    /**
     * 用于创建平台新用户
     * @return
     */
    @RequestMapping("newplatformuser")
    public String newUserPlatform(@RequestParam("usertype") String usertype, PlatformUserDTO userDTO){

        return "ok";
    }

    /**
     * 用于创建平台外包资源用户
     * @return
     */
    @RequestMapping("newoutsourceuser")
    public String newUserOutSource(@RequestParam("usertype") String usertype,OutSourceUserDTO userDTO){

        return "ok";
    }


}
