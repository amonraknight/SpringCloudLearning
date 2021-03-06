package com.sheli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain8003.class);
    }
}
