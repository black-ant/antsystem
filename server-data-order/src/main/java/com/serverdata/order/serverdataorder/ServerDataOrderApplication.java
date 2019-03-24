package com.serverdata.order.serverdataorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServerDataOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerDataOrderApplication.class, args);
    }

}

