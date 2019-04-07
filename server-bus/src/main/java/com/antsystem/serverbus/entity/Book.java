package com.antsystem.serverbus.entity;

import java.io.Serializable;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/6 21:48
 * @Version 1.0
 **/

public class Book implements Serializable {

    private static final long serialVersionUID = -2164058270260403154L;

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

