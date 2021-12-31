package com.xj.springcloud.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("paymentConsul")
@Api(tags = "paymentConsul")
@Slf4j
public class PaymentConsulController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("paymentConsul")
    public String paymentConsul(){
        return serverPort + UUID.randomUUID().toString();
    }
}
