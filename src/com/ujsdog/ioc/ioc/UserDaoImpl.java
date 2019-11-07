package com.ujsdog.ioc.ioc;

/**
 * @author 茅伟龙
 * @createTime 2019-11-05 15:55
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void say() {
        System.out.println("hello World from UserDao");
    }
}
