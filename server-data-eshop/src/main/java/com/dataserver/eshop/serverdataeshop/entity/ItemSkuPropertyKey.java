package com.dataserver.eshop.serverdataeshop.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/2 15:48
 * @Version 1.0
 **/
@Data
//@Entity
//@Table(name="itemSkuPropertyKey")
public class ItemSkuPropertyKey {
    /**
     * 属性编号
     */
    private Integer id;
    /**
     * 属性文本
     */
    private String name;
    /**
     * 添加时间
     */
    private Date addTime;
}
