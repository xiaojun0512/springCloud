package com.xj.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "HYSTRIX-PAYMENT-SERVICE")
public interface OrderFeignHystrixService {

    @GetMapping("paymentHystrix/timeOut")
    String timeOut();

    @GetMapping("paymentHystrix/get")
    String get();
}
