package com.serverdata.order.serverdataorder.Entity;

import com.serverdata.order.serverdataorder.Entity.vo.TradeOrderItemVO;
import com.serverdata.order.serverdataorder.Entity.vo.TradeVO;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description 自行配送订单
 * @Date 2019/1/28 23:03
 * @Version 1.0
 **/
@Entity
@Table(name="logisticsOrder")
@Data
public class LogisticsOrder {

    @Id
    @Column(columnDefinition = "varchar(100) default '' comment '物流单ID'")
    private String id;

    @Column(columnDefinition = "varchar(100) default '' comment '店铺ID'")
    private String shopId;

    @Column(columnDefinition = "int(3) default 0 comment '物流类型'")
    private Integer type;

    @Column(columnDefinition = "int(3) default 0 comment '物流状态'")
    private Integer status;

    @Column(columnDefinition = "datetime comment '创建时间'")
    private Date createTime;

    @Column(columnDefinition = "datetime comment '更新时间'")
    private Date updateTime;

    @Column(columnDefinition = "int(3) default 0 comment '关闭类型'")
    private Integer closeType;

    @Column(columnDefinition = "int(6) default 0 comment '货品数量'")
    private Integer num;

    @Column(columnDefinition = "varchar(100) default '' comment '货品编号'")
    private String goodscode;

    @Column(columnDefinition = "decimal(9,2) NOT NULL comment '物流价格'")
    private BigDecimal transfee;

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

    @Column(columnDefinition = "varchar(200) default '' comment '收货收货人姓名'")
    private String delMobile;

    @Column(columnDefinition = "varchar(200) default '' comment '收货地区编号'")
    private String delPlace;

    @Column(columnDefinition = "varchar(200) default '' comment '收货邮编'")
    private String delZip;

    @Column(columnDefinition = "int(3) default 0 comment '收货类型'")
    private Integer delType;

    @Column(columnDefinition = "decimal(9,2) default NULL comment ' 发货时间'")
    private Date consignTime;

    @Column(columnDefinition = "decimal(9,2) default NULL comment ' 签收时间'")
    private Date signTime;

    @OneToMany
    List<LogisticsOrderItem> items;

    public LogisticsOrder() {
    }

    public LogisticsOrder(TradeVO tradeVO) {
        this.type = tradeVO.getType();
        this.status = 0;
        this.num = tradeVO.getNum();
        this.goodscode = tradeVO.getGoodscode();
        this.buyuserid = tradeVO.getBuyuserid();
        this.buyerMessage = tradeVO.getBuyerMessage();
        this.delAddress = tradeVO.getDelAddress();
        this.delAddressDetail = tradeVO.getDelAddressDetail();
        this.delName = tradeVO.getDelName();
        this.delMobile = tradeVO.getDelMobile();
        this.delPlace = tradeVO.getDelPlace();
        this.delZip = tradeVO.getDelZip();
        this.delType = tradeVO.getDelType();
        List<LogisticsOrderItem> items = new LinkedList<>();
        for (TradeOrderItemVO itemVO : tradeVO.getItems()) {
            LogisticsOrderItem item = new LogisticsOrderItem(itemVO);
            items.add(item);
        }
        this.items = items;
    }
}
