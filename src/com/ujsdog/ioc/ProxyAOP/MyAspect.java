package com.ujsdog.ioc.ProxyAOP;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author 茅伟龙
 * @createTime 2019-11-06 10:28
 */
public class MyAspect implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        checkPermission();
        Object obj = methodInvocation.proceed();
        log();
        return obj;
    }
    public void checkPermission(){
        System.out.println("代理： 检查权限。。。。。。。。");
    }
    public void log(){
        System.out.println("代理： 记录日志。。。。。。。。");
    }
}
