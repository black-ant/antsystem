package com.dataserver.demo.entity.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/1/15 22:56
 * @Version 1.0
 **/
@Data
public class AbstractUserDTO {

    String username;
    String userage;
    String usertype;
    String usermobild;
    String userlinkman;
    String userlinkphone;
    String userimg;
    String userdesc;
    String userstatus;
    String userisactive;
    //User类对象其余信息
    Map<String,Object> othermessage = new HashMap<String,Object>();





}
