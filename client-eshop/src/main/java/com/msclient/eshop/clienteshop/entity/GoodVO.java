package com.msclient.eshop.clienteshop.entity;

import lombok.Data;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/2/10 22:13
 * @Version 1.0
 **/
@Data
public class GoodVO {

    private Integer id;
    private String goodscode;
    private String goodstitle;
    private String shopid;
    private String summary;
    private String goodsdesc;

    public GoodVO() {
    }

    public GoodVO(Integer id, String goodscode, String goodstitle, String summary, String goodsdesc) {
        this.id = id;
        this.goodscode = goodscode;
        this.goodstitle = goodstitle;
        this.summary = summary;
        this.goodsdesc = goodsdesc;
    }
}
