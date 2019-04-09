package com.msclient.logistics.clientlogistics.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 19:59
 * @Version 1.0
 **/
@Data
public class LogisticsItemVO {



    private Integer id;
    /**
     * 配送总单
     */
    private String lid;
    /**
     * 店铺ID
     */
    private Integer shopId;
    /**
     * 货品状态
     */
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
     * 配送价格
     */
    private BigDecimal transfee;
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
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

}
