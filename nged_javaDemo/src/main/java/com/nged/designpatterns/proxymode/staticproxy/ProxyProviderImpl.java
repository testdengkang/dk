package com.nged.designpatterns.proxymode.staticproxy;

/**
 * 被代理对象的实现类
 */
public class ProxyProviderImpl implements ProxyProvider {
    @Override
    public void doSometing(String taskName) {
        System.out.println("我是被代理的委托类,正在处理:"+taskName);
    }
}
