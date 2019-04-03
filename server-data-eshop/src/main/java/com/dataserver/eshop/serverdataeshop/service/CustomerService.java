package com.dataserver.eshop.serverdataeshop.service;

import com.alibaba.fastjson.JSONObject;
import com.dataserver.eshop.serverdataeshop.common.utils.ObjectUtil;
import com.dataserver.eshop.serverdataeshop.entity.Customer;
import com.dataserver.eshop.serverdataeshop.entity.CustomerAddress;
import com.dataserver.eshop.serverdataeshop.entity.VO.CustomerAddressVO;
import com.dataserver.eshop.serverdataeshop.repository.CustomerAddressRepository;
import com.dataserver.eshop.serverdataeshop.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    CustomerRepository cusrepo;

    public CustomerAddress addCustomerAddress(CustomerAddressVO customerAddressVO) {
        CustomerAddress customerAddress = new CustomerAddress();
        ObjectUtil.copyData(customerAddressVO, customerAddress);
        logger.info(JSONObject.toJSONString(customerAddress));
        customerAddress.setCustomerId(10001);
        customerAddress = cusAddressrepo.save(customerAddress);
        return customerAddress;
    }

    public List<CustomerAddressVO> findCustomerAddressList(Integer userid, String filter) {
        List<CustomerAddress> customerAddress = cusAddressrepo.findByCustomerId(userid);
        List<CustomerAddressVO> vos = customerAddress.stream().map(vo -> new CustomerAddressVO(vo)).collect(Collectors.toList());
        return vos;
    }

    public CustomerAddressVO findDefaultAddress(Integer userid, String filter) {
        Customer customer = cusrepo.findById(userid);
        logger.info("json address:{}", customer.getDefaultAddressId());
        CustomerAddressVO customerAddress = new CustomerAddressVO(cusAddressrepo.findById(customer.getDefaultAddressId()));
        return customerAddress;
    }
}
