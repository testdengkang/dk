package com.nged.designpatterns.proxymode.dynamic.JDKDynamic;


import java.lang.reflect.Proxy;

public class HandlerTest {

    public static void main(String[] args){

//         同时代理多个接口
        Object proxy =  Proxy.newProxyInstance(HandlerTest.class.getClassLoader(),new Class[]{FoodProvider.class,DrinkProvider.class},new MyHandler(Restaurant.class));
        ((DrinkProvider)proxy).getDrink("可乐");
        ((FoodProvider)proxy).getFood("汉堡");
        ((FoodProvider)proxy).finshedEat();


    }
}
