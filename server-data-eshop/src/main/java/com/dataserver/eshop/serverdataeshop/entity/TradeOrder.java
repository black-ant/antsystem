package com.dataserver.eshop.serverdataeshop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/2 16:39
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "tradeOrder")
public class TradeOrder {

    @Id
    @Column(columnDefinition = "varchar(100) default '' comment '唯一交易ID'")
    private String id;

    @Column(columnDefinition = "varchar(100) default '' comment '店铺ID'")
    private String shopId;

    @Column(columnDefinition = "int(3) default 0 comment '交易类型'")
    private Integer type;

    @Column(columnDefinition = "int(3) default 0 comment '交易状态'")
    private Integer status;

    @Column(columnDefinition = "datetime comment '创建时间'")
    private Date createTime;

    @Column(columnDefinition = "datetime comment '更新时间'")
    private Date updateTime;

    @Column(columnDefinition = "int(3) default 0 comment '关闭类型'")
    private Integer closeType;

    @Column(columnDefinition = "int(6) default 0 comment '交易数量'")
    private Integer num;

    @Column(columnDefinition = "int(3) default 0 comment '订单数量'")
    private Integer ordernum;

    @Column(columnDefinition = "varchar(100) default '' comment '货品编号'")
    private String goodscode;

    @Column(columnDefinition = "decimal(9,2) NOT NULL comment '订单价格'")
    private BigDecimal price;

    @Column(columnDefinition = "int(100) default 0 comment '买家编号1'")
    private Integer buyuserid;

    @Column(columnDefinition = "varchar(200) default '' comment '订单备注'")
    private String buyerMessage;

    @Column(columnDefinition = "varchar(200) default '' comment '收货地址'")
    private String delAddress;

    @Column(columnDefinition = "varchar(200) default '' comment '收货详细地址'")
    private String delAddressDetail;

    @Column(columnDefinition = "varchar(200) default '' comment '收货收货人姓名'")
    private String delName;

    @Column(columnDefinition = "varchar(200) default '' comment '收货地区编号'")
    private String delPlace;

    @Column(columnDefinition = "varchar(200) default '' comment '收货邮编'")
    private String delZip;

    @Column(columnDefinition = "int(3) default 0 comment '收货类型'")
    private Integer delType;

    @Column(columnDefinition = "decimal(9,2) default NULL comment ' 发货时间'")
    private Date consignTime ;

    @Column(columnDefinition = "decimal(9,2) default NULL comment ' 签收时间'")
    private Date signTime;

    @Column(columnDefinition = "varchar(200) default '' comment '支付流水ID'")
    private String payorderid;

    @Column(columnDefinition = "decimal(9,2) default NULL comment '付款时间'")
    private Date payTime ;

    @Column(columnDefinition = "int(3) default 0 comment '支付类型'")
    private Integer payType ;

    @Column(columnDefinition = "varchar(200) default '' comment '第三方ID'")
    private String outerTid ;

    @Column(columnDefinition = "decimal(9,2) default 0 comment '订单总价'")
    private BigDecimal totalFee ;

    @Column(columnDefinition = "decimal(9,2) default 0 comment '配送费'")
    private BigDecimal transfee;

    @Column(columnDefinition = "decimal(9,2) default 0 comment '优惠费用'")
    private BigDecimal discountFee ;

    @Column(columnDefinition = "decimal(9,2) default 0 comment '实付'")
    private BigDecimal realfee;

    @Column(columnDefinition = "decimal(9,2) default 0 comment '退款'")
    private BigDecimal refundedFee  ;
}
