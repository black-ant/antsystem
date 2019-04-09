package com.dataserver.eshop.serverdataeshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/3 16:53
 * @Version 1.0
 **/
@Data
@Entity
@Table(name="itemSkuPropertyValue")
public class ItemSkuPropertyValue {
    /**
     * 属性编号
     */
    @Id
    @GeneratedValue
    private Integer id;
    @Column(columnDefinition = "int(5) NOT NULL comment '对应属性KEY'")
    private Integer keyid;
    /**
     * 属性文本
     */
    @Column(columnDefinition = "varchar(128) NOT NULL comment '属性文本'")
    private String value;
    /**
     * 添加时间
     */
    @Column(columnDefinition = "datetime comment '添加时间'")
    private Date addTime;
    /**
     * 数据类型
     */
    @Column(columnDefinition = "int(5) default 0 comment '数据类型'")
    private Integer datatype;
}
