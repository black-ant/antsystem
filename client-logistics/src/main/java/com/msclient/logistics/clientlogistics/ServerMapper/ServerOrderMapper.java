package com.msclient.logistics.clientlogistics.ServerMapper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/22 23:20
 * @Version 1.0
 **/
@FeignClient("server-order")
public interface ServerOrderMapper {

    @PostMapping("findall")
    String findAll();
}
