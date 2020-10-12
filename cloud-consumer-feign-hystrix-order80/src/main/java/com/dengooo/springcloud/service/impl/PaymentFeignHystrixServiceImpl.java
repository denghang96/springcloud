package com.dengooo.springcloud.service.impl;

import com.dengooo.springcloud.service.PaymentFeignHystrixService;
import org.springframework.stereotype.Service;

@Service
public class PaymentFeignHystrixServiceImpl implements PaymentFeignHystrixService {
    public String ok(Integer id) {
        return "调用OK超时了、异常了、或者服务端宕机了";
    }

    public String timeout(Integer id) {
        return "调用timeout超时了、异常了、或者服务端宕机了";
    }
}
