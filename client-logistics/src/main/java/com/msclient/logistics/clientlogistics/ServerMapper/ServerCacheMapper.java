package com.msclient.logistics.clientlogistics.ServerMapper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 21:31
 * @Version 1.0
 **/
@FeignClient(value = "server-cache",fallback = ServerCacheFailBack.class)
public interface ServerCacheMapper {

    @GetMapping("getOrderList")
    public List<String> getOrderList(@RequestParam("type") String type);
}
