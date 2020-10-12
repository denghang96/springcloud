package com.dengooo.springcloud.service.impl;

import com.dengooo.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
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
}
