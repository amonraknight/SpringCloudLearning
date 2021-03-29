package com.outofscan.irules;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BalancingRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();
//        return new RoundRobinRule();
    }
}
