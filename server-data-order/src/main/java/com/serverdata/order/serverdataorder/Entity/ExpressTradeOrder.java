package com.serverdata.order.serverdataorder.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 16:16
 * @Version 1.0
 **/
public class ExpressTradeOrder {

    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 交易编号 {@link cn.iocoder.doraemon.tradegroup.trade.entity.Trade#id}
     */

    private String tid;
    /**
     * 交易明细编号 {@link cn.iocoder.doraemon.tradegroup.trade.entity.TradeOrder#id}
     */
    private Long oid;
    /**
     * 快递单号
     */
    private String nu;
    /**
     * 快递公司编号
     */
    private Integer expressId;
    /**
     * 状态
     *
     * 1-正常
     * 2-删除
     */
    private Integer status;
    /**
     * 发货时间
     */
    private Date createTime;
    /**
     * 删除时间
     */
    private Date deleteTime;
}
