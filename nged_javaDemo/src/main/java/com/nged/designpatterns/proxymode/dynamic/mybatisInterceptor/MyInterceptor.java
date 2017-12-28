package com.nged.designpatterns.proxymode.dynamic.mybatisInterceptor;

import java.lang.reflect.Method;

/**
 * 定义拦截器的接口
 */
public interface MyInterceptor {
    Object intercept(Invocation invocation);

}
