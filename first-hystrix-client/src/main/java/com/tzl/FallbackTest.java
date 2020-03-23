package com.tzl;

import com.netflix.config.ConfigurationManager;

/**
 * 2、断路器被打开，执行回退方法
 */
public class FallbackTest {

    public static void main(String[] args) {
        // 断路器被强制打开
        ConfigurationManager.getConfigInstance().setProperty( "hystrix.command.default.circuitBreaker.forceOpen", "true");
        FallbackCommand c = new FallbackCommand();
        c.execute();
        // 创建第二个命令，断路器关闭
        ConfigurationManager.getConfigInstance().setProperty( "hystrix.command.default.circuitBreaker.forceOpen", "false");
        FallbackCommand c2 = new FallbackCommand();
        c2.execute();
    }

}
