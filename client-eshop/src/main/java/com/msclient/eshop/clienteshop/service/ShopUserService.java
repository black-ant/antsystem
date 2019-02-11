package com.msclient.eshop.clienteshop.service;

import com.msclient.eshop.clienteshop.entity.UserVO;
import org.springframework.stereotype.Service;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/11 19:42
 * @Version 1.0
 **/
@Service
public class ShopUserService extends BaseService {

    public String addUser(UserVO userVO) {
        userVO.setStatus("1");
        userVO.setUserid(2);
        userVO.setUsername("gang");
        userVO.setUserdesc("描述");
        return eshopMapper.addUser(userVO);
    }
}
