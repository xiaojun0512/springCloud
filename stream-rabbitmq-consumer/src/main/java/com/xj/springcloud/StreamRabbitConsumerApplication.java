package com.xj.springcloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class StreamRabbitConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamRabbitConsumerApplication.class,args);
        log.info("==============================StreamRabbitConsumer启动成功==============================");
    }
}
