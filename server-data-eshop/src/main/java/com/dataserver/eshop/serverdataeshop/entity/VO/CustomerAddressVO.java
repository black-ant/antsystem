package com.dataserver.eshop.serverdataeshop.entity.VO;

import com.dataserver.eshop.serverdataeshop.entity.CustomerAddress;
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

    private Integer id;
    private Integer customerId;
    private String delAddress;
    private String province;
    private String city;
    private String district;
    private String delAddressDetail;
    private String delName;
    private String delMobile;
    private Integer delType;

    public CustomerAddressVO(Integer id,String type) {
        this.id =id;
        this.customerId = 111;
        this.delAddress = type;
    }

    public CustomerAddressVO(CustomerAddress customerAddress) {
        this.id = customerAddress.getId();
        this.customerId = customerAddress.getCustomerId();
        this.delAddress = customerAddress.getDelAddress();
        this.province = customerAddress.getProvince();
        this.city = customerAddress.getCity();
        this.district = customerAddress.getDistrict();
        this.delAddressDetail = customerAddress.getDelAddressDetail();
        this.delName = customerAddress.getDelName();
        this.delMobile = customerAddress.getDelMobile();
        this.delType = customerAddress.getDelType();
    }
}
