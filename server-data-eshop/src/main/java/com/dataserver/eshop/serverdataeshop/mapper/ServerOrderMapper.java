package com.dataserver.eshop.serverdataeshop.mapper;

import com.dataserver.eshop.serverdataeshop.entity.TradeOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 17:42
 * @Version 1.0
 **/
@FeignClient(value = "server-order")
public interface ServerOrderMapper {

    @PostMapping("storehouse/findall")
    public String findStorehouseAll();

    @PostMapping("inventory/findall")
    public String findInventoryAll();

    @PostMapping("info/infocarid")
    public String findCarInfoByCarId(@RequestParam("carid") Long carid);

    @PostMapping("logistics/createtrade")
    public String createOrder(TradeOrder trade);

}
