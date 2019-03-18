package com.platform.platformclient.entity.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/18 22:36
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
