package com.aop.p4;




import com.aop.p3.Performance03;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/p4/AopConfig04.xml")
public class Test04 {
    @Autowired
    private Performance4 pm;


    @Test
    public void test(){

        ((Encoreable4)pm).performEncore((new Date())+"新增功能");
    }

}
