package com.dataserver.eshop.serverdataeshop.entity;

import javax.persistence.Id;

/**
 * @author 10169
 * @Description 店铺提货仓库
 * @Date 2019/1/29 23:08
 * @Version 1.0
 **/
public class ShopWarehouse {
    @Id
    private Integer warehouseid;
    private String warehouseaddress;
    private String warehousetype;
}