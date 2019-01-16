package com.dataserver.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/16 22:02
 * @Version 1.0
 **/
@Data
@Entity(name="user_roles")
public class UserRolesEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String role;
}
