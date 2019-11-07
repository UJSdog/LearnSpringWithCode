package com.ujsdog.ioc.AOP;

/**
 * @author 茅伟龙
 * @createTime 2019-11-05 20:10
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {

        System.out.println("添加用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }
}
