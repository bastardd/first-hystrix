package com.tzl;


import com.netflix.config.ConfigurationManager;

/**
 * 1、执行命令失败，调用回退方法！
 */
public class HelloMain {
    public static void main(String[] args) {
        // 请求正常的服务
//        String normalUrl = "http://localhost:8080/normalHello";
        String normalUrl = "http://localhost:8080/errorHello";
        HelloCommand command = new HelloCommand(normalUrl);
        String result = command.execute();
        System.out.println("请求正常的服务，结果：" + result);

    }
}
