package com.platform.platformclient.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractService {
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
