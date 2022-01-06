package com.xj.springcloud.service;

import com.xj.springcloud.entity.Payment;
import com.xj.springcloud.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {
    @GetMapping("payment/getPaymentById")
    CommonResult<Payment> getPaymentById(@RequestParam("id") String id);

    @GetMapping("payment/timeOut")
    String timeOut();
}
