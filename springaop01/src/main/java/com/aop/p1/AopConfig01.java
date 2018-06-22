package com.aop.p1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//启动AspectJ自动代理
@EnableAspectJAutoProxy
@ComponentScan("com.aop.**")
public class AopConfig01 {
    @Bean
    public Audience01 audience01(){
        return new Audience01();
    }
}
