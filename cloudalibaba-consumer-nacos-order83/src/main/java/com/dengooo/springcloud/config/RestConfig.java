package com.dengooo.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced //使用Ribbon的负载均衡能力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
