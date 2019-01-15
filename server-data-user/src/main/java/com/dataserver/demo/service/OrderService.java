package com.dataserver.demo.service;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


/**
 * @Description
 * @author
 * @Date
 * @Version
 **/
@Service
public class OrderService {

    public List<OrderDTO> getOrderList(){
        return new LinkedList<>();
    }
}
