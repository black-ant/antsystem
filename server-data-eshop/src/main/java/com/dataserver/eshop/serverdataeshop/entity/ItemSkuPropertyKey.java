package com.dataserver.eshop.serverdataeshop.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/2 15:48
 * @Version 1.0
 **/
@Data
@Entity
@Table(name="itemSkuPropertyKey")
public class ItemSkuPropertyKey {
    /**
     * 属性编号
     */
    @Id
    @GeneratedValue
    @Column(columnDefinition = "Integer(5) NOT NULL comment '属性编号'")
    private Integer id;
    /**
     * 属性文本
     */
    @Column(columnDefinition = "varchar(128) NOT NULL comment '属性文本'")
    private String name;
    /**
     * 添加时间
     */
    @Column(columnDefinition = "datetime comment '添加时间'")
    private Date addTime;
    /**
     * 状态
     */
    @Column(columnDefinition = "Integer(5) NOT NULL comment '状态'")
    private Integer status;
    /**
     * 是否必须
     */
    @Column(columnDefinition = "bit(1) DEFAULT NULL comment '是否必须'")
    private Boolean mustneed;
    /**
     * 是否必须
     */
    @Column(columnDefinition = "bit(1) DEFAULT NULL comment '是否多选'")
    private Boolean ismultiple;
}
