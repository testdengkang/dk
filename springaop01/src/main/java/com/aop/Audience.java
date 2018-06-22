package com.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 创建切面
 * 设置切入点
 */
@Aspect
public class Audience {
    @Before("execution(** com.aop.Performance.perform(..))")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phones");
    }
    @Before("execution(** com.aop.Performance.perform(..))")
    public void takeSeats(){
        System.out.println("Taking seats");
    }

    @AfterReturning("execution(** com.aop.Performance.perform(..))")
    public void applause(){
        System.out.println("after Return");
    }
}
