package com.platform.platformclient.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/17 23:13
 * @Version 1.0
 **/


@Data
@Entity(name="shop")
public class ShopEntity {
    @Id
    private Integer shopid;
    private String shopname;
    private Integer shopstatus;
    private Integer shoplevel;
    private String linkman;
    private String linkphone;
    private String shopdesc;
    private Integer createuser;
    private Date createdate;
    private Date logindate;

    public ShopEntity(){

    }

    public ShopEntity(Integer shopid, String shopname, String shopdesc) {
        this.shopid = shopid;
        this.shopname = shopname;
        this.shopdesc = shopdesc;
    }
}
