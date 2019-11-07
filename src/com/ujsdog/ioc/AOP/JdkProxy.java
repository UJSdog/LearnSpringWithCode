package com.ujsdog.ioc.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 茅伟龙
 * @createTime 2019-11-05 20:20
 */
public class JdkProxy implements InvocationHandler {
    private UserDao ud;
    public Object createProxy(UserDao ud){
        this.ud = ud;
        //类加载器
        ClassLoader cl = JdkProxy.class.getClassLoader();
        //ud 的所有接口
        Class[] clazz = ud.getClass().getInterfaces();
        //返回增强的对象
        return Proxy.newProxyInstance(cl,clazz,this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MyAspect ma = new MyAspect();
        ma.checkPermission();
        Object o = method.invoke(ud,args);
        ma.log();
        return o;
    }
}
