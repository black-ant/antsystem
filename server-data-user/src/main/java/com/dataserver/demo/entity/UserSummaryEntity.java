package com.dataserver.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/16 21:42
 * @Version 1.0
 **/

@Data
@Entity(name="user_summary")
public class UserSummaryEntity {

    @Id
    @GeneratedValue
    private Integer sn;
    private int userid;
    private String username;
    private String password;
    private String userfrom;
    private String userstatus;

    public UserSummaryEntity(){

    }

    public UserSummaryEntity(int userid, String username, String userfrom, String userstatus, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.userfrom = userfrom;
        this.userstatus = userstatus;
    }
}
