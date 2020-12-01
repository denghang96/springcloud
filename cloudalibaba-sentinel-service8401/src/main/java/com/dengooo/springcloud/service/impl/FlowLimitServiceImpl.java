package com.dengooo.springcloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dengooo.springcloud.service.FlowLimitService;
import org.springframework.stereotype.Service;

@Service
public class FlowLimitServiceImpl implements FlowLimitService {

    @Override
    @SentinelResource(value = "testC")
    public String testC() {
        return "===========c";
    }
}
