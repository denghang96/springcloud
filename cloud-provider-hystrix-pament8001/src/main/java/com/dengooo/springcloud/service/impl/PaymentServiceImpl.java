package com.dengooo.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.dengooo.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PaymentServiceImpl implements PaymentService {

    //===============服务降级=====================
    /**
     * 正常访问
     * @param id
     * @return
     */
    public String PaymentInfo(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " ok  " + id;
    }

    /**
     * timeOutHandler 异常或者超时的时候调用的方法，
     * execution.isolation.thread.timeoutInMilliseconds 超时时间 value 3S
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "timeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "7000")
    })
    public String timeOut(Integer id) {
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() + " Time Out!!!  " + id + "   耗时5S钟";
    }

    public String timeOutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + " timeOutHandler!!!  " + id;
    }


    //===============服务熔断=====================
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),   //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),    //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),    //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();  //UUID.randomUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍后再试，o(╥﹏╥)o  id："+id;
    }

}
