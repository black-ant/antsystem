package com.serverauthcenter.demo.entity;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/17 22:22
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
