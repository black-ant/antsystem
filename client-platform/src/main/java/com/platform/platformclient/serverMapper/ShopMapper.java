package com.platform.platformclient.serverMapper;

import com.platform.platformclient.entity.vo.ShopVO;
import com.platform.platformclient.entity.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/18 22:37
 * @Version 1.0
 **/
@FeignClient("server-eshop")
public interface ShopMapper {

    /*
     *shop
     *
     */
    @PostMapping("/shopone")
    String shopone();

    @PostMapping("/shopedit")
    String shopEdit(@RequestBody ShopVO shopVO, @RequestParam("shopid") String shopid, @RequestParam("status")String status);

    @PostMapping("/shoppath/{status}")
    String shopPath(@RequestBody ShopVO shopVO, @RequestParam("shopid") String shopid, @PathVariable("status")String status);

    /*
     *shopUser
     *
     */
    @PostMapping("/user/adduser")
    String addUser(UserVO userVO);

}

