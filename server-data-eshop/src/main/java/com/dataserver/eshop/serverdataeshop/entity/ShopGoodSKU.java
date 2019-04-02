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
 * @Date 2019/4/2 11:17
 * @Version 1.0
 **/
@Data
@Entity
@Table(name="shopGoodsku")
public class ShopGoodSKU {

    @Id
    @GeneratedValue
    private Long sn;
    private Integer gid;
    private String propertyName;
    private String propertyDesc;
    private String propertyType;
    private Date createDate;
}
