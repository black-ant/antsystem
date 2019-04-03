package com.dataserver.eshop.serverdataeshop.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 10169
 * @Description 店铺提货仓库
 * @Date 2019/1/29 23:08
 * @Version 1.0
 **/
@Data
@Entity
@Table(name="shopWarehouse")
public class ShopWarehouse {
    @Id
    private Integer warehouseid;
    private String warehouseaddress;
    private String warehousetype;
}
