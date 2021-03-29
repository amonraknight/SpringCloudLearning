package com.sheli.services;

import com.sheli.entities.Payment;
import com.sheli.entities.ResponseCodeMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value="CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public ResponseCodeMessage<Payment> getPaymentByID(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/getafterawhile/{id}")
    public ResponseCodeMessage<Payment> getPaymentAfterAWhileByID(@PathVariable("id") Long id);
}
