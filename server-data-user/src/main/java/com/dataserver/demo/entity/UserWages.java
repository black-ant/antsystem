package com.dataserver.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/5 11:13
 * @Version 1.0
 **/
@Data
@Entity(name = "userWages")
public class UserWages {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(columnDefinition = "int(30) COMMENT '员工ID'")
    private Integer userid;
    private Date createDate;
    private Date startDate;
    private Date endDate;
    @Column(columnDefinition = "double(9,2) COMMENT '基础工资'")
    private BigDecimal basalWages;
    @Column(columnDefinition = "double(9,2) COMMENT '补助工资'")
    private BigDecimal subsidyWages;
    @Column(columnDefinition = "double(9,2) COMMENT '扣除工资'")
    private BigDecimal deductionWages;
    @Column(columnDefinition = "double(9,2) COMMENT '需发工资'")
    private BigDecimal needWages;
    @Column(columnDefinition = "double(9,2) COMMENT '实发工资'")
    private BigDecimal realWages;
    @Column(columnDefinition = "varchar(200) default '' comment '支付流水ID'")
    private String payorderid;
    @Column(columnDefinition = "varchar(200) default '' comment '第三方ID'")
    private String outerTid;
    @Column(columnDefinition = "datetime comment '到账'")
    private BigDecimal arrivalDate;
    @Column(columnDefinition = "datetime comment '更新时间'")
    private Date updateTime;
    @Column(columnDefinition = "int(3) default 0 comment '交易类型'")
    private Integer type;
    @Column(columnDefinition = "int(3) default 0 comment '交易状态'")
    private Integer status;
    @Column(columnDefinition = "int(3) default 0 comment '关闭类型'")
    private Integer closeType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid",insertable = false,updatable = false)
    private List<UserWagesDetails> userWagesDetails;


}
