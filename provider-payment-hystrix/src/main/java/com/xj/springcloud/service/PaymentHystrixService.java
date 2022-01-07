package com.xj.springcloud.service;

public interface PaymentHystrixService {
    String timeOut(String id);

    String get(String id);
}
