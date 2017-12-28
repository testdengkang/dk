package com.nged.designpatterns.proxymode.dynamic.mybatisInterceptor;

import com.nged.designpatterns.proxymode.dynamic.JDKDynamic.DrinkProvider;
import com.nged.designpatterns.proxymode.dynamic.JDKDynamic.FoodProvider;

import java.lang.reflect.InvocationTargetException;

/**
 * 多接口继承对象 只拦截某一个接口
 */
@MyIntecepts(
        {
//                @InteceptContent(type = DrinkProvider.class,method = "getDrink",args = String.class)
                @InteceptContent(type = FoodProvider.class,method = "getFood",args = String.class)
        }
)
public class BaseInterceptor implements MyInterceptor {

    @Override
    public Object intercept(Invocation invocation) {
        Object result = null;
        //拦截器扩展 也可叫做代理扩展
        preAction();
        try {
            //执行委托类的方法
            result=  invocation.proceed();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        afterAction();
       return result;
    }


    private void preAction(){
        System.out.println("preAction");
    }
    private void afterAction(){
        System.out.println("afterAction");
    }

}
