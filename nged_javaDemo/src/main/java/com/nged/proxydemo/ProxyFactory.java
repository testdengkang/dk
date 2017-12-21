package com.nged.proxydemo;

public  class ProxyFactory {
    private static ProxyDemo proxyDemo = null;
    public static ProxyDemo getInstance(){
            return null==proxyDemo?new ProxyDemo(new ProxyProviderImpl()): proxyDemo;
    }
}
