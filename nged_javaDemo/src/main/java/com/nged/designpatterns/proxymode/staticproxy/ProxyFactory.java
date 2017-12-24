package com.nged.designpatterns.proxymode.staticproxy;

/**
 * 代理工厂 生成代理类
 */
public  class ProxyFactory {
    private static ProxyDemo proxyDemo = null;
    public static ProxyDemo getInstance(){
            return null==proxyDemo?new ProxyDemo(new ProxyProviderImpl()): proxyDemo;
    }
}
