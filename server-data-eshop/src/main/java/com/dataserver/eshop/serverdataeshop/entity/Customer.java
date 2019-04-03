package com.dataserver.eshop.serverdataeshop.entity;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/2 18:02
 * @Version 1.0
 **/
@Entity
@Data
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(columnDefinition = "int(5) default 0 comment '顾客平台等级'")
    private Integer level;
    @Column(columnDefinition = "varchar(100) default '' comment '顾客姓名'")
    private String name;
    @Column(columnDefinition = "varchar(100) default '' comment '顾客电话'")
    private String mobile;
    @Column(columnDefinition = "varchar(100) default '' comment '顾客年龄'")
    private Integer age;
    @Column(columnDefinition = "int(5) default '' comment '默认地址'")
    private Integer defaultAddressId;
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customerId", referencedColumnName = "id", insertable = false, updatable = false, nullable = true)
//    @NotFound(action = NotFoundAction.IGNORE)
//    private CustomerAddress customerAddress;
}
