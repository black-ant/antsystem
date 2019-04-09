package com.serverdata.order.serverdataorder.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 10169
 * @Description 第三方物流名称
 * @Date 2019/4/8 16:04
 * @Version 1.0
 **/
@Entity
@Data
@Table(name="logisticsOrder")
public class Express {
    /**
     * 编号
     */
    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 是否展示
     *
     * 1-展示
     * 0-隐藏
     */
    private Integer display;

}
