package com.sheli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayMain8007 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain8007.class, args);
    }
}
