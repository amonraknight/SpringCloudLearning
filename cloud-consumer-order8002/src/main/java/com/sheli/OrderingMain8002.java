package com.sheli;

import com.outofscan.irules.BalancingRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = BalancingRule.class)
public class OrderingMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(OrderingMain8002.class, args);
    }
}
