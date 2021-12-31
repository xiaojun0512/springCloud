package com.xj.springcloud.service;

import com.xj.springcloud.entity.Payment;

public interface Payment1Service {
    Integer savePayment(Payment payment);

    Payment getPaymentById(String id);
}
