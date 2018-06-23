package com.aop.p2;


import org.springframework.stereotype.Component;

/**
 * 新功能默认实现
 */
@Component
public class DefaultEncoreable implements Encoreable{

    public DefaultEncoreable(){
        System.out.println("DefaultEncoreable 02  初始化");
    }

    @Override
    public void performEncore( String name
    ) {
        System.out.println(name + "_DefaultEncoreable");
    }
}
