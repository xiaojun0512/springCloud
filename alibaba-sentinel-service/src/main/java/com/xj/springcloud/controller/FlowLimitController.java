package com.xj.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xj.springcloud.handler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("flowLimit")
@Slf4j
public class FlowLimitController {

    @GetMapping("getA")
    public String getA(){
        return "A" + UUID.randomUUID().toString();
    }

    @GetMapping("getB")
    public String getB(){
        return "B" + UUID.randomUUID().toString();
    }

    @GetMapping("getHotKey")
    @SentinelResource(value = "getHotKey",blockHandler = "errGetHotKey")
    public String getHotKey(@RequestParam(value = "s1",required = false) String s1,@RequestParam(value = "s2",required = false) String s2) {
        return "getHotKey" + UUID.randomUUID().toString();
    }

    @GetMapping("errGetHotKey")
    public String errGetHotKey(String s1, String s2, BlockException e) {
        return "errGetHotKey" + UUID.randomUUID().toString();
    }

    @GetMapping("byResource")
    @SentinelResource(value = "byResource",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException")
    public String byResource() {
        return "byResource 200 " + UUID.randomUUID().toString();
    }

}
