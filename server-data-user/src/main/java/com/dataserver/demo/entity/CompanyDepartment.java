package com.dataserver.demo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/18 22:43
 * @Version 1.0
 **/
@Data
@Entity(name="companyDepartment")
public class CompanyDepartment {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "int(30) COMMENT '部门id'")
    private Long depid;
    @Column(columnDefinition = "varchar(128) COMMENT '部门主管'")
    private Integer depDirector;
    @Column(columnDefinition = "varchar(128) COMMENT '部门联系人姓名'")
    private String depCallUser;
    @Column(columnDefinition = "varchar(128) COMMENT '部门联系电话'")
    private String depMobile;
    @Column(columnDefinition = "varchar(128) COMMENT '部门名称'")
    private String depname;
    @Column(columnDefinition = "varchar(128) COMMENT '部门描述'")
    private String depdes;
    @Column(columnDefinition = "varchar(5) COMMENT '部门类型'")
    private String deptype;
    @Column(columnDefinition = "varchar(128) COMMENT '部门权限'")
    private String power;
    /**
     * 员工总数
     */
    @Transient
    private int usernum;
    /**
     * 小组总数
     */
    @Transient
    private int groupnum;
    /**
     * 在职员工总数
     */
    @Transient
    private int inworknum;
}
