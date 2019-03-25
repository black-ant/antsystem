package com.serverdata.order.serverdataorder.controller;

import com.serverdata.order.serverdataorder.Entity.Inventory;
import com.serverdata.order.serverdataorder.common.response.Wrapper;
import com.serverdata.order.serverdataorder.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/25 23:28
 * @Version 1.0
 **/
@RestController
@RequestMapping("inventory")
public class InventoryController extends BaseController {

    @Autowired
    InventoryService inventoryService;

    @PostMapping("findall")
    public Wrapper findAll() {
        List<Inventory> list = inventoryService.findAll();
        return apiResponse(list);
    }
}
