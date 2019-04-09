package com.msclient.logistics.clientlogistics.ServerMapper;

import com.msclient.logistics.clientlogistics.entity.StorehouseVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 16:03
 * @Version 1.0
 **/
@FeignClient(value = "server-user",fallback = ServerUserFailBack.class)
public interface ServerUserMapper {

    @RequestMapping("user/warehouse")
    public String findWarehouseUser(@RequestParam("warehouseid") Integer houseid);


}
