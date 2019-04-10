package com.serversearch.demo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;




/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/10 18:04
 * @Version 1.0
 **/
@Data
@Document(indexName = "shopgoods",type = "goods")
public class GoodsInfo implements Serializable {

    private Integer id;
    private String alias;
    private String goodscode;
    private String shopid;

    private Date createDate;
    private Date updateDate;

    private Integer status;
    private String goodstitle;
    private String summary;
    private String goodsdesc;
    private String goodstype;
    private String goodscate;
    private String goodsstyle;

    public GoodsInfo() {
    }


    public GoodsInfo(Integer id, String alias, String goodscode, Date createDate, String goodstitle, String summary) {
        this.id = id;
        this.alias = alias;
        this.goodscode = goodscode;
        this.createDate = createDate;
        this.goodstitle = goodstitle;
        this.summary = summary;
    }
}
