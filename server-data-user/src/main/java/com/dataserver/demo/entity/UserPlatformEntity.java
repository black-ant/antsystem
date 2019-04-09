package com.dataserver.demo.entity;

import com.dataserver.demo.entity.dto.PlatformUserDTO;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 14:44
 * @Version 1.0
 **/
@Data
@Entity
@Table(name = "user_platform")
public class UserPlatformEntity {

    @Id
    @GeneratedValue
    private Integer userid;
    private String username;
    @Size(max = 3)
    private String userage;
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

    public UserPlatformEntity(){}

    public UserPlatformEntity(PlatformUserDTO platformUserDTO){
        this.username = platformUserDTO.getUsername();
        this.usersex = platformUserDTO.getSex();
        this.usertype = platformUserDTO.getType();
        this.status = platformUserDTO.getStatus();
    }
}

