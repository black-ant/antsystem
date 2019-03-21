package com.msclient.logistics.clientlogistics.entity;

import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/21 23:13
 * @Version 1.0
 **/
public class Info {

    private Integer id;
    private String title;
    private Date time;

    public Info() {
    }

    public Info(Integer id, String title, Date time) {
        this.id = id;
        this.title = title;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", time=" + time +
                '}';
    }
}
