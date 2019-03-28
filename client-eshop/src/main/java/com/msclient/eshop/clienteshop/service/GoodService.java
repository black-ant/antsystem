package com.msclient.eshop.clienteshop.service;

import com.msclient.eshop.clienteshop.entity.GoodVO;
import com.msclient.eshop.clienteshop.entity.ShopVO;
import com.msclient.eshop.clienteshop.utils.JSONUtils;
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

    public List<GoodVO> findGoodByShopid(String shopid){
        String wrapper = eshopMapper.findGoodsByShopid(shopid);
        List<GoodVO> list = JSONUtils.wrapperToList(wrapper,GoodVO.class);
        return list;
    }

    public GoodVO findGoodByCode(String code){
        String wrapper = eshopMapper.findGoodsByCode(code);
        GoodVO good = JSONUtils.toBean(wrapper,GoodVO.class);
        return good;
    }

    public String saveGoods( GoodVO goodVO){
        return eshopMapper.saveGood(goodVO);
    }

    public List<GoodVO> getCart(String userid){
        return eshopMapper.getusercart(userid);
    }
}
