package com.dataserver.eshop.serverdataeshop.entity.VO;

import lombok.Data;

import javax.persistence.Column;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/2 21:47
 * @Version 1.0
 **/
@Data
public class CustomerAddressVO {

    private Integer customerId;
    private String delAddress;
    private String province;
    private String city;
    private String district;
    private String delAddressDetail;
    private String delName;
    private String delMobile;
    private Integer delType;

}
