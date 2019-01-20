package com.dataserver.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@Entity(name = "user_platform")
public class UserPlatformEntity {

    @Id
    @GeneratedValue
    private Long userid;
    private String username;
    @Size(max = 3)
    private String userage;
    @Size(max = 1)
    private Boolean usersex;
    private String systemname;
    private String usertype;
    private String department;
    private String userlevel;
    private String systemdesc;
    private Date createdate;
    private String status;
    private String useraccount;
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private List<UserRolesEntity> userroles;


}
