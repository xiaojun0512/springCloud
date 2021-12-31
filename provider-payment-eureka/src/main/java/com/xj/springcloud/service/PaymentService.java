package com.xj.springcloud.service;

import com.xj.springcloud.entity.Payment;

public interface PaymentService {
    Integer savePayment(Payment payment);

    Payment getPaymentById(String id);
}
