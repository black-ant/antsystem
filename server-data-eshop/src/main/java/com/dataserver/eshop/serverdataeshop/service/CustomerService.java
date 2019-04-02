package com.dataserver.eshop.serverdataeshop.service;

import com.alibaba.fastjson.JSONObject;
import com.dataserver.eshop.serverdataeshop.common.utils.ObjectUtil;
import com.dataserver.eshop.serverdataeshop.entity.CustomerAddress;
import com.dataserver.eshop.serverdataeshop.entity.VO.CustomerAddressVO;
import com.dataserver.eshop.serverdataeshop.repository.CustomerAddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/2 22:25
 * @Version 1.0
 **/
@Service
public class CustomerService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    CustomerAddressRepository cusAddressrepo;

    public CustomerAddress addCustomerAddress(CustomerAddressVO customerAddressVO) {
        CustomerAddress customerAddress = new CustomerAddress();
        ObjectUtil.copyData(customerAddressVO, customerAddress);
        logger.info(JSONObject.toJSONString(customerAddress));
        customerAddress.setCustomerId(10001);
        customerAddress = cusAddressrepo.save(customerAddress);
        return customerAddress;
    }
}
