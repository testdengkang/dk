package com.nged.CallbackDemo;

public class Student {

    private String name;

    public Student(String name){
        this.name = name;
    }

    public void answerQuestion(Teacher teacher){
        try {
            Thread.sleep(2000);
            System.out.println("answerQuestion"+Thread.currentThread().getName());
            teacher.callBack("我是："+name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
