package com.serverdata.order.serverdataorder.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/16 22:56
 * @Version 1.0
 **/

@Embeddable
@Data
public class ShopOrderItemPK implements Serializable {

    @NotNull
    @Column(length = 30)
    private String orderid;
    @NotNull
    @Column(length = 22)
    private String sn;

}
