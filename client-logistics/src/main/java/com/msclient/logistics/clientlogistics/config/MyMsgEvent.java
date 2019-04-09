package com.msclient.logistics.clientlogistics.config;


/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 12:09
 * @Version 1.0
 **/

//public class MyMsgEvent extends RemoteApplicationEvent {
public class MyMsgEvent {

    private String msg;

    public MyMsgEvent(Object source, String originService, String destinationService, String msg) {
//        super(source, originService, destinationService);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
