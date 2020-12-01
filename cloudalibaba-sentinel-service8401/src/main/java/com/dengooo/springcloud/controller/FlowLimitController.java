package com.dengooo.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class FlowLimitController {

    @GetMapping("testA")
    public String testA() {
        System.out.println(new Date().getTime() + "----------------A");
        return "=========A";
    }

    @GetMapping("testB")
    public String testB() {
        System.out.println(new Date().getTime() + "----------------B");
        return "=========B";
    }

    @GetMapping("testC")
    public String testC() {
        System.out.println(new Date().getTime() + "----------------C");
        return "=========C";
    }
}
