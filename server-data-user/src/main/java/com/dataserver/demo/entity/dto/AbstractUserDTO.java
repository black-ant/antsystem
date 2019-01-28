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

    Long id;
    String username;
    String age;
    Boolean sex;
    String type;
    String mobile;
    String linkman;
    String phone;
    String img;
    String desc;
    String status;
    String isactive;
    //User类对象其余信息
    Map<String,Object> othermessage = new HashMap<String,Object>();





}
