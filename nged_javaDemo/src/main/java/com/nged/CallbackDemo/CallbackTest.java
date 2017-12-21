package com.nged.CallbackDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public class CallbackTest {

    public static void main(String[] args){

        Student s1 = new Student("小明");
        Student s2 = new Student("老王");
        Teacher teacher = new Teacher("大老师");
        Thread.currentThread().setName("mainThread");
        teacher.askStudent(s1);
        teacher.askStudent(s2);

    }
}
