package com.dataserver.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "userplatform")
public class UserPlatform {

    @Id
    @GeneratedValue
    @Column(name = "userid")
    public int userid;
    @Column(name = "username")
    public String username;
    @Column(name = "createdate")
    public Date createdate;
    @Column(name = "type")
    public String type;
    @Column(name = "power")
    public String power;
    @Column(name = "isactive")
    public String isactive;
    @Column(name = "phone")
    public String phone;
    @Column(name = "linkman")
    public String linkman;
    @Column(name = "linkmobile")
    public String linkmobile;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkmobile() {
        return linkmobile;
    }

    public void setLinkmobile(String linkmobile) {
        this.linkmobile = linkmobile;
    }
}
