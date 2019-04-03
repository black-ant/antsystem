package com.dataserver.eshop.serverdataeshop.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
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

    private Integer keyid;
    /**
     * 属性文本
     */
    private String value;
    /**
     * 添加时间
     */
    private Date addTime;
}
