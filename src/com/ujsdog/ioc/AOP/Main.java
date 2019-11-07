package com.ujsdog.ioc.AOP;

/**
 * @author 茅伟龙
 * @createTime 2019-11-05 20:28
 */
public class Main {
    public static void main(String[] args) {
        JdkProxy jp = new JdkProxy();
        UserDao ud = new UserDaoImpl();
        UserDao ud1 = (UserDao) jp.createProxy(ud);

        ud1.addUser();
        ud1.deleteUser();
    }
}
