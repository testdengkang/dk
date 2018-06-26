package com.aop.p5;


import com.aop.p4.Performance4;
import org.springframework.stereotype.Component;

@Component

public class PerformanceImpl5 implements Performance5 {
    @Override
    public void perform() {
        System.out.println("Performance05");
    }

    @Override
    public void performWithArgs(int num) {
        System.out.println("Performance05  "+num);
    }


}
