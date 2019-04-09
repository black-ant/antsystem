package com.dataserver.eshop.serverdataeshop.service;

import com.alibaba.fastjson.JSONObject;
import com.dataserver.eshop.serverdataeshop.entity.CustomerCart;
import com.dataserver.eshop.serverdataeshop.entity.ItemSkuPropertyReference;
import com.dataserver.eshop.serverdataeshop.entity.ShopGoods;
import com.dataserver.eshop.serverdataeshop.entity.VO.CustomerAddressVO;
import com.dataserver.eshop.serverdataeshop.entity.VO.CustomerCartVO;
import com.dataserver.eshop.serverdataeshop.exception.SaveException;
import com.dataserver.eshop.serverdataeshop.repository.CustomerCartRepository;
import com.dataserver.eshop.serverdataeshop.repository.ItemSkuPropertyReferenceRepository;
import com.dataserver.eshop.serverdataeshop.repository.ShopGoodsRepository;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 10169
 * @Description 对商品进行编辑
 * @Date 2019/1/29 23:10
 * @Version 1.0
 **/
@Service
public class GoodsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ItemSkuPropertyReferenceRepository skuRefrepo;
    @Autowired
    ShopGoodsRepository goodsrepo;
    @Autowired
    ApplicationService application;
    @Autowired
    CustomerCartRepository cartrepo;

    /**
     * 批量保存List列表
     *
     * @param goodsList
     * @return
     */
    @Transactional
    @ExceptionHandler(SaveException.class)
    public boolean saveGoods(List<ShopGoods> goodsList) {
        Iterator<ShopGoods> iterator = goodsList.iterator();

        while (iterator.hasNext()) {
            ShopGoods shopGood = iterator.next();
            shopGood = editGoods(shopGood, null, null, null);
            goodsrepo.save(shopGood);
        }
        return true;
    }

    /**
     * 保存单个货品
     *
     * @param saveGood
     * @return
     */
    @Transactional
    @ExceptionHandler(SaveException.class)
    public boolean saveGoods(ShopGoods saveGood) {
        saveGood = editGoods(saveGood, null, null, null);
        goodsrepo.save(saveGood);
        return true;
    }


    /**
     * 保存前编辑货品资料
     *
     * @param saveGoods
     * @return
     */
    public ShopGoods editGoods(ShopGoods saveGoods, String param1, String param2, String param3) {
        saveGoods.setId(1);
        return saveGoods;
    }

    /**
     * 查找店铺所有的货品
     *
     * @return
     */
    public List<ShopGoods> findShopGoods(String shopid) {
        List<ShopGoods> shopGoods = goodsrepo.findByShopid(shopid);
        return shopGoods;
    }

    /**
     * 根据Code 查询单个货品
     *
     * @return
     */
    public Map<Integer, Map<String, Object>> findShopGoodsOne(Integer goodsid) {
        List<ItemSkuPropertyReference> reflist = skuRefrepo.findByGoodsid(goodsid);
        Map<Integer, Map<String, Object>> map = new LinkedHashMap<>();
        Map<String, Object> itemMap;
        for (ItemSkuPropertyReference item : reflist) {
            if (map.containsKey(item.getSkuid())) {
                itemMap = map.get(item.getSkuid());
                itemMap.put(application.getItemkeyMap().get(item.getSkukeyid()).getName(), application.getItemvalueMap().get(item.getSkuvalueid()).getValue());
                itemMap.put("skuid", item.getSkuid());
            } else {
                itemMap = new HashMap<String, Object>();
                logger.info("item.getSkukeyid() :{}---item.getSkuvalueid():{}",item.getSkukeyid(),item.getSkuvalueid());
                itemMap.put(application.getItemkeyMap().get(item.getSkukeyid()).getName(), application.getItemvalueMap().get(item.getSkuvalueid()).getValue());
                map.put(item.getSkuid(), itemMap);
            }
            logger.info("skukey:{}--skuvalue:{}", item.getSkukeyid(), item.getSkuvalueid());

        }
        return map;
    }

    /**
     * 将货品加入购物车
     *
     * @return
     */
    @Transactional
    public CustomerCart addToCart(CustomerCartVO cartVO) {
        CustomerCart cart = cartrepo.findByGoodsidAndSkuidAndShopId(cartVO.getGoodsid(), cartVO.getSkuid(), cartVO.getShopId());
        if (null == cart) {
            cart = new CustomerCart(cartVO);
            return cartrepo.save(cart);
        } else {
            cart.setNum(cart.getNum() + cartVO.getNum());

        }
        return cart;
    }

    public List<CustomerCartVO> findCartList(Integer userid, String nobodykey) {
        userid = 0 == userid ? null : userid;
        nobodykey = "".equals(nobodykey) ? null : nobodykey;
        List<CustomerCart> carts = cartrepo.findByUserid(userid, nobodykey);
        final CustomerCartVO[] vos = new CustomerCartVO[1];
        List<CustomerCartVO> cartVOS = carts.stream().map(p -> {
            vos[0] = new CustomerCartVO(p);
            logger.info("shopMap:{}", JSONObject.toJSONString(application.getShopMap().get(10001)));
            vos[0].setShopname(application.getShopMap().get(p.getShopId()).getShopname());
            vos[0].setGoodsdesc(application.getGoodsMap().get(p.getGoodsid()).getGoodsdesc());
            vos[0].setGoodstitle(application.getGoodsMap().get(p.getGoodsid()).getGoodstitle());
            return vos[0];
        }).collect(Collectors.toList());
        return cartVOS;
    }
}
