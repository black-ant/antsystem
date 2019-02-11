package com.dataserver.eshop.serverdataeshop.service;

import com.dataserver.eshop.serverdataeshop.entity.ShopUser;
import com.dataserver.eshop.serverdataeshop.repository.ShopUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/11 16:11
 * @Version 1.0
 **/
@Service
public class ShopUserService {

    @Autowired
    ShopUserRepository shopUserRepository;

    /**
     * 添加店铺用户
     */
    public ShopUser addUser(ShopUser shopUser) {
        shopUser = editShopUser(shopUser);
        return shopUserRepository.save(shopUser);
    }

    public ShopUser editShopUser(ShopUser shopUser) {
        shopUser.setLevel("1");
        shopUser.setRemarks("添加用户");
        return shopUser;
    }

}
