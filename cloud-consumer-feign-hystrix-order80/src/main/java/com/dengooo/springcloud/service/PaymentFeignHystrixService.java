package com.dengooo.springcloud.service;

import com.dengooo.springcloud.service.impl.PaymentFeignHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
/*
    这里多了一个fallback属性，就是告诉feign,如果我调用异常了，
    就用PaymentFeignHystrixServiceImpl中对应的方法来处理fallback,
    PaymentFeignHystrixServiceImpl是PaymentFeignHystrixService的实现类
 */
@FeignClient(value = "cloud-payment-service",fallback = PaymentFeignHystrixServiceImpl.class)
//@FeignClient("cloud-payment-service")
public interface PaymentFeignHystrixService {
    @GetMapping("payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id);

    @GetMapping("payment/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id);
}
