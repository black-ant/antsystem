package com.serverdata.order.serverdataorder.Entity.vo;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 16:57
 * @Version 1.0
 **/
@Data
public class TradeVO {
    private String id;
    private String shopId;
    private Integer type;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;


    private Date updateTime;

    /**
     * 关闭类型
     */
    private Integer closeType;

    /**
     * 交易数量
     */
    private Integer num;


    /**
     * 货品编号
     */
    private String goodscode;

    /**
     * 买家编号1
     */
    private Integer buyuserid;
    /**
     * 订单备注
     */
    @Column(columnDefinition = "varchar(200) default '' comment '订单备注'")
    private String buyerMessage;
    /**
     * 收货地址
     */
    @Column(columnDefinition = "varchar(200) default '' comment '收货地址'")
    private String delAddress;
    /**
     * 收货详细地址
     */
    @Column(columnDefinition = "varchar(200) default '' comment '收货详细地址'")
    private String delAddressDetail;
    /**
     * 收货收货人姓名
     */
    @Column(columnDefinition = "varchar(200) default '' comment '收货收货人姓名'")
    private String delName;
    /**
     * 收货地区编号
     */
    @Column(columnDefinition = "varchar(200) default '' comment '才'")
    private String delMobile;
    /**
     * 收货地区编号
     */
    @Column(columnDefinition = "varchar(200) default '' comment '收货地区编号'")
    private String delPlace;
    /**
     * 收货邮编
     */
    @Column(columnDefinition = "varchar(200) default '' comment '收货邮编'")
    private String delZip;
    /**
     * 收货类型
     */
    @Column(columnDefinition = "int(3) default 0 comment '收货类型'")
    private Integer delType;
    /**
     * 发货时间
     */
    @Column(columnDefinition = "decimal(9,2) default NULL comment ' 发货时间'")
    private Date consignTime;
    /**
     * 签收时间
     */
    @Column(columnDefinition = "decimal(9,2) default NULL comment ' 签收时间'")
    private Date signTime;
    /**
     * 订单备注
     */
    @Column(columnDefinition = "varchar(200) default '' comment '支付流水ID'")
    private String payorderid;
    /**
     * 订单总价
     */
    @Column(columnDefinition = "decimal(9,2) default 0 comment '订单总价'")
    private BigDecimal totalFee;
    /**
     * 配送费
     */
    @Column(columnDefinition = "decimal(9,2) default 0 comment '配送费'")
    private BigDecimal transfee;
    /**
     * 优惠费用
     */
    private BigDecimal discountFee;
    /**
     * 退款
     */
    private BigDecimal refundedFee;
    /**
     * 订单备注
     */
    private List<TradeOrderItemVO> items;


}
