package com.tzl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MyController {

    @GetMapping("/normalHello")
    public String normalHello(HttpServletRequest request) {
        return "Hello World";
    }

    @GetMapping("/errorHello")
    public String errorHello(HttpServletRequest request) throws Exception {
        // 模拟需要处理 10 秒
        Thread.sleep(10000);
        return "Error Hello World";
    }
}
