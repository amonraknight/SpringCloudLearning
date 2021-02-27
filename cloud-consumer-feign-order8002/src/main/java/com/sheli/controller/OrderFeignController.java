package com.sheli.controller;

import com.sheli.entities.Payment;
import com.sheli.entities.ResponseCodeMessage;
import com.sheli.services.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public ResponseCodeMessage<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentByID(id);
    }
}
