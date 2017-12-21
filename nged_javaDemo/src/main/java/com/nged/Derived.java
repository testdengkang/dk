package com.nged;

/**
 * 验证类的初始化顺序
 */
public class Derived extends Base
{
    public String whenAmISet = "set when declared";

    @Override void preProcess()
    {
        whenAmISet = "set in preProcess()";
    }

    public static void main(String[] args){
        Derived d = new Derived();
        System.out.println( d.whenAmISet );
    }
}