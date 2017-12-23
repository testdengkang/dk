package com.nged.designpatterns.singleton;

public class SingletonDemo {

    /**
     * 饿汉模式,初始化加载，线程安全
     */
    static  class HugryMode{
        private  static SingletonDemo singleton = new SingletonDemo();

        public static SingletonDemo newInstance(){
            return singleton;
        }
    }

    /**
     * 懒汉模式，延迟加载，非线程安全
     */
    static  class  LazyMode{
        private static SingletonDemo singleton = null;

        public static SingletonDemo newInstance(){
            if(null==singleton){
                singleton =new SingletonDemo();
            }
            return singleton;
        }
    }

    /**
     * 双重验证，线程安全
     */
    static class DubbleCheckMode{

        private static volatile SingletonDemo singleton = null;

        public static SingletonDemo newInstance(){
            //tips:为了防止代码重排 必须使用volatile关键字 保证代码顺序
            if(null==singleton){
                synchronized(SingletonDemo.class){
                    if(null==singleton){
                        singleton = new SingletonDemo();
                    }
                }
            }
            return singleton;
        }

    }

    /**
     * 通过类在调用时只加载一次的特点 实现延迟和单例
     */
    static class innerClassMode{

        private static class InstanceHanler{
            public static SingletonDemo singleton = new SingletonDemo();
        }

        public static SingletonDemo newInstance(){
            return InstanceHanler.singleton;
        }

    }


}




