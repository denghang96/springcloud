package com.dengooo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenFeignZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignZkMain80.class,args);
    }
}
