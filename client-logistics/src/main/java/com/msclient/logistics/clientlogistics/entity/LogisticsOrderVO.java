package com.msclient.logistics.clientlogistics.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 19:57
 * @Version 1.0
 **/
@Data
public class LogisticsOrderVO {

    /**
     * 物流单ID
     */
    private String id;
    /**
     * 店铺ID
     */
    private String shopId;
    /**
     * 物流类型
     */
    private Integer type;
    /**
     * 物流状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 关闭类型
     */
    private Integer closeType;
    /**
     * 货品数量
     */
    private Integer num;
    /**
     * 货品编号
     */
    private String goodscode;
    /**
     * 物流价格
     */
    private BigDecimal transfee;
    /**
     * 买家编号1
     */
    private Integer buyuserid;
    /**
     * 买家编号1
     */
    private String procode;
    /**
     * 订单备注
     */
    private String buyerMessage;
    /**
     * 收货地址
     */
    private String delAddress;
    /**
     * 收货详细地址
     */
    private String delAddressDetail;
    /**
     * 收货收货人姓名
     */
    private String delName;
    /**
     * 收货收货人姓名
     */
    private String delMobile;
    /**
     * 收货地区编号
     */
    private String delPlace;
    /**
     * 收货邮编
     */
    private String delZip;
    /**
     * 收货类型
     */
    private Integer delType;
    /**
     * 发货时间
     */
    private Date consignTime;
    /**
     * 签收时间
     */
    private Date signTime;

    List<LogisticsItemVO> items;
}
