package com.dataserver.eshop.serverdataeshop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/29 22:49
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "shopgoods")
public class ShopGoods {
    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(100) default '' comment '系统生成唯一ID'")
    private String alias;
    @Column(columnDefinition = "varchar(100) default '' comment '商家自定义货号'")
    private String goodscode;
    @Column(columnDefinition = "varchar(100) default '' comment '店铺ID'")
    private String shopid;

    private Date createDate;
    private Date updateDate;

    private Integer status;
    @Column(columnDefinition = "varchar(100) default '' comment '货品标题'")
    private String goodstitle;
    @Column(columnDefinition = "varchar(255) default '' comment '货品副标题'")
    private String summary;
    @Column(columnDefinition = "varchar(255) default '' comment '货品描述'")
    private String goodsdesc;
    @Column(columnDefinition = "varchar(100) default '' comment '商品类型'")
    private String goodstype;
    @Column(columnDefinition = "varchar(100) default '' comment '商品类别'")
    private String goodscate;
    @Column(columnDefinition = "varchar(100) default '' comment '商品风格'")
    private String goodsstyle;

    private String goodsprice;
    private String volume;
    private String size;
    private String message;

    /**
     * 商品销售状态
     */
    private String saleStaus;
    /**
     * 商品销售类型
     */
    private String saleType;



}
