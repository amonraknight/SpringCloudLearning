package com.sheli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignOrderingMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderingMain8002.class, args);
    }
}
