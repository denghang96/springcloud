package com.dengooo.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/product")
    public String product() {
        return "serverPort " + serverPort + " product message" + UUID.randomUUID().toString().replaceAll("-", "");
    }
}
