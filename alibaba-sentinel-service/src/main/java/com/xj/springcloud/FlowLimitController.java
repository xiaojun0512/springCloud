package com.xj.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
