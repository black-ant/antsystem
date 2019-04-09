package com.serverdata.order.serverdataorder.mapper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 21:01
 * @Version 1.0
 **/
@FeignClient(value = "server-cache",fallback = CacheServiceFailback.class)
public interface CacheServerMapper {

    @GetMapping("saveLsOrder")
    public String SaveLogisticsOrder(@RequestParam("type") String type, @RequestParam("data") String orderData);
}
