package com.dengooo.springcloud.controller;

import com.dengooo.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {
    @Resource
    IMessageProvider messageProvider;

    @RequestMapping("/send")
    public String sendMessage() {
        return messageProvider.send();
    }
}
