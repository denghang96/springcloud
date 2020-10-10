package com.dengooo.springcloud;

import com.dengooo.myruler.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class) //Ribbon自定义负载均衡算法为轮休，如果需要替换则放开本行注释
public class OrderMain80 {
    
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
