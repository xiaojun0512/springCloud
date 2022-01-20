package com.xj.springcloud.service;

import com.xj.springcloud.handler.PaymentServiceHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "nacos-payment-provider",fallback = PaymentServiceHandler.class)
public interface PaymentService {

    @GetMapping("/nacos/getNacosPort")
    String getNacosPort(@RequestParam("name") String name);
}
