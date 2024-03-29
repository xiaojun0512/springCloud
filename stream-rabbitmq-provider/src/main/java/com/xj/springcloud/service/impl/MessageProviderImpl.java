package com.xj.springcloud.service.impl;

import com.xj.springcloud.service.MessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)    //定义消息的推送管道
public class MessageProviderImpl implements MessageProvider {

    @Resource
    private MessageChannel output;  //消息发送管道

    public String send() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        return uuid;
    }
}
