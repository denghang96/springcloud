package com.dengooo.springcloud.service;

import com.dengooo.springcloud.entities.CommonResult;
import com.dengooo.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/zk")
    public String get();
}
