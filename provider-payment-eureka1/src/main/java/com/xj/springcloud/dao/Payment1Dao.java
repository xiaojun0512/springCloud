package com.xj.springcloud.dao;

import com.xj.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Payment1Dao {
    Integer savePayment(Payment payment);

    Payment getPaymentById(String id);
}
