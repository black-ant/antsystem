package com.dataserver.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/18 22:43
 * @Version 1.0
 **/
@Data
@Entity(name="department")
public class Department {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "int(30) COMMENT '部门id'")
    private Long depid;
    @Column(columnDefinition = "varchar(128) COMMENT '部门名称'")
    private String depname;
    @Column(columnDefinition = "varchar(128) COMMENT '部门描述'")
    private String depdes;
    @Column(columnDefinition = "varchar(5) COMMENT '部门类型'")
    private String deptype;
    @Column(columnDefinition = "varchar(128) COMMENT '部门权限'")
    private String power;
}
