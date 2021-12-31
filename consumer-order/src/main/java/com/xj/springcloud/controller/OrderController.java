package com.xj.springcloud.controller;

import com.xj.springcloud.entity.Payment;
import com.xj.springcloud.utils.CommonResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("order")
@Api(tags = "order数据接口")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

//    private String PAYMENT_URL = "http://localhost:8081";
    private String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("savePayment")
    public CommonResult savePayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/savePayment", payment, CommonResult.class);
    }

    @GetMapping("getPaymentById")
    public CommonResult getPaymentById(String id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById?id="+id, CommonResult.class);
    }

}
