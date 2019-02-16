package com.serverdata.order.serverdataorder.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/28 23:03
 * @Version 1.0
 **/
@Entity
@Table(name="logisticsOrder")
@Data
public class LogisticsOrder {

    @Id
    String orderid;
    String orderstatus;
    Date createdate;
    String createuser;
    String status;
    String type;
    @OneToMany
    List<LogisticsOrderItem> items;
}
