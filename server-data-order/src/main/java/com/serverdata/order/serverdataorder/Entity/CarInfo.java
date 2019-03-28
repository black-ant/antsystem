package com.serverdata.order.serverdataorder.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/27 15:07
 * @Version 1.0
 **/

@Entity
@Data
@Table(name="carinfo")
public class CarInfo {

    @Id
    @GeneratedValue
    private Long sn;
    private Long carId;
    private Long driverId;
    private String address;
    private Date createDate;
    private Double longitude;
    private Double latitude;

}
