package com.dataserver.eshop.serverdataeshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/2 11:17
 * @Version 1.0
 **/
@Data
@Entity
@Table(name="shopGoodsSku")
public class ShopGoodSKU {

    @Id
    private String uniqueCode;
    /**
     * sku 编号
     *
     * 非唯一
     */
    private Integer skuId;
    /**
     * 商品编号
     */
    private Integer itemId;
    /**
     * 店铺编号
     */
    private Integer shopId;
    /**
     * 状态
     *
     * 1-正常
     * 2-删除
     */
    private Integer status;
    /**
     * 图片地址
     */
    private String imageURL;
    /**
     * 商品规格
     *
     * 格式：kid[0]-vid[0],kid[1]-vid[1]...kid[n]-vid[n]
     * 例如：20000-3275069,1753146-3485013
     */
    private String properties;
    /**
     * 商品货号（商家为商品设置的外部编号）
     */
    private String goodsNo;
    /**
     * 价格，单位分
     */
    private Integer price;
    /**
     * 库存数量
     */
    @Column(columnDefinition = "int(6) default 0 comment '库存'")
    private Integer quantity;
    /**
     * 商品在付款减库存的状态下，该Sku上未付款的订单数量
     */
    private Integer withHoldQuantity;
    @Column(columnDefinition = "int(6) default 0 comment '销量'")
    private Integer saleNum;
    private Date createTime;
    private Date updateTime;
}
