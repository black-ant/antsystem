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
 * @Date 2019/1/16 21:42
 * @Version 1.0
 **/
@Entity(name="user_log")
@Data
public class UserLogEntity {

    @Id
    @GeneratedValue
    @Column(name = "sn")
    private Integer sn;
    @Column(name = "userid")
    private String userid;
    @Column(name = "createdate")
    private Date createdate;
    @Column(name = "logtype")
    private String logtype;
    @Column(name = "logip")
    private String logip;
    @Column(name = "remarks")
    private String remarks;

}
