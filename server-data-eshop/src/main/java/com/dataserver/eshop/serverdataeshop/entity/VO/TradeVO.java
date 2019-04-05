package com.dataserver.eshop.serverdataeshop.entity.VO;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/2 17:40
 * @Version 1.0
 **/
@Data
public class TradeVO {

    /**
     * 交易类型
     */
    private Integer type;
    /**
     * 交易数量
     */
    private Integer num;
    /**
     * 订单数量
     */
    private Integer ordernum;
    /**
     * 货品编号
     */
    private String goodscode;
    /**
     * 订单价格
     */
    private BigDecimal price;
    /**
     * 买家编号1
     */
    private Integer buyuserid;
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
    private List<TradeItemVO> itemVOS;
}
