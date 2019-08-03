package com.nged.suger;

/**
 * java 语法糖 自动装箱 自动拆箱的
 * 隐藏的小坑：Byte Short Integer Long Char 当值 >=-128 ,<=127 会存在缓存，后序相同值直接取的缓存 解释1,2
 * 在进行运算后 自动拆箱 解释3,4
 * equals 不能对数据类型类型进行转换 解释5,6
 */
public class SugerTest {
    public static void main(String[] args){
        Integer a =1;
        Integer b=2;
        Integer c=3;
        Integer d=3;
        Integer e = 128;
        Integer f = 128;
        Long g  =3L;
        System.out.println(c==d);//1 true
        System.out.println(e==f);//2 false
        System.out.println(c==(a+b));//3 true
        System.out.println(c.equals(a+b));//5 true
        System.out.println(g==(a+b));//4 true
        System.out.println(g.equals(a+b));//6 false
    }
}
