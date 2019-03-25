package com.serverdata.order.serverdataorder.service;

import com.serverdata.order.serverdataorder.Entity.Inventory;
import com.serverdata.order.serverdataorder.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/25 23:27
 * @Version 1.0
 **/
@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    public List<Inventory> findAll(){
        return  inventoryRepository.findAll();
    }
}
