package com.dengooo.springcloud.controller;

import com.dengooo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("server.port")
    private String serverPort;

    //===========================服务降级===============================
    @GetMapping("payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id) {
        String result = paymentService.PaymentInfo(id);
        log.info("**********result: " + result);
        return result;
    }

    @GetMapping("payment/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id) {
        String result = paymentService.timeOut(id);
        log.info("**********result: " + result);
        return result;
    }

    //===========================服务熔断===============================
    //服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result："+result);
        return result;
    }

}
