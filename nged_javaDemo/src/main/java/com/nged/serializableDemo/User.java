package com.nged.serializableDemo;


import java.io.IOException;
import java.io.Serializable;

public class User implements Serializable{

    private String userName;

    private static String des ="注释";

    private transient String pwd;

    private int age;

    private char sex;
    @Override
    public String toString(){
        return this.getUserName()+";"+this.getPwd()+";"+this.getAge()+";"
                +this.getSex()+";"+des;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public static String getDes() {
        return des;
    }

    public static void setDes(String des) {
        User.des = des;
    }

    private void readObject(java.io.ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
    }
}
