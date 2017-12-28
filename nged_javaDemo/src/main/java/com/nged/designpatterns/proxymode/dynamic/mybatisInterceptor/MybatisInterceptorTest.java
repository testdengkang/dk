package com.nged.designpatterns.proxymode.dynamic.mybatisInterceptor;

import com.nged.designpatterns.proxymode.dynamic.JDKDynamic.DrinkProvider;
import com.nged.designpatterns.proxymode.dynamic.JDKDynamic.FoodProvider;
import com.nged.designpatterns.proxymode.dynamic.JDKDynamic.Restaurant;

public class MybatisInterceptorTest {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        //优化 下面这段可以直接封装成一个方法wrapProxy
       // Object proxy =  Proxy.newProxyInstance(MybatisInterceptorTest.class.getClassLoader(),
         //       new Class[]{FoodProvider.class,DrinkProvider.class},new PluginHandler(new BaseInterceptor(),Restaurant.class));
        Object proxy =  PluginHandler.wrapProxy(new Restaurant(),new BaseInterceptor());
        ((DrinkProvider)proxy).getDrink("可乐");
        ((FoodProvider)proxy).getFood("汉堡");
        //通过以上发现多接口代理在这里不行，因为对象只要有一个接口被拦截器拦截，则返回的都是代理扩展过的对象

    }
}
