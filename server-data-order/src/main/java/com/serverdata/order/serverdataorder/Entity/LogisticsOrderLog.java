package com.serverdata.order.serverdataorder.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/28 23:08
 * @Version 1.0
 **/
@Entity
@Table(name="LogisticsOrderLog")
@Data
public class LogisticsOrderLog {

    @Id
    private String logid;
}
