package com.msclient.logistics.clientlogistics.ServerMapper;


import com.msclient.logistics.clientlogistics.entity.StorehouseVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/22 23:20
 * @Version 1.0
 **/
@FeignClient(value = "server-order", fallback = ServerOrderFailBack.class)
public interface ServerOrderMapper {

    @PostMapping("storehouse/findall")
    public String findStorehouseAll();

    @PostMapping("inventory/findall")
    public String findInventoryAll();

    @PostMapping("info/infocarid")
    public String findCarInfoByCarId(@RequestParam("carid") Long carid);

    @PostMapping("logistics/findallorder")
    public String findallLogisticsOrder(@RequestParam("type") String type);

    @PostMapping("storehouse/saveone")
    public String saveOneStorehouse(@RequestBody StorehouseVO storehouse);
}
