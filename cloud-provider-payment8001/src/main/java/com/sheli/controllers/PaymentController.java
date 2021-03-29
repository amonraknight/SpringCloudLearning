package com.sheli.controllers;


import com.sheli.entities.Payment;
import com.sheli.entities.ResponseCodeMessage;
import com.sheli.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public ResponseCodeMessage create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("Insert get a return {}", result);

        if (result > 0) {
            return new ResponseCodeMessage(200, "Payment record created! Server: " + serverPort, result);
        } else {
            return new ResponseCodeMessage(500, "Payment not created successfully. Server: " + serverPort, null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public ResponseCodeMessage getRecord(@PathVariable Long id) {
        Payment result = paymentService.getPaymentById(id);
        if (result != null) {
            log.info("The result is {}", result);
            return new ResponseCodeMessage(200, "Payment record found! Server: " + serverPort, result);
        } else {
            return new ResponseCodeMessage(404, "Payment not found. Server: " + serverPort, null);
        }
    }

    @GetMapping(value = "/getafterawhile/{id}")
    public ResponseCodeMessage getRecordAfterAWhile(@PathVariable Long id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Payment result = paymentService.getPaymentById(id);
        if (result != null) {
            log.info("The result is {}", result);
            return new ResponseCodeMessage(200, "Payment record found! Server: " + serverPort, result);
        } else {
            return new ResponseCodeMessage(404, "Payment not found. Server: " + serverPort, null);
        }
    }

    @GetMapping(value = "/discovery")
    public Object discovery() {
        List<String> service = discoveryClient.getServices();
        for (String eachService : service) {
            log.info("Service: {}", eachService);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance eachInstance : instances) {
            log.info("Instance id: {}", eachInstance.getInstanceId());
        }

        return discoveryClient;
    }
}
