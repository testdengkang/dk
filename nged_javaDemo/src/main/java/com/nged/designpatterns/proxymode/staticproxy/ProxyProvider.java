package com.nged.designpatterns.proxymode.staticproxy;

public interface ProxyProvider {
    /**
     * 被代理接口
     * @param taskName
     */
    void doSometing(String taskName);
}
