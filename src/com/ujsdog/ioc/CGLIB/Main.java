package com.ujsdog.ioc.CGLIB;

/**
 * @author 茅伟龙
 * @createTime 2019-11-06 10:20
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("CGLIB");
        //获取代理
        CglibProxy cglibProxy = new CglibProxy();
        //代理创建
        UserDao ud = (UserDao) cglibProxy.createProxy(new UserDao());
        //调用
        ud.addUser();
        ud.deleteUser();
    }
}
