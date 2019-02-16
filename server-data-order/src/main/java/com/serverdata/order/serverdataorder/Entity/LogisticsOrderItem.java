package com.serverdata.order.serverdataorder.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/28 23:04
 * @Version 1.0
 **/
@Data
@Entity
@Table(name="logisticsOrderItem")
public class LogisticsOrderItem {

    @Id
    String orderid;
    String orderstatus;
    Date createdate;
    String createuser;
    String status;
    String type;
}
