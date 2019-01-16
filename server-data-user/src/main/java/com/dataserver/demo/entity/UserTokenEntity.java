package com.dataserver.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/16 22:06
 * @Version 1.0
 **/
@Data
@Entity(name="user_token")
public class UserTokenEntity {

    @Id
    @GeneratedValue
    private Long userid;
    private String devicetype;
    private String deviceid;
    private String token;
    private String tokenseed;
    private Date failuredate;
    private Date updatedate;
    private String status;
    private String loginip;

}
