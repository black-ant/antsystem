package com.platform.platformclient.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/14 21:50
 * @Version 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name="authority")
public class AuthorityEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String value;
}
