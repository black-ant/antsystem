package com.antsystem.serverbus.config;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 11:33
 * @Version 1.0
 **/
public class MyMsgEvent extends RemoteApplicationEvent {

    private String msg;

    public MyMsgEvent(Object source, String originService, String destinationService, String msg) {
        super(source, originService, destinationService);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
