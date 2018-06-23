package com.aop.p2;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AopConfig02.class)
public class Test02 {
    @Autowired
    private Performance pm;

   @Autowired
    private Encoreable en;
    @Test
    public void test(){
       pm.performWithArgs(2);
       en.performEncore("自身调用");
        ((Encoreable)pm).performEncore("performance02 ");
    }

}
