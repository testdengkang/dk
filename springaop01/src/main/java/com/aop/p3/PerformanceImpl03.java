package com.aop.p3;



import org.springframework.stereotype.Component;

@Component
public class PerformanceImpl03 implements Performance03 {
    @Override
    public void perform() {
        System.out.println("Performance03->perform()");
    }

    @Override
    public void performWithArgs(int num) {
        System.out.println("Performance03->performWithArgs  args:"+num);
    }
}
