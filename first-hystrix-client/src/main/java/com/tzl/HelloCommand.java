package com.tzl;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HelloCommand extends HystrixCommand<String> {

    private String url;

    CloseableHttpClient httpclient;

    protected HelloCommand(String url) {
        // 调用父类的构造器，设置命令组的 key，默认用来作为线程池的 key
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        // 创建 HttpClient 客户端
        this.httpclient = HttpClients.createDefault();
        this.url = url;
    }

    @Override
    protected String run() throws Exception {
        try {
        // 调用 GET 方法请求服务
            HttpGet httpget = new HttpGet(url);
        // 得到服务响应
            HttpResponse response = httpclient.execute(httpget);
        // 解析并返回命令执行结果
            return EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 回退方法
     * 调用延时的服务，为客户端设置回退方法
     * @return
     */
    protected String getFallback() {
        System.out.println("执行 HelloCommand 的回退方法");
        return "error";
    }
}
