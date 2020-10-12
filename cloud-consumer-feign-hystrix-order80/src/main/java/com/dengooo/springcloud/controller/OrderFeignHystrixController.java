package com.dengooo.springcloud.controller;

import com.dengooo.springcloud.entities.CommonResult;
import com.dengooo.springcloud.service.PaymentFeignHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "controller_global_fallbackMethod") //一个类中全局服务降级的方法controller_global_fallbackMethod
public class OrderFeignHystrixController {
    @Resource
    private PaymentFeignHystrixService paymentFeignHystrixService;


    @GetMapping("consumer/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id) {
        String result = paymentFeignHystrixService.ok(id);
        return result;
    }

    @GetMapping("consumer/payment/hystrix/timeout/{id}")
    public String timeout(@PathVariable("id") Integer id) {
        String result = paymentFeignHystrixService.timeout(id);
        return result;
    }

    /**
     * timeOutHandler 异常或者超时的时候调用的方法，
     * execution.isolation.thread.timeoutInMilliseconds 超时时间 value 3S
     * @param id
     * @return
     */
    @GetMapping("consumer/payment/hystrix/timeOutWithHystrix/{id}")
    @HystrixCommand(fallbackMethod = "timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String timeOutWithHystrix(@PathVariable("id") Integer id) {
        String result = paymentFeignHystrixService.timeout(id);
        return result;
    }

    public String timeOutHandler(Integer id) {
        return "不想理你！！！  " + id;
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("consumer/payment/hystrix/timeOutWithHystrixControllerGlobal/{id}")
    @HystrixCommand
    public String timeOutWithHystrixControllerGlobal(@PathVariable("id") Integer id) {
        String result = paymentFeignHystrixService.timeout(id);
        return result;
    }

    private String controller_global_fallbackMethod() {
        return "全局的服务降级方法";
    }
}
