package com.dengooo.springcloud.controller;

import com.dengooo.springcloud.entities.CommonResult;
import com.dengooo.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/zk")
    public CommonResult<String> get() {
        return new CommonResult<String>(200,paymentFeignService.get());
    }
}
