package com.ujsdog.ioc.ioc;

/**
 * @author 茅伟龙
 * @createTime 2019-11-05 17:01
 */
public class FactoryImpl implements Factory {
    public FactoryImpl() {
        System.out.println("实例化工厂运行ing");
    }

    @Override
    public UserDao createUserDao() {
        return new UserDaoImpl();
    }
}
