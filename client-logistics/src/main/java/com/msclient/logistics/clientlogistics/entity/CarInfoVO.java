package com.msclient.logistics.clientlogistics.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/27 15:20
 * @Version 1.0
 **/
@Data
public class CarInfoVO {

    private Long sn;
    private Long carId;
    private Long driverId;
    private String address;
    private Date createDate;
    private Double longitude;
    private Double latitude;
}
