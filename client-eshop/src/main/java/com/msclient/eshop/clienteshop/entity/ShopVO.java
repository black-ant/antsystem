package com.msclient.eshop.clienteshop.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/2 23:24
 * @Version 1.0
 **/
@Component
@Data
public class ShopVO {

    public String shopid;
    public String shopname;
    public String shopboss;

    public ShopVO() {
    }

    public ShopVO(String shopid, String shopname, String shopboss) {
        this.shopid = shopid;
        this.shopname = shopname;
        this.shopboss = shopboss;
    }
}
