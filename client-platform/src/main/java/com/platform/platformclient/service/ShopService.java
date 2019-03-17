package com.platform.platformclient.service;

import com.platform.platformclient.entity.ShopEntity;
import com.platform.platformclient.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/17 23:14
 * @Version 1.0
 **/
@Service
public class ShopService {

    @Autowired
    ShopRepository shopRepository;

    public List<ShopEntity> findShopList() {
        return shopRepository.findAll();
    }
}
