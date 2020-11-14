package com.dengooo.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //支持Nacos的动态刷新功能
public class NacosConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @Value("${spring.profiles.active}")
    private String active;
    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo + "," + active;
    }
}
