package com.msclient.eshop.clienteshop.service;

import com.msclient.eshop.clienteshop.entity.GoodVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/10 21:48
 * @Version 1.0
 **/
@Service
public class GoodService extends BaseService{

    public String saveGoods(){
        GoodVO goodVO=new GoodVO(null,"code111","添加货品","sum","desc");
        return eshopMapper.saveGood(goodVO);
    }

    public List<GoodVO> getCart(String userid){
        return eshopMapper.getusercart(userid);
    }
}
