package com.msclient.logistics.clientlogistics.ServerMapper;

import com.alibaba.fastjson.JSONObject;
import com.msclient.logistics.clientlogistics.entity.StorehouseVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/4/8 12:54
 * @Version 1.0
 **/
public abstract class BaseErrorFailBack {
    JSONObject errorJSON = new JSONObject();

    public String ErrorTemplate(){
        return ErrorTemplate("访问服务失败","500");
    }

    public String ErrorTemplate(String msg){
       return ErrorTemplate(msg,"500");
    }

    public String ErrorTemplate(String msg,String code){
        errorJSON.put("code",code);
        errorJSON.put("message",msg);
        errorJSON.put("result","");
        return errorJSON.toJSONString();
    }
}
