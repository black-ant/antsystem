package com.msclient.logistics.clientlogistics.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/26 21:27
 * @Version 1.0
 **/
@Data
public class InventoryVO {

    private String procode;
    private String sid;
    private int insnum;
    private int outnum;
    private String prodesc;
    private String remarks;
    private String sn;

    public InventoryVO() {
    }
}
