package com.msclient.logistics.clientlogistics.service;

import com.msclient.logistics.clientlogistics.entity.Info;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/21 23:14
 * @Version 1.0
 **/
@Service
public class InfoService {

    private static List<Info> list = new LinkedList<>();

    {
        Info info1 = new Info(1, "test1", new Date());
        Info info2 = new Info(2, "test2", new Date());
        Info info3 = new Info(3, "test3", new Date());
        list.add(info1);
        list.add(info2);
        list.add(info3);

    }

    public List<Info> findAll() {
        return list;
    }

    public Info getOne(Integer id) {
        return list.get(0);
    }

    public Info save(Info info) {
        list.add(info);
        return info;
    }

    public void deleteById(Integer id){

    }

}
