package com.sheli.dao;

import com.sheli.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    public Payment getPaymentById(Long id);
    public int recordAPayment(Payment aPay);
}
