package com.nged.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {


        //获取对象①
        Student student = new Student(20,"tom");
        Class clazz2 =student.getClass();
        //获取对象②
        Class clazz = Student.class;
        //获取对象③
        Class clazz1 = Class.forName("com.nged.reflect.Student");

        //获取构造函数（带参数的）
        Constructor constructor = clazz.getConstructor(int.class,String.class);
        //获取无参数的构造器
        Constructor constructor1 = clazz.getConstructor();

        //获取对象带有参数的方法
        Method method = clazz.getMethod("sayHello",String.class);
        //获取对象无参数的方法
        Method method1 = clazz.getMethod("saySomething");

        //初始化有参数的构造器
        Object object = constructor.newInstance(20,"hanmeimei");
        //执行有参数的方法
        method.invoke(object,"lilei ");

        //初始化无参构造器
        Object object1 = constructor1.newInstance();
        //执行无参方法
        method1.invoke(object1);

    }
}
