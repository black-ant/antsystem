package com.dataserver.eshop.serverdataeshop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author 10169
 * @Description 参考自 by 芋道源码 -- http://www.iocoder.cn/?vip
 * @Date 2019/4/2 16:54
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "tradeOrderItem")

public class TradeOrderItem {

    @Id
    private String id;

    @Column(columnDefinition = "varchar(100) default '' comment '交易编号'")
    private String rid;

    @Column(columnDefinition = "varchar(100) default '' comment '店铺ID'")
    private String shopId;

    @Column(columnDefinition = "int(10) default 0 comment '交易状态'")
    private Integer status;

    @Column(columnDefinition = "int(100) default 0 comment '商品ID'")
    private Integer itemId;

    @Column(columnDefinition = "varchar(100) default '' comment '商品标题'")
    private String title;

    @Column(columnDefinition = "int(10) default 0 comment '商品总类型'")
    private Integer goodsType;

    @Column(columnDefinition = "int(10) default 0 comment '商品类型'")
    private Integer itemType;

    @Column(columnDefinition = "int(10) default 0 comment 'SKU编号'")
    private Integer skuId;

    @Column(columnDefinition = "int(10) default 0 comment 'SKU值'")
    private String skuPropertiesName;

    @Column(columnDefinition = "decimal(9,2) default NULL comment '商品价格'")
    private BigDecimal price;

    @Column(columnDefinition = "decimal(9,2) default NULL comment '商品数量'")
    private BigDecimal num;

    @Column(columnDefinition = "varchar(100) default '' comment '商品备注'")
    private String buyerMessages;

    @Column(columnDefinition = "varchar(100) default '' comment '商品快照编号'")
    private String snapshotId;

    @Column(columnDefinition = "decimal(9,2) default NULL comment '商品总价'")
    private BigDecimal totalFee;

    @Column(columnDefinition = "decimal(9,2) default NULL comment '优惠金额'")
    private BigDecimal discountFee;

    @Column(columnDefinition = "decimal(9,2) default NULL comment '实付金额'")
    private BigDecimal payment;

    @Column(columnDefinition = "decimal(9,2) default NULL comment '退款金额'")
    private BigDecimal refundedFee;
}
