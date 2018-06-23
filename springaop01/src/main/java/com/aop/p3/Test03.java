package com.aop.p3;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/p3/AopConfig03.xml")
public class Test03 {
    @Autowired
    private Performance03 pm;


    @Test
    public void test(){
       //有参数
       pm.performWithArgs(2);

        //无参数
        pm.perform();
    }

}
