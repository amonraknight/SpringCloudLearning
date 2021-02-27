package com.sheli.controllers;

import com.sheli.entities.Payment;
import com.sheli.entities.ResponseCodeMessage;
import com.sheli.loadbalancing.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.ServiceInformation;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController(value = "/order")
@Slf4j
public class OrderController {

    //use eureka application name
    private String PAYMENT_MODULE_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/consumer/payment/create")
    public ResponseCodeMessage<Payment> create(@RequestBody Payment payment) {
        log.info("Receive a request for creation.");
        return restTemplate.postForObject(PAYMENT_MODULE_URL + "/payment/create", payment, ResponseCodeMessage.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public ResponseCodeMessage<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("Receive a request for query.");
        return restTemplate.getForObject(PAYMENT_MODULE_URL + "/payment/get/" + id, ResponseCodeMessage.class);
    }

    @GetMapping(value = "/consumer/paymentlb/get/{id}")
    public String getPaymentWithLoadBalance(@PathVariable("id") Long id) {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.isEmpty()) {
            return null;
        } else {
            ServiceInstance targetInstance=loadBalancer.instance(instances);

            URI uri=targetInstance.getUri();
            return restTemplate.getForObject(uri+"/payment/get/"+id, String.class);
        }
    }
}
