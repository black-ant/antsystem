package com.serverdata.order.serverdataorder.Entity;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/28 23:06
 * @Version 1.0
 **/
public class ShopReturnOrderItem {

    @Id
    String orderid;
    String orderstatus;
    Date createdate;
    String createuser;
    String status;
    String type;
}
