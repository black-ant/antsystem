package com.dataserver.demo.entity.dto;

import com.alibaba.fastjson.JSONObject;
import com.dataserver.demo.entity.UserPlatformEntity;
import com.dataserver.demo.entity.UserSourceEntity;
import com.dataserver.demo.entity.UserWarehouseMapper;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 14:44
 * @Version 1.0
 **/
@Data
public class WarehouseUserDTO {

    private Integer userid;
    private String username;
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
    private Integer warehouseid;
    private Integer warestatus;
    private Date startDate;
    private Date endDate;
    private Integer usertypeFrom;

    public WarehouseUserDTO() {
    }

    public WarehouseUserDTO(UserPlatformEntity user, UserWarehouseMapper mapper) {
        System.out.println("platform exchange "+ JSONObject.toJSONString(user));
        this.userid = user.getUserid();
        this.username = user.getUsername();
        this.userage = user.getUserage();
        this.usersex = user.getUsersex();
        this.systemname = user.getSystemname();
        this.usertype = user.getUsertype();
        this.department = user.getDepartment();
        this.userlevel = user.getUserlevel();
        this.systemdesc = user.getSystemdesc();
        this.createdate = user.getCreatedate();
        this.status = user.getStatus();
        this.useraccount = user.getUseraccount();
        this.warehouseid = mapper.getWarehouseid();
        this.warestatus = mapper.getStatus();
        this.startDate = mapper.getStartDate();
        this.endDate = mapper.getEndDate();
        this.usertypeFrom = mapper.getUsertype();
    }

    public WarehouseUserDTO(UserSourceEntity user, UserWarehouseMapper mapper) {
        System.out.println("source exchange"+ JSONObject.toJSONString(user));
        this.userid = user.getUserid();
        this.username = user.getUsername();
        this.userage = user.getUserage();
        this.usersex = user.getUsersex();
        this.systemname = user.getSystemname();
        this.usertype = user.getUsertype();
        this.userlevel = user.getCompanylevel();
        this.systemdesc = user.getSystemdesc();
        this.createdate = user.getCreatedate();
        this.status = user.getStatus();
        this.useraccount = user.getUseraccount();
        this.warehouseid = mapper.getWarehouseid();
        this.warestatus = mapper.getStatus();
        this.startDate = mapper.getStartDate();
        this.endDate = mapper.getEndDate();
        this.usertypeFrom = mapper.getUsertype();
    }
}
