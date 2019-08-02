package com.atguigu.gulimall.oms.controller;

import com.atguigu.gulimall.oms.feign.HelloFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloController {
    @Autowired
    HelloFeignService helloFeignService;
    @Value("${guli.content:-}")
    private String content;

    @GetMapping("/hello")
    public String hello(){
        String msg = helloFeignService.world();
        return "hello "+ msg + content;
    }
}
