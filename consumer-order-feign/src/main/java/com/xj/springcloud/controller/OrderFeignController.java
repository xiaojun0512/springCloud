package com.xj.springcloud.controller;

import com.xj.springcloud.entity.Payment;
import com.xj.springcloud.service.PaymentService;
import com.xj.springcloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("orderFeign")
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("getPaymentById")
    public CommonResult<Payment> getPaymentById(String id){
        return paymentService.getPaymentById(id);
    }

    @GetMapping("timeOut")
    public String timeOut(){
        //openfeign默认等待1秒钟
        return paymentService.timeOut();
    }
}
