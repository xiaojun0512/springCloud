package com.xj.springcloud.service.impl;

import com.xj.springcloud.dao.Payment1Dao;
import com.xj.springcloud.entity.Payment;
import com.xj.springcloud.service.Payment1Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Payment1ServiceImpl implements Payment1Service {

    @Resource
    private Payment1Dao payment1Dao;

    public Integer savePayment(Payment payment) {
        return payment1Dao.savePayment(payment);
    }

    public Payment getPaymentById(String id) {
        return payment1Dao.getPaymentById(id);
    }
}
