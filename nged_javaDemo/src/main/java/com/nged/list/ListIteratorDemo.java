package com.nged.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * 关于集合遍历时进行增删改的操作方式
 * iterator 遍历只能做删除操作
 * ListIterator 可以修改和新增
 */
public class ListIteratorDemo {

    public static void main(String[] args){
        List list = new ArrayList(10);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //对值%2==0的选项进行删除，并添加 值*2+1
        method3(list);

        for(Object i:list){
            System.out.println(i);
        }
    }
    //三种遍历方法 for(int i=0;i<size;i++) , for(int i:list) ,iterator
    //区别Iterator和ListIterator的实现
    public static void method1(List list){
        for(int i=0;i<list.size();i++){
            int integer = (int)list.get(i);
            if(integer % 2==0){
                list.remove(list.get(i));
                list.add(integer*2 + 1);
            }
        }
    }

    public static void method2(List list){
        for(Object o:list){
            Integer integer = (Integer) o;
            if(integer%2==0){
                //错误操作
                list.remove(o);
                list.add(integer*2 +1);
            }
        }
    }

    public static void method3(List list){
        ListIterator it = list.listIterator();
        while(it.hasNext()){
            Integer integer = (Integer) it.next();
            if(integer%2 == 0){
                //正确操作
                it.remove();
                it.add(integer*2 + 1);

              //错误操作
              /*  list.remove(integer);
                list.add(integer*2 + 1);*/
            }
        }
    }


}
