package com.nged.dongtai.gclib;

import com.nged.proxydemo.ProxyProviderImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;


public class CGlibTest {

    public static void main(String[] args){
        MethodInterceptor methodInterceptor = new SubjectInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProxyProviderImpl.class);
        enhancer.setCallback(methodInterceptor);
        ProxyProviderImpl subject =(ProxyProviderImpl) enhancer.create();
        subject.doSometing("我是CGlib 任务");
    }

}
