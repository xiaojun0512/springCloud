package com.xj.springcloud.service.impl;

import com.netflix.hystrix.HystrixCommandProperties;
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

    /**
     * 服务熔断
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallBack",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),   //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),    //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if (id < 0) {
            throw new RuntimeException("id不能为负数");
        }
        return serverPort;
    }

    public String paymentCircuitBreakerFallBack(Integer id){
        return "id不能为负数";
    }
}
