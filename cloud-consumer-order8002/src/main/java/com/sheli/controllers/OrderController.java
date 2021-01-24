package com.sheli.controllers;

import com.sheli.entities.Payment;
import com.sheli.entities.ResponseCodeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController(value="/order")
@Slf4j
public class OrderController {

    @Value(value = "${crossmodule.payment.url}")
    private String PAYMENT_MODULE_URL;

    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value="/consumer/payment/create")
    public ResponseCodeMessage<Payment> create(@RequestBody Payment payment) {
        log.info("Receive a request for creation.");
        return restTemplate.postForObject(PAYMENT_MODULE_URL+"/payment/create", payment, ResponseCodeMessage.class);
    }

    @GetMapping(value="/consumer/payment/get/{id}")
    public ResponseCodeMessage<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("Receive a request for query.");
        return restTemplate.getForObject(PAYMENT_MODULE_URL+"/payment/get/"+id, ResponseCodeMessage.class);
    }
}
