package com.msclient.logistics.clientlogistics.entity;

import lombok.Data;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 14:16
 * @Version 1.0
 **/
@Data
public class StoreUserVO {

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

}
