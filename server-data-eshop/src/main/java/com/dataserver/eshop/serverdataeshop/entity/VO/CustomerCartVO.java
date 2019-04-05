package com.dataserver.eshop.serverdataeshop.entity.VO;

import com.dataserver.eshop.serverdataeshop.entity.CustomerCart;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/4 14:55
 * @Version 1.0
 **/
@Data
public class CustomerCartVO {

    private String cartdesc;
    /**
     * 购物车类型
     */
    private Integer carttype;
    /**
     * 货品ID
     */
    private Integer goodsid;
    /**
     * SKUID
     */
    private Integer skuid;
    /**
     * 店铺ID
     */
    private Integer shopId;
    private String shopname;
    /**
     * 用户ID
     */
    private Integer buyerId;
    /**
     * 用户 会话ID
     */
    private String nobodyKey;
    private Integer activityId;
    private Integer activityType;
    /**s
     * 加入价格
     */
    private BigDecimal price;
    private Integer num;

    private String goodstitle;
    private String goodsdesc;

    public CustomerCartVO(CustomerCart cart) {
        this.cartdesc = cart.getCartdesc();
        this.carttype = cart.getCarttype();
        this.goodsid = cart.getGoodsid();
        this.skuid = cart.getSkuid();
        this.shopId = cart.getShopId();
        this.num = cart.getNum();
        this.price = cart.getPrice();
    }

}
