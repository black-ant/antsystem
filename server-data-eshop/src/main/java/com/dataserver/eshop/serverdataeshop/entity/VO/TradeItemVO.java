package com.dataserver.eshop.serverdataeshop.entity.VO;

import java.math.BigDecimal;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/2 17:40
 * @Version 1.0
 **/
public class TradeItemVO {

    private String shopId;
    /**
     * 商品ID
     */
    private Integer itemId;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品总类型
     */
    private Integer goodsType;
    /**
     * 商品类型
     */
    private Integer itemType;
    /**
     * SKU编号
     */
    private Integer skuId;
    /**
     * SKU值
     */
    private String skuPropertiesName;
    /**
     * 商品价格
     */
    private BigDecimal price;
    /**
     * 商品数量
     */
    private BigDecimal num;
    /**
     * 商品备注
     */
    private String buyerMessages;
    /**
     * 商品快照编号
     */
    private String snapshotId;

    //
//    @Column(columnDefinition = "decimal(9,2) default NULL comment '商品总价'")
//    private BigDecimal totalFee;
//
//    @Column(columnDefinition = "decimal(9,2) default NULL comment '优惠金额'")
//    private BigDecimal discountFee;
//
//    @Column(columnDefinition = "decimal(9,2) default NULL comment '实付金额'")
//    private BigDecimal payment;
//
//    @Column(columnDefinition = "decimal(9,2) default NULL comment '退款金额'")
//    private BigDecimal refundedFee;
}
