package com.msclient.logistics.clientlogistics.entity;

import lombok.Data;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/22 22:17
 * @Version 1.0
 **/
@Data
public class StorehouseVO {

    private Long id;
    private String addressdetail;
    private String linkman;
    private String linkmobile;
    private double addresslatitude;
    private double addresslongitude;
    private String wtype;
    private String isactive;


    public StorehouseVO() {
    }

    public StorehouseVO(Long id, String addressdetail, String linkman, String linkmobile, double addresslatitude, double addresslongitude, String wtype, String isactive) {
        this.id = id;
        this.addressdetail = addressdetail;
        this.linkman = linkman;
        this.linkmobile = linkmobile;
        this.addresslatitude = addresslatitude;
        this.addresslongitude = addresslongitude;
        this.wtype = wtype;
        this.isactive = isactive;
    }
}
