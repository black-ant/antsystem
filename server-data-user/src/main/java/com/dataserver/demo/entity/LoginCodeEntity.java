package com.dataserver.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/16 22:07
 * @Version 1.0
 **/
@Data
@Entity(name = "login_code")
public class LoginCodeEntity {

    @Id
    @GeneratedValue
    private Long sn;
    private String userid;
    private String mobile;
    private String logincode;
    private String startdate;
    private String enddate;
}
