package com.xj.springcloud.service.impl;

import com.xj.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Value("${server.port}")
    private String serverPort;

    public String timeOut() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "port"+serverPort;
    }

    public String get() {
        return "port:"+serverPort;
    }
}
