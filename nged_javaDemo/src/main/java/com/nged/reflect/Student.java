package com.nged.reflect;

/**
 * 一个简单的对象
 */
public class Student {
    private int age;
    private String name;

    public Student(){}

    public Student(int age,String name){
        this.age = age;
        this.name = name;
    }

    public void sayHello(String name){
        System.out.println("Hello "+name+" ;my name is "+this.name);
    }

    public void saySomething(){
        System.out.println("Hello I am  a student");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
