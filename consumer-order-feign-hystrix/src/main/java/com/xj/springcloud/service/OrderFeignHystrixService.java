package com.xj.springcloud.service;

import com.xj.springcloud.utils.HystrixDefaultFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "HYSTRIX-PAYMENT-SERVICE",fallback = HystrixDefaultFallBack.class)
public interface OrderFeignHystrixService {

    @GetMapping("paymentHystrix/timeOut")
    String timeOut(@RequestParam("id") String id);

    @GetMapping("paymentHystrix/get")
    String get(@RequestParam("id") String id);
}
