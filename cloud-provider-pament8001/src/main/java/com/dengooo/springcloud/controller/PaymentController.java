package com.dengooo.springcloud.controller;

import com.dengooo.springcloud.entities.CommonResult;
import com.dengooo.springcloud.entities.Payment;
import com.dengooo.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("********插入结果: {}" , result);
        if (result > 0) {
            return new CommonResult(200, "插入成功,端口：" + serverPort, result);
        }else {
            return new CommonResult(500, "插入失败,端口：" + serverPort, null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getByid(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果: {}" , payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,端口：" + serverPort, payment);
        }else {
            return new CommonResult(500, "没有对应记录,端口：" + serverPort, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("******element: " + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance: instances) {
            log.info(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort()  + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }
}
