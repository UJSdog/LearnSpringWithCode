package com.ujsdog.ioc.ioc;

import java.util.List;

/**
 * @author 茅伟龙
 * @createTime 2019-11-05 16:09
 */
public class UserServiceImpl implements UserService {
    UserDao ud;
    List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao ud) {
        this.ud = ud;
    }

    @Override
    public void say() {
        ud.say();
        System.out.println("hello world from service");
        System.out.println(list.size());
        for(String str:list){
            System.out.println(str);
        }
    }

    public void setUd(UserDao ud) {
        this.ud = ud;
    }
}
