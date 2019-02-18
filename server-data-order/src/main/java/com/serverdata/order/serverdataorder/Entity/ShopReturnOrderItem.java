package com.serverdata.order.serverdataorder.Entity;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/28 23:06
 * @Version 1.0
 **/
@Entity
@Table(name = "shopReturnOrderitem")
@Data
public class ShopReturnOrderItem {

    @EmbeddedId
    private ShopReturnOrderItemPK shopReturnOrderItemPK;
    String orderstatus;
    Date createdate;
    String createuser;
    String status;
    String type;

    public ShopReturnOrderItem() {
    }

    public ShopReturnOrderItem(String orderid, String sn) {
        ShopReturnOrderItemPK shopReturnOrderItemPK = new ShopReturnOrderItemPK();
        shopReturnOrderItemPK.setOrderid(orderid);
        shopReturnOrderItemPK.setSn(sn);
        this.shopReturnOrderItemPK = shopReturnOrderItemPK;
    }
}
