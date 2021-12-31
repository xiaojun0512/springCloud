package com.xj.springcloud.service.impl;

import com.xj.springcloud.dao.PaymentDao;
import com.xj.springcloud.entity.Payment;
import com.xj.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public Integer savePayment(Payment payment) {
        return paymentDao.savePayment(payment);
    }

    public Payment getPaymentById(String id) {
        return paymentDao.getPaymentById(id);
    }
}
