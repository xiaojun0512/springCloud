package com.xj.springcloud.utils;

import com.xj.springcloud.service.OrderFeignHystrixService;
import org.springframework.stereotype.Component;

@Component
public class HystrixDefaultFallBack implements OrderFeignHystrixService {
    public String timeOut(String id) {
        return "服务连接失败";
    }

    public String get(String id) {
        return "服务连接失败";
    }
}
