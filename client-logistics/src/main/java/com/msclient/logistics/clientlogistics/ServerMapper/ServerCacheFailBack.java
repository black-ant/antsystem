package com.msclient.logistics.clientlogistics.ServerMapper;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/9 22:38
 * @Version 1.0
 **/
@Component
public class ServerCacheFailBack extends BaseErrorFailBack implements ServerCacheMapper {
    @Override
    public List<String> getOrderList(String type) {
        return new LinkedList<>();
    }
}
