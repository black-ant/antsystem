package com.platform.platformclient.service;

import com.platform.platformclient.serverMapper.ShopMapper;
import com.platform.platformclient.serverMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.client.RestTemplate;

/**
 * @author 10169
 * @Description TODO
 * @Date 2019/3/18 23:17
 * @Version 1.0
 **/
public abstract class BaseService {

    @Autowired
    ShopMapper eshopMapper;
    @Autowired
    UserMapper userMapper;

    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;

    public String getServiceUrl(String service){
        ServiceInstance serviceInstance = loadBalancerClient.choose(service);
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort();
        return url;
    }
}
