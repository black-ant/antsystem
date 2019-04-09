package com.serverdata.order.serverdataorder.Entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 16:19
 * @Version 1.0
 **/
public class ExpressTradeTemplate {
    /**
     * 运费规范
     */
    public static class ValueRule {

        /**
         * 地区编号数组
         */
        private List<String> regions;
        /**
         * 首件数量，单位根据 {@link #valuationType}
         */
        private Integer firstAmount;
        /**
         * 首件运费，单位：分
         */
        private Integer firstFee;
        /**
         * 续件数量，单位根据 {@link #valuationType}
         */
        private Integer additionalAmount;
        /**
         * 续件运费，单位：分
         */
        private Integer additionalFee;

    }

    /**
     * 模板编号
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 店铺编号
     */
    private Integer shopId;

    @Column(columnDefinition = "varchar(100) not null comment '模板描述'")
    private String name;

    @Column(columnDefinition = "varchar(200) default '' comment '模板描述'")
    private String desc;

    @Column(columnDefinition = "int(2) default 1 comment '状态,1正常 ,2 删除'")
    private Integer status;

    @Column(columnDefinition = "int(2) default 1 comment '当前使用情况 , 当使用情况>0 时 ，不可删除'")
    private Integer useCount;
    @Column(columnDefinition = "int(2) default 1 comment '付费方式 , 1 卖家付费 2 货到付款'")
    private Integer payType;

    @Column(columnDefinition = "int(2) default 1 comment '是否包邮 , 0 不包邮 1 包邮 2 部分包邮'")
    private Integer freeType;

    /**
     * 计算类型
     * <p>
     * 1-按件
     * 2-按重量
     * 3-按体积
     */
    @Column(columnDefinition = "int(2) default 1 comment '计费标准 , 1 按件 2 按重量 3 按体积'")
    private Integer valuationType;
    /**
     * 运费规则数组
     * <p>
     * 使用 JSON 将 {@link ValueRule}数组 格式化成字符串
     */

    private String valuationRules;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除时间
     */
    private Integer deleteTime;
}
