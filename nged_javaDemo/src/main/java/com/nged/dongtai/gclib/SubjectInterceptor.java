package com.nged.dongtai.gclib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class SubjectInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
       preAction();
       Object result =methodProxy.invokeSuper(o,objects);
       afterAction();
        return result;
    }

    private void preAction(){
        System.out.println("preAction");
    }
    private void afterAction(){
        System.out.println("afterAction");
    }
}
