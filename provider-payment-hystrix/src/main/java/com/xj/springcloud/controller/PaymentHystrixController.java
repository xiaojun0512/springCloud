package com.xj.springcloud.controller;


import com.xj.springcloud.service.PaymentHystrixService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("paymentHystrix")
@Api(tags = "paymentHystrix")
@Slf4j
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("timeOut")
    public String timeOut(@RequestParam("id") String id){
        return paymentHystrixService.timeOut(id);
    }

    @GetMapping("get")
    public String get(@RequestParam("id") String id){
        return paymentHystrixService.get(id);
    }
}
