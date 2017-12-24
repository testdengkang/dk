package com.nged.designpatterns.proxymode.staticproxy;

/**
 * 代理类
 */
public class ProxyDemo implements  ProxyProvider {

//    委托类
    private ProxyProvider proxyProvider;

    public ProxyDemo(ProxyProvider proxyProvider){
        this.proxyProvider = proxyProvider;
    }

    /**
     * 代理扩展
     */
    public  void beforeMethod(){
       System.out.println("我是代理类的方法beforeMethod，我在代理方法执行前扩展！");
    }

    public void afterMethod(){
        System.out.println("我是代理类的方法afterMethod，我在代理方法执行后扩展！");
    }

    /**
     * 代理方法
     * @param taskName
     */
    @Override
    public void doSometing(String taskName) {
        taskName =  new StringBuilder("静态代理接到订单:").append(taskName).toString();
        System.out.println(taskName);
        beforeMethod();
        proxyProvider.doSometing(taskName);
        afterMethod();
    }

}
