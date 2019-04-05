package com.dataserver.eshop.serverdataeshop.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/29 22:53
 * @Version 1.0
 **/
@Data
@Entity
@Table(name="Shop")
public class Shop {

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

    public Shop(){

    }

    public Shop(Integer shopid, String shopname, String shopdesc) {
        this.shopid = shopid;
        this.shopname = shopname;
        this.shopdesc = shopdesc;
    }
}
