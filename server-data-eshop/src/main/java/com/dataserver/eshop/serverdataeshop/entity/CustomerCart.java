package com.dataserver.eshop.serverdataeshop.entity;

import com.dataserver.eshop.serverdataeshop.entity.VO.CustomerCartVO;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/4 14:38
 * @Version 1.0
 **/
@Entity
@Data
@Table(name = "customerCart")
public class CustomerCart {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(columnDefinition = "varchar(120) default 0 comment '购物车描述'")
    private String cartdesc;
    @Column(columnDefinition = "int(3) default 0 comment '购物车商品类型'")
    private Integer carttype;
    @Column(columnDefinition = "int(5) default 0 comment '商品ID'")
    private Integer goodsid;
    @Column(columnDefinition = "int(5) default 0 comment '商品SKUID'")
    private Integer skuid;
    @Column(columnDefinition = "int(5) default 0 comment '商品数量'")
    private Integer num;
    @Column(columnDefinition = "int(5) default 0 comment '店铺ID'")
    private Integer shopId;
    /**
     * 状态
     * <p>
     * 1-正常
     * 2-主动删除
     * 3-下单删除
     */
    @Column(columnDefinition = "int(3) default 0 comment '1-正常、2-主动删除、3-下单删除'")
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
    @Column(columnDefinition = "int(5) default 0 comment '买家编号'")
    private Integer buyerId;
    @Column(columnDefinition = "varchar(255) default 0 comment '游客回话ID'")
    private String nobodyKey;
    @Column(columnDefinition = "varchar(255) default 0 comment '交易ID'")
    private String tid;
    @Column(columnDefinition = "datetime default NULL  comment '下单时间'")
    private Date buyTime;
    @Column(columnDefinition = "int(5) default NULL  comment '优惠活动'")
    private Integer activityId;
    @Column(columnDefinition = "int(3) default NULL  comment '优惠类型'")
    private Integer activityType;
    @Column(columnDefinition = "int(3) default NULL  comment '价格快照,用于低于加入价格等活动'")
    private BigDecimal price;

    public CustomerCart() {
    }

    public CustomerCart(CustomerCartVO cartVO) {
        this.cartdesc = cartVO.getCartdesc();
        this.carttype = cartVO.getCarttype();;
        this.goodsid = cartVO.getGoodsid();;
        this.skuid = cartVO.getSkuid();;
        this.shopId = cartVO.getShopId();;
        this.status = 0;;
        this.createTime = new Date();
        this.num = cartVO.getNum();
        this.price = cartVO.getPrice();;
    }
}
