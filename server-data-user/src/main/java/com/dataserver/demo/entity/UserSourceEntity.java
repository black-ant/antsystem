package com.dataserver.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/16 21:41
 * @Version 1.0
 **/
@Data
@Entity(name="user_source")
public class UserSourceEntity {

    @Id
    @GeneratedValue
    private Long userid;
    private String username;
    @Size(max = 3)
    private String userage;
    @Size(max = 1)
    private Boolean usersex;
    private String systemname;
    private String systemdesc;
    private String createuser;
    private Date createdate;
    private String usercompany;
    private String companymobile;
    private String companylevel;
    private String status;
    private String usertype;
    private String useraccount;
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<UserRolesEntity> userroles;
}
