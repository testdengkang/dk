package com.nged.dongtai.JDKDynamic;



import com.nged.proxydemo.ProxyProvider;
import com.nged.proxydemo.ProxyProviderImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class HandlerTest {

    public static void main(String[] args){
        InvocationHandler handler = new MyHandler(ProxyProviderImpl.class);
        ProxyProvider proxy = (ProxyProvider) Proxy.newProxyInstance(HandlerTest.class.getClassLoader(),new Class[]{ProxyProvider.class},handler);
        proxy.doSometing("我是动态代理的任务哦");


    }
}
