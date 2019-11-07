package com.ujsdog.ioc.aspectAnnotationJ;

import org.springframework.stereotype.Repository;

/**
 * @author 茅伟龙
 * @createTime 2019-11-05 20:10
 */
@Repository("userDao")
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
