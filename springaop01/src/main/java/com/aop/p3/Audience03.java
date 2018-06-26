package com.aop.p3;

import org.aspectj.lang.ProceedingJoinPoint;


/**
 * 去掉注解通过xml来配置即纯POJO方式
 *
 */

public class Audience03 {

   // @Pointcut("execution(** com.aop.Performance.perform(..))")
   // public void performace(){}

   // @Pointcut("execution(** com.aop.Performance.performWithArgs(int)) && args(num)" )
   // public void performWithArgs(int num){}

    //@Before("performWithArgs(num)")
    public void performaceArgs(int num){
        System.out.println(num);
    }

    //@Before("performace()")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phones");
    }
    //@Before("performace()")
    public void takeSeats(){
        System.out.println("Taking seats");
    }

    //@AfterReturning("performace()")
    public void applause(){
        System.out.println("after Return");
    }

    /**
     * 环绕通知
     * @param joinPoint
     * @throws Throwable
     */
    //@Around("performace()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before");
        joinPoint.proceed();
        System.out.println("around after");
    }
}
