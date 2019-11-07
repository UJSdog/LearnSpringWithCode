package com.ujsdog.ioc.ioc;

/**
 * @author 茅伟龙
 * @createTime 2019-11-05 16:45
 */
public interface StaticFActory {
    static UserDao createBean(){
        return () -> System.out.println("from static factory");
    }
}
