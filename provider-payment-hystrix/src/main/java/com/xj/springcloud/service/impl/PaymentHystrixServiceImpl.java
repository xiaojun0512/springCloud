package com.xj.springcloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xj.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Value("${server.port}")
    private String serverPort;

    //服务端服务降级
    @HystrixCommand(fallbackMethod = "timeOutHystrix",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")  //超时
    })
    public String timeOut(String id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "port"+serverPort+";id:"+id;
    }

    public String timeOutHystrix(String id) {
        return "timeOut;id" + id;
    }

    public String get(String id) {
        return "port:"+serverPort+";id:"+id;
    }
}
