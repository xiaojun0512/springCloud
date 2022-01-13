package com.xj.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("nacos")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("getNacosPort")
    public String getNacosPort(@RequestParam("name") String name){
        return "port:" + serverPort + ";name:" + name + ";id:" + UUID.randomUUID().toString();
    }
}
