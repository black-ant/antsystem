package com.dataserver.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/5 11:10
 * @Version 1.0
 **/
@Data
@Entity(name="companyGroup")
public class CompanyGroup {


    @Id
    @GeneratedValue
    private Integer id;
    @Column(columnDefinition = "int(30) COMMENT '部门id'")
    private Integer did;
    @Column(columnDefinition = "varchar(128) COMMENT '小组名称'")
    private String groupName;
    @Column(columnDefinition = "varchar(128) COMMENT '小组描述'")
    private String groupDesc;
    @Column(columnDefinition = "varchar(5) COMMENT '小组类型'")
    private String groupType;
    @Column(columnDefinition = "varchar(128) COMMENT '部门权限'")
    private String power;
}
