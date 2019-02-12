package com.msclient.eshop.clienteshop.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 10169
 * @Description 前端查询对象
 * @Date 2019/2/12 22:56
 * @Version 1.0
 **/
@Data
public class FilterVO {
    /**
     * 查询id
     */
    private String filterid;
    /**
     * 查询名称
     */
    private String filtername;
    /**
     * 查询关键字
     */
    private String filterkey;
    /**
     * 查询价格
     */
    private BigDecimal price;
    /**
     * 查询时间
     */
    private Date date;

}
