package com.aop.p2;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Performance02 implements Performance {
    @Override
    public void perform() {
        System.out.println("Performance02");
    }

    @Override
    public void performWithArgs(int num) {
        System.out.println("Performance02  "+num);
    }


}
