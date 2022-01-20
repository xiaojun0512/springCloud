package com.xj.springcloud.handler;

import com.xj.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceHandler implements PaymentService {

    public String getNacosPort(String name) {
        return "出错啦";
    }
}
