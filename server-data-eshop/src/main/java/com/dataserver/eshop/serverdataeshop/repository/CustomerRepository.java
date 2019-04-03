package com.dataserver.eshop.serverdataeshop.repository;

import com.dataserver.eshop.serverdataeshop.entity.Customer;
import com.dataserver.eshop.serverdataeshop.entity.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/3 12:57
 * @Version 1.0
 **/
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findById(Integer id);
}
