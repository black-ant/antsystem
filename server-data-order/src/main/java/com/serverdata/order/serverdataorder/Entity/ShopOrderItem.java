package com.serverdata.order.serverdataorder.Entity;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/28 23:04
 * @Version 1.0
 **/
@Entity
@Data
@Table(name = "shopOrderitem")
public class ShopOrderItem {


    @EmbeddedId
    private ShopOrderItemPK shopOrderItemPK;
    @Size(max = 6)
    String orderstatus;
    Date createdate;
    @Size(max = 22)
    String createuser;
    String status;
    String type;

    public ShopOrderItem() {
    }

    public ShopOrderItem(String orderid, String sn) {
        ShopOrderItemPK shopOrderItemPK = new ShopOrderItemPK();
        shopOrderItemPK.setOrderid(orderid);
        shopOrderItemPK.setSn(sn);
        this.shopOrderItemPK = shopOrderItemPK;
    }
}
