package com.serverdata.order.serverdataorder.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/18 22:57
 * @Version 1.0
 **/
@Embeddable
@Data
public class ShopReturnOrderItemPK implements Serializable {

    @NotNull
    @Column(length = 30)
    private String orderid;
    @NotNull
    @Column(length = 22)
    private String sn;
}
