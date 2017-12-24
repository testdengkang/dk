package com.nged.designpatterns.proxymode.staticproxy;

public class Client {

    public static void main(String[] args){
//        通过代理工厂拿到代理
        ProxyDemo demo = ProxyFactory.getInstance();

        demo.doSometing("购买机票");
    }
}
