package com.platform.platformclient.entity.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/5 11:40
 * @Version 1.0
 **/
@Data
public class GroupVO {

    private Integer id;
    private Integer did;
    private String groupName;
    private String groupDesc;
    private String groupType;
    private String power;

}
