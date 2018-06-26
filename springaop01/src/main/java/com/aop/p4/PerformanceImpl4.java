package com.aop.p4;


import com.aop.p2.Performance;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class PerformanceImpl4 implements Performance4 {
    @Override
    public void perform() {
        System.out.println("Performance04");
    }

    @Override
    public void performWithArgs(int num) {
        System.out.println("Performance04  "+num);
    }


}
