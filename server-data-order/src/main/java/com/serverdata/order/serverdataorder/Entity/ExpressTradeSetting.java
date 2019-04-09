package com.serverdata.order.serverdataorder.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 16:37
 * @Version 1.0
 **/
public class ExpressTradeSetting {

    @Id
    @Column(columnDefinition = "int(3) not null comment '店铺ID'")
    private Integer id;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 是否开通快递发货功能
     */
    private Boolean isExpress;
    /**
     * 计费方式
     *
     * 0-按商品累加运费
     * 1-组合运费（推荐使用）
     */
    private Integer calcType;
    /**
     * 是否支持同城
     */
    private Boolean isLocal;
    /**
     * 是否支持同城定时达
     */
    private Boolean isLocalInTime;
    /**
     * 是否支持自提
     */
    private Boolean isSelf;
}
