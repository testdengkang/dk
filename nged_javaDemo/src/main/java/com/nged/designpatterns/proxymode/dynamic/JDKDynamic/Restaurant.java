package com.nged.designpatterns.proxymode.dynamic.JDKDynamic;

public class Restaurant  implements DrinkProvider,FoodProvider{


    @Override
    public void getDrink(String name) {
        System.out.println("顾客需要饮料"+name);
    }

    @Override
    public void getFood(String name) {
        System.out.println("顾客需要食物"+name);
    }

    @Override
    public void finshedEat() {
        System.out.println("顾客吃完了");
    }

}
