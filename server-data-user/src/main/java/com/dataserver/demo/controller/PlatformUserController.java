package com.dataserver.demo.controller;


import com.dataserver.demo.entity.UserPlatformEntity;
import com.dataserver.demo.entity.dto.PlatformUserDTO;
import com.dataserver.demo.common.response.Wrapper;
import com.dataserver.demo.service.UserManageService;
import com.dataserver.demo.service.UserPlatformService;
import com.dataserver.demo.utils.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("platform")
public class PlatformUserController extends BaseController{

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    UserPlatformService userService;
    @Autowired
    UserManageService userManageService;

    Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("test")
    public String dc() {
        String services = "Services platform user: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @PostMapping("puserlist")
    public Wrapper puserlist(){
        List<PlatformUserDTO> userList =userService.userlist();
        return apiResponse(userList);
    }

    @GetMapping("getoneuser")
    public Wrapper getoneuser(@RequestParam("username") String username,@RequestParam("useraccount") String useraccount){
        UserPlatformEntity user = userService.getOneUser(1L);
        return apiResponse(user);
    }

    @PostMapping("createuser")
    public Wrapper createuser(@RequestBody PlatformUserDTO userdto){
        ObjectUtil.reflect(userdto);
        logger.debug("userid is :{}---username is:{}",userdto.getId(),userdto.getUsername());
        logger.info("userid is :{}---username is:{}",userdto.getId(),userdto.getUsername());
        userService.createPlatformUser(userdto);
        return apiResponse("添加成功");
    }
    @PostMapping("testcreate")
    public Wrapper createuser(@RequestParam("userid") String userid,@RequestParam("username") String username){
        logger.debug("userid is :{}---username is:{}",userid,username);
        return apiResponse("添加成功");
    }
}
