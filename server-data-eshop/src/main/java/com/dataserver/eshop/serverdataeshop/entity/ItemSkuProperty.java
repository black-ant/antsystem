package com.dataserver.eshop.serverdataeshop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 10169
 * @Description Item SKU 规格属性 , 用于对规格进行名词规划  / 暂时未用
 * @Date 2019/4/3 16:41
 * @Version 1.0
 **/
@Data
@Entity
@Table(name="itemSkuProperty")
public class ItemSkuProperty {

    /**
     * 属性编号
     */
    @Id
    @Column(columnDefinition = "int(3) default 0 comment '规格编号'")
    private Integer id;
    /**
     * 属性文本 : 均码 ， 颜色  ---以及 红色 ， 黄色  ,大码
     */
    @Column(columnDefinition = "varchar(100) default '' comment '属性文本'")
    private String name;
    /**
     * 添加时间
     */
    private Date addTime;
}
