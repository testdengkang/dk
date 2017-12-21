package com.nged;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class rfTest {

        public void run() {
            System.out.println("Proxy.run");
        }

    public static void main(String[] arg){

        rfTest pr = new rfTest();
//        获取class 方式①
        Class s1 = rfTest.class;
//        获取class 方式②
        Class s2 = pr.getClass();

        try {
//            创建实例方式①
            Object o1 = s1.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


        try {
            //        获取class 方式③
            Class s3 = Class.forName("rfTest");
            Method mm = s3.getMethod("run");
            Constructor constructor = s3.getConstructor();
            //            通过获取构造器来创建实例  创建实例①
            Object o = constructor.newInstance();
            //执行实例的方法
            mm.invoke(o);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

   /*     Method[] methods = s1.getMethods();
        for(Method m:methods){
            System.out.println(m.getName());
        }*/
        try {
            Method m = s2.getMethod("run");
            m.invoke(pr);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
