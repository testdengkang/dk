package com.nged.CallbackDemo;

public class Teacher implements ICallbackService{

    private String name;
    public Teacher(String name){
        this.name = name;
    }


    public void askStudent(Student student){
        System.out.println("askStudent"+Thread.currentThread().getName().toString());
        student.answerQuestion(this);
    }

    @Override
    public void callBack(String message) {
        System.out.println("callBack"+Thread.currentThread().getName());
        System.out.println(message);
    }
}
