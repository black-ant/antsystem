package com.msclient.eshop.clienteshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@SpringCloudApplication
public class ClientEshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientEshopApplication.class, args);
    }

}

