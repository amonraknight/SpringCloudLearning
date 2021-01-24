package com.sheli.services.impl;

import com.sheli.dao.PaymentDao;
import com.sheli.entities.Payment;
import com.sheli.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment aPay) {
        return paymentDao.recordAPayment(aPay);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
