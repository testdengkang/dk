package com.nged.clone;

import java.util.Objects;

/**
 * @Auther: Administrator
 * @Date: 2018/11/30 09:49
 * @Description:
 */
public class CloneBean implements Cloneable {

    private int age;

    private String name;

    public CloneBean() {
    }

    public CloneBean(int age, String name) {
        this.age = age;
        this.name = name;
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

    @Override
    protected Object clone() throws CloneNotSupportedException {

        //浅拷贝
        //return   super.clone();
        //深拷贝
       CloneBean cloneBean = (CloneBean) super.clone();
        cloneBean.name = new String(this.name);
        return cloneBean;
    }


    public static void main(String[] args){
        CloneBean cloneBean = new CloneBean(30,"至尊宝");
        try {
            CloneBean newClone = (CloneBean)cloneBean.clone();
            System.out.println(cloneBean.equals(newClone));
            System.out.println(cloneBean.age==newClone.age);
            System.out.println(cloneBean.name.equals(newClone.name));
            System.out.println( cloneBean.name.hashCode()+"--"+newClone.name.hashCode());
            newClone.name = "至尊玉";
            System.out.println( cloneBean.name.hashCode()+"--"+newClone.name.hashCode());
            System.out.println(cloneBean.name+"///"+newClone.name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
