package com.ujsdog.ioc.AOP;

/**
 * @author 茅伟龙
 * @createTime 2019-11-05 20:13
 */
public class MyAspect {
    public void checkPermission(){
        System.out.println("代理： 检查权限。。。。。。。。");
    }
    public void log(){
        System.out.println("代理： 记录日志。。。。。。。。");
    }
}
