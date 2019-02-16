package com.serverdata.order.serverdataorder.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/28 23:00
 * @Version 1.0
 **/
@Data
@Entity
@Table(name="shoporder")
public class ShopOrder {

    @Id
    String orderid;
    String orderstatus;
    Date createdate;
    String createuser;
    String status;
    String type;
}
