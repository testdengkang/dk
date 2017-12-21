package com.nged.dongtai.JDKDynamic;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {

    private static final Logger LOG = Logger.getLogger(MyHandler.class);

    private Object targer;

    public MyHandler(Class clazz){
        try {
            this.targer = clazz.newInstance();
        } catch (InstantiationException e) {
            LOG.error("111");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            LOG.error("222");
            e.printStackTrace();
        }

    }

    private void preAction(){
        System.out.println("preAction");
    }
    private void afterAction(){
        System.out.println("afterAction");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       preAction();
       Object result = method.invoke(targer,args);
       afterAction();
       LOG.info(proxy.getClass().getName());
       return result;
    }
}
