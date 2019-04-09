package com.serverdata.order.serverdataorder.Entity.vo;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 17:06
 * @Version 1.0
 **/
@Data
public class TradeOrderItemVO {


    private Integer id;

    private String rid;

    private Integer shopId;

    private Integer status;
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

}
