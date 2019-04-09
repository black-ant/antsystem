package com.dataserver.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 14:28
 * @Version 1.0
 **/
@Data
@Entity(name="userWarehouseMapper")
public class UserWarehouseMapper {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(columnDefinition = "int(5) NOT NULL  comment '用户ID'")
    private Integer userid;
    @Column(columnDefinition = "int(5) NOT NULL  comment '仓库ID'")
    private Integer warehouseid;
    @Column(columnDefinition = "int(5) NOT NULL  comment '员工状态 1 在职 2 休假 9 离职'")
    private Integer status;
    @Column(columnDefinition = "datetime comment '创建时间，入职时间'")
    private Date startDate;
    @Column(columnDefinition = "datetime comment '结束时间'")
    private Date endDate;
    @Column(columnDefinition = "int(1) NOT NULL  comment '用户类型,1 平台 2 外包'")
    private Integer usertype;
}
