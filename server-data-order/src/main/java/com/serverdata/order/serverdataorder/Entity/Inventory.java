package com.serverdata.order.serverdataorder.Entity;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/25 23:21
 * @Version 1.0
 **/
@Entity
@Table(name="inventory")
@Data
public class Inventory {

    @EmbeddedId
    private InventoryPK inventoryPK;
    private int insnum;
    private int outnum;
    private String desc;
    private String remarks;
}
