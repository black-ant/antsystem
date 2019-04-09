package com.serverdata.order.serverdataorder.Entity;

import com.serverdata.order.serverdataorder.Entity.vo.TradeOrderItemVO;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/28 23:04
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "logisticsOrderItem")
public class LogisticsOrderItem {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(columnDefinition = "int(3) default 0 comment '配送总单'")
    private String lid;

    @Column(columnDefinition = "varchar(25) default 0 comment '店铺ID'")
    private Integer shopId;

    @Column(columnDefinition = "int(3) default 0 comment '货品状态'")
    private Integer status;

    @Column(columnDefinition = "int(4) default 0 comment '商品ID'")
    private Integer itemId;

    @Column(columnDefinition = "varchar(100) default '' comment '商品标题'")
    private String title;

    @Column(columnDefinition = "int(3) default 0 comment '商品总类型'")
    private Integer goodsType;

    @Column(columnDefinition = "int(3) default 0 comment '商品类型'")
    private Integer itemType;

    @Column(columnDefinition = "int(5) default 0 comment 'SKU编号'")
    private Integer skuId;

    @Column(columnDefinition = "int(5) default 0 comment 'SKU值'")
    private String skuPropertiesName;

    @Column(columnDefinition = "decimal(9,2) default 0 comment '配送价格'")
    private BigDecimal transfee;

    @Column(columnDefinition = "decimal(9,2) default NULL comment '商品数量'")
    private BigDecimal num;

    @Column(columnDefinition = "varchar(100) default '' comment '商品备注'")
    private String buyerMessages;

    @Column(columnDefinition = "varchar(100) default '' comment '商品快照编号'")
    private String snapshotId;

    @Column(columnDefinition = "datetime comment '创建时间'")
    private Date createTime;

    @Column(columnDefinition = "datetime comment '更新时间'")
    private Date updateTime;

    public LogisticsOrderItem() {
    }

    public LogisticsOrderItem(TradeOrderItemVO tradeItemVO) {
        this.shopId = tradeItemVO.getShopId();
        this.status = 0;
        this.itemId = tradeItemVO.getItemId();
        this.title = tradeItemVO.getTitle();
        this.goodsType = tradeItemVO.getGoodsType();
        this.itemType = tradeItemVO.getItemType();
        this.skuId = tradeItemVO.getSkuId();
        this.skuPropertiesName = tradeItemVO.getSkuPropertiesName();
        this.transfee = tradeItemVO.getPrice();
        this.num = tradeItemVO.getNum();
        this.buyerMessages = tradeItemVO.getBuyerMessages();
        this.snapshotId = tradeItemVO.getSnapshotId();
    }
}
