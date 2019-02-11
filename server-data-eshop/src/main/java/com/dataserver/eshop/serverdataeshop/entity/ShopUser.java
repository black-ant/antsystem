package com.dataserver.eshop.serverdataeshop.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 10169
 * @Description 店铺操作人员
 * @Date 2019/1/29 23:12
 * @Version 1.0
 **/
@Entity
@Table(name="shopuser")
@Data
public class ShopUser {

    @Id
    @GeneratedValue
    private int userid;
    private String username;
    private String userdesc;
    private String status;
    private String level;
    private String remarks;

}
