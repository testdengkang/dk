package com.aop.p1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 创建切面
 * 设置切入点
 * 通过@Pointcut 声明切入点
 */
@Aspect
public class Audience01 {

   /* @Pointcut("execution(** com.aop.Performance.perform(..))")
    public void performace(){}*/
    @Pointcut("execution(** com.aop.Performance.performWithArgs(int)) && args(num)" )
    public void performWithArgs(int num){}

    @Before("performWithArgs(num)")
    public void performaceArgs(int num){
        System.out.println(num);
    }

   /* @Before("performace()")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phones");
    }
    @Before("performace()")
    public void takeSeats(){
        System.out.println("Taking seats");
    }

    @AfterReturning("performace()")
    public void applause(){
        System.out.println("after Return");
    }

    @Around("performace()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before");
        joinPoint.proceed();
        System.out.println("around after");
    }*/
}
