package com.platform.platformclient.entity.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/18 23:21
 * @Version 1.0
 **/
@Data
public class DepartmentVO {

    private Long depid;
    private String depname;
    private String depdes;
    private String deptype;
    private String power;
}
