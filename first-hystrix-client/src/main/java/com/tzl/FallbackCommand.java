package com.tzl;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class FallbackCommand extends HystrixCommand<String> {


    public FallbackCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    }
    /**
     * 断路器被强制打开，该方法不会执行
     */
    protected String run() throws Exception {
        System.out.println("命令执行");
        return "";
    }
    /**
     * 回退方法，断路器打开后会执行回退
     */
    protected String getFallback() {
        System.out.println("执行回退方法");
        return "fallback";
    }
}
