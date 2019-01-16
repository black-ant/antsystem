package com.dataserver.demo.controller;

import com.dataserver.demo.entity.dto.OutSourceUserDTO;
import com.dataserver.demo.entity.dto.PlatformUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {


    /**
     * 用于创建平台新用户
     * @return
     */
    @RequestMapping("newplatformuser")
    public String newUserPlatform(@RequestParam("usertype") String usertype,PlatformUserDTO userDTO){

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
