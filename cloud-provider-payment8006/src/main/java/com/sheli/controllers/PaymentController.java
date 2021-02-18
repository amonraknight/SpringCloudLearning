package com.sheli.controllers;

import com.sheli.entities.Payment;
import com.sheli.entities.ResponseCodeMessage;
import com.sheli.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public ResponseCodeMessage create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("Insert get a return {}", result);

        if (result > 0) {
            return new ResponseCodeMessage(200, "Payment record created! Server: "+serverPort, result);
        } else {
            return new ResponseCodeMessage(500, "Payment not created successfully. Server: "+serverPort, null);
        }
    }

    @GetMapping(value = "/get/{id}")
    public ResponseCodeMessage create(@PathVariable Long id) {
        Payment result = paymentService.getPaymentById(id);
        if (result != null) {
            log.info("The result is {}", result);
            return new ResponseCodeMessage(200, "Payment record found! Server: "+serverPort, result);
        } else {
            return new ResponseCodeMessage(404, "Payment not found. Server: "+serverPort, null);
        }


    }
}
