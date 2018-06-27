package com.shiro.d1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class Test01 {

    /*
    *check user by shiro.ini config
     */
    @Test
    public void test(){
    //1 get SecurityManager factory,init SecurityManager by shiro.ini
     Factory<org.apache.shiro.mgt.SecurityManager> factory =
             new IniSecurityManagerFactory("classpath:d1/shiro.ini");
    //2 get Securitymanager instance and set into SecurityUtils
     SecurityManager securityManager = factory.getInstance();
     SecurityUtils.setSecurityManager(securityManager);

     //3 get subject and create user/password token
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","1233");
       try{
           //4 check login
           subject.login(token);
           System.out.println("login success!");
       }catch(AuthenticationException e){
           // 5error
           System.out.println(e);
       }

        Assert.assertEquals(true,subject.isAuthenticated());

       //6 logout
        subject.logout();
    }

}
