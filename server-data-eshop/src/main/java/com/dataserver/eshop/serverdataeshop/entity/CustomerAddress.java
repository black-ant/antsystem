package com.dataserver.eshop.serverdataeshop.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/2 18:02
 * @Version 1.0
 **/
@Entity
@Data
@Table(name="customerAddress")
public class CustomerAddress {

    @Id
    @GeneratedValue
    private Integer id;
    private Integer customerId;

    @Column(columnDefinition = "varchar(200) default '' comment '收货地址'")
    private String delAddress;
    @Column(columnDefinition = "varchar(200) default '' comment '收货地址省份'")
    private String province;
    @Column(columnDefinition = "varchar(200) default '' comment '收货地址城市'")
    private String city;
    @Column(columnDefinition = "varchar(200) default '' comment '收货地址区域'")
    private String district;
    @Column(columnDefinition = "varchar(200) default '' comment '收货详细地址'")
    private String delAddressDetail;
    @Column(columnDefinition = "varchar(200) default '' comment '收货收货人姓名'")
    private String delName;
    @Column(columnDefinition = "varchar(200) default '' comment '收货收货人姓名'")
    private String delMobile;
    @Column(columnDefinition = "varchar(200) default '' comment '收货地区编号'")
    private String delPlace;
    @Column(columnDefinition = "varchar(200) default '' comment '收货邮编'")
    private String delZip;
    @Column(columnDefinition = "int(4) default 0 comment '收货类型'")
    private Integer delType;
    @Column(columnDefinition = "double(6,6) default 0 comment '纬度'")
    private double latitude;
    @Column(columnDefinition = "double(6,6) default 0 comment '经度'")
    private double longitude;


}
