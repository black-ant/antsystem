package com.serverdata.order.serverdataorder.Entity.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/29 22:28
 * @Version 1.0
 **/

public class ShopGoodsDTO {

    private Integer id;
    private String goodscode;
    private Date createDate;
    private Date updateDate;
    private Integer status;

    private String goodstitle;
    private String summary;
    private String goodsdesc;

    private String goodstype;
    private String goodscate;
    private String goodsstyle;

    private String goodsprice;
    private String volume;
    private String size;
    private String message;

    /**
     * 商品销售状态
     */
    private String saleStaus;
    /**
     * 商品销售类型
     */
    private String saleType;

    private String shopid;

}
