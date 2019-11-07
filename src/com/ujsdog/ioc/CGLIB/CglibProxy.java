package com.ujsdog.ioc.CGLIB;

import com.ujsdog.ioc.AOP.MyAspect;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 茅伟龙
 * @createTime 2019-11-06 10:11
 */
public class CglibProxy implements MethodInterceptor {
    public Object createProxy(Object target){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        MyAspect ma = new MyAspect();
        ma.checkPermission();
        Object obj = methodProxy.invokeSuper(o,objects);
        ma.log();
        return o;
    }
}
