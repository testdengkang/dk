package com.nged.designpatterns.proxymode.dynamic.mybatisInterceptor;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
/**
 * 通过接口对handler的invoke方法提供扩展
 */
public class PluginHandler implements InvocationHandler {
    private MyInterceptor interceptor;
    private Object target;

    Map<Class<?>,Set<Method>> inteceptContentMap;
    public PluginHandler(MyInterceptor interceptor,Class clazz,Map<Class<?>,Set<Method>> inteceptContentMap) throws IllegalAccessException, InstantiationException {
        this.interceptor = interceptor;
        this.target = clazz.newInstance();
        this.inteceptContentMap = inteceptContentMap;
    }

    public static Object wrapProxy(Object target,MyInterceptor interceptor) throws InstantiationException, IllegalAccessException {
        //获取interceptor 注解中的拦截设置
        Map<Class<?>,Set<Method>> inteceptContentMap = getInteceptAnnotation(interceptor);
        //获取代理对象继承的所有接口
        Class clazz = target.getClass();
        Class<?>[] interfaces = getTargetInterfaces(clazz,inteceptContentMap);
        if(interfaces.length>0){
            return Proxy.newProxyInstance(clazz.getClassLoader(),interfaces,new PluginHandler(interceptor,clazz,inteceptContentMap));
        }else{
            return target;
        }


    }

    private static Map<Class<?>,Set<Method>> getInteceptAnnotation(MyInterceptor intecept){
        Map<Class<?>,Set<Method>> inteceptContentMap  = new HashMap<Class<?>,Set<Method>>();
        MyIntecepts intecepts = intecept.getClass().getAnnotation(MyIntecepts.class);
        if(intecept ==null){
            System.out.println("没有发现annotation");
        }
        InteceptContent[] inteceptContents = intecepts.value();
        for(InteceptContent itc :inteceptContents){
            Set<Method> methods =  inteceptContentMap.get(itc.type());
            if(methods==null){
                methods = new HashSet<>();
                inteceptContentMap.put(itc.type(),methods);
            }

            try {
                Method method = itc.type().getMethod(itc.method(),itc.args());
                methods.add(method);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return inteceptContentMap;
    }
    //获取定义type所继承的接口中含有拦截指定的接口
    public static Class<?>[] getTargetInterfaces(Class type, Map<Class<?>,Set<Method>> inteceptContentMap){
       Set<Class<?>> interfaces = new HashSet<>();
       while(type!=null){

           //如何是多接口继承 需要将直接继承的接口都添加进来，否则没有被拦截到的接口，无法拿到正确的代理
           int i=0;
           for(Class<?> c :type.getInterfaces()){
               if(i==0 || inteceptContentMap.containsKey(c)){
                   interfaces.add(c);
               }
           }
           i++;
           //查询type的父类
           type = type.getSuperclass();
       }
       return interfaces.toArray(new Class<?>[interfaces.size()]);
    }
    /**
     * 目前的拦截器对所有 接口都会拦截
     * 改进，通过加注解的方式在定义拦截器的时候执行需要拦截接口的类型 方法 以及
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Set<Method> methods = inteceptContentMap.get(method.getDeclaringClass());
        if(methods!=null&&methods.contains(method)){
            return  interceptor.intercept(new Invocation(target,method,args));
        }else{
            return method.invoke(target,args);
        }

    }
}
