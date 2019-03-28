package com.msclient.eshop.clienteshop.service;

import com.msclient.eshop.clienteshop.entity.ShopVO;
import com.msclient.eshop.clienteshop.serverMapper.ShopMapper;
import com.msclient.eshop.clienteshop.utils.JSONUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/2 23:21
 * @Version 1.0
 **/
@Service
public class ShopService extends BaseService{

//    @HystrixCommand(fallbackMethod = "geterror")
    public ShopVO getShop(String shopid){
        ShopVO shopVO = JSONUtils.wrapperToBean(eshopMapper.shopone(shopid),ShopVO.class);
        return shopVO;
    }

    public String shopedit(){
        return eshopMapper.shopEdit(new ShopVO("1","111","1111"),"222","333");
    }

    public String shoppath(){
        return eshopMapper.shopEdit(new ShopVO("2","222","333"),"555","444");
    }

    public String geterror(String shopid){
        return "查找错误"+shopid;
    }
}
