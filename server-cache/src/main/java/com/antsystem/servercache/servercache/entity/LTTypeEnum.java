package com.antsystem.servercache.servercache.entity;

import lombok.Data;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/6 19:16
 * @Version 1.0
 **/
public enum LTTypeEnum {

    ALLTYPE(0, "ALL", "查询所有"),
    IN_RUN(1, "RUN", "路途中"),
    IN_WAREHOUSE(2, "HOUSE", "存放在中转站或者仓库"),
    OTHER(3, "OTHER", "其他");

    private int code;
    private String msg;
    private String desc;

    private LTTypeEnum(int code, String msg, String desc) {
        this.code = code;
        this.msg = msg;
        this.desc = desc;
    }


}
