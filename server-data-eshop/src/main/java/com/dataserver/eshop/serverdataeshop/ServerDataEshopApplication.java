package com.dataserver.eshop.serverdataeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServerDataEshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerDataEshopApplication.class, args);
    }

}

