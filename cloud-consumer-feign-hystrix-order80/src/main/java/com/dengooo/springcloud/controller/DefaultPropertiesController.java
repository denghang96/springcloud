package com.dengooo.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import javafx.beans.DefaultProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * 全局的服务降级方法
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "global_fallbackMethod")
public class DefaultPropertiesController {
    private String global_fallbackMethod() {
        return "全局的服务降级方法";
    }
}
