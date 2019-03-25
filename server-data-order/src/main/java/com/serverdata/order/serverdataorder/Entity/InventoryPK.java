package com.serverdata.order.serverdataorder.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/25 23:23
 * @Version 1.0
 **/@Embeddable
@Data
public class InventoryPK {

    @NotNull
    @Column(length = 30)
    private String procode;
    @NotNull
    @Column(length = 22)
    private String sid;
}
