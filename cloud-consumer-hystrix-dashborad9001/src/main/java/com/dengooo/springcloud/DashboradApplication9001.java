package com.dengooo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DashboradApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashboradApplication9001.class,args);
    }
}
