package com.xj.springcloud.controller;

import com.xj.springcloud.service.MessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("message")
public class SendMessageController {

    @Resource
    private MessageProvider messageProvider;

    @GetMapping("send")
    public String send(){
        return messageProvider.send();
    }
}
