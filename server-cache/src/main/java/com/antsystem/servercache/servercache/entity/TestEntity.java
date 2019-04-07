package com.antsystem.servercache.servercache.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/6 15:23
 * @Version 1.0
 **/

@Data
@Document(collection = "test")
public class TestEntity  implements Serializable {


    @Id
    private Integer id;
    private String msg;
    private String name;
    private Date createDate;

    public TestEntity(String msg, String name, Date createDate) {
        this.msg = msg;
        this.name = name;
        this.createDate = createDate;
    }
}
