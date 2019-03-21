package com.serverdata.order.serverdataorder.Entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/21 21:53
 * @Version 1.0
 **/
@Data
@Entity
@Table(name="storehouse")
public class Storehouse {

    @Id
    private Long id;
    private String addressdetail;
    private String linkman;
    private String linkmobile;
    private double addresslatitude;
    private double addresslongitude;
    private String wtype;
    private String isactive;
}
