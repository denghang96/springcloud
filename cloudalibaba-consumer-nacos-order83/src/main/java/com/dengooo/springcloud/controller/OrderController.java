package com.dengooo.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

    private static final String PROVIDER_URL = "http://alibaba-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumerGetProduct")
    private String consumerGetProduct() {
        return restTemplate.getForObject(PROVIDER_URL + "/product", String.class);
    }
}
