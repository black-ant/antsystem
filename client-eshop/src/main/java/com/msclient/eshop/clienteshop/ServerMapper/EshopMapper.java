package com.msclient.eshop.clienteshop.ServerMapper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/31 23:00
 * @Version 1.0
 **/
@FeignClient("server-eshop")
public interface EshopMapper {

    @PostMapping("/shopone")
    String shopone();
}
