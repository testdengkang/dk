package com.nged.proxydemo;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 代理类
 */
public class ProxyDemo implements  ProxyProvider {

//    委托类
    private ProxyProvider proxyProvider;

    public ProxyDemo(ProxyProvider proxyProvider){
        this.proxyProvider = proxyProvider;
    }
    /**
     * 代理方法
     * @param taskName
     */
    @Override
    public void doSometing(String taskName) {
        taskName =  new StringBuilder("我是静态代理:").append(taskName).toString();
        System.out.println(taskName);
        proxyProvider.doSometing(taskName);
    }

}
