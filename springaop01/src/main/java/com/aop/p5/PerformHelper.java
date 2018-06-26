package com.aop.p5;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class PerformHelper implements MethodBeforeAdvice,AfterReturningAdvice,MethodInterceptor {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("before");
    }


    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("afterReturning");
    }


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        methodInvocation.proceed();
        return null;
    }

}
