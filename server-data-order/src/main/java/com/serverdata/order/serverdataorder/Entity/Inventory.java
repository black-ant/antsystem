package com.serverdata.order.serverdataorder.Entity;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/25 23:21
 * @Version 1.0
 **/
@Entity
@Data
@Table(name="inventory")
public class Inventory{

    @EmbeddedId
    private InventoryPK inventoryPK;
    private int insnum;
    private int outnum;
    private String prodesc;
    private String remarks;
    @Transient
    private String procode;
    @Transient
    private String sid;
    @Transient
    private String sn;

    public void exchangePK(){
        this.procode = inventoryPK.getProcode();
        this.sid = inventoryPK.getSid();
        this.sn = this.procode+this.sid;
    }

    public InventoryPK getInventoryPK() {
        return inventoryPK;
    }

    public void setInventoryPK(InventoryPK inventoryPK) {
        this.inventoryPK = inventoryPK;
        System.out.println("pk is find:"+inventoryPK.getProcode());
        exchangePK();
    }
}
