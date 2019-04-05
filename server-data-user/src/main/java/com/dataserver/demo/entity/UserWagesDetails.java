package com.dataserver.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/5 11:44
 * @Version 1.0
 **/
@Data
@Entity(name = "userWagesDetails")
public class UserWagesDetails {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(columnDefinition = "int(30) COMMENT '所属工资'")
    private Integer wid;
    @Column(columnDefinition = "int(30) COMMENT '员工ID'")
    private Integer userid;
    private Date createDate;
    private Date updateDate;
    @Column(columnDefinition = "int(3) default 0 comment '明细类型'")
    private Integer type;
    @Column(columnDefinition = "int(3) default 0 comment '明细金额'")
    private BigDecimal money;
    @Column(columnDefinition = "varchar(200) default '' comment '明细描述'")
    private String detailsDesc;
    @Column(columnDefinition = "varchar(200) default '' comment '明细备注'")
    private String detailsMsg;
}
