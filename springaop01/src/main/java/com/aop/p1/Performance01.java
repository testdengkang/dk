package com.aop.p1;

import com.aop.Performance;
import org.springframework.stereotype.Component;

@Component
public class Performance01 implements Performance {
    @Override
    public void perform() {
        System.out.println("Performance01");
    }

    @Override
    public void performWithArgs(int num) {
        System.out.println("Performance01  "+num);
    }
}
