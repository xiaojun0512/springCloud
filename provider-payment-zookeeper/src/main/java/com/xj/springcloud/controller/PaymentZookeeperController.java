package com.xj.springcloud.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paymentZookeeper")
@Api(tags = "paymentZookeeper")
@Slf4j
public class PaymentZookeeperController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("paymentZk")
    public String paymentZk(){
        return serverPort;
    }
}
