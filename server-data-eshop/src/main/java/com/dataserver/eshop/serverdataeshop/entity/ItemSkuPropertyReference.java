package com.dataserver.eshop.serverdataeshop.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 10169
 * @Description key value 对应表 , 用于和SKU绑定
 * @Date 2019/4/3 16:56
 * @Version 1.0
 **/
@Data
@Entity
@Table(name="itemSkuPropertyReference")
public class ItemSkuPropertyReference {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer goodsid;
    private Integer skukeyid;
    private Integer skuvalueid;
    private Boolean issku;
    private Integer skuid;
    private Date addTime;
}
