package com.dataserver.eshop.serverdataeshop.service;

import com.dataserver.eshop.serverdataeshop.entity.UserShop;
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
    public UserShop addUser(UserShop userShop) {
        userShop = editShopUser(userShop);
        return shopUserRepository.save(userShop);
    }

    public UserShop editShopUser(UserShop userShop) {
        userShop.setLevel("1");
        userShop.setRemarks("添加用户");
        return userShop;
    }

}
