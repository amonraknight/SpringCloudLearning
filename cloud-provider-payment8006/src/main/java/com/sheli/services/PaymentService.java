package com.sheli.services;

import com.sheli.entities.Payment;

public interface PaymentService {
    public int create(Payment aPay);
    public Payment getPaymentById(Long id);
}
