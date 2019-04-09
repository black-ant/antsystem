package com.dataserver.eshop.serverdataeshop.entity;

import lombok.Data;

import javax.persistence.*;
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
    @Column(columnDefinition = "int(5) NOT NULL comment '对应店铺ID'")
    private Integer shopid;
    @Column(columnDefinition = "int(15) NOT NULL comment '对应商品ID'")
    private Integer goodsid;
    @Column(columnDefinition = "int(5) NOT NULL comment '对应属性KEY'")
    private Integer skukeyid;
    @Column(columnDefinition = "int(5) NOT NULL comment '对应属Value'")
    private Integer skuvalueid;
    @Column(columnDefinition = "tinyint(1) NOT NULL comment '是否为SKU'")
    private Boolean issku;
    @Column(columnDefinition = "int(5) NOT NULL comment 'skuid'")
    private Integer skuid;
    private Date addTime;
}
