package com.aop.p4;


import com.aop.p2.Encoreable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 新功能默认实现
 */

public class DefaultEncoreable4 implements Encoreable4{

    public DefaultEncoreable4(){
        System.out.println((new Date())+"DefaultEncoreable 4  初始化");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void performEncore( String name
    ) {
        System.out.println(name + "_DefaultEncoreable");
    }
}
