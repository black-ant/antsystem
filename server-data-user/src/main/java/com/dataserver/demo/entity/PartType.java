package com.dataserver.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/18 22:49
 * @Version 1.0
 **/
@Data
@Entity(name="part_type")
public class PartType {

    @Id
    @Column(columnDefinition = "int(30) COMMENT '角色ID'")
    private Long pid;
    @Column(columnDefinition = "varchar(128) COMMENT '角色名称'")
    private String pname;
    @Column(columnDefinition = "varchar(128) COMMENT '角色描述'")
    private String pdes;
    @Column(columnDefinition = "varchar(5) COMMENT '角色类型'")
    private String ptype;
    @Column(columnDefinition = "varchar(128) COMMENT '角色权限'")
    private String power;
}
