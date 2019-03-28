package com.msclient.logistics.clientlogistics.entity;

import lombok.Data;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/27 15:27
 * @Version 1.0
 **/
@Data
public class CarVO {

    private Long carId;
    private String carAddress;
    private Double longitude;
    private Double latitude;
    private String carplate;

    public CarVO() {
    }

    public CarVO(Long carId, Double longitude, Double latitude) {
        this.carId = carId;
        this.carAddress = "武汉市硚口区";
        this.longitude = longitude;
        this.latitude =latitude;
    }
}
