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
    private Long sn;
    private Long useid;
    private String username;
    private String userfrom;
    private String userstatus;



}
