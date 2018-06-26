package com.aop.p5;




import com.aop.p4.Encoreable4;
import com.aop.p4.Performance4;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/p5/AopConfig05.xml")
public class Test05 {

    @Autowired
    @Qualifier("proxy")
    private Performance5 pm;


    @Test
    public void test(){

        pm.perform();
    }

}
